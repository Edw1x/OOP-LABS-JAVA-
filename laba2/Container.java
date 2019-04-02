package laba1;

import java.util.Iterator;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Container implements Iterable<String>, Serializable
{
	
	private static final long serialVersionUID = 1;

	private String[] theDataContainer = new String[0];
	
	private int realSize = 0;

	public static Container deserialize(String fname)
	{
		Container obj = null;
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
			obj = (Container) ois.readObject();
			ois.close();
			return obj;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("The file does not contain StringIterable class.");
		}
		catch(StreamCorruptedException e)
		{
			System.out.println("Serialized data is corrupted.");
		}
		catch(IOException e)
		{
			System.out.println("Error with opening the file.");
		}

		return obj;
	}
	
	
	public void serializeTo(String fname)
	throws Exception
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
		oos.writeObject(this);
		oos.close();
	}

	public Iterator<String> iterator()
	{
		return new Iterator<String>()
		{

			private int index = -1;

			public boolean hasNext()
			{
				return index + 1 < theDataContainer.length;
			}

			public String next()
			{
				return theDataContainer[++index];
			}

			public void remove()
			{
				String[] newData = new String[--realSize];
				
				for(int i = 0, j = 0; i < theDataContainer.length; i++)
				{
					if(i != index)
					{
						newData[j++] = theDataContainer[i];
					}
				}
				
				theDataContainer = newData;
			}

		};
	}

	
	public String toString()
	{
		return String.join(", ", theDataContainer);
	}

	
	public void add(String string)
	{
		
		String[] newData = new String[theDataContainer.length + 1];
		System.arraycopy(theDataContainer, 0, newData, 0, theDataContainer.length);
		newData[realSize] = string;
		theDataContainer = newData;
		realSize++;
	}

	
	public void clear()
	{
		theDataContainer = new String[0];
		realSize = 0;
	}

	
	public boolean remove(String string)
	{
		Iterator<String> iter = this.iterator();

		while(iter.hasNext())
		{
			if(string.equals(iter.next()))
			{
				iter.remove();
				return true;
			}
		}

		return false;
	}

	
	public String[] toArray()
	{
		return theDataContainer;
	}

	
	public int size()
	{
		return realSize;
	}

	
	public boolean contains (String string)
	{
		Iterator<String> iter = this.iterator();

		while(iter.hasNext())
			if(string.equals(iter.next()))
				return true;

		return false;
	}


	public boolean containsAll(Container container)
	{
		for(String string: container)
		{
			if(!this.contains(string))
			{
				return false;
			}
		}

		return true;
	}

	
	
	public int indexOf(String string)
	{
		for(int i = 0; i < theDataContainer.length; i++)
		{
			if(theDataContainer[i].equals(string))
			{
				return i;
			}
		}

		return -1;
	}

	

	public void sort()
	{
		boolean isSwapped = false;
		
		do 
		{
		    isSwapped = false;
		    
		    for(int i = 0; i < theDataContainer.length-1; i++)
		    {
		        if(theDataContainer[i].compareTo(theDataContainer[i + 1]) > 0)
		        {
		            String temp = theDataContainer[i+1];
		            theDataContainer[i+1] = theDataContainer[i];
		            theDataContainer[i] = temp;
		            
		            isSwapped = true;
		        }
		    }
		}
		while(isSwapped);
	}
	
}
