package Assignments_Week1;

public class FindIntersection {

	public static void main(String[] args) {

		int[] a1= {3,2,11,4,6,7};
		int[] a2=  {1,2,8,4,9,7};
		
		//Common intersection values are 2, 4 and 7 
		
		for(int i=0;i<=a1.length-1;i++)
		{
			for(int j=0;j<=a2.length-1;j++)
			{
				if(a1[i]==a2[j])
				{
					System.out.println("Intersection Point:"+a1[i]);
				}else
				{
					//System.out.println("No Intersection");
				}		
	}

}
}
}
