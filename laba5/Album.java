package laba5;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Album implements Comparable<Album>,Serializable
{
	private static final long serialVersionUID = 1L;

	public String name;
	
	public String genre;
	
	public String peformer;
	
	public String date;
	
	public String description;
	
	public String duration;
	
	public String type ;
	
	public Matcher k = new Matcher();
	
	public boolean answer = false;
	
	public Rating rate = new Rating();
	
	
	
	public Album(Scanner in) throws UnsupportedEncodingException
	{
	     
		System.out.print("Enter the ~Name~ : ");
		do
		{
			name = in.nextLine();
			if((k.Name(name)) == true)
			{
				
			}
			else
				System.out.println("~~ Incorrect format,please enter [A-Z][a-z] ~~ ");
		}
		while(!(k.Name(name)));
		
		System.out.print("Enter the ~Genre~ : ");
		do
		{
			genre = in.nextLine();
			if((k.Genre(genre)) == true)
			{
				
			}
			else
				System.out.println("~~ Incorrect format,please enter [A-Z][a-z] ~~ ");
		}
		while(!(k.Genre(genre)));
		
		System.out.print("Enter the ~Peformer~ : ");
		do
		{
			peformer = in.nextLine();
			if((k.Peformer(peformer)) == true)
			{
				
			}
			else
				System.out.println("~~ Incorrect format,please enter [A-Z][a-z] ~~ ");
		}
		while(!(k.Peformer(peformer)));
		
		System.out.print("Enter the ~Date~ : ");
		do
		{
			date = in.nextLine();
			if((k.Date(date)) == true)
			{
				
			}
			else
				System.out.println("~~ Incorrect format,please enter dd/mm/yyyy ~~ ");
		}
		while(!(k.Date(date)));
		
		String answ;
		System.out.print("Does this compostion has the ~Text~ ?\n(enter 'Yes' or 'No')\n");
		answ = in.nextLine();
		switch(answ) 
		{
			case "Yes":
			{
				answer = true;
				
				System.out.print("Enter the ~Text~ : ");
				do
				{
					description = in.nextLine();
					if((k.Description(description)) == true)
					{
						
					}
					else
						System.out.println("~~ Incorrect format,please enter [A-Z][a-z] ~~ ");
				}
				while(!(k.Description(description)));
				break;
			}
			
			case "No":
				break;
				
		}
		
		System.out.print("Enter the ~Duration~ : ");
		do
		{
			duration = in.nextLine();
			if((k.Duration(duration)) == true)
			{
				
			}
			else
				System.out.println("~~ Incorrect format,please enter [0-23]:[0-59] ~~ ");
		}
		while(!(k.Duration(duration)));
		
		System.out.print("Enter the ~Type~ : ");
		do
		{
			type = in.nextLine();
			if((k.Type(type)) == true)
			{
				
			}
			else
				System.out.println("~~ Incorrect format,please enter MP3 || DVD || CD || DTS || WMA ~~ ");
		}
		while(!(k.Type(type)));
		
		
		System.out.println("~-----~");
		System.out.println("Enter the ~Rating~ : \n");
		
		System.out.print("Enter the ~Contest~ : ");
		do
		{
			rate.setContest(in.nextLine());
			if((k.Contesting(this.rate.getContest())) == true)
			{
				
			}
			else
				System.out.println("~~ Incorrect format,please enter [A-Z][a-z] ~~ ");
		}
		while(!(k.Contesting(this.rate.getContest())));
		rate.Contest(this.rate.getContest());
		
		System.out.print("Enter the ~Place~ : ");
		do
		{
			rate.setPlace(in.nextInt());
			if((k.Place(this.rate.getPlace())) == true)
			{
				
			}
			else
				System.out.println("~~ Incorrect format,please enter [0 - 100 ] ~~ ");
		}
		while(!(k.Place(this.rate.getPlace())));
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


	@Override
	public int compareTo(Album o) 
	{
		return this.Get() < o.Get() ? -1 :(this.Get() > o.Get()) ? 1 : 0 ;
	}
}