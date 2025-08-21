package com.mc.algorithm.d_datastructure.queue;

public class Run {

	public static void main(String[] args) {
		
		_Queue<Integer> queue = new _Queue<Integer>();
		for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println("enqueue(" + i + "): " + queue);
        }

        System.out.println("\n--- dequeue 시작 ---");

        // 앞에서 하나씩 dequeue
        while (!queue.isEmpty()) {
            int value = queue.dequeue();
            System.out.println("dequeue(): " + value + ", queue: " + queue);
        }

    }
}