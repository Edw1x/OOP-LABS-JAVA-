
import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

public class Album
{
	
	private SimpleStringProperty name;
	
	private SimpleStringProperty genre;
	
	private SimpleStringProperty peformer;
	
	private LocalDate date;
	
	private SimpleStringProperty description;
	
	private SimpleStringProperty duration;
	
	private SimpleStringProperty type ;
	
	private SimpleStringProperty contest;
	
	private SimpleStringProperty place;
	
	
	 public Album(String name, String genre, String peformer, LocalDate date, String description, String duration, String type, String contest, String place)
	 {
		this.name = new SimpleStringProperty(name);
		
		this.genre = new SimpleStringProperty(genre);
		
		this.peformer = new SimpleStringProperty(peformer);
		
		this.date = date;
		
		this.description = new SimpleStringProperty(description);
		
		this.duration = new SimpleStringProperty(duration);
		
		this.type = new SimpleStringProperty(type);
		
		this.contest = new SimpleStringProperty(contest);
		
		this.place = new SimpleStringProperty(place);
		
	}
	 
	public String getName() 
	{
		return name.get();
	}

	public void setName(String name)
	{
		this.name = new SimpleStringProperty(name);
	}
	
	public String getGenre() 
	{
		return genre.get();
	}

	public void setGenre(String genre)
	{
		this.genre = new SimpleStringProperty(genre);
	}
	
	public String getPeformer() 
	{
		return peformer.get();
	}

	public void setPeformer(String peformer)
	{
		this.peformer = new SimpleStringProperty(peformer);
	}
	
	public LocalDate getDate() 
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}
	
	public String getDescription() 
	{
		return description.get();
	}

	public void setDescription(String description)
	{
		this.description = new SimpleStringProperty(description);
	}
	
	public String getDuration() 
	{
		return duration.get();
	}

	public void setDuration(String duration)
	{
		this.duration = new SimpleStringProperty(duration);
	}
	
	public String getType() 
	{
		return type.get();
	}

	public void setType(String type)
	{
		this.type = new SimpleStringProperty(type);
	}
	
	
	public String getContest() 
	{
		return contest.get();
	}

	public void setContest(String contest)
	{
		this.contest = new SimpleStringProperty(contest);
	}
	public String getPlace() 
	{
		return place.get();
	}

	public void setPlace(String place)
	{
		this.place = new SimpleStringProperty(place);
	}
}