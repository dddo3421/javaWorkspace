package com.mc.algorithm.g_divideandconquer;

import java.util.Arrays;

import com.mc.algorithm.util.SortUtil;

// bottom up : 상향식
// 가장 간단하고 작은 부분 문제들을 해결한 다음, 그 해답을 결합해 더 큰 문제의 해답을 만들어가는 방식
// 시작점 : 가장 작은 문제(길이가 1인 두 배열을 병합)
// 진행 방향 : 부분 -> 전체
public class BottomupMergeSort {

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };

		SortUtil.checkTime(() -> {
			System.out.println(Arrays.toString(a));
			mergeSort(SortUtil.createRandomIntArray(100000000));
			
		});
	}

	private static void mergeSort(int[] arr) {
		int n = arr.length;

		// size : 부분 배열의 길이
		for (int size = 1; size < n; size *= 2) {
			// left : 첫 번째 부분 배열의 시작 인덱스
			for (int left = 0; left < n - 1; left += 2 * size) {
				int mid = Math.min(left + size + 1, n - 1);
				// right : 두번째 부분 배열의 끝 인덱스
				int right = Math.min(left + 2 * size, n - 1);
				merge(arr, left, mid, right);
			}

		}
	}

	static void merge(int[] arr, int left, int mid, int right) {
		int lSize = mid - left + 1; // 0번부터 시작
		int rSize = right - mid;

		if (rSize == 0)
			return;

		int[] l = new int[lSize];
		int[] r = new int[rSize];

		for (int i = 0; i < lSize; i++) { // 왼쪽 배열에 원본 배열 복사
			l[i] = arr[left + i];
		}

		for (int i = 0; i < rSize; i++) {
			r[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0, k = left;
		while (i < lSize && j < rSize) {
			if (l[i] < r[j]) {
				arr[k] = l[i];
				i++;
			} else {
				arr[k] = r[j];
				j++;
			}
			k++;
		}
		while (i < lSize) {
			arr[k] = l[i];
			k++;
			i++;
		}

		while (j < rSize) {
			arr[k] = r[j];
			k++;
			j++;
		}
	}

}
