import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

	public class Activity implements Comparable<Activity> {
		public int id;
		public int s;
		public int e;
		public char who;

		public Activity(int id, int s, int e) {
			this.id = id;
			this.s = s;
			this.e = e;
		}

		public int compareTo(Activity a) {
			if(this.s < a.s) {
				return -1;
			}
			if(this.s > a.s) {
				return 1;
			}

			if(this.e < a.e) {
				return -1;
			}
		
			if(this.e > a.e) {
				return 1;
			}

			return 0;
		}
	}

	public void realMain() throws Exception {

		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);

		String in = fin.readLine();

		int T = Integer.parseInt(in);

		for(int t = 1; t <= T; t++) {
				int ret2 = 0;
				boolean dig2 = false;
				for (int ch = 0; (ch = fin.read()) != -1; ) {
        				if (ch >= '0' && ch <= '9') {
            					dig2 = true;
           					ret2 = ret2 * 10 + ch - '0';
        				} else if (dig2) break;
    				}

				int n = ret2;
			
			ArrayList<Activity> al = new ArrayList<Activity>();

			for(int i = 0; i < n; i++) {
				int ret = 0;
				boolean dig = false;
				for (int ch = 0; (ch = fin.read()) != -1; ) {
        				if (ch >= '0' && ch <= '9') {
            					dig = true;
           					ret = ret * 10 + ch - '0';
        				} else if (dig) break;
    				}

				int s = ret;

				ret = 0;
				dig = false;
				for (int ch = 0; (ch = fin.read()) != -1; ) {
        				if (ch >= '0' && ch <= '9') {
            					dig = true;
           					ret = ret * 10 + ch - '0';
        				} else if (dig) break;
    				}

				int e = ret;

				al.add(new Activity(i, s, e));
			
			}

			Collections.sort(al);

			int lastj = 0;
			int lastc = 0;

			boolean can = true;

			for(int i = 0; i < n; i++) {
				int curs = al.get(i).s;
				int cure = al.get(i).e;

				if(lastj <= curs) {
					al.get(i).who = 'J';
					lastj = cure;
				} else if(lastc <= curs) {
					al.get(i).who = 'C';
					lastc = cure;
				} else {
					can = false;
				}
			}

			char[] ans = new char[n];
			for(int i = 0; i < n; i++) {
				ans[ al.get(i).id ] = al.get(i).who;
			}

			StringBuilder sb = new StringBuilder("");

			for(int i = 0; i < n; i++) {
				sb.append(ans[i]);
			}

			if(!can) {
				System.out.println("Case #" + t + ": IMPOSSIBLE" );
			} else {
				System.out.println("Case #" + t + ": " + sb);
			}		
		}
	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}