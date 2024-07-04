import java.util.*;
import java.io.*;

public class Solution{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		int testnum = 1;
		while (t-- > 0) {
			int n=sc.nextInt();
			Pair[] arr= new Pair[n];
			for(int i=0;i<n;i++)
				arr[i]=new Pair(sc.nextInt(), sc.nextInt(), i);
			Arrays.parallelSort(arr);
			StringBuilder sb= new StringBuilder();
			Pair c=arr[0];
			c.doer='C';
			Pair j=arr[1];
			j.doer='J';
			boolean possible =true;
			for(int i=2;i<n;i++) {
				if(!c.overlap(arr[i])) {
					c=arr[i];
					c.doer='C';
				}
				else if(!j.overlap(arr[i])) {
					j=arr[i];
					j.doer='J';
				}
				else {
					possible=false;
					break;
				}
			}
			if(possible) {
			char[] ans= new char[n];
			for(int i=0;i<n;i++)
				ans[arr[i].index]=arr[i].doer;
			for(int i=0;i<n;i++)
				sb.append(ans[i]);
			out.printf("Case #%d: %s%n", testnum++, sb);
			}
			else
				out.printf("Case #%d: %s%n", testnum++, "IMPOSSIBLE");
		}
		out.close();

	}
	static class Pair implements Comparable<Pair>{
		int start, end, index;
		char doer;
		public Pair(int s, int e,int i) {
			start=s;
			end=e;
			index=i;
		}
		@Override
		public int compareTo(Pair o) {
			if(start==o.start)
				return end-o.end;					
			return start-o.start;
		}
		public boolean overlap(Pair o) {
			if(end<=o.start || o.end<=start)
				return false;
			return true;
		}
	}
}
