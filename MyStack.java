package stacks;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack<E> implements StackInterface<E> {
	
	private MyNode head;
	private int size;
	
	class MyNode   
	{
		E value;
		MyNode next;

		public MyNode()
		{
			next = null;
			value = null;
		} 
		
		public String toString() 
		{
			return value.toString();
		}
		

	}
	
	public MyStack()
	{
		
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
	
	public static void main(String[] args) {
		MyStack <Integer> s = new MyStack<Integer>();
		s.push(20);
		s.push(50);
		s.push(80);
		s.push(40);
		s.push(60);
		s.push(75);
		System.out.println("Element removed from LinkedList: "+s.pop());
		System.out.println("Element removed from LinkedList: "+s.pop());
		s.push(10);
		System.out.println("Element removed from LinkedList: "+s.pop());
		
		s.display();
	}
	
	

}
