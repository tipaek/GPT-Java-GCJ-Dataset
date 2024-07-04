import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int t= sc.nextInt();
		
		for(int x=0;x<t;x++)
		{
			
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			int arr1[][]=new int[n][n];
			int sum=0;
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]=sc.nextInt();
					arr1[j][i]=arr[i][j];
					if(i==j)
					{
						sum+=arr[i][j];
					}
				}
			}
			
			int r=hasD(arr);
			int c=hasD(arr1);
			
			System.out.println("Case #"+(x+1)+": "+ sum+" "+ r + " " + c);
			
			
			
		}
			
		sc.close();

	}
	
	
	public static int hasD(int[][] inArray)
	{
		int count=0;
	    for (int row = 0; row < inArray.length; row++)
	    {
	    	boolean fl=false;
	    	
	        outer_o : for (int col = 0; col < inArray[row].length; col++)
	        {
	            int num = inArray[row][col];
	            for(int otherCol = col + 1; otherCol < inArray.length; otherCol++)
	            {
	                if (num == inArray[row][otherCol])
	                {
	                	fl=true;
	                	break outer_o;
	                }
	            }
	        }
	    	
	    	if(fl)
	    	{
	    		count++;
	    	}
	    }

	    return count;
	}

}