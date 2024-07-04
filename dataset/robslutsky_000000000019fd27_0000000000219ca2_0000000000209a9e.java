import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
		public static void main(String[] args) throws IOException {
			Scanner fs=new Scanner(System.in);
			int cases=fs.nextInt();
			int b = fs.nextInt();
			for(int cas=1;cas<=cases;cas++) {
				int[] k = new int[b];
				System.out.println(1);
				k[0] = fs.nextInt();
				System.out.println(b);
				k[b-1] = fs.nextInt();
				System.out.println(2);
				k[1] = fs.nextInt();
				int tq = 3;
				int pos2 = 0;
				for(int p = 3; p < b; p++) {
					tq++;
					if(tq % 10 == 1) {
						System.out.println(1);
						int new0 = fs.nextInt();
						System.out.println(b);
						int newb = fs.nextInt();
						System.out.println(2);
						int new1 = fs.nextInt();
						if(newb == 1 - k[b-1]) {
								if(new0 == newb) {
									for(int i = 0; i < b; i++) {
										k[i] = 1-k[i];
									}
								}
								else {
									if(new1 != k[1]) {
										for(int i = 0; i < b; i++) {
											k[i] = 1-k[i];
										}
										k[0] = new0;
										k[b-1] = newb;
									}
							}
						}
						else {
							if(new0==newb) {
								continue;
							}
							if(new1 == 1-k[1]) {
								for(int i = 0; i < b; i++) {
									k[i] = 1-k[i];
								}
							}
							k[0] = new0;
							k[b-1] = newb;
						}
					}
					else {
						System.out.println(p);
						k[p - 1] = fs.nextInt();
					}
				}
				String s ="";
				for(int i =0; i < b;i++) {
					s+=k[i];
				}
				System.out.println(s);
			}
		}
		static class FastScanner {
		    BufferedReader br;
		    StringTokenizer st;
		    public FastScanner(InputStream i){
		        br = new BufferedReader(new InputStreamReader(i));
		        st = new StringTokenizer("");
		    }
		    public String next() throws IOException{
		        if(st.hasMoreTokens()) return st.nextToken();
		        else st = new StringTokenizer(br.readLine());
		        return next();
		    }
		    public long nextLong() throws IOException{ return Long.parseLong(next()); }
		    public int nextInt() throws IOException { return Integer.parseInt(next()); }
		    public double nextDouble() throws IOException { return Double.parseDouble(next()); }
		    public String nextLine() throws IOException {
		        if(!st.hasMoreTokens()) 
		            return br.readLine();
		        String ret = st.nextToken();
		        while(st.hasMoreTokens()) 
		            ret += " " + st.nextToken();
		        return ret;
		    }
		}
	}


