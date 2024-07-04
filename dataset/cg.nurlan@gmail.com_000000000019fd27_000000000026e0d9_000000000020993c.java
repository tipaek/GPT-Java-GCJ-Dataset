import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
 
 
	
	
    public void solve(int t) throws Exception {
        int n = sc.nextInt();
        ArrayList<HashSet<Integer>> row = new ArrayList<>();
        ArrayList<HashSet<Integer>> col = new ArrayList<>();
        for (int i = 0;i < n; ++ i) {
            row.add(new HashSet<Integer>());
            col.add(new HashSet<Integer>());
        }
        
        HashSet<Integer> rRow = new HashSet<Integer>();
        HashSet<Integer> rCol = new HashSet<Integer>();
        
        int x = 0;
        for (int i = 0;i < n; ++ i) {
            for (int j = 0;j < n; ++ j) {
                int a = sc.nextInt();
                if (i == j) {
                    x += a;
                }
                if (row.get(i).contains(a)) {
                    rRow.add(i);
                }
                if (col.get(j).contains(a)) {
                    rCol.add(j);
                }
                row.get(i).add(a);
                col.get(j).add(a);
            }
        }
        
        System.out.println("Case #" + t + ": " + x + " " + rRow.size() + " " + rCol.size());
    }
	
	public void solve() throws Exception {
	    int t = sc.nextInt();
	    for (int i = 0;i < t; ++i) {
	        solve(i + 1);
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