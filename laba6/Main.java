package laba66;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main
{

	public static void help()
	{
		System.out.println
		(
			"Container comands:\n\n" + 
			"[add]  Add new string to container."
			+ "\n{The add function}\n\n" +
			"[create]  Fill's the container with random strings"
			+ "\n{The autoFill function}.\n\n" +
			"[clear]  Clears the container"
			+ "\n{The clear function}.\n\n" +
			"[print]  Print data of the container"
			+ "\n{The print function}.\n\n" +
			"[help]  Shows help"
			+ "\n{The help function}.\n\n" +
			"[CreateThread] Creates a Thread"
			+ "\n{The Thread function}.\n\n\n\n\n" +
			"Thread comands:\n\n" + 
			"[CreateThread]  Creates a Thread \n\n"
		   +"[TestList]  Shows the list of possible tests with thread\n\n"
		   +"[BeginTesting]  starts working with Threads \n\n"
		   +"[ShowResult]  shows the result of working with Threads \n\n"
		   +"[NoThread]  starts working without Threads \n\n"+
			"Type [exit] to exit from the program.\n\n"
		);
	}
	
	
	static String wordSearch = "";
	
	static String wordCalc = "";
	
	static char letterCalc;
	
	static int cont = 0;
	
	public static void main(String[] args) throws Exception
	{
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		
		Container test = new Container();
		
		Container numOfTests = new Container();
		int count12 = 1;
		int timeEnd = 0;
		
		double threadTime = 0;
		
		double noThreadTime = 0;
		
		int counter1 = 0;

		help();
		
		System.out.println("Enter the comand");
		
		while(true)
		{
			System.out.print("~-~ ");
			
			switch(reader.nextLine())
			{
				case "CreateThread":
					
					System.out.println("To create a Thread you need to enter the interruption time");
					
					System.out.println("Enter the time for interruption");
					
					timeEnd = 1000 * Integer.parseInt(reader.nextLine());
					
					break;
					
				case"TestList":
				{
					System.out.println
							(
								"[MaxLength]  Test that finds maxlength of the word"
								+ "\n" +
								"[LinearSearch]  Test that finds the word using LinearSearch"
								+ "\n" +
								"[LetterCalculation]  Test that calculates the number of entered letter in the word"
								+ "\n" +	
								"[done] Stops the Test chosing"
							);
					
					String chosen;
					while(true)
					{
						chosen = reader.nextLine();
						
						if(chosen.equals("done"))
						{
							break;
						}
						else if(chosen.equals("LetterCalculation"))
						{
							System.out.println("Enter the word to find:");
							
							String sek0 = reader.nextLine();
							
							wordCalc = sek0;
							
							System.out.println("Enter the letter to find:");
							
							char sek1 = reader.nextLine().charAt(0);
							
							letterCalc= sek1;
							
							numOfTests.add(chosen);
							
						}
						else if(chosen.equals("LinearSearch"))
						{
							System.out.println("Enter the word to find:");
							
							String sek = reader.nextLine();
							
							wordSearch = sek;
							
							numOfTests.add(chosen);
							
						}
						else
							numOfTests.add(chosen);
							
					}
					
					break;
				}
				
				case"BeginTesting":
				{
					if(numOfTests == null)
					{
						System.out.println("Choose tests before starting");
						
						break;
					}
					
					LinearSearch search = null;
					
					LetterCalculation lettercalc = null;
					
					MaxLength max = null;
					
					double time = System.currentTimeMillis();
					
					for(String i : numOfTests)
					{
						if(i.equals("LetterCalculation"))
						{
							
							lettercalc = new LetterCalculation(test,wordCalc,timeEnd,letterCalc,counter1);
						}
						else if (i.equals("LinearSearch"))
						{
							
							search = new LinearSearch(test,wordSearch,timeEnd);
						}
						
						if(i.equals("MaxLength"))
						{
							max = new MaxLength(test,timeEnd);
						}
					}
					
					
					if(search != null)
					{
						search.thread.join();
					}
					
					if(lettercalc != null)
					{
						lettercalc.thread.join();
					}
					
					if(max != null)
					{
						max.thread.join();
					}
					
					threadTime = (System.currentTimeMillis() - time) / 1000;
					
					break;
				}
				
				case"ShowResult":
				{
					System.out.print
					(
							"_______________________________________________________ \n"
						   +"|     |      _     _   __            ___      |       |\n"	
						   +"|     |     |_|   |_  |_   |  |  |    |       |       |\n"		
						   +"|     |     | >_  |_  __|  |__|  |__  |       |       |\n"		
						   +"|     |                                       |       |\n"		
						   +"|     | With Thread | "+ threadTime +        "                   |       | \n"		
						   +"|     |                                       |       |\n"	
						   +"|     | Without Thread | "+ noThreadTime +   "                |       |       \n"		
						   +"|     |_______________________________________|       |\n"		
						   +"|     |                                       |       |\n"			
						   +"|     |     With Thread vs Without Thread     |       |\n"	
						   +"|     |                                       |       |\n"		
						   +"|     |            "+ noThreadTime / threadTime +    "         |       |         \n"
						   +"|     |                                       |       |\n"				
						   +"|_____|_______________________________________|_______|\n"		
					);
					
					break;
				}
				
				case"NoThread":
				{
					noThreadTime = System.currentTimeMillis();
					for(String i: numOfTests)
					{
						if(i.equals("LetterCalculation"))
						{
							lettercalculation(test);
						}
						else if (i.equals("LinearSearch"))
						{
							linearsearch(test);
						}
						else if(i.equals("MaxLength"))
						{
							maxlength(test);
						}
					}
					
					noThreadTime = (System.currentTimeMillis() - noThreadTime) / 1000;
					
					break;
				}
				
				case "help":
					
					help();
					
					break;

				case "add":
					
					System.out.print("Enter the string to add: ");
					
					test.add(reader.nextLine());
					
					cont++;
					
					break;
					
				case "clear":
					
					test.clear();
					
					System.out.println("Container was cleared.");
					
					break;
				case "create":
						create(test);
					break;
				case "print":
					
					System.out.println("List of strings: ");
					
					for(String string: test)
					{
						System.out.printf("%d WORD: \n",count12);
						System.out.println(string);
						count12++;
						System.out.println();
					}
					
					break;
					
				case "exit":
					
					System.out.println
					(
							"__________________________________________________________ \n"
						   +"|     |                                           |       |\n"	
						   +"|     |   _______                    ________     |       |\n"     	
						   +"|     |   |      |       \\\\     //  |________|    |       |\n"         		
						   +"|     |   |      |        \\\\   //   |             |       |\n"		
						   +"|     |   |_______|        \\\\ //    |             |       |\n"
						   +"|     |   |        |         //     |________     |       |\n"	
						   +"|     |   |         |	    //      |________|    |       |\n"	
						   +"|     |   |          |     //       |             |       |\n"		
						   +"|     |   |         |     //        |             |       |\n"			
						   +"|     |   |        |     //         |________     |       |\n"     
						   +"|     |   |_______|     //          |________|    |       |\n"		
						   +"|     |                                           |       |\n"          
						   +"|     |                                           |       |\n"				
						   +"|_____|___________________________________________|_______|\n"		
					);
					
					return;
					
			}
		}
	}

	
	@SuppressWarnings("static-access")
	public static void linearsearch(Container con) 
	{
		Thread thread = Thread.currentThread();
		
		for(String i: con)
		{
			try 
			{
				thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			if(i.equals(wordSearch))
			{
				System.out.println("NoThread: WordSearch - yes");
				
				return;
			}
		}
		
		System.out.println("NoThread: WordSearch - no");
	}
	
	
	@SuppressWarnings("static-access")
	public static void maxlength(Container con) 
	{
		int max = 0;
		
		int k = cont;
		
		Thread thread = Thread.currentThread();
		
		for(int i = 0; i < k; i++)
		{
			try 
			{
				thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			if(max  < con.at(i).length())
			{
				max = con.at(i).length();
			}
			
		}
		
		System.out.println("NoThread: MAX - "+ max);
	}
	
	
	@SuppressWarnings({ "unlikely-arg-type", "static-access" })
	public static void lettercalculation(Container con) 
	{
		ArrayList<String> m = new ArrayList<String>();
		m.add(wordCalc);
		int counter = 0;
		
		Thread thread = Thread.currentThread();
		
		for(String i: con)
		{
			try 
			{
				thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			if(m.contains(wordCalc) && i.equals(wordCalc))
			{
				StringBuilder wor = new StringBuilder(wordCalc.subSequence(0, wordCalc.length()));
				
				for(int j = 0; j < wor.length(); j++)
				{
					if(wor.charAt(j) == letterCalc)
					{
						counter++;
					}
					
				}
				System.out.println("NoThread: There are " + counter + " such letters in this word");

				return ;
			}
		}
		
		System.out.println("NoThread: No Word Found");
	}
	
	public static void create(Container con)
	{
		int o;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many objects do u want to create?");
		
		o = scan.nextInt();
		
		String[] randomStrings = new String[o];
		
	    Random random = new Random();
	    
	    for(int i = 0; i < o; i++)
	    {
	        char[] word = new char[random.nextInt(200)+100];
	        
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        
	        randomStrings[i] = new String(word);
	        
	        con.add(randomStrings[i]);
	        cont++;
	    }
	}
}
