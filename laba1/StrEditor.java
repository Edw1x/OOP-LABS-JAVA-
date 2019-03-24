package demo;

public class StrEditor 
{
	static StringBuilder sentence;
	
	//using string builder
	static void settings(String koks)
	{
		sentence = new StringBuilder(koks);
	}
	
	//breaking a sentence after dot
	static void tut()
	{
		for(int i = 0; i < sentence.length(); i++) 
		{
		    System.out.print(sentence.charAt(i));
			if(sentence.charAt(i) == '.')
			{
				System.out.println();
				i++;
			}
		}
		
	    System.out.println();
	}
	
	static void WordChecker(int debug)
	{
		int conter,mount;
		int indexOfSpace = -1;
		int nextIndexOfSpace = 0;
		int lastIndexOfSpace = sentence.lastIndexOf(" ");
		String substr1;
		int l;
		
		do
		{
		    conter = 0;
			mount = 0;
			nextIndexOfSpace = sentence.indexOf(" ",indexOfSpace+1);
			
			//end
			if (nextIndexOfSpace ==-1)
			{
				break;
			}
			
			
			substr1 = sentence.substring(indexOfSpace+1,nextIndexOfSpace);
			indexOfSpace = nextIndexOfSpace;
			l = substr1.length();
			
			//checking the word with the dot after it
			if(substr1.charAt(l-1) == '.')
			{
				if(substr1.charAt(0) == substr1.charAt(l-2))
				{
					mount = 1;
					System.out.println("WORD IS CORRECT:");
					System.out.println(substr1.substring(0,l-1));
				}
				else if(debug == 1)
				{
					conter = 1;
					System.out.println("WORD IS INCORRECT:");
					System.out.println(substr1.substring(0,l-1));
				}
			}
			
			//main checking algorithm
			if(substr1.charAt(0) == substr1.charAt(l-1))
			{
				System.out.println("WORD IS CORRECT:");
				System.out.println(substr1);
			}
			else if(debug == 1 && conter == 0 && mount == 0)
		    {
			    System.out.println("WORD IS INCORRECT:");
			    System.out.println(substr1);
		    }
			
			
			//last word check
			if(nextIndexOfSpace == lastIndexOfSpace)
			{ 
				if(sentence.charAt(lastIndexOfSpace+1) == sentence.charAt(sentence.length()-2))
				{
					System.out.println("WORD IS CORRECT:");
					System.out.println(sentence.substring(lastIndexOfSpace+1,sentence.length()-1));
				}
				else if(debug == 1)
				{
					System.out.println("WORD IS INCORRECT:");
					System.out.println(sentence.substring(lastIndexOfSpace+1,sentence.length()-1));
				}
			}
			
		}
		
		//do while out of bound error
	    while(indexOfSpace != -1);
	}
	
}
