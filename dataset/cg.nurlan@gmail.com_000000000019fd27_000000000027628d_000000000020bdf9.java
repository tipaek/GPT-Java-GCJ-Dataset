import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
 
    class Pair implements Comparable<Pair> {
        public int s, e;
        public int index;
        public Pair(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }
        
        public int compareTo(Pair p) {
            if (s > p.s) {
                return 1;
            } else if (s < p.s) {
                return -1;
            } else {
                return e - p.e;
            }
        }
    }
    
    public boolean isOverlap(Pair p1, Pair p2) {
        if (p1.e <= p2.s || p1.s >= p2.e) {
            return false;
        }
        return true;
    }
    
    public String solve(ArrayList<Pair> a) {
        char[] res = new char[a.size()];
        
        for (int i = 2; i < a.size(); ++i) {
            Pair p1 = a.get(i - 2);
            Pair p2 = a.get(i - 1);
            Pair p3 = a.get(i);
            if (isOverlap(p1, p2) && isOverlap(p1, p3) && isOverlap(p2, p3)) {
                return "IMPOSSIBLE";
            }
        }
        
        int[][] d = new int[a.size()][2];
        
        for (int i = 0;i < a.size(); ++i) {
            if (i == 0) {
                d[i][0] = -1;
                d[i][1] = -1;
                continue;
            }
            Pair prev = a.get(i - 1);
            Pair cur = a.get(i);
            boolean overlap = cur.s < prev.e;
            if (d[i-1][0] != 0) {
                d[i][1] = 1;
            }
            if (d[i-1][1] != 0) {
                d[i][0] = 2;
            }
            if (!overlap) {
                if (d[i-1][0] != 0) {
                    d[i][0] = 1;
                }
                if (d[i-1][1] != 0) {
                    d[i][1] = 2;
                }   
            }
        }
        
        int x = 0;
        res[a.get(a.size() - 1).index] = 'C';
        for (int i = a.size() - 1; i > 0; -- i) {
            if (d[i][x] == 1) {
                res[a.get(i - 1).index] = 'C';
                x = 0;
            } else if (d[i][x] == 2) {
                res[a.get(i - 1).index] = 'J';
                x = 1;
            }
        }
        
        return new String(res);
    }
	
	
	public void solve() throws Exception {
 		int t = sc.nextInt();
 		for (int i = 0;i < t; ++i) {
 		    int n = sc.nextInt();
 		    ArrayList<Pair> a = new ArrayList<>();
 		    for (int j = 0;j < n; ++j) {
 		        a.add(new Pair(sc.nextInt(), sc.nextInt(), j));
 		    }
 		    Collections.sort(a);
 		    System.out.println("Case #" + (i+1) + ": " + solve(a));
 		}
    }
 
 
 
 
 /*--------------------------------------------------------------*/
 
 static String filename = "";
 static boolean fromFile = false;
 
 BufferedReader in;
 PrintWriter out;
 FastScanner sc;
 
 public static void main(String[] args) {
 new Thread(null, new Solution(), "", 1 << 25).start();
 }
 
 public void run() {
 try {
 init();
 solve();
 } catch (Exception e) {
 throw new RuntimeException(e);
 } finally {
 out.close();
 }
 }
 
 void init() throws Exception {
 	if (fromFile) {
 		in = new BufferedReader(new FileReader(filename+".in"));
 	out = new PrintWriter(new FileWriter(filename+".out"));
 	} else {
 		in = new BufferedReader(new InputStreamReader(System.in));
 	out = new PrintWriter(System.out);
 	}
 sc = new FastScanner(in);
 }
}

class FastScanner {
 
 BufferedReader reader;
 StringTokenizer strTok;
 
 public FastScanner(BufferedReader reader) {
 this.reader = reader;
 }
 
 public String nextToken() throws IOException {
 while (strTok == null || !strTok.hasMoreTokens()) {
 strTok = new StringTokenizer(reader.readLine());
 }
 
 return strTok.nextToken();
 }
 
 public int nextInt() throws IOException {
 return Integer.parseInt(nextToken());
 }
 
 public long nextLong() throws IOException {
 return Long.parseLong(nextToken());
 }
 
 public double nextDouble() throws IOException {
 return Double.parseDouble(nextToken());
 }
 
 public BigInteger nextBigInteger() throws IOException {
 	return new BigInteger(nextToken());
 }
 
 public BigDecimal nextBigDecimal() throws IOException {
 	return new BigDecimal(nextToken());
 }
}