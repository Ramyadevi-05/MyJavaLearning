package homework.week3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Input: "PayPal India"
//Output:PaylIndi

//dup value - Paa --- P a d y I i l n
//PaylIndi
public class RemoveDuplicates {

	public static void main(String[] args) {		
		
//		Declare a String as PayPal India
		String str="PayPal India";

//		Convert it into a character array
		char[] c=str.toCharArray();

//		Declare a Set as charSet for Character
		
		Set<Character> charSet=new HashSet<Character>();

//		Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupCharSet=new HashSet<Character>();

//		Iterate character array and add it into charSet
//		if the character is already in the charSet then, add it to the dupCharSet
//		Check the dupCharSet elements and remove those in the charSet
//		Iterate using charSet
//		Check the iterator variable isn't equals to an empty space
//		print each character for charSet
		
		for(int i=0;i<=c.length-1;i++)
		{
			if(charSet.contains(c[i]))
				dupCharSet.add(c[i]);
			else
				charSet.add(c[i]);
		}
	
		System.out.println(charSet);
		System.out.println(dupCharSet);	

		
		for (Character ch : charSet) {
			if(!ch.isWhitespace(ch))
				System.out.print(ch);
		}

			
		
}
}