import java.util.*;
import java.io.*;

public class Solution {
	static FastReader sc;
	static BufferedWriter bufferedWriter;
	
	public static void main(String[] args) throws IOException {
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		sc = new FastReader();
		int tp = sc.nextInt();
		for (int i_t = 0; i_t < tp; i_t++) {
			
			int n = sc.nextInt();
			Activity[] activities=new Activity[n];
			for(int i=0;i<n;i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				activities[i]=new Activity(x, y,i);
			}
			String ans = solve(activities,n);
			bufferedWriter.write("Case #"+(i_t+1)+": " + ans + "\n");
		}
		bufferedWriter.flush();

	}

	private static String solve(Activity[] activities, int n) {
		int c=0;int j=0;
		String ans="";
		Arrays.sort(activities,(a1,a2)->a1.start-a2.start==0 ? a1.end-a2.end:a1.start - a2.start);
		for(int i=0;i<n;i++) {
			if(activities[i].start>=c) {
				activities[i].ans="C";
				c=activities[i].end;
			}else if(activities[i].start>=j) {
				activities[i].ans="J";
				j=activities[i].end;
			}else {
				return "IMPOSSIBLE";
			}
		}
		Arrays.sort(activities,(a1,a2)->a1.index-a2.index);
		for(Activity a : activities) {
			ans+=a.ans;
		}
		return ans;
	}

}

class Activity{
	int start;
	int end;
	String ans;
	int index;
	public Activity(int s,int e,int index) {
		start=s;
		end=e;
		this.index=index;
	}
}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br=new  BufferedReader(new InputStreamReader(System.in));
	
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	String nextLine() {
		String s = "";
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}
