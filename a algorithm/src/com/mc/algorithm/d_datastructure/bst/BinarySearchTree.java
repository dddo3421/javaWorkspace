package com.mc.algorithm.d_datastructure.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.mc.algorithm.d_datastructure.list._LinkedList;
import com.mc.algorithm.d_datastructure.queue._Queue;
import com.mc.algorithm.d_datastructure.stack._Stack;

//E : 이 트리 안에 저장될 원소의 타입 (Generic Type Parameter).
//
//extends Comparable<E> : E는 반드시 Comparable 인터페이스를 구현한 타입이어야 함.
//즉, E 타입끼리 비교 가능(compareTo 메소드 보유) 해야 한다는 조건.
public class BinarySearchTree<E extends Comparable<E>> {

	private Node<E> root;
	private int size;

	public int size() {
		return this.size;
	}

	public void insert(E element) {
		Node<E> newNode = new Node<>(element);

		if (size == 0) { // 만약 현재 자료구조에 아무것도 없다면
			root = newNode; // 지금 만든 newNode를 **root(루트 노드)**로 설정
			size++; // 크기(size)를 1 증가시킴
			return;
		}

		Node<E> link = root;

		while (true) {
			if (element.compareTo(link.data()) < 0) { // 새로 삽입할 값 element가 현재 노드 link의 값보다 작으면
				if (link.left() == null) { // 왼쪽 자식이 비어 있다면 새 노드를 왼쪽에 연결
					link.left(newNode);
					break;
				}

				link = link.left(); // 왼쪽 자식이 이미 존재하면 왼쪽 자식으로 이동, 다음 반복에서 다시 비교
			} else {
				if (link.right() == null) {
					link.right(newNode);
					break;
				}

				link = link.right();
			}
		}

		size++;

	}
	
	public void delete (E target) {
		
		Node<E> parent = null;
		Node<E> link = root;
		
		while(link != null && target.compareTo(link.data()) != 0) { // link.data() = 현재 노드가 가진 data값
			parent = link;
			if(target.compareTo(link.data()) < 0 ) {
				link = link.left();
			}else {
				link = link.right();
			}
		}
		// 노드를 찾지 못한 경우
		if(link == null) return;
		
		// 삭제할 노드가 leaf 노드인 경우(왼쪽, 오른쪽 자식 노드들이 전부 null)
		if(link.left() == null && link.right() == null) {
			deleteNode(parent, link, null);
			size--;
			return;
		}
		
		// 자식 노드가 둘인 경우
		if(link.left() != null && link.right() != null) { // 둘 다 null이 아니면 양쪽에 자식노드가 있음
			
			//오른쪽 서브트리에서 가장 작은 노드(후계자) 찾기
			//후계자(successor): 삭제할 노드의 오른쪽 서브트리에서 가장 작은 값
			Node<E> successorParent = link;
			Node<E> successor = link.right();
			
			while(successor.left() != null) { // 가장 작은 자식노드까지 탐색
				successorParent = successor;
				successor = successor.left();
			}
			
			link.data(successor.data());
		
			
			//후계자 노드가 리프노드(자식 노드가 없는 노드)인 경우
			if(successor.right() == null) {			
				deleteNode(successorParent, successor, null);
				return;
			}
			
			
			//후계자 노드의 자식노드가 1개(오른쪽 자식 노드만 존재)만 존재하는 경우
			deleteNode(successorParent, successor, null);
			
			return;
		}
		
		//자식 노드가 1개인 경우
		Node<E> child = link.left() != null ? link.left() : link.right();
		deleteNode(parent, link, child);
		
	}
	// TODO
	// FIXME
	
