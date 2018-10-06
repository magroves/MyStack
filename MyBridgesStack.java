package stacks;

import bridges.connect.Bridges;

import java.util.EmptyStackException;

import bridges.base.Element;
import bridges.base.SLelement;

import stacks.MyStack.MyNode;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;


import bridges.base.Element;
import bridges.base.SLelement;

public class MyBridgesStack<E> extends MyStack<E> implements StackInterface<E>{
	
	private MyNode head;
	private int size;
	
	public static void main(String args[]) {
		
		Bridges bridges = new Bridges(3,"magroves", "1226519867954");
		SLelement <E> s = new SLelement<E>();
			
		
	}
	
	@Override
	public void push(E newEntry) {
		MyNode e = new MyNode();
		e.next = head; 
		e.value = newEntry;
		head = e;   
		size++;	
	}

	@Override
	public E pop() throws EmptyStackException{
		E item = head.value;
		head = head.next;
		size--;
		return item;
	}

	@Override
	public E peek() {
		return head.value;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public void clear() 


	{
		head = null; 
	}

	public E head(){
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		return head.value;
	}

	public int size()

	{
		return size;
	}

	public void display() {
		System.out.printf("Top of stack: %s\n", head);
		for (MyNode current = head.next; current != null; current = current.next) {
			if (current.next == null) {
				System.out.printf("Bottom Stack: %s\n", current);
			} else {
				System.out.printf("%16s\n", current);
			}
		}
	}

}
