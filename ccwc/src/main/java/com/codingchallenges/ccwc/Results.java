package com.codingchallenges.ccwc;

public class Results {
	
	private int byteCount = 0;
	private int line = 0;
	private int word = 0;
	
	public void byteCountSetter(int byteLength)
	{
		byteCount = byteLength;
	}
	
	public int byteCountGetter()
	{
		return byteCount;
	}
	
	public void byteLineSetter(int line)
	{
		this.line = line;
	}
	
	public int byteLineGetter()
	{
		return line;
	}
	
	
	public void byteWordSetter(int word)
	{
		this.word = word;
	}
	
	public int byteWordGetter()
	{
		return word;
	}

}
