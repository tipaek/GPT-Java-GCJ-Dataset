import java.util.*;
import java.lang.*;
import java.io.*;
class Intervals implements Comparable<Intervals>
{
    int start;
    int end;
    int index;
    Intervals(int start, int end, int index)
    {
      this.start = start;
      this.end = end;
      this.index = index;
    }
    @Override
    public int compareTo(Intervals i1) {
        if(this.start > i1.start)
            return 1;
        else if (this.start < i1.start)
            return -1;
        return 0;
    }
}
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int testCase = 1; testCase <= t; testCase++)
	    {
	        int n = Integer.parseInt(br.readLine());
	        char [] result = new char [n];
	        boolean flag = true;
	        int c = 0;
	        int j = 0;
	        ArrayList<Intervals> tasks = new ArrayList<Intervals>();
	        for(int i =0; i<n; i++)
	        {
	            String [] line = br.readLine().split(" ");
	            int start = Integer.parseInt(line[0]);
	            int end = Integer.parseInt(line[1]);
	            Intervals temp = new Intervals(start,end,i);
	            tasks.add(temp);
	        }
	        Collections.sort(tasks);
	        for(int i = 0; i < n ; i++)
	        {
	            Intervals temp = tasks.get(i);
	            int start = temp.start;
	            int end = temp.end;
	            if(c <= start)
	                c = 0;
	            if(j <= start)
	                j = 0;
	   
	            if(c == 0)
	            {
	                c = end;
	                result[temp.index] = 'C';
	            }
	            else if(j == 0)
	            {
	                j = end;
	                result[temp.index] = 'J';
	            }
	            else
	            {
	                flag = false;
	                break;
	            }
	        }
	        String ans = new String(result); 
	        if(flag)
	             System.out.println("Case #" + testCase + ": " + ans);
	        else
	             System.out.println("Case #" + testCase + ": " + "IMPOSSIBLE");
	    }
	}
}