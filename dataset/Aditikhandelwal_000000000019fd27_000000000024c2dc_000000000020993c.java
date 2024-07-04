import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc =t;
        while(t!=0)
        {
        	int n = scn.nextInt();
        	int arr[][]= new int[n][n];
        	int r =0;
        	int count=0;
        	int trace=0;
        	for(int i =0;i<n;i++)
        	{
        		HashMap<Integer,Boolean> map = new HashMap<>();
        		count=0;
        		for(int j =0;j<n;j++)
        		{
        			arr[i][j]=scn.nextInt();
        			if(i==j)
        			{
        				trace+=arr[i][j];
        			}
        			if(map.containsKey(arr[i][j]))
        			{
        				count++;
        			}
        			else
        			{
        				map.put(arr[i][j],true);
        			}
        		}
        		if(count>0)
        		{
        			r++;
        		}
        	}
        	int c=0;
        	for(int i =0;i<n;i++)
        	{
        		HashMap<Integer,Boolean> map = new HashMap<>();
        		count=0;
        		for(int j =0;j<n;j++)
        		{
        			if(map.containsKey(arr[j][i]))
        			{
        				count++;
        			}
        			else
        			{
        				map.put(arr[j][i],true);
        			}
        		}
        		if(count>0)
        		{
        			c++;
        		}
        	}
        	String s = "Case #"+(tc-t+1)+": "+ trace + " " + r +" "+c;
        	System.out.println(s);
        	t--;
        }

	}

}