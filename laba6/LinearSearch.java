package laba66;

public class LinearSearch implements Runnable
{
	Container con;
	
	String word;
	
	double time = 0;
	
	int timeEnd = 0;
	
	public Thread thread;
	
	public LinearSearch(Container cont, String word, int timeEnd)
	{
		this.con = cont;
		
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
			time = System.currentTimeMillis();
			
			for(String i: con)
			{
				if(System.currentTimeMillis() - time > timeEnd)
				{
					thread.interrupt();
				}
				
					thread.sleep(500);

				if(i.equals(word))
				{
					System.out.println("WithThread: yes");
					
					return;
				}
			}
			System.out.println("WithThread: No");
			
			time = System.currentTimeMillis() - time;
		}
		catch(InterruptedException e)
		{
			System.out.println("~~~~~ Thread has been Interapted ~~~~~~~~~~~~");
		}

	}
}
