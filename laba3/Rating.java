package laba3;

public class Rating 
{
	
	private String contest;
	private int place;
	
	public String Contest() 
	{ 
		return this.getContest();
	}

	public void Contest(String contest) 
	{ 
		this.setContest(contest);
	}
	
	public String getContest() 
	{
		return contest;
	}

	public void setContest(String contest)
	{
		this.contest = contest;
	}
	
	public int place() 
	{
        return this.getPlace();
    }
	
	public void place(int place)
	{
		this.setPlace(place);
	}

	public int getPlace() 
	{
		return place;
	}

	public void setPlace(int place) 
	{
		this.place = place;
	}

}
