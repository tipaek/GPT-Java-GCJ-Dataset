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
			int t=fs.nextInt();
			for(int i =0;i<t;i++) {
				int n = fs.nextInt();
				int k = fs.nextInt();
				System.out.print("Case #"+(i+1)+":");
				int[][] ans = new int[n][n];
				int min = k/n;
				for(int j=0;j<n;j++) {
					ans[j][j]=min;
				}
				int rem = k%n;
				if((rem == 1 && min==1) || (k == n*n-1)) {
					System.out.println(" IMPOSSIBLE");
				}
				else {
					if(rem == 1) {
						ans[0][0]++;
						ans[1][1]++;
						ans[2][2]--;
					}
					else if(rem != n - 1) {
						for(int m=0;m<rem;m++){
							ans[m][m]++;
						}
					}else {
						ans[0][0]++;
						for(int m=0;m<rem-1;m++) {
							ans[m][m]++;
						}
					}
					if(ds(ans,0,0)) {
						System.out.println(" POSSIBLE");
						StringBuilder b = new StringBuilder("");
						for(int r=0;r<n;r++) {
							for(int c=0;c<n;c++) {
								b.append(ans[r][c]+" ");
							}
							b.append("\n");
						}
						System.out.print(b);

					}else {
						System.out.println(" IMPOSSIBLE");

					}
				}
				}
			}
//			int[][] a = new int[5][5];
//			a[0][0]=1;
//			a[1][1]=1;
//			a[2][2]=1;
//			a[3][3]=2;
//			a[4][4]=3;

//			System.out.println(ds(a,0,0));
//			for(int[] c:a) {
//				System.out.println(Arrays.toString(c));
//			}
			
		public static boolean  ds(int[][] a, int r, int c) {
			if(c==a.length) {
				c=0;
				r++;
			}
			if(r>=a.length) {
				return true;
			}
			if(r==c) {
				return ds(a,r,c+1);
			}
			for(int i =1; i <=a.length; i++) {
				boolean works = true;
				for(int j=0; j <a.length; j++) {
					if(a[r][j] == i ||a[j][c] ==i) {
						works = false;
						break;
					}
				}
				if(works) {
					a[r][c] = i;
					if(ds(a,r,c+1))
						return true;
					a[r][c] = 0;
				}
			}
			return false;
			
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


