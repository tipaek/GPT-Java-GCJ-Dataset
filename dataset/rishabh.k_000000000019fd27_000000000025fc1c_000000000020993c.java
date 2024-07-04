import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	private static String validateTestCase(int ind, Scanner sc) throws Exception
	{
		int N;

		do
		{
			N=sc.nextInt();
		} while(N<2 || N>100);
			
		int[][] M=new int[N][N];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			{
				do
				{
					M[i][j]=sc.nextInt();
				} while(M[i][j]<1 || M[i][j]>N);  
			}
		
		int trace=0, r=0,c=0;
		
		for(int i=0;i<N;i++)
		{
			trace+=M[i][i];
		}
		
		ArrayList<Integer> row=new ArrayList<Integer>();
		
		for(int i=0;i<N;i++)
		{
			row=new ArrayList<Integer>();
			
			for(int k=0;k<N;k++)
			{
				row.add(k+1);
			}
			
			for(int j=0;j<N;j++)
			{
				Integer val=M[i][j];
				
				if(row.contains(val))
				{
					row.remove(val);
				}
				else
				{
					r++;
					break;
				}
			}
		}
		
		for(int i=0;i<N;i++)
		{
			row=new ArrayList<Integer>();
			
			for(int k=0;k<N;k++)
			{
				row.add(k+1);
			}
			
			for(int j=0;j<N;j++)
			{
				Integer val=M[j][i];
				
				if(row.contains(val))
				{
					row.remove(val);
				}
				else
				{
					c++;
					break;
				}
			}
		}
		
		String result="Case #"+String.valueOf(ind+1)+": "+String.valueOf(trace)+" "+String.valueOf(r)+" "+String.valueOf(c);
	
		return result;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int T;
		
		do
		{
			T=sc.nextInt();
		} while(T<1 || T>100);
			
		String[] result=new String[T];
		try
		{
			for(int i=0;i<T;i++)
			{
				result[i]=validateTestCase(i,sc);
			}
			
			for(int i=0;i<T;i++)
			{
				System.out.println(result[i]);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
			sc.close();
		
	}

}
