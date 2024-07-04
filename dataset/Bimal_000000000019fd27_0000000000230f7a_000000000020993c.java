
import java.util.*;
 class Codejam1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			int N=sc.nextInt();
			int arr[][]=new int[N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
					arr[i][j]=sc.nextInt();
			}
			int trace=0;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
				  if(i==j)
					  trace=trace+arr[i][j];
					  
				}
			}
			int r=0;
			for(int i=0;i<N;i++)
			{
				int hash[]=new int[N+1];
				for(int j=0;j<N;j++)
				{
					hash[arr[i][j]]++;
					if(hash[arr[i][j]]>1)
					{
						r++;
						break;
					}
					
					
						
					
				}
			}
			int c=0;
			for(int i=0;i<N;i++)
			{
				int hash[]=new int[N+1];
				for(int j=0;j<N;j++)
				{
					hash[arr[j][i]]++;
					if(hash[arr[j][i]]>1)
					{
						c++;
						break;
					}
					
					
						
					
				}
			}
			System.out.println("Case "+"#"+t+":"+" "+trace+" "+r+" "+c);
			
			
			
			
			
		}
		
	}

}
