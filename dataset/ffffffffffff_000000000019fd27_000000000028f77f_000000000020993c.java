import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class Solution
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int i =0; i<T; i++)
		{
			int N = in.nextInt();
			int N = 0;
			int[][] matr = new int[N][N];
			int sum = 0;
			for(int j = 0; j<N; j++)
				for(int k = 0; k<N; k++)
				{
					matr[j][k]  = in.nextInt();
					if(j==k)
						sum+=matr[j][k];
				}
			
			int count = 0;
			int count2 = 0;
			for(int j = 0; j<N; j++)
			{
				boolean go = false;
				for(int k =0; k<N; k++)
				{
					for(int m = k+1; m<N; m++)
					{
						if(matr[j][m] == matr[j][k])
							go = true;
					}
				}
				
				if(go)
					count++;
			}
			
			for(int j = 0; j<N; j++)
			{
				boolean go = false;
				for(int k =0; k<N; k++)
				{
					for(int m = k+1; m<N; m++)
					{
						if(matr[m][j] == matr[k][j])
							go = true;
					}
				}
				
				if(go)
					count2++;
			}
			
			System.out.println("Case #"+(i+1)+": "+sum+" "+count+ " "+count2);
				
		}
	}
}
