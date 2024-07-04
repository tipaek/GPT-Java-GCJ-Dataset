import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	private static String validateTestCase(int ind) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int n;

		n=sc.nextInt();

		int[][] arr=new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				arr[i][j]=sc.nextInt();
			}
		
		int trace=0, r=0,c=0;
		
		for(int i=0;i<n;i++)
		{
			trace+=arr[i][i];
		}
		
		ArrayList<Integer> row=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			row=new ArrayList<Integer>();
			
			for(int k=0;k<n;k++)
			{
				row.add(k+1);
			}
			
			for(int j=0;j<n;j++)
			{
				Integer val=arr[i][j];
				
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
		
		for(int i=0;i<n;i++)
		{
			row=new ArrayList<Integer>();
			
			for(int k=0;k<n;k++)
			{
				row.add(k+1);
			}
			
			for(int j=0;j<n;j++)
			{
				Integer val=arr[j][i];
				
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
		
		String result="#"+String.valueOf(ind+1)+": "+String.valueOf(trace)+" "+String.valueOf(r)+" "+String.valueOf(c);
		return result;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t;
		
		do
		{
			t=sc.nextInt();
		} while(t<1 || t>100);
		
		try
		{
			String[] result=new String[t];
			
			for(int i=0;i<t;i++)
			{
				result[i]=validateTestCase(i);
			}
			
			for(int i=0;i<t;i++)
			{
				System.out.println(result[i]);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
