package com.mc.algorithm.d_datastructure.queue;

public class QueueQuiz1 {

    // 매개변수 있는 일반 메소드
    public void run(int n, int k) {
        _Queue<Integer> queue = new _Queue<>();

        // 1~n 사람 넣기
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
        }

        System.out.print("제거 순서: ");

        while (!queue.isEmpty()) {
            // k-1명 회전
            for (int i = 1; i < k; i++) {
                queue.enqueue(queue.dequeue());
            }
            // k번째 사람 제거 및 출력
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueQuiz1 quiz = new QueueQuiz1();
        quiz.run(7, 3); // 예시: n=7, k=3
    }
}
