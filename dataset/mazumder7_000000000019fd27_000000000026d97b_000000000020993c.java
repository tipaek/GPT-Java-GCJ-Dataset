import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
class Solution
{
    public static void main(String args[]) 
    {
    	Scanner in =new Scanner(System.in);
    	int t = in.nextInt();
    	int x = 1;
    	while(t-->0) 
    	{
    	int n = in.nextInt();
    	int ar[][]=new int[n][n];
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    			ar[i][j] = in.nextInt();
    	}
    	System.out.println("Case #"+x+": "+trace(ar,n)+" "+rowCheck(ar,n)+" "+colCheck(ar,n));
    	x++;
    	}
    }
    public static int rowCheck(int ar[][], int n) {
    	boolean[] visited = new boolean[n];
    	int count = 0;
    	for(int i=0;i<n;i++)
    	{
    		Arrays.fill(visited,false);
    		for(int j=0;j<n;j++)
    		{
    			visited[ar[i][j]-1]=true;
    		}
    		for(int j=0;j<n;j++)
    		{
    			if(!visited[j])
    			{
    				count++;
    				break;
    			}
    		}
    	}
    	return count;
    }
    public static int colCheck(int ar[][], int n) {
    	boolean[] visited = new boolean[n];
    	int count = 0;
    	for(int j=0;j<n;j++)
    	{
    		Arrays.fill(visited,false);

    		for(int i=0;i<n;i++)
    		{
    			visited[ar[i][j]-1]=true;
    		}
    		for(int i=0;i<n;i++)
    		{
    			if(!visited[i])
    			{
    				count++;
    				break;
    			}
    		}
    	}
    	return count;
    }
    
    public static long trace(int ar[][], int n) {
    	long sum = 0;
    	for(int i=0;i<n;i++)
    		sum+=ar[i][i];
    	return sum;
    }
  }