	private void deleteNode(Node<E> parent, Node<E> current, Node<E> child) {
		//노드가 root 인 경우
		if(parent == null) { //루트이자 리프인 노드(트리에 하나만 존재)를 삭제할 경우
			root = child;
			return;
		}
		
		if(parent.left() != null && parent.left().equals(current)) { // 삭제할 노드(link)가 부모(parent)의 왼쪽 자식인지 확인
			parent.left(child); // 부모의 왼쪽 자식을 null로 바꿔 연결 끊기			
			return;
		}
		
		if(parent.right() == null)return;
		parent.right(child);
	}
	
	
	
	
	// bfs : 너비우선탐색
	// 현재 노드와 인접한 모든 노드를 탐색한 후, 그 다음 레벨의 노드를 탐색하는 방식
	// DB 인덱스를 사용해 데이터를 탐색
	public _LinkedList<E> bfs() {
		_Queue<Node<E>> queue = new _Queue<Node<E>>();
		_LinkedList<E> result = new _LinkedList<E>();

		queue.enqueue(root);
		int level = 1; // 출력용

		while(!queue.isEmpty()) {
		    System.out.print("level : " + level + ": ");
		    int size = queue.size(); // 현재 레벨 노드 수를 미리 저장

		    for (int i = 0; i < size; i++) {
		        Node<E> node = queue.dequeue();
		        System.out.print(node.data() + " ");
		        result.add(node.data());

		        if(node.left() != null) {
		            queue.enqueue(node.left());
		        }

		        if(node.right() != null) {
		            queue.enqueue(node.right());
		        }
		    }
				level++;
				System.out.println();
			}

		
		return result;

	}
	
	public List<E> preOrderRecursive(){
		List<E> result = new ArrayList<E>();
		preOrderHelper(root, result);
		return result;
	}

	private void preOrderHelper(Node<E> node, List<E> result) {
		if(node == null) return;
		result.add(node.data()); // 현재노드 추가
		
		preOrderHelper(node.left(), result); // 왼쪽 자식 순회
		preOrderHelper(node.right(), result); // 오른쪽 자식 순회
	}
	
	// 전위 순회 stack 구현
//	public List<E> preOrder(){
//		Stack<Node<E>> stack = new Stack<>();
//		List<E> result = new ArrayList<>();
//		
//		if(root != null) {
//			stack.push(root);
//		}
//		
//		while(!stack.isEmpty()) {
//			 Node<E> node = stack.pop();         // 1. 스택에서 꺼내 방문
//		       result.add(node.data());    		// 2. 꺼낸 스택을 result로
//		       
//		       if(node.right() != null) {
//		    	   stack.push(node.right());
//		       }
//		       if(node.left() != null) {
//		    	   stack.push(node.left());
//		       }
//		}
//		
//		
//		return result;		
//	}
	
	public List<E> postOrderRecursive(){
		List<E> result = new ArrayList<E>();
		postOrderHelper(root, result);
		return result;
	}
	
	private void postOrderHelper(Node<E> node, List<E> result) {
		
		if(node == null) return;
		postOrderHelper(node.left(), result);
		postOrderHelper(node.right(), result);
		result.add(node.data());
	}
	
	public List<E> postOrder(){
		_Stack<Node<E>> stack = new _Stack<>();
		List<E> result = new ArrayList<>();
			
		stack.push(root);
	    
	    while(!stack.isEmpty()) {
	        Node<E> pointer = stack.pop();
	        result.add(pointer.data());
	        
	        if(pointer.left() != null) {  // 전위 순회 때와 반대로 push
	            stack.push(pointer.left());
	        }
	        if(pointer.right() != null) {
	            stack.push(pointer.right());
	        }
	    }
	    
	    Collections.reverse(result); // 결과 역순으로
	    return result;
	}
	
	
	public List<E> preOrder(){
		_Stack<Node<E>> stack = new _Stack<>();
		List<E> result = new ArrayList<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node<E> pointer = stack.pop();
			result.add(pointer.data());
			
			if(pointer.right() != null) { //왼쪽 자식 노드가 먼저 pop되어야 해서 오른쪽 자식 노드부터 집어넣음 
				stack.push(pointer.right());
			}
			if(pointer.left() != null) {
				stack.push(pointer.left());
			}
		}		
		
		return result;
	}
	
	public List<E> inOrderRecursive(){
		List<E> result = new ArrayList<E>();
		
		inOrderHelper(root, result);
		return result;
	}

	private void inOrderHelper(Node<E> node, List<E> result) {
		if(node == null) return;
		inOrderHelper(node.left(), result);
		result.add(node.data());
		inOrderHelper(node.right(), result);
		
		
	}
	
}
