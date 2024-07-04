package qwerty;
import java.util.Scanner;
import java.util.Arrays;
public class verdict {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			int sum=0;
			int rows=0;
			int cols=0;
			int n=sc.nextInt();
			int B[]=new int[n];
			int A[][]=new int[n][n];
			for(int j=0;j<n;j++)
			{
				for(int k=0;k<n;k++)
				{
					A[j][k]=sc.nextInt();
					if(j==k)
					{
						sum+=A[j][k];					
					}
					B[k]=A[j][k];
				}
				Arrays.sort(B);
				for(int a=0;a<n-1;a++)
				{
					if(B[a]==B[a+1])
						{
							rows++;
							break;
						}
				}
			}
			for(int j=0;j<n;j++)
			{
				for(int k=0;k<n;k++)
				{
					B[k]=A[k][j];
				}
				Arrays.sort(B);
				for(int a=0;a<n-1;a++)
				{
					if(B[a]==B[a+1])
						{
							cols++;
							break;
						}
				}
				
			}
			System.out.println("Case #"+(i+1)+": "+ sum +" "+rows+" "+cols );
			
			
		}
	}

}
