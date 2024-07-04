import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
 class Solution {

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
	    	Map<Interval,Integer> map=new HashMap<>();
	        for(int i=0;i<n;i++)
	        {
	        	int start=in.nextInt();
	            int end =in.nextInt();
	        	intervals[i]= new Interval(start,end);
	        	map.put(intervals[i], i);
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

	        ans=solve(intervals,n,map);
	        System.out.println("Case #" + t + ": "+ans);
	    }
	  }

	private static String solve(Interval[] intervals,int n, Map<Interval, Integer> map) {

		char result[]= new char[n];
		int cameron=0,jamie=0;
		for(int i=0;i<n;i++)
		{
			if(cameron<=intervals[i].start)
			{
				cameron=intervals[i].end;
				result[map.get(intervals[i])]='C';
			}
			else if(jamie<=intervals[i].start)
			{
				jamie=intervals[i].end;
				result[map.get(intervals[i])]='J';
			}
			else return "IMPOSSIBLE";
		}
		return String.valueOf(result);
	}
}