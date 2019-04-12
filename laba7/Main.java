package laba3;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Main
{

	static ArrayList<Album> Albums = new ArrayList<>();
	
	static ArrayList<Album> Test = new ArrayList<>();
	
	static LocationFounder location = null;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception,FileNotFoundException
	{
		Locale.setDefault(new Locale("uk", "UA"));
		Scanner reader = new Scanner(System.in, "UTF-8");
		
		help();
		
		while(true)
		{
			location = new LocationFounder(new Scanner(System.in));
			
			if(args.length > 0)
			{
				if(args[0].equals("-sort") || (args.length > 4 && args[4].equals("-sort")) && Albums.size() >= 2)
				{
					System.out.println("~--~ Automatic sorting have been engaged...");
					Collections.sort(Albums);

				}
			}
				
			System.out.print("~-~ ");
			switch(reader.nextLine())
			{
				case "ser":
					
					serialize();
					
					break;
				case "unser":
					
					deserialize();
					
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
					
					for(int i = 0, z = 1; i < Albums.size(); i++,z++)
					{
						if(z == inek)
						{
							find = true;
							Albums.remove(i);
						}
					}
					
					if(find == false)
					{
						System.out.println("~--~ The Album of entered index wasn't resolved ~--~ \n");
					}
					else
						System.out.println("~--~ Album was succsessfully removed ~--~ \n");
					
					break;
				case "sort":
					
					boolean isSwapped = false;
					
					System.out.println("~--~ Sorting...\n");
					
					Collections.sort(Albums);

					System.out.println("~--~ The Albums were sorted ~--~ \n");
					break;
				case "search":
					
					System.out.println("~--~ Enter the index to search: ");
					int index = reader.nextInt();
					
					boolean fin = false;
					
					for(int i = 0, n = 1; i < Albums.size(); i++,n++)
					{
						if(n == index)
						{
							fin = true;
							Albums.get(i).EnteredInfo();
						}
					}
					
					if(fin == false)
					{
						System.out.println("~--~ The Album of entered index wasn't resolved ~--~ \n");
					}
					
					break;
				case "print":
					
					System.out.printf("~--~ %s Albums were entered ~--~\n", Albums.size());
					System.out.println("~--~ Printing...\n");
					
					for(int i = 0,j = 1; i < Albums.size(); i++,j++)
					{
						System.out.printf("¹%d ~--~ AudioComposition ", j);
						Albums.get(i).EnteredInfo();
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

	public static void serialize() throws FileNotFoundException
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

	@SuppressWarnings("unchecked")
	public static void deserialize() throws FileNotFoundException
	{

		System.out.println("~--~ Choose the file to read out ~--~");
		System.out.println("~--~ Deserializing...");
		
		XMLDecoder decoder = new XMLDecoder(new FileInputStream(location.directoryChoose()));
		
		Albums = (ArrayList<Album>) decoder.readObject();
		
		System.out.println("~--~ Deserialized ~--~\n");
		
		decoder.close();
	}

}