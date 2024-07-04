import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        //FastReader scan = new FastReader("in.txt");
        FastReader scan = new FastReader();
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Task solver = new Task();
        int t = scan.nextInt();
        //int t = 1;
        for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }
    static class Task {
        public void solve(int testNumber, FastReader sc, PrintWriter out) {
        	int N = sc.nextInt();
        	
        	List<String> irrelevant = new ArrayList<>();
        	
        	String front = "";
        	String back  = "";
        	List<String> fr = new ArrayList<>();
        	List<String> ba = new ArrayList<>();
        	
        	while(N --> 0) {
        		String s = sc.next();
        		String[] n = s.split("\\*");
        		if(s.charAt(0) != '*') {
        			if(front.length() < n[0].length())
        				front = n[0];
        			fr.add(n[0]);
        		} else {
        			irrelevant.add(n[0]);
        		}
        		for(int i = 1; i < n.length - 1; i++) {
        			irrelevant.add(n[i]);
        		}
        		if(s.charAt(s.length()-1) != '*') {
        			if(back.length() < n[n.length-1].length())
        				back = n[n.length-1];
        			ba.add(n[n.length-1]);
        		} else {
        			irrelevant.add(n[n.length-1]);
        		}
        	}
        	
        	for(String each: fr) {
        		if(!front.substring(0, each.length()).equals(each)) {
        			out.println("Case #" + testNumber + ": *");
        			return;
        		}
        	}
        	for(String each: ba) {
        		if(!back.substring(back.length() - each.length()).equals(each)) {
        			out.println("Case #" + testNumber + ": *");
        			return;
        		}
        	}
        	StringBuilder ans = new StringBuilder(front);
        	for(String each: irrelevant)
        		ans.append(each);
        	ans.append(back);
        	
        	out.println("Case #" + testNumber + ": " + ans);
        }
    }
    static class tup implements Comparable<tup>, Comparator<tup> {
        int a, b;
 
        tup() {
        }
 
        tup(int a, int b) {
            this.a = a;
            this.b = b;
        }
 
        @Override
        public int compareTo(tup o2) {
            return a==o2.a?Integer.compare(b,o2.b):Integer.compare(a, o2.a);
        }

		@Override
		public int compare(tup o1, tup o2) {
			return o1.a==o2.a ? Integer.compare(o1.b, o2.b): Integer.compare(o1.a, o2.a); 
		}
		
		@Override
	    public int hashCode() {
			return Objects.hash(a, b);
	    }

	    @Override
	    public boolean equals(Object obj) {
	    	if (this == obj)
                return true;
	    	if (obj == null)
                return false;
	    	if (getClass() != obj.getClass())
                return false;
	    	tup other = (tup) obj;
	    	return a==other.a && b==other.b;
	    }
    }
    static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
}