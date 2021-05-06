package homework.week3;
/* Insert elements to the TreeMap
Input:
Employee Info:

Emp_id|Emp_name
100	Hari
101     Naveen
102	Sam
104	Balaji

OutPut: Print Employee info in reverse order based on Emp_d*/

import java.util.Map;
import java.util.TreeMap;

public class ReverseMap {

	public static void main(String[] args) {
		int[] array= {100,101,102,104};
		String[] names= {"Hari","Naveen","Sam","Balaji"};
		Map<Integer, String> map=new TreeMap<Integer, String>();
		for(int i=0;i<array.length;i++)
		{
			map.put(array[i], names[i]);
		}
		System.out.println(map);
		
		for(int j=array.length-1;j>=0;j--)
		{
			System.out.println(map.get(array[j]));
		}
		
	}
	
	/*
	 * Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
	at java.lang.String.compareTo(String.java:111)
	at java.util.TreeMap.getEntry(TreeMap.java:352)
	at java.util.TreeMap.get(TreeMap.java:278)
	at homework.week3.ReverseMap.main(ReverseMap.java:31)
	 */

}
