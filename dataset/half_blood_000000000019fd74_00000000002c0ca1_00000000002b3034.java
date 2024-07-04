import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {


		 
		public static void main(String[] args) {
			
			
			// your code goes here
	         FastReader scn = new FastReader();
			 int t = scn.nextInt();
			 int  p = t;
			 while(t-->0) {
				 int n = scn.nextInt();
				 ArrayList<String>[] arr = new ArrayList[n];
				 for(int i=0; i<n; i++)
					 arr[i] = new ArrayList<>();
				 for(int i=0; i<n; i++) {
					 String str = scn.next();
					 Collections.addAll(arr[i], str.split("\\*"));
				 }
				 System.out.print("Case #" + (p-t) + ": ");
				 
				 String k1 = arr[0].get(0);
				 String k2;
				if(arr[0].size() == 1)
					 k2 = "";
				else
					k2 = arr[0].get(arr[0].size()-1);
				 int flag = 0;
				 for(int i=1; i<n; i++) {
					 if(arr[i].size() == 1) {
						 String a1 = arr[i].get(0);
						 if(a1.length() < k1.length()) {
							 if(a1.length()!=0 && !k1.substring(0, a1.length()).equals(a1)) {
								 flag = 1;
								 break;
							 }
						 }else {
							 if(k1.length()!=0 && !a1.substring(0,k1.length()).equals(k1)) {
								 flag = 1;
								 break;
							 }
							 k1 = a1;
						 }
						 continue;
					 }
					 String a1 = arr[i].get(0);
					 String a2 = arr[i].get(arr[i].size()-1);
					 if(a1.length() < k1.length()) {
						 if(a1.length()!=0 && !k1.substring(0, a1.length()).equals(a1)) {
							 flag = 1;
							 break;
						 }
					 }else {
						 if(k1.length()!=0 && !a1.substring(0,k1.length()).equals(k1)) {
							 flag = 1;
							 break;
						 }
						 k1 = a1;
					 }
					 
					 if(a2.length() < k2.length()) {
						 if(!k2.substring(k2.length()-a2.length()).equals(a2)) {
							 flag = 1;
							 break;
						 }
					 }else {
						 if(!a2.substring(a2.length()-k2.length()).equals(k2)) {
							 flag = 1;
							 break;
						 }
						 k2 = a2;
					 }
				 }
				 //System.out.println(k1);
				 if(flag == 1)
					 System.out.println("*");
				 else {
					 if(k1.length()==0)
						 System.out.print("A" + k1);
					 else
						 System.out.print(k1);
					 if(k2.length()==0)
						 System.out.print(k2 + "B");
					 else
						 System.out.print(k2);
					 System.out.println();
				 }
				 
				 
			 }
			 

		}
		static class Pair implements Comparable<Pair>{
			long a;
			long b;
			int k;
			Pair(long x, long y, int k){
				a = x;
				b = y;
				this.k = k;
			}
			public int compareTo(Pair p) {
				if(a == p.a)
					return (int) (p.b - b);
				return (int) (a - p.a);
			}
		}
		static class FastReader {
			BufferedReader br;
			StringTokenizer st;

			public FastReader() {
				br = new BufferedReader(new InputStreamReader(System.in));
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

		