package laba66;

import java.util.ArrayList;

public class LetterCalculation implements Runnable
{
	Container con;
	
	String word;
	
	char letter;
	
	double time = 0;
	
	int timeEnd = 0;
	
	int counter = 0;
	
	public Thread thread;
	
	public LetterCalculation(Container cont, String word, int timeEnd, char letter, int counter)
	{
		this.con = cont;
		
		this.counter = counter;
		
		this.letter = letter;
		
		this.word = word;
		
		this.timeEnd = timeEnd;
		
		thread  = new Thread(this,"LinearSearch");
		
		thread.start();
	}
	
	@SuppressWarnings("static-access")
	public void run()
	{
		try 
		{
			ArrayList<String> m = new ArrayList<String>();
			m.add(word);
			
			time = System.currentTimeMillis();
			
			for(String i: con)
			{
				if(System.currentTimeMillis() - time > timeEnd)
				{
						thread.interrupt();
				}
				
					thread.sleep(1000);

				
				if(m.contains(word) && i.equals(word))
				{
					StringBuilder wor = new StringBuilder(word.subSequence(0, word.length()));
					
					for(int j = 0; j < wor.length(); j++)
					{
						if(wor.charAt(j) == letter)
						{
							counter++;
						}
						
					}
					System.out.println("WithThread: There are " + counter + " such letters in this word");

					return ;
				}
			}
			System.out.println("No Word Found");
			
			time = System.currentTimeMillis() - time;
		}
		catch(InterruptedException e)
		{
			System.out.println("~~~~~ Thread has been Interapted ~~~~~~~~~~~~");
		}
		
	}
}
