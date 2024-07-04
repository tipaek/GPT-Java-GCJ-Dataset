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
            ArrayList<Pair> list = new ArrayList<Pair>();
            HashSet<Character> set = new HashSet<Character>();
            for (int i=0; i<10000; i++) {
            	long num = sc.nextLong();
            	String str = sc.next();
            	if (num > 0) {
            		list.add(new Pair(num, str));
            	} else {
            		list.add(new Pair(lim, str));
            	}
            	if (set.size() < 10) {
            		for (int j=0; j<str.length(); j++) {
            			set.add(str.charAt(j));
            		}
            	}
            }
            HashMap<Integer, HashSet<Character>> hm = new HashMap<Integer, HashSet<Character>>();
            for (int i=0; i<10; i++) {
            	hm.put(i, new HashSet<Character>());
            }
            for (char c : set) {
            	for (int i=0; i<10; i++) {
            		hm.get(i).add(c);
            	}
            }
            for (int i=0; i<list.size(); i++) {
            	Pair cur = list.get(i);
            	char firstChar = cur.str.charAt(0);
            	hm.get(0).remove(firstChar);
            	String numString = Long.toString(cur.num);
            	if (numString.length() == cur.str.length()) {
            		int upper = Integer.parseInt(numString.substring(0, 1));
            		for (int j=upper+1; j<10; j++) {
            			hm.get(j).remove(firstChar);
            		}
            	} else {
            		list.remove(i);
            		i--;
            	}
            }
            char[] answer = new char[10];
            for (char c : hm.get(0)) {
            	answer[0] = c;
            	for (int j=1; j<=9; j++) {
            		hm.get(j).remove(c);
            	}
            	break;
            }
            for (int i=9; i>=1; i--) {
            	HashSet<Character> curSet = hm.get(i);
            	//if (curSet.size() == 1) {
            		for (char c : curSet) {
            			answer[i] = c;
            			for (int j=1; j<=9; j++) {
            				if (j != i) {
            					hm.get(j).remove(c);
            				}
            			}
            			break;
            		}
            	//}
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