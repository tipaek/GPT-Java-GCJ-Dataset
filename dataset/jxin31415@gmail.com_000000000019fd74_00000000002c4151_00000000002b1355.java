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
    	static boolean[][] temp;
        public void solve(int testNumber, FastReader sc, PrintWriter out) {
        	int R = sc.nextInt();
        	int C = sc.nextInt();
        	
        	int[][] skill = new int[R][C];
        	for(int i = 0; i < R; i++) {
        		for(int j = 0; j < C; j++) {
        			skill[i][j] = sc.nextInt();
        		}
        	}
        	
        	boolean[][] elim = new boolean[R][C];
        	temp = new boolean[R][C];
        	boolean changed = true;
        	long total = 0;
        	while(changed) {
        		//System.out.println("GO");
        		changed = false;
        		for(int i = 0; i < R; i++) {
        			for(int j = 0; j < C; j++) {
        				if(!elim[i][j]) {
        					//System.out.println(i + " " + j + " " + eli(skill, i, j, elim) + " " + skill[i][j]);
        					if(eli(skill, i, j, elim)) {
        						temp[i][j] = true;
        						changed = true;
        					}
        					total += skill[i][j];
        				}
        			}
        		}
        		for(int i = 0; i < R; i++) {
        			for(int j = 0; j < C; j++) {
        				elim[i][j] = temp[i][j];
        			}
        		}
        		//for(boolean[] each: elim)
        		//	System.out.println(Arrays.toString(each));
        	}
        	out.println("Case #" + testNumber + ": " + total);
        }
        
        public static boolean eli(int[][] board, int i, int j, boolean[][] elim) {
        	double sum = 0;
        	int count = 0;
        	for(int t = i-1; t >= 0; t--) {
        		if(!elim[t][j]) {
        			sum += board[t][j];
        			count++;
        			break;
        		}
        	}
        	for(int t = j-1; t >= 0; t--) {
        		if(!elim[i][t]) {
        			sum += board[i][t];
        			count++;
        			break;
        		}
        	}
        	for(int t = i+1; t < board.length; t++) {
        		if(!elim[t][j]) {
        			sum += board[t][j];
        			count++;
        			break;
        		}
        	}
        	for(int t = j+1; t < board[i].length; t++) {
        		if(!elim[i][t]) {
        			sum += board[i][t];
        			count++;
        			break;
        		}
        	}        	//System.out.println("DIV" + sum + " " + count + " " + board[i][j]);

        	if(count == 0)
        		return false;
        	return (sum / count) > board[i][j];
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