import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int t, n, a,b, s, e;
	static PriorityQueue<Info> d;
	static String[] ans;
	static boolean isImp;
	static int[] end=new int[2];
	static StringTokenizer st=null;
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	static class Info implements Comparable<Info>{
		int i, s, e;
		public Info(int i, int s, int e) {
			this.i=i;
			this.s=s;
			this.e=e;
		}
		@Override
		public int compareTo(Info o) {
			if(o.e==this.e)
				return o.s-this.s;
			else
				return this.e-o.e;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		st= new StringTokenizer(br.readLine());
		t=Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= t; tc++) {
			st= new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			d= new PriorityQueue<Info>(new Comparator<Info>() {
				@Override
				public int compare(Info o1, Info o2) {
					if(o2.s==o1.s)
						return o2.e-o1.e;
					else
						return o1.s-o2.s;
				}
			});
			ans=new String[n];
			Arrays.fill(end, 0);
			isImp=false;
			
			for (int i = 0; i < n; i++) {
				st= new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				d.add(new Info(i, a, b));
			}
			
			while(!d.isEmpty()) {
				Info now= d.poll();
				if(now.s>=end[0]) {
					end[0]=now.e;
					ans[now.i]="C";
				} else if(now.s>=end[1]) {
					end[1]=now.e;
					ans[now.i]="J";
				} else {
					isImp=true;
					break;
				}
			}
			
			bw.append("Case #"+tc+": ");
			if (isImp)
				bw.append("IMPOSSIBLE");
			else {
				for(String w : ans)
					bw.append(w);
			}
			bw.append("\n");
		}
			
		bw.flush();
		bw.close();
	}

}
