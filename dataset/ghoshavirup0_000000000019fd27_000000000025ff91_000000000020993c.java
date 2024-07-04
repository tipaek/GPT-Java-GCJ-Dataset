import java.util.*;


public class Solution
{
	
	
public static void main(String arrr[]) {	
	
	Scanner s=new Scanner(System.in);
	int count=0;
	int t=s.nextInt();
	while(t!=0)
	{
		count++;
		int n=s.nextInt();
		
		int mat[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				mat[i][j]=s.nextInt();
		}
		
		
		
		
		int k=0;
		for(int i=0;i<n;i++)
			k=k+mat[i][i];
		
		int r=0;
		
		for(int i=0;i<n;i++)
		{
			Set<Integer> set=new HashSet<>();
			for(int j=0;j<n;j++)
			{
				if(set.contains(mat[i][j]))
				{
					r++;
					break;
				}
				set.add(mat[i][j]);
			}
		}
		int c=0;
		for(int i=0;i<n;i++)
		{
			Set<Integer> set=new HashSet<>();
			for(int j=0;j<n;j++)
			{
				if(set.contains(mat[j][i]))
				{
					c++;
					break;
				}
				set.add(mat[j][i]);
			}
			
		}
		
		System.out.println("case#"+count+":"+" "+k+" "+r+" "+c);
		t--;
	}
	
}
}
