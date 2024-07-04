import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static class Interval implements Comparable<Interval>
	{  
	    int start;  
	    int end; 
	    public Interval(int start, int end)  
	    { 
	        super(); 
	        this.start = start; 
	        this.end = end; 
	    }
		@Override
		public int compareTo(Interval i) {
			
			return this.start - i.start;
		}  
	};  

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; ++i)
		{
			int n = sc.nextInt();
			func(i, n, sc);
		}
		
	}
	static void func(int tcase, int n, Scanner sc) {
		
		Interval arr[] = new Interval[n];
		String res = "";
		for(int i = 0; i < n; i++)
		{
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			arr[i] = new Interval(start, end);
		}
		
		Arrays.sort(arr);
		int j = 0, c = 0;
		
		for(int i = 0; i < n; i++) {
			Interval in = arr[i];
			//System.out.println("J:" + j + " C:" + c);
			if(i==0)
			{
				res += "J";
				j = in.end;
				continue;
			}
			
			/*if(in.start < j && in.start < c) {
				res = "";
				break;
			}
			else */if(in.start >= c) {
				res += "C";
				c = in.end;
			}
			else if(in.start >= j) {
				res += "J";
				j = in.end;
			}
			else
			{
				res = "IMPOSSIBLE";
				break;
			}
			//System.out.println(res);
		}
		
		
		System.out.println("Case #" + ++tcase + ": " + res);
    }

}