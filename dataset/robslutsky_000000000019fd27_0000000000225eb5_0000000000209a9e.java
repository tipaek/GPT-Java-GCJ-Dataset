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
				int samepair = -1;
				int diffpair = -1;
				boolean sf=false;
				boolean df=false;
				int tq = 0;
				int resume = 0;
				for(; resume < b/2; resume++) {
					int i =resume;
					tq+=2;
					System.out.println(i+1);
					k[i]=fs.nextInt();
					System.out.println(b - i);
					k[b-i-1]=fs.nextInt();
					if(k[i] == k[b-i-1]) {
						samepair= i;
						sf=true;
					}
					else {
						diffpair=i;
						df=true;
					}
					if(sf && df) {
						resume+=1;
						break;
					}
					if(tq%10 == 0 && resume +1 !=b/2) {
						System.out.println(1);
						int t1 = fs.nextInt();
						System.out.println(2);
						int t2=fs.nextInt();
						if(t1!=k[0]) {
							for(int j=0;j<i;j++) {
							k[j] = 1 - k[j];
							k[b-j-1] = 1- k[b-j-1];
							}
						}
						tq+=2;
					}
				}
				boolean rev = false;
				if(resume != b/2) {
					for(int p = resume; p < b - resume; p++) {
						if(!rev) {
							System.out.println(p+1);
							k[p]=fs.nextInt();
						}
						else {
							System.out.println(b-p);
							k[b-p  - 1]=fs.nextInt();
						}
						tq++;
						if(tq%10==0) {
							System.out.println(samepair + 1);
							int s1 = fs.nextInt();
							System.out.println(diffpair + 1);
							int d1 = fs.nextInt();
							if(s1 == k[samepair]) {
								if(d1 != k[diffpair]) {
									for(int i=0;i < b/2; i++) {
										int temp = k[i];
										k[i] = k[b-1-i];
										k[b-1-i]=temp;
									}
								}
							}
							else {
								if(d1==k[diffpair]) {
									for(int i=0;i < b/2; i++) {
										int temp = k[i];
										k[i] = k[b-1-i];
										k[b-1-i]=temp;
									}
									rev = !rev;
								}
								for(int i =0; i<b;i++)
									k[i]=1-k[i];
							}
						tq+=2;
						}
					}
			}
				String s ="";
				for(int i =0; i < b;i++) {
					s+=k[i];
				}
				System.out.println(s);
				String j = fs.next();
				if(j.equals("N")) {
					return;
				}
				
//				System.out.println(1);
//				k[0] = fs.nextInt();
//				System.out.println(b);
//				k[b-1] = fs.nextInt();
//				System.out.println(2);
//				k[1] = fs.nextInt();
//				int tq = 3;
//				int pos2 = 0;
//				for(int p = 3; p < b; p++) {
//					tq++;
//					if(tq % 10 == 1) {
//						System.out.println(Arrays.toString(k));
//						System.out.println(1);
//						int new0 = fs.nextInt();
//						System.out.println(b);
//						int newb = fs.nextInt();
//						System.out.println(2);
//						int new1 = fs.nextInt();
//						tq+=3;
//						if(newb == new0) {
//								if(new0 == 1- k[0]) {
//									for(int i = 0; i < b; i++) {
//										k[i] = 1-k[i];
//									}
//								}
//								else {
//									if(new1 != k[1]) {
//										for(int i = 0; i < b; i++) {
//											k[i] = 1-k[i];
//										}
//										k[0] = new0;
//										k[b-1] = newb;
//									}
//							}
//						}
//						else {
//							if(new0==newb) {
//								continue;
//							}
//							if(new1 == 1-k[1]) {
//								System.out.println("in here");
//								for(int i = 0; i < b; i++) {
//									k[i] = 1-k[i];
//								}
//							}
//							k[0] = new0;
//							k[b-1] = newb;
//						}
//						System.out.println(Arrays.toString(k));
//					}
//					System.out.println(p);
//					k[p - 1] = fs.nextInt();
//				}
//				String s ="";
//				for(int i =0; i < b;i++) {
//					s+=k[i];
//				}
//				System.out.println(s);
//				String j = fs.next();
//				if(j.equals("N")) {
//					return;
//				}
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


