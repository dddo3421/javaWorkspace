package com.mc.algorithm.d_datastructure.list;

public class Node<E> {
	
	private Node<E> next;
	private E data; // E라는 제네릭 타입에 데이터를 저장하기 위한 변수
	
	public Node() {
		
	}
	
	public Node(E data) {
		this.data = data;
	}

	public Node<E> next(){
		return next;
	}
	
	public void next(Node<E> next) {
		this.next = next;
	}
	
	public void data(E data) {
		this.data = data;
	}
	
	public E data() {
		return this.data;
	}
	@Override
	public String toString() {
		return data.toString();
	}
	
	
}
