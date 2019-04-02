package laba1;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.io.IOException;

public class Main
{

	public static void help()
	{
		System.out.println(
"Container comands:\n\n" + 
"[unser]  Upload container from the file"
+ "\n{The deserialize function}.\n\n" + 
"[ser]  Save container to the file"
+ "\n{The serialize function}.\n\n" + 
"[sort]  Sort strings in container"
+ "\n{sort function}.\n\n" +
"[add]  Add new string to container."
+ "\n{The add function}\n\n" +
"[del]  Deletes the given string"
+ "\n{The delete function}.\n\n" +
"[clear]  Clears the container"
+ "\n{The clear function}.\n\n" +
"[indexOf]  Shows index of the given string"
+ "\n{The element find function}.\n\n" +
"[print]  Print data of the container"
+ "\n{The print function}.\n\n" +
"[compareTo] Upload another container from file and compare with the current one"
+ "\n{The compare function}.\n\n" +
"Type [exit] to exit from the program.\n\n");
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner reader = new Scanner(System.in);
		Container obj = new Container();

		help();
		System.out.println("Enter the comand");
		while(true)
		{
			System.out.print("~-~ ");
			switch(reader.nextLine())
			{
				case "help":
					help();
					break;

				case "unser":
					System.out.print("Path of the file to upload: ");
					obj = Container.deserialize(reader.nextLine());
					if(obj != null)
					{
						System.out.println("Uploaded " + obj.size() + " strings.");
					}
					break;

				case "ser":
					System.out.print("Path of the file to serialize in: ");
					try
					{
						obj.serializeTo(reader.nextLine());
					}
					catch(IOException e)
					{
						System.out.println("Error with opening the file.");
					}
					System.out.println("Saved " + obj.size() + " strings.");
					break;

				case "sort":
					obj.sort();
					System.out.println("Container was sorted.");
					break;

				case "indexOf":
					System.out.print("Enter the string to search: ");
					int i = obj.indexOf(reader.nextLine());
					System.out.println(i);
					System.out.println("String you want to find has the following index: " +(i != -1 ? i : "<not found>"));
					break;


				case "del":
					System.out.print("Enter the string to search: ");
					if(obj.remove(reader.nextLine()))
					{
						System.out.println("String was deleted.");
					}
					else
					{
						System.out.println("No such string found.");
					}
					break;

				case "add":
					System.out.print("Enter the string to add: ");
					obj.add(reader.nextLine());
					break;
				case "cont":
					System.out.println("Enter the string to check");
					System.out.println(obj.contains(reader.nextLine()));
					break;
				case "clear":
					obj.clear();
					System.out.println("Container was cleared.");
					break;

				case "print":
					System.out.println("List of strings: ");
					for(String string: obj)
						System.out.println(string);
					break;

				case "compareTo":
					if(obj == null)
					{
						System.out.println("Current object is empty.");
						break;
					}
					System.out.print("Path of the file to upload: ");
					Container cmpobj = obj.deserialize(reader.nextLine());
					if(obj.containsAll(cmpobj))
					{
						System.out.println("The data is eaqual");
					}
					else
					{
						System.out.println("The data is different");
					}
					break;
				case "exit":
					System.out.println("Thanks for using my container, bye");
					return;
			}
		}
	}

}
