package com.mc.algorithm.d_datastructure.map;

import java.util.HashMap;              // HashMap 클래스(키-값 저장)를 사용하기 위해 가져옵니다.
import java.util.Map;                  // Map 인터페이스 타입(일반화된 맵 타입)을 쓰기 위해 가져옵니다.

public class HashTableQuiz {        // 클래스 선언: 실행용 main과 유틸 메서드를 담습니다.

    public static char getMostFrequentChar(String str) {   // 문자열에서 최빈 문자를 반환하는 정적 메서드
        if (str == null || str.isEmpty()) {                // 입력이 null이거나 빈 문자열이면
            throw new IllegalArgumentException("문자열이 비어있습니다."); // 예외를 던져 잘못된 입력을 즉시 알립니다.
        }

        Map<Character, Integer> freqMap = new HashMap<>(); // 문자 빈도를 저장할 맵: 문자 → 등장 횟수

        // 문자 빈도 세기
        for (char c : str.toCharArray()) {                 // 문자열을 문자 배열로 바꿔 하나씩 순회
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);// c의 현재 빈도(없으면 0)에 1을 더해 갱신
        }

        // 가장 많이 나온 문자 찾기
        char mostFrequent = 0;                             // 결과용 변수(초깃값 0: 널 문자. 이후 반드시 갱신될 예정)
        int maxCount = 0;                                  // 현재까지의 최대 빈도(초깃값 0)

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) { // 맵의 (문자, 빈도) 쌍을 모두 순회
            if (entry.getValue() > maxCount) {             // 이 문자의 빈도가 현재 최대보다 크면
                mostFrequent = entry.getKey();             // 결과 문자를 이 문자로 바꾸고
                maxCount = entry.getValue();               // 최대 빈도도 갱신합니다.
            }
        }

        return mostFrequent;                               // 최빈 문자를 반환합니다.
    }

    public static void main(String[] args) {               // 실행 진입점
        String test = "hello world";                       // 테스트 문자열
        char result = getMostFrequentChar(test);           // 최빈 문자 함수 호출
        System.out.println("가장 많이 나온 문자: " + result); // 결과 출력(hello world에서는 'l')
    }
}
