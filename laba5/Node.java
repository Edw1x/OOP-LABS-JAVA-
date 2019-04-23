package laba5;

import java.io.Serializable;


public class Node<T> implements Serializable 
{
	private static final long serialVersionUID = 1L;
	public T data;
	public Node<T> next;
	
	public Node()
	{
		
	}
	
	public Node(T data, Node<T> next) 
	{
		this.data = data;
		this.next = next;
	}
}