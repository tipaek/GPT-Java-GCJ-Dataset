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
        int n = a.size();
        
        ArrayList<Pair> c = new ArrayList<>();
        ArrayList<Pair> j = new ArrayList<>();
        
        for (int mask = 0;mask < 1 << n; ++ mask) {
            c = new ArrayList<>();
            j = new ArrayList<>();
            for (int i = 0;i < n; ++ i) {
                if ((mask & (1 << i)) > 0) {
                    c.add(a.get(i));
                } else {
                    j.add(a.get(i));
                }
            }
            boolean flag = true;
            for (int k = 0; k < c.size(); ++k) {
                for (int l = k + 1; l < c.size(); ++l) {
                    if (isOverlap(c.get(k), c.get(l))) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (!flag) {
                continue;
            }
            for (int k = 0; k < j.size(); ++k) {
                for (int l = k + 1; l < j.size(); ++l) {
                    if (isOverlap(j.get(k), j.get(l))) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                String res = "";
                for (int i = 0;i < n; ++ i) {
                    if ((mask & (1 << i)) > 0) {
                        res += "C";
                    } else {
                        res += "J";
                    }
                }
                return res;
            }
        }
        
        
        return "IMPOSSIBLE";
    }
	
	
	public void solve() throws Exception {
 		int t = sc.nextInt();
 		for (int i = 0;i < t; ++i) {
 		    int n = sc.nextInt();
 		    ArrayList<Pair> a = new ArrayList<>();
 		    for (int j = 0;j < n; ++j) {
 		        a.add(new Pair(sc.nextInt(), sc.nextInt(), j));
 		    }
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