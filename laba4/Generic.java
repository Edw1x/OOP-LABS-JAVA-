package laba4;

import java.io.Serializable;

public interface Generic<List> extends Serializable
{
	void add(List item);
	
	boolean remove(List item);
	
	int size();
	
	boolean isEmpty();
	
	String toString();
	
	void clear();
}
