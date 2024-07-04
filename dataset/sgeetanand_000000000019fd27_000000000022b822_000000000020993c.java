import java.io.*;
import java.util.*;
public class Vestigium
{
	public static void main(String[] args)
	{
		int t;
		Scanner scan=new Scanner(System.in);
		t=scan.nextInt();
		int[] N=new int[t];
		int[][] T=new int[100][100];
		int checker=0;
		int[][] final1=new int[t][3];
		for(int i=0;i<t;i++)
		{
			N[checker]=scan.nextInt();
			for(int j=0;j<N[checker];j++)
			{
				for(int k=0;k<N[checker];k++)
				{
					T[j][k]=scan.nextInt();
					if(j==k)
					{
						final1[checker][0]+=T[j][k];
					}
				}
			}
			for(int k=0;k<N[checker];k++)
			{
				int temp=-1;
				for(int j=0;j<N[checker];j++)
				{	
					for(int x=j+1;x<N[checker];x++)
					{
						if(T[j][k]==T[x][k])
						{
							final1[checker][2]++;
							temp=1;
							break;
						}
					}
					if(temp!=-1)
						break;
				}
			}
			for(int k=0;k<N[checker];k++)
			{
				int temp=-1;
				for(int j=0;j<N[checker];j++)
				{	
					for(int x=j+1;x<N[checker];x++)
					{
						if(T[k][j]==T[k][x])
						{
							final1[checker][1]++;
							temp=1;
							break;
						}
					}
					if(temp!=-1)
						break;
				}
			}
			checker++;
		}
		for(int i=0;i<checker;i++)
		{
			int k=i+1;
			if(i!=checker-1)
			{
				System.out.println("Case #"+k+": "+final1[i][0]+" "+final1[i][1]+" "+final1[i][2]);
			}
			else
				System.out.print("Case #"+k+": "+final1[i][0]+" "+final1[i][1]+" "+final1[i][2]);
		}
	}
}
			
			