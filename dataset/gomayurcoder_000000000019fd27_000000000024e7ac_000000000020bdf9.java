import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		for(int ti=1;ti<=t;ti++)
		{
			int n = s.nextInt();
			Triplet[] arr = new Triplet[n];
			for(int i=0;i<n;i++) {
				int start = s.nextInt();
				int end = s.nextInt();
				int idx = i;
				arr[i] = new Triplet(start, end, idx);
			}
			
			Arrays.sort(arr);
			
			char[] allot = new char[n];
			boolean flag = true;
			int c = -1, j = -1;
			for(int i=0;i<n;i++) {
				if(c!=-1 && arr[c].second <= arr[i].first) {
					c = -1;
				}
				if(j!=-1 && arr[j].second <= arr[i].first) {
					j = -1;
				}
				if(c==-1) {
					c = i;
					allot[arr[i].idx] = 'C';
				}
				else if(j==-1) {
					j = i;
					allot[arr[i].idx] = 'J';
				}
				else {
					flag = false;
					break;
				}
			}
			
			String ans;
			if(!flag) {
				ans = "IMPOSSIBLE";
			}
			else {
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<n;i++) {
					sb.append(allot[i]);
				}
				ans = sb.toString();
			}
			
			System.out.println("Case #"+ti+": "+ans);

		}
	}

	static class Triplet implements Comparable<Triplet>{
		int first;
		int second;
		int idx;
		
		Triplet(int first, int second, int idx)
		{
			this.first = first;
			this.second = second;
			this.idx = idx;
		}

		Triplet() {}
		
		public int compareTo(Triplet other)
		{
			if(this.first<other.first)
				return -1;
			else
				return 1;
		}
	}
}
