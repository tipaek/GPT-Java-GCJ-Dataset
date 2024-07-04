package qualification;
import java.util.Scanner;
public class Vestigium 
{
	public static void main(String[] args) 
	{	
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int x=1;x<=T;x++)
		{
		int N = scan.nextInt();
		int t=0,r=0,c=0,z=1,y=N;
		int M[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				M[i][j] = scan.nextInt();
				if(i==j)
				{
					t+=M[i][j];
				}
			}
		}	
		
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				if(M[i][z]==M[i][j] )
				{
					if(i!=j)
					{
					r++;
					break;
					}
				}
			}
			z++;
		}
			
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				if(M[y][i]==M[j][i])
				{
					if(y!=j)
					{
					c++;
					break;
					}
				}
			}
			y--;
		}
		System.out.println("Case #"+x+": "+t+" "+r+" "+c);
		}
		scan.close();
	}
}
