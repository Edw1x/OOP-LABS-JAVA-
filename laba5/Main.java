package laba5;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.util.Locale;
import java.util.Scanner;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileNotFoundException;

public class Main implements Serializable
{

	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;

	
	static LocationFounder location = null;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception,FileNotFoundException
	{
		LinkedList<Album> Albums = new LinkedList<Album>();
		
		Locale.setDefault(new Locale("uk", "UA"));
		Scanner reader = new Scanner(System.in);
		boolean auto = false;
		help();
		
		if(args.length > 0)
		{
			if(args[0].equals("-auto") || (args.length > 4 && args[4].equals("-auto")))
			{
				System.out.println("~--~ Automatic saving have been engaged...");
				auto = true;      
			}
		}
		
		while(true)
		{
			location = new LocationFounder(new Scanner(System.in));
			
			if(auto)
			{
				System.out.println("Pick the file .(txt)");
				System.out.println("~--~ To move through the folders enter [go 'folder's name']\n"
						+ "~--~ To return back enter [back 'folder's name']");
				Albums = deserialize();
				auto = false;
			}
				
			System.out.print("~-~ ");
			switch(reader.nextLine())
			{
				case "toString":

				System.out.println(Albums.toString());
				
				break;
				case "ser":

					serialize(Albums);
					
					break;
				case "unser":
				
					Albums = deserialize();
					
					break;
				case "serXML":

					serializeXML(Albums);
					
					break;
				case "unserXML":
				
					Albums = deserializeXML();
					
					break;
				case "add":
					
					System.out.println("~--~ Adding new album...");
					
					Albums.add(new Album(reader));
					
					break;
				case "remove":
				
					System.out.println("~--~ Enter the index to remove: ");
					int inek = reader.nextInt();
					
					System.out.println("~--~ Removing current Album...");
					
					boolean find = false;
					
					int z = 1;
					for(Album i: Albums)
					{
						if(z == inek)
						{
							find = true;
							Albums.remove(i);
						}
						z++;
					}
					
					if(find == false)
					{
						System.out.println("~--~ The Album of entered index wasn't resolved ~--~ \n");
					}
					else
						System.out.println("~--~ Album was succsessfully removed ~--~ \n");
					
					break;
				case "search":
					
					System.out.println("~--~ Enter the index to search: ");
					int index = reader.nextInt();
					
					boolean fin = false;
					
					int n = 1;
					for(Album i: Albums)
					{
						if(n == index)
						{
							fin = true;
							i.EnteredInfo();
						}
						n++;
					}
					
					if(fin == false)
					{
						System.out.println("~--~ The Album of entered index wasn't resolved ~--~ \n");
					}
					
					break;
				case "print":
					
					System.out.printf("~--~ %s Albums were entered ~--~\n", Albums.size());
					System.out.println("~--~ Printing...\n");
					
					int j = 1;
					for(Album indexito: Albums)
					{
						System.out.printf("%d ~--~ AudioComposition ", j);
						indexito.EnteredInfo();
						j++;
						System.out.println("~-----~\n");
					}
					System.out.println("~--~ The info was printed ~--~ \n");
					
					break;
				case "clear":
					
					System.out.println("~--~ Clearing...\n");
					
					Albums.clear();
					
					break;
				case "exit":
					
					System.out.println("~--~ Exiting...");
					
					return;
			}
		}
	}
	public static void help()
	{
		System.out.println(
"Album's commands:\n\n" + 
"[unser]  Upload All Albums from the file"
+ "\n{The deserialize function}.\n\n" + 
"[ser]  Save All Albums to the file"
+ "\n{The serialize function}.\n\n" + 
"[add]  Add new Album to container."
+ "\n{The add function}\n\n" +
"[clear]  Clears the container"
+ "\n{The clear function}.\n\n" +
"[print]  Print all Albums "
+ "\n{The print function}.\n\n" +
"Type [exit] to exit from the program.\n\n");
	}
	
	@SuppressWarnings("rawtypes")
	public static void serializeXML(LinkedList Albums) throws FileNotFoundException
	{
		
		System.out.printf("~--~ %s Albums were entered ~--~\n", Albums.size());
		System.out.println("~--~ Serializing...");
		System.out.println("~--~ To move through the folders enter [go 'folder's name']\n"
				+ "~--~ To return back enter [back 'folder's name']");
		System.out.println("~--~ Create the file or Choose the file to write in ~--~\n");
		
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(location.directoryChoose())));
		
		encoder.writeObject(Albums);
		
		System.out.println("~--~ Serialized ~--~\n");
		
		encoder.close();
	}

	@SuppressWarnings("rawtypes")
	public static LinkedList deserializeXML() throws FileNotFoundException
	{

		System.out.println("~--~ Choose the file to read out ~--~");
		System.out.println("~--~ Deserializing...");
		
		XMLDecoder decoder = new XMLDecoder(new FileInputStream(location.directoryChoose()));

		LinkedList Albums = (LinkedList) decoder.readObject();
		
		System.out.println("~--~ Deserialized ~--~\n");
		
		decoder.close();
		return Albums;
	}

	 public static boolean serialize(@SuppressWarnings("rawtypes") LinkedList object) 
	    {
			System.out.println("~--~ Serializing...");
			System.out.println("~--~ To move through the folders enter [go 'folder's name']\n"
					+ "~--~ To return back enter [back 'folder's name']");
			System.out.println("~--~ Create the file or Choose the file to write in ~--~\n");
	           FileOutputStream fos;
	           try 
	           {
	               fos = new FileOutputStream(location.directoryChoose());
	           } 
	           catch (FileNotFoundException e) 
	           {
	               System.out.println(e);
	               return false;
	           }
	            
	           try 
	           {
	               ObjectOutputStream oos = new ObjectOutputStream(fos);
	               oos.writeObject(object);
	               System.out.println("~--~ Serialized ~--~\n");
	               oos.flush();
	               oos.close();
	               fos.close();
	               return true;
	           } 
	           catch (IOException e) 
	           {
	               System.out.println(e);
	               return false;
	           }
	      }
	 @SuppressWarnings({ "rawtypes", "resource" })
	public static LinkedList deserialize()
	   {
		 	  System.out.println("~--~ Choose the file to read out ~--~");
		 	  System.out.println("~--~ Deserializing...");
	          FileInputStream fis;
	          try 
	          {
	              fis = new FileInputStream(location.directoryChoose());
	          } 
	          catch (FileNotFoundException e) 
	          {
	              System.out.println(e);
	              return null;
	          }
	          try 
	          {
	              ObjectInputStream ois = new ObjectInputStream(fis);
	              
	              LinkedList  temp = (LinkedList) ois.readObject();      
	              System.out.println("~--~ Deserialized ~--~\n");
	              ois.close();
	              return temp;
	          } 
	          catch (IOException e) 
	          {
	              System.out.println(e);
	              return null;
	          }
	          catch (ClassNotFoundException e) 
	          {
	              System.out.println(e);      
	              return null;
	          }
	      }
}