package com.mc.algorithm.d_datastructure.queue;

import com.mc.algorithm.d_datastructure.list.Node;

public class _Queue<E> {
	
	private Node<E> top;
	private Node<E> tail;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(E e) {
		Node<E> newNode = new Node<>(e);
		if(size == 0) {			
			top = newNode;   // 첫 번째 노드이므로 top도 가리킴
			tail = newNode;  // 마지막 노드이므로 tail도 가리킴
			
		}else {
			tail.next(newNode);
			tail = newNode;
		}
		size++;
		
	}
	
	public E dequeue() {
		if(top == null) return null;
		E res = top.data();
		top = top.next();
		size--;
		return res;
	}

	@Override
	public String toString() {
		Node<E> link = top;
		if(link == null) return "[]";
		StringBuffer sb = new StringBuffer();
		sb.append("[");
	
		
		while (link != null) {
			sb.append(link.data()).append(",");
			link = link.next();
		
		}
		
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");	
		return sb.toString();
	}
	
	
	
	
	
	
	
}
