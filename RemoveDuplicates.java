package Assignments_Week1;

public class RemoveDuplicates {
	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";	
		String[] newtext=text.split(" ");
		for(int i=0;i<=newtext.length-1;i++)
		{
			for(int j=i+1;j<=newtext.length-1;j++)
			{
			if(newtext[i].equals(newtext[j]))
			{			
				newtext[j]=" ";
				}		
			}
			System.out.print(" "+ newtext[i]);		
			
		}
}
}