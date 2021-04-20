package Assignments_Week1;

public class OddNumToUpperCase {

	public static void main(String[] args) {
		String test="changeme";
		
		char[] ch=test.toCharArray();
		//total length - 7
		//odd chars are h n e e--- to upper case 
		// odd chars logic .. remainder should nt be =0 
		
		for(int i=0;i<=ch.length-1;i++)
		{
			int ivalue=0;
			ivalue=test.indexOf(ch[i]);
			//System.out.println("Index value: " +ivalue+"" + " " +ch[i]);
			if(ivalue%2!=0)
			{
				//System.out.println("Changing to upper case");
				test.toUpperCase().charAt(ivalue);
				System.out.print(test.toUpperCase().charAt(ivalue));
			}
			else
			{
				System.out.print(test.charAt(ivalue));
			}
		}
	}

}
