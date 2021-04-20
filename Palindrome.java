package Assignments_Week1;

public class Palindrome {

	public static void main(String[] args) {
	
		String str="madam";
		//String str="test";
		String rev="";
		char[] ch=str.toCharArray();
		for(int i=ch.length-1;i>=0;i--)
		{
			rev=rev+ch[i];	
	}
		System.out.println(rev);
		if(rev.equalsIgnoreCase(str))
		{
			System.out.println("Input String is a Palindrome");
		}
		else
		{
			System.out.println("Input String is not a palindrome");
		}

}
}

