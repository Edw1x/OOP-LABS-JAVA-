package laba5;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Matcher implements Serializable
{
	private static final long serialVersionUID = 1L;

	public boolean Name(String name)
	{
		String regex = "[A-Z][a-z]+";
		Pattern pattern = Pattern.compile(regex); 
		java.util.regex.Matcher matcher = pattern.matcher(name);
		
		if(matcher.matches())
		{
			return true;
		}
		else
		return false;
	}
	
	public boolean Genre(String name)
	{
		String regex = "[A-Z][a-z]+";
		Pattern pattern = Pattern.compile(regex); 
		java.util.regex.Matcher matcher = pattern.matcher(name);
		
		if(matcher.matches())
		{
			return true;
		}
		else
		return false;
	}
	
	public boolean Peformer(String name)
	{
		String regex = "[A-Z][a-z]+";
		Pattern pattern = Pattern.compile(regex); 
		java.util.regex.Matcher matcher = pattern.matcher(name);
		
		if(matcher.matches())
		{
			return true;
		}
		else
		return false;
	}
	
	public boolean Date(String name)
	{
		String regex =  "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
		Pattern pattern = Pattern.compile(regex); 
		java.util.regex.Matcher matcher = pattern.matcher(name);
		
		if(matcher.matches())
		{
			return true;
		}
		else
		return false;
	}
	
	public boolean Description(String name)
	{
		String regex = "[A-Z][a-z]+";
		Pattern pattern = Pattern.compile(regex); 
		java.util.regex.Matcher matcher = pattern.matcher(name);
		
		if(matcher.matches())
		{
			return true;
		}
		else
		return false;
	}
	
	public boolean Duration(String name)
	{
		String regex = "^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$";
		Pattern pattern = Pattern.compile(regex); 
		java.util.regex.Matcher matcher = pattern.matcher(name);
		
		if(matcher.matches())
		{
			return true;
		}
		else
		return false;
	}
	
	public boolean Type(String name)
	{
		String regex = "MP3|DVD|CD|DTS|WMA";
		Pattern pattern = Pattern.compile(regex); 
		java.util.regex.Matcher matcher = pattern.matcher(name);
		
		if(matcher.find())
		{
			return true;
		}
		else
		return false;
	}
	
	public boolean Contesting(Object contest)
	{
		String regex = "[A-Z][a-z]+";
		Pattern pattern = Pattern.compile(regex); 
		java.util.regex.Matcher matcher = pattern.matcher((CharSequence) contest);
		
		if(matcher.matches())
		{
			return true;
		}
		else
		return false;
	}
	
	public boolean Place(int i)
	{
		String regex = "^([0-9]|([1-9][0-9])|100)$";
		Pattern pattern = Pattern.compile(regex);
		String str = Integer.toString(i);
		java.util.regex.Matcher matcher = pattern.matcher(str);
		
		if(matcher.find())
		{
			return true;
		}
		else
		return false;
	}
	
}
