import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution 
{
	class Tuple implements Comparable<Tuple>
	{
		int start;
		int end;
		int index;
		String person;
	
		public int compareTo(Tuple two)
		{
			return (int) (this.start - two.start);
		}
		
		public int getStart()
		{
			return this.start;
		}

		public long getEnd()
		{
			return this.end;
		}
	}
		
	public static void main(String[] args){
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    Solution Mainn3 = new Solution();
    
    for (int i=1; i<=T; i++)
	{
    	int cam = 0;
    	int jam = 0;
    	int N = in.nextInt();
    	boolean impos = false;
    	//System.out.println(T);
    	Tuple[] tasks = new Tuple[N];
    	for(int j = 0; j < N; j++)
    	{
    		int s = in.nextInt();
    		int e = in.nextInt();
    		Tuple t = Mainn3.new Tuple();
    		t.start = s;
    		t.end = e;
    		t.index = j;
    		t.person = "J";
    		tasks[j] = t;
    	}
    	Tuple[] orig = new Tuple[N];
    	for(int b = 0; b < N; b++)
    	{
    		orig[b] = tasks[b];
    	}
    	
    	java.util.Arrays.sort(tasks);
//    	System.out.println(tasks[0].end);
//    	tasks[0].end = 7;
//    	System.out.println(tasks[0].end);
//
//    	System.out.println(orig[0].end);
    	for(int p = 0; p < N; p++)
    	{
    		if(cam <= tasks[p].start)
    		{
    			tasks[p].person = "C";
    			cam = tasks[p].end;
    		}
    		else if(jam <= tasks[p].start)
    		{
    			tasks[p].person = "J";
    			jam = tasks[p].end;
    		}
    		else
    		{
    			impos = true;
    		}
    	}
    	if(impos)
    	{
    		System.out.println("\n" + "Case #" + i + ": IMPOSSIBLE");
    	}
    	else
    	{
    	String[] res = new String[N];
    	for(int e = 0; e < N; e++)
    	{
    		Tuple tup = tasks[e];
    		res[tup.index] = tup.person;
    	}
    	StringBuilder sb = new StringBuilder("");
    	for(int h = 0; h < N; h++)
    	{
    		sb.append(res[h]);
    	}
    	System.out.println("\n" + "Case #" + i + ": " + sb);
    	}
	}
    
}
    
}
