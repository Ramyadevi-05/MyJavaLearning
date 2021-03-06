package homework.week3;

import java.util.HashMap;
import java.util.Map;

public class FindOccurence {
	/*
	 * Assingment : Map
Write a Java Program to Find the Occurance of Each Character in the given String : "welcome to Selenium automation"

PseudoCode:
1. Create a String with your name as value
2. Convert the string into a char array		
3. Create an empty Map<Character,Integer>
4. Iterate over the array
5. Check whether the Map contains the Character
6. If it contains then increment the key (+1)
7. Add the character in the map & set the value as 1
8. Print the Map	
	 */

	public static void main(String[] args) {
		String input="welcome to Selenium automation";
		char[] c=input.toCharArray();
		
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(char ch:c)
		{
			if(map.containsKey(ch)) {
				map.put(ch,map.get(ch)+1);
			}else
			{
				map.put(ch, 1);
			}
		}
		System.out.println(map);
	}

}
