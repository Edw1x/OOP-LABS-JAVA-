package laba66;


public class MaxLength implements Runnable
{
	Container container;
	int max = 0;
	
	double time = 0;
	
	int timeEnd = 0;
	
	public Thread thread;
	
	public MaxLength(Container container,int timeEnd)
	{
		this.container = container;
		
		this.timeEnd = timeEnd;
		
		thread = new Thread(this,"Max");
		
		thread.start();
		
	}
	
	@SuppressWarnings("static-access")
	public void run()
	{
		try
		{
			time = System.currentTimeMillis();
			
			for(int i = 0;i < container.size();i++)
			{
				if(System.currentTimeMillis() - time > timeEnd)
				{
					thread.interrupt();
				}
	
	
					thread.sleep(500);
				
				if(max < container.at(i).length())
				{
					max = container.at(i).length();
				}
			}
			System.out.println("WithThread: MAX - " + max);
			
			time = System.currentTimeMillis() - time;
		}
		catch(InterruptedException e)
		{
			System.out.println("~~~~~ Thread has been Interapted ~~~~~~~~~~~~");
		}
	}
}
