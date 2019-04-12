package laba3;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Album
{
	
	public String name;
	
	public String genre;
	
	public String peformer;
	
	public String date;
	
	public String description;
	
	public String duration;
	
	public String type ;
	
	public boolean answer = false;
	
	public Rating rate = new Rating();
	
	public Album(Scanner in) throws UnsupportedEncodingException
	{
	     
		System.out.print("Enter the ~Name~ : ");
		name = in.nextLine();
		
		System.out.print("Enter the ~Genre~ : ");
		genre = in.nextLine();
		
		System.out.print("Enter the ~Peformer~ : ");
		peformer = in.nextLine();
		
		System.out.print("Enter the ~Date~ : ");
		date = in.nextLine();
		
		String answ;
		System.out.print("Does this compostion has the ~Text~ ?\n(enter 'Yes' or 'No')\n");
		answ = in.nextLine();
		switch(answ) 
		{
			case "Yes":
			{
				answer = true;
				
				System.out.print("Enter the ~Text~ : ");
				description = in.nextLine();
				break;
			}
			
			case "No":
				break;
				
		}
		
		System.out.print("Enter the ~Duration~ : ");
		duration = in.nextLine();
		
		System.out.print("Enter the ~Type~ : ");
		type = in.nextLine();
		
		
		System.out.println("~-----~");
		System.out.println("Enter the ~Rating~ : \n");
		
		System.out.print("Enter the ~Contest~ : ");
		rate.setContest(in.nextLine());
		rate.Contest(this.rate.getContest());
		
		System.out.print("Enter the ~Place~ : ");
		rate.setPlace(in.nextInt());
		rate.place(this.rate.getPlace());
		
		System.out.println("~~ The Audio was created ~~\n");
		
	}
	
	
	public Album()
	{
		
	}
	
	
	public void EnteredInfo() throws UnsupportedEncodingException
	{
		System.out.println();
		
		System.out.printf
		(
			"Your Album:\n"+
			"~~Name~~:\t%s\n"+
			"~~Genre~~:\t%s\n"+
			"~~Peformer~~:\t%s\n"+
			"~~Date~~:\t%s\n",
			
			name,
			genre,
			peformer,
			date
			
		);
		
		if(answer == true)
		{
			System.out.printf("~~Text~:\t%s\n",description);
			
		}
		else
			System.out.println("~~Text~~ is missing");
		
		System.out.printf
		(
			"~~Duration~~:\t%s\n"+
			"~~Type~~:\t%s\n",
			
			duration,
			type
		);
		
		System.out.println();
		
		System.out.println("The ~Rating~ : ");
		System.out.printf("~~Contest~~:\t%s\n",this.rate.getContest());
		System.out.printf("~~Place~~:\t%s\n",this.rate.getPlace());
		
	}
	
	public int Get()
	{
		return this.rate.getPlace();
	}
}