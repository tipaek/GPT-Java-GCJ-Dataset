import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[]args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int t=0;t<tc;t++)
		{
    		int n=sc.nextInt();
    		
    		int[][]A=new int[n][n];
    		
    		for(int i=0;i<n;i++)
    		{
    		    for(int j=0;j<n;j++)
    		    {
    		        A[i][j]=sc.nextInt();
    		    }
    		}
    		
    		long trace=0;
    		
    		for(int i=0,j=0;i<n && j<n;i++,j++)
    		{
    		    trace=trace+A[i][j];
    		}
    		
    		long rows=0;
    		HashMap<Integer,Boolean>repeat=new HashMap<>();
    		
    		for(int i=0;i<n;i++)
    		{
    		    repeat=new HashMap<>();
    		    
    		    for(int j=0;j<n;j++)
    		    {
    		        if(repeat.containsKey(A[i][j]))
    		        {
    		            rows++;
    		            break;
    		        }
    		        else
    		        {
    		            repeat.put(A[i][j],true);
    		        }
    		    }
    		}
    		
    		
    		long cols=0;
    		
    		for(int j=0;j<n;j++)
    		{
    		    repeat=new HashMap<>();
    		    
    		    for(int i=0;i<n;i++)
    		    {
    		        if(repeat.containsKey(A[i][j]))
    		        {
    		            cols++;
    		            break;
    		        }
    		        else
    		        {
    		            repeat.put(A[i][j],true);
    		        }
    		    }
    		}
    		
    		
    		
    		System.out.println("Case #"+(t+1)+": "+trace+" "+rows+" "+cols);
    	}
    }
}