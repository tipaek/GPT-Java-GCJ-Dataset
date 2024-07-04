import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
	public void run() throws Exception {
		FastScanner f = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int times = f.nextInt();
		for(int asdf = 1; asdf <= times; asdf++) {
			out.printf("Case #%d: ", asdf);
			long l = f.nextLong(), r = f.nextLong();
			long cur = 0;
			if(l > r) {
				long diff = l-r;
				cur = (long) Math.sqrt(2*diff);
				if(cur != 0) cur--;
				l -= cur*(cur+1)/2;
				cur++;
				while(l-r >= cur) l -= cur++;
			} else {
				long diff = r-l;
				cur = (long) Math.sqrt(2*diff);
				if(cur != 0) cur--;
				r -= cur*(cur+1)/2;
				cur++;
				while(r > l && r >= cur) r -= cur++;
			}
			cur--;
			long odd = cur%2 == 0 ? cur-1 : cur;
			long even = odd == cur ? cur-1 : cur;
			odd = (odd+1)/2*((odd+1)/2);
			even = even/2*even/2+even/2;
			long lo = cur, hi = 10000000000L;
			while(lo < hi) {
				long m = (lo+hi)/2;
				long modd = m%2 == 0 ? m-1 : m;
				long meven = modd == m ? m-1 : m;
				modd = (modd+1)/2*((modd+1)/2);
				meven = meven/2*meven/2+meven/2;
				if(cur%2 == 0 && (modd-odd > l || meven-even > r) || cur%2 != 0 && (meven-even > l || modd-odd > r)) hi = m;
				else lo = m+1;
			}
			long m = lo-1;
			long modd = m%2 == 0 ? m-1 : m;
			long meven = modd == m ? m-1 : m;
			modd = (modd+1)/2*((modd+1)/2);
			meven = meven/2*meven/2+meven/2;
			if(cur % 2 == 0) {l -= modd-odd; r -= meven-even;}
			else {r -= modd-odd; l -= meven-even;}
			m++;
			while(l >= m || r >= m) {
				if(r > l) r -= m;
				else l -= m;
				m++;
			}
			m--;
			out.println(m + " " + l + " " + r);
		}
///
		out.flush(); 
	}
///
    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
        	return Long.parseLong(next());
        }
        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        public String nextLine() {
        	try {
        		return reader.readLine();
        	} catch(IOException e) {
        		throw new RuntimeException(e);
        	}
        }
    }
}
