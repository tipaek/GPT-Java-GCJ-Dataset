import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;
 
public class Solution {
	static long[][] pascals = new long[33][33];
    public static void main(String[] args) throws IOException {
    	pascals[1][1] = 1;
    	for(int i = 2; i < pascals.length; i++) {
    		for(int j = 1; j <= i; j++) {
    			pascals[i][j] = pascals[i-1][j] + pascals[i-1][j-1];
    		}
    	}
    	
    	//for(long[] each : pascals)
    	//	System.out.println(Arrays.toString(each));
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
        	out.println("Case #" + testNumber + ": ");
        	long N = sc.nextInt();
        	String s = Long.toBinaryString(N);
        	long requested = N - s.length();
        	String actual = Long.toBinaryString(requested);
        	
        	//System.out.println(actual);
        	StringBuilder sb = new StringBuilder("");
        	boolean left = true;
        	long total = 0;
        	int i;
        	for(i = 1; i <= actual.length(); i++) {
           		if(actual.charAt(actual.length()-i) == '1') {
        			if(left) {
	        			for(int j = 1; pascals[i][j] != 0; j++) {
	        				total += pascals[i][j];
	        				sb.append(i + " " + j + "\n");
	        			}
        			} else {
        				int j;
        				for(j = pascals.length-1; pascals[i][j] == 0; j--) {}
        				for(; j >= 1; j--) {
        					total += pascals[i][j];
        					sb.append(i + " " + j + "\n");
        				}
        			}
        			left = !left;
        		} else {
        			if(left) {
            			sb.append(i + " 1\n");
            		} else {
            			sb.append(i + " " + i + "\n");
            		}
            		total += 1;
        		}
        		//System.out.println(total);
        	}
        	
        	//System.out.println(total);
        	while(total < N) {
        		if(left) {
        			sb.append(i + " 1\n");
        		} else {
        			sb.append(i + " " + i + "\n");
        		}
        		i++;
        		total++;
        		//System.out.println(total);
        	}
        	
        	out.print(sb);
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