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

				long x = ret;

			

			
				
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

			long y = ret;

			
			long curx = 0;
			long cury = 0;

			long[] pows = new long[11];

			pows[0] = 1;

			for(int i = 1; i < 11; i++) {
				pows[i] = 2 * pows[i - 1];
			}

			boolean done = false;
			String ans = "";

			for(int i = 0; i < 1953125 && !done; i++) {
				String base5 = Integer.toString(i, 5);

				curx = 0;
				cury = 0;

				boolean nope = false;

				for(int j = 0; j < base5.length(); j++) {
					if(base5.charAt(j) == '0') {
						nope = true;
						break;
					}
					if(base5.charAt(j) == '1') {
						cury += pows[j];
					}
					if(base5.charAt(j) == '2') {
						cury -= pows[j];
					}
					if(base5.charAt(j) == '3') {
						curx += pows[j];
					}
					if(base5.charAt(j) == '4') {
						curx -= pows[j];
					}

				}

				/*if(i == 13) {
					System.out.println(base5);
					System.out.println(curx);
					System.out.println(cury);
				}*/

				if(nope) {
					continue;
				}

				if(curx == x && cury == y) {
					done = true;

					for(int j = 0; j < base5.length(); j++) {
					if(base5.charAt(j) == '1') {
						ans += 'N';
					}
					if(base5.charAt(j) == '2') {
						ans += 'S';
					}
					if(base5.charAt(j) == '3') {
						ans += 'E';
					}
					if(base5.charAt(j) == '4') {
						ans += 'W';
					}
					}

					break;

				}

			}


			if(!done) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + t + ": " + ans);
			}

		}

	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}