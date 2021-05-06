package homework.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortingUsingCollection {

	public static void main(String[] args) {

		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
//		Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		

//		get the length of the array		
		int length=input.length;
		System.out.println(length);

//		sort the array	
		
		List<String> lst=new ArrayList<String>();
		for(int i=0;i<=length-1;i++)
		{
		lst.add(input[i]);
		}
		System.out.println("Before sort:"+lst);
		Collections.sort(lst);
		System.out.println("After sort:"+lst);

//		Iterate it in the reverse order
		
		for(int j=length-1;j>=0;j--)
		{
//			print the array		
//			Required Output: Wipro, HCL , CTS, Aspire Systems
			System.out.println(lst.get(j));
		}
		
	

		

	}

}