package com.mc.algorithm.g_divideandconquer;

import java.util.Stack;

import com.mc.algorithm.d_datastructure.stack._Stack;
import com.mc.algorithm.util.SortUtil;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = SortUtil.createRandomIntArray(100000000);
		SortUtil.checkTime(() -> {
			quickSort(arr, 0, arr.length - 1);
		});
	}

	// 재귀를 사용하지 않는 퀵 정렬
	private static void quickSort(int[] arr, int left, int right) {
		if (left >= right) // 구간 길이가 1 이하이면 정렬할 필요 없음 → 종료
			return;

		_Stack<Integer> stack = new _Stack<Integer>(); // 정렬할 구간 정보를 저장할 스택 생성

		stack.push(left); // 전체 배열의 왼쪽 인덱스 push
		stack.push(right); // 전체 배열의 오른쪽 인덱스 push

		while (!stack.isEmpty()) { // 스택이 빌 때까지 반복
			right = stack.pop(); // 현재 처리할 구간의 오른쪽 인덱스 pop
			left = stack.pop(); // 현재 처리할 구간의 왼쪽 인덱스 pop

			int pivotIndex = partition(arr, left, right); // pivot 기준으로 배열 재배치, pivot 최종 위치 반환

			if (pivotIndex - 1 > left) { // 왼쪽 구간 길이 ≥ 1이면
				stack.push(left); // 왼쪽 구간의 left 인덱스 push
				stack.push(pivotIndex - 1); // 왼쪽 구간의 right 인덱스 push
			}

			if (pivotIndex + 1 < right) { // 오른쪽 구간 길이 ≥ 1이면
				stack.push(pivotIndex + 1); // 오른쪽 구간의 left 인덱스 push
				stack.push(right); // 오른쪽 구간의 right 인덱스 push
			}
		}
	}

	private static int partition(int[] arr, int first, int last) {
		int pivotElement = arr[first];
		int lp = first;
		int rp = last;

		while (true) {
			while (lp < last && arr[lp] <= pivotElement) {
				lp++;
			}
			while (rp > first && arr[rp] > pivotElement) {
				rp--;
			}

			if (lp >= rp)
				break;
			SortUtil.swap(arr, lp, rp);
			lp++;
			rp--;
		}

		SortUtil.swap(arr, first, rp);
		return rp;
	}
}
