import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			System.out.print("Case #" + (t+1) + ": ");
			
			int n = Integer.parseInt(in.readLine());
			Interval[] arr = new Interval[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i] = new Interval(a,b, i);
			}
			
			Arrays.sort(arr);
			
			boolean imp = false;
			arr[0].n = 0;
			for (int i = 0; i < n; i++) {
				if (i < n-2 && arr[i].b > arr[i+1].a && arr[i].b > arr[i+2].a) {
					int c = (arr[i].n +1) % 2;
					int fLast = arr[i].b;
					int last = arr[++i].b;
					arr[i].n = c;
					i++;
					while (i < n && arr[i].a < fLast) {
						if (arr[i].a < last) {
							System.out.println("IMPOSSIBLE");
							imp = true;
							break;
						}
						
						arr[i].n = c;
						last = arr[i].b;
						i++;
					}
					if (imp) break;
					
					arr[i].n = (c+1)%2;
				}
				else if (i < n-1 && arr[i].b > arr[i+1].a) 
					arr[i+1].n = (arr[i].n + 1) % 2;
				else if (i < n-1) 
					arr[i+1].n = 0;		
			}
			
			if (imp) continue;
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) sb.append("J");
			
			for (int i = 0; i < n; i++) 
				if (arr[i].n == 1)
					sb.setCharAt(arr[i].id, 'C');
			
			System.out.println(sb);	
		}
	}
	static class Interval implements Comparable<Interval> {
		int a, b;
		int id;
		int n;
		public Interval(int a, int b, int id) {
			this.a = a;
			this.b = b;
			this.id = id;
		}
		
		@Override
		public int compareTo(Interval o) {
			return a - o.a;
		}	
	}
}
