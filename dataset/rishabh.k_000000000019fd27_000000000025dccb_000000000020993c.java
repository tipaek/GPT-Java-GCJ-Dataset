import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	private static void validateTestCase(int ind) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int n;

		do
		{
			n=sc.nextInt();
		} while(n<2 || n>100);
			
		int[][] arr=new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				do
				{
					arr[i][j]=sc.nextInt();
				} while(arr[i][j]<1 || arr[i][j]>n);  
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
		
		String result="Case #"+String.valueOf(ind+1)+": "+String.valueOf(trace)+" "+String.valueOf(r)+" "+String.valueOf(c);
		System.out.println(result);
		
		sc.close();
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
				System.out.println("Enter the number of test cases");
		int t;
		
		do
		{
			t=sc.nextInt();
		} while(t<1 || t>100);
			
			for(int i=0;i<t;i++)
			{
				try
				{
					validateTestCase(i);
				} catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			sc.close();
		
	}

}
