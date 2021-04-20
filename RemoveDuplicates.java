package Assignments_Week1;

public class RemoveDuplicates {
	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";	
		int count=0;
		String[] newtext=text.split(" ");
		boolean flag=false;
		for(int i=0;i<=newtext.length-1;i++)
		{
			for(int j=i+1;j<=newtext.length-1;j++)
			{
			if(newtext[i].equals(newtext[j]))
			{
				count=count+1;
				System.out.println("Occurence of "+ " "+count+" " +newtext[i] );
				if(count>1)
				{
					System.out.println("String after duplicate words removal :"+ " "+text.replace(newtext[j], ""));
					flag=true;
					break;
				}
					
			}
			
			
		}
//			
//			if(!flag)
//			{
//				System.out.println("No duplicates found");
//			}
//	
	}

}
}