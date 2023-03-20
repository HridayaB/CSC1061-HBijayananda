package edu.frcc.csc1061j.MyHashMap;

import java.util.Map;

public class MyHashMapTest
{

	public static void main(String[] args) 
	{
		Map<String, Integer> map = new MyHashMap<String, Integer>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);
		map.put("Five", 5);
		map.put("Six", 6);
		
		if (map.containsKey("Two"))
		{
			System.out.println("Has two");
		}
		if (map.containsKey("Six"))
		{
			System.out.println("Has six");
		}
		
		System.out.println("Value of Three: " + map.get("Three"));
		System.out.println("Value of Six: " + map.get("Six"));
	} // end of main

} // end of class MyHashMapTest
