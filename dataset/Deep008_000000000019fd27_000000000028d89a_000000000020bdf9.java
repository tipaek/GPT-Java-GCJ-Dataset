import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
public  class Solution {

	public static class Interval
	{
	    int start,end;
	    Interval(int start, int end)
	    {
	        this.start=start;
	        this.end=end;
	    }
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int test = in.nextInt();
	    for (int t = 1; t <= test; ++t) {
	    	String ans="";
	    	int n = in.nextInt();
	    	Interval intervals[]=new Interval[n];
	        for(int i=0;i<n;i++)
	        {
	        	int start=in.nextInt();
	            int end =in.nextInt();
	        	intervals[i]= new Interval(start,end);
	        }

	        Arrays.sort(intervals,new Comparator<Interval>(){
	        	@Override
	            public int compare(Interval a,Interval b)
	            {
	               if(a.start!=b.start)
	            	   return a.start-b.start ;
	               else return a.end-b.end;
	            }
	        });

	        ans=solve(intervals,n);
	        System.out.println("Case #" + t + ": "+ans);
	    }
	  }

	private static String solve(Interval[] intervals,int n) {

		String result="";
		int cameron=0,jamie=0;
		for(int i=0;i<n;i++)
		{
			if(cameron<=intervals[i].start)
			{
				cameron=intervals[i].end;
				result+="C";
			}
			else if(jamie<=intervals[i].start)
			{
				jamie=intervals[i].end;
				result+="J";
			}
			else return "IMPOSSIBLE";
		}
		return result;
	}
}