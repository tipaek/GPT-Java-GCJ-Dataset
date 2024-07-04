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
        int nc = f.nextInt();
        for (int asdf = 0; asdf < nc; asdf++) {
        	int na = f.nextInt();
        	char[] schedule = new char[na];
        	boolean works = true;
        	List<Activity> list = new ArrayList<>();
        	for (int i = 0; i < na; i++) {
        		list.add(new Activity(i, f.nextInt(), f.nextInt()));
        	}
        	Collections.sort(list);
        	int c = 0;
        	int j = 0;
        	for (Activity a : list) {
        		if (a.start >= c) {
        			c = a.end;
        			schedule[a.id] = 'C';
        		} else if (a.start >= j) {
        			j = a.end;
        			schedule[a.id] = 'J';
        		} else {
        			works = false;
        			break;
        		}
        	}
        	
           if (works) {
        	   System.out.print("Case #" + (asdf+1) + ": ");
               System.out.println(schedule);
           } else {
        	   System.out.println("Case #" + (asdf+1) + ": IMPOSSIBLE");
           }
           
        }
        out.flush();
    }
    
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
    
    static class Activity implements Comparable<Activity> {
    	int id;
    	int start;
    	int end;
    	public Activity(int i, int s, int e) {
    		id = i;
    		start = s;
    		end = e;
    	}
    	public int compareTo(Activity o) {
    		return start - o.start;
    	}
    }
}