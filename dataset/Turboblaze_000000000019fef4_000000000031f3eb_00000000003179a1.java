import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out), true);
        int test = sc.nextInt();
        for (int t=1; t<=test; t++) {
            int u = sc.nextInt();
            long lim = 1;
            for (int i=0; i<u; i++) {
                lim *= 10;
            }
            lim--;
            Pair[] arr = new Pair[10000];
            HashSet<Character> set = new HashSet<Character>();
            for (int i=0; i<10000; i++) {
            	long num = sc.nextLong();
            	String str = sc.next();
            	if (num > 0) {
            		arr[i] = new Pair(num, str);
            	} else {
            		arr[i] = new Pair(lim, str);
            	}
            	if (set.size() < 10) {
            		for (int j=0; j<str.length(); j++) {
            			set.add(str.charAt(j));
            		}
            	}
            }
            HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
            for (char c : set) {
            	hm.put(c, 9);
            }
            HashSet<Character> not0 = new HashSet<Character>();
            for (int i=0; i<10000; i++) {
            	Pair cur = arr[i];
            	not0.add(cur.str.charAt(0));
            	String numString = Long.toString(cur.num);
            	if (numString.length() == cur.str.length()) {
            		int upper = Integer.parseInt(numString.substring(0, 1));
            		if (upper < hm.get(cur.str.charAt(0))) {
            			hm.put(cur.str.charAt(0), upper);
            		}
            	}
            }
            char[] answer = new char[10];
            for (char c : set) {
            	if (!not0.contains(c)) {
            		answer[0] = c;
            		break;
            	}
            }
            for (char c : hm.keySet()) {
            	if (c != answer[0]) {
            		answer[hm.get(c)] = c;
            	}
            }
            pw.println("Case #" + t + ": " + new String(answer));
        }
    }

    static class Pair {
        long num;
        String str;

        public Pair(long num, String str) {
            this.num = num;
            this.str = str;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(String in){
            br = new BufferedReader(
                    new InputStreamReader(new ByteArrayInputStream(in.getBytes())));
        }
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
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
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}