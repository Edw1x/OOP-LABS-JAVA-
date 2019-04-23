package laba5;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;

public class LocationFounder implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	Scanner reader;
	
	ArrayList<String> dataSaver = new ArrayList<String>();

	public LocationFounder()
	{
		
	}
	
	public LocationFounder(Scanner input)
	{
		reader = input;
		
		for(String folders: System.getProperty("user.dir").split("\\\\"))
		{
			dataSaver.add(folders);
		}
	}

	public void foldersInfo()
	{
		File file = new File(String.join("\\", dataSaver));
		
		for(File fileCheck: file.listFiles())
		{
			if(fileCheck.isFile())
			{
				System.out.println("File: " + fileCheck.getName());
			}
			else
				System.out.printf("Folder: %s\n", fileCheck.getName());
		}
	}

	public boolean yourDecision()
	{
		String decision = reader.nextLine();
		
		if(decision.substring(0, 5).equals("back "))
		{
			dataSaver.remove(dataSaver.size() - 1);
			return false;
		}
		
		else if(decision.substring(0, 3).equals("go "))
		{
			dataSaver.add(decision.substring(3));
			return false;
		} 
		
		else 
		{
			dataSaver.add(decision);
			return true;
		}
	}

	public String directoryChoose()
	{
		do
		{
			System.out.println("~-----~\n");
			System.out.println("You are here: " + String.join("\\", dataSaver));
			
			foldersInfo();
			
			System.out.print("~-~ ");
			
		}
		while(yourDecision() == false);
		
		return String.join("\\", dataSaver);
		
	}

}
