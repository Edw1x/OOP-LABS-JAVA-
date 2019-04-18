package laba4;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedList<T> implements Iterable<T>,Generic<T>,Serializable 
{
	private static final long serialVersionUID = 1L;

	public Node<T> first;
	public Node<T> last;
	public int listSize;
	
	public LinkedList()
	{
		
	}
	
	public LinkedList(Scanner in) 
	{
		first = null;
				
		last = null;
				
		listSize = 0;
	}
	
	public void add(T item) 
	{
		if (item == null) 
		{ 
			throw new NullPointerException(); 
		}
		if (!isEmpty()) 
		{
			Node<T> prev = last;
			last = new Node<T>(item, null);
			prev.next = last;
		}
		else 
		{
			last = new Node<T>(item, null);
			first = last;
		}
			        
		listSize++;
	}
	
	public boolean remove(T item) 
	{
		if (isEmpty()) 
		{ 
			throw new IllegalStateException("Cannot remove() from and empty list."); 
		}
			        
		boolean result = false;
			        
		Node<T> prev = first;
			        
		Node<T> curr = first;
			        
		while (curr.next != null || curr == last) 
		{
			if (curr.data.equals(item)) 
			{
				if (listSize == 1) 
				{ 
					first = null; last = null; 
				}
				else if (curr.equals(first)) 
				{ 
					first = first.next; 
				}
				else if (curr.equals(last)) 
				{ 
					last = prev; last.next = null; 
				}
				else 
				{ 
					prev.next = curr.next; 
				}
				
				listSize--;
				
				result = true;
				
				break;
			}
			prev = curr;
				            
			curr = prev.next;
		}
		return result;
	}
	
	public int size() 
	{
		return listSize;
	}
	
	public boolean isEmpty() 
	{
		return listSize == 0;
	}
		    
	public void clear() 
	{
		for(Node<T> x = first; x != null; ) 
		{
			Node<T> next = x.next;
			x.next = null;
			x = next;
		}
		
		first = last = null;
			        
		listSize = 0;
	}
	
	public Iterator<T> iterator() 
	{ 
		return new LinkedListIterator(); 
	}
	
	public class LinkedListIterator implements Iterator<T> 
	{
		private Node<T> current = first;
		
		public T next() 
		{
			if (!hasNext()) 
			{ 
				throw new NoSuchElementException(); 
			}
			
			T item = current.data;
			current = current.next;
			return item;
		}
		
		public boolean hasNext() 
		{ 
			return current != null; 
		}
		
		public void remove() 
		{ 
			throw new UnsupportedOperationException(); 
		}
	}
	
	@Override public String toString() 
	{
		StringBuilder s = new StringBuilder();
		
		for (T item : this)
		s.append(item + " ");
		return s.toString();
	}		
	    
}
