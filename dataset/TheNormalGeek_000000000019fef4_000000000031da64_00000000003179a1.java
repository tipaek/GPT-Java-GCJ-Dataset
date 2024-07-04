import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

	public void realMain() throws Exception {

		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);

		String in = fin.readLine();

		int T = Integer.parseInt(in);

		for(int t = 1; t <= T; t++) {
							long ret = 0;
		            int c = fin.read(); 
		            while (c <= ' ') 
                		c = fin.read(); 
		            boolean neg = (c == '-'); 
		            if (neg) 
		                c = fin.read(); 
		            do
		            { 
		                ret = ret * 10 + c - '0'; 
		            }  while ((c = fin.read()) >= '0' && c <= '9'); 
  
  		          if (neg) 
                		ret *= -1;

			long u = ret;

			int n = 10000;



			long[] q = new long[n];
			String[] strq = new String[n];
			StringBuilder[] r = new StringBuilder[n];

			boolean[] notzero = new boolean[26];

			int[] upper = new int[26];

			boolean[] used = new boolean[26];


			for(int i = 0; i < 26; i++) {
				upper[i] = 10;
			}

int firstfew = 0;


			for(int i = 0; i < n; i++) {
				ret = 0;
		            c = fin.read(); 
		            while (c <= ' ') 
                		c = fin.read(); 
		            neg = (c == '-'); 
		            if (neg) 
		                c = fin.read(); 
		            do
		            { 
		                ret = ret * 10 + c - '0'; 
		            }  while ((c = fin.read()) >= '0' && c <= '9'); 
  
  		          if (neg) 
                		ret *= -1;
			
				q[i] = ret;

				strq[i] = "" + q[i];				

				r[i] = new StringBuilder("");

				c = fin.read();

				while(c <= ' ') {
					c = fin.read();
				}

				do {
					r[i].append((char)c);
					used[c - 'A'] = true;
				} while ((c = fin.read()) >= 'A' && c <= 'Z');

				////System.err.println(r[i]);


				notzero[r[i].charAt(0) - 'A'] = true;

				

				if(r[i].length() == strq[i].length()) {
					upper[ r[i].charAt(0) - 'A' ] = Math.min(upper[ r[i].charAt(0) - 'A' ], strq[i].charAt(0) - '0');

					if(firstfew <= 10) {
						//System.err.println("setting: " + (r[i].charAt(0) - 'A') + " to " + (strq[i].charAt(0) - '0'));
						firstfew++;
					}
				}

	
			}

			String ans = "";

			//int usedaszero = 

			for(int i = 0; i < 26; i++) {
				if(!used[i]) {
					continue;
				}

				if(!notzero[i]) {
					ans += (char)('A' + i);
					break;
				}
			}

			//System.err.println(Arrays.toString(used));
			//System.err.println(Arrays.toString(notzero));
			//System.err.println(Arrays.toString(upper));

			int curupper = 1;

			while(curupper < 10) {
				for(int i = 0; i < 26; i++) {
					if(!used[i]) {
						continue;
					}

					if(upper[i] == curupper) {
						ans += (char)('A' + i);
						curupper++;
						break;
					}
				}
			}			
				





			System.out.println("Case #" + t + ": " + ans);

		}

	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}