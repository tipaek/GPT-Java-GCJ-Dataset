import java.io.*;
import java.util.*;
public class Latin {
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		
		int test=sc.nextInt();
		StringBuilder str=new StringBuilder("");
		int caseNo=1;
		while(test-->0)
		{
			int n=sc.nextInt();
			
			int arr[][]=new int[n][n];
			int row=0;
			int trace=0;
			int col=0;
			
			for(int i=0;i<n;i++)
			{
				
				Set<Integer> ro=new HashSet();
				
				
				for(int j=0;j<n;j++)
				{
					arr[i][j]=sc.nextInt();
					ro.add(arr[i][j]);
					
					if(i==j)
						trace+=arr[i][j];
				}
				if(ro.size()!=n)
					row++;
					
			}
			
			
			for(int i=0;i<n;i++)
			{
				Set<Integer> co=new HashSet();
				for(int j=0;j<n;j++)
				{
					co.add(arr[j][i]);
				}
				if(co.size()!=n)
					col++;
			}
			
			
			str.append("Case #"+caseNo+": "+trace+" "+row+" "+col+"\n" );
			
			caseNo++;
			
			
			
		}
		
		System.out.println(str.toString());
		
	}

}
