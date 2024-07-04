import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
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
		static HashMap<BigDecimal, BigDecimal> map = new HashMap<BigDecimal, BigDecimal> ();
		public static void main(String[] args) throws IOException {
			Scanner fs=new Scanner(System.in);
			int t=fs.nextInt();
			for(int cas=1; cas<=t;cas++) {
				String ans="";
//				int n = fs.nextInt();
//				int[] a = new int[n];
//				for(int i =0;i<n;i++) {
//					a[i]=fs.nextInt();
//				}
//				int ans = 0;
				/*int x = fs.nextInt();
				boolean xneg = false;
				xneg = x<0;
				x=(int)Math.abs(x);
				int y = fs.nextInt();
				boolean yneg = false;
				yneg = y<0;
				y=(int)Math.abs(y);
				String xbin=Integer.toBinaryString(x);
				String ybin=Integer.toBinaryString(y);
				int sum = x+y;
				HashSet<Integer> xhas = new HashSet<Integer>();
				HashSet<Integer> xmiss = new HashSet<Integer>();
				HashSet<Integer> yhas = new HashSet<Integer>();
				HashSet<Integer> ymiss = new HashSet<Integer>();
				while(xbin.length()<ybin.length()) {
					xbin="0"+xbin;
				}
				while(ybin.length()<xbin.length()) {
					ybin="0"+xbin;
				}
				for(int i = 0;i<xbin.length();i++) {
					if(xbin.charAt(i)=='1') {
						xhas.add(xbin.length()-1-i);
					}
					else {
						xmiss.add(xbin.length()-1-i);
					}
				}
				System.out.println(xbin+" "+ybin);
				for(int i = 0;i<ybin.length();i++) {
					if(ybin.charAt(i)=='1') {
						yhas.add(ybin.length()-1-i);
					}
					else {
						ymiss.add(ybin.length()-1-i);
					}
				}
				System.out.println(xhas+" "+yhas);
				boolean works = true;
				for(Integer j: xhas) {
					if(!ymiss.contains(j)) {
						works = false;
						break;
					}
				}
				if(works) {
					for(Integer j: yhas) {
						if(!xmiss.contains(j)) {
							works = false;
							break;
						}
					}	
				}
				if(works) {
					int k = Math.max(xbin.length(), ybin.length());
					for(int i = 0; i < k; i++) {
						if(xhas.contains(i)) {
							if(!xneg)
								ans+="E";
							else
								ans+="W";
						}
						else {
							if(!yneg)
								ans+="N";
							else
								ans+="S";
						}
					}
				}
				if(!works) {
					
				}*/
				int x = fs.nextInt();
				boolean xneg = false;
				xneg = x<0;
				x=(int)Math.abs(x);
				int y = fs.nextInt();
				boolean yneg = false;
				yneg = y<0;
				y=(int)Math.abs(y);
				int sum = x+y;
				int sumpl = sum+1;
				String ybin = Integer.toBinaryString(y);
				String xbin = Integer.toBinaryString(x);
				HashMap<Integer, Integer> powers = new HashMap<Integer,Integer>();
				for(int i =0;i<=31;i++) {
					powers.put((int)Math.pow(2, i), i);
				}
				if(powers.containsKey(sumpl)) {
					int moves = powers.get(sumpl);
					String[] a= new String[moves];
					for(int i =0;i < moves; i++) {
						if((x>>i) % 2 == 1) {
							a[i]="E";
						}
						else {
							a[i]="N";
						}
					}
					if(xneg) {
						for(int i = 0; i < a.length; i++) {
							if(a[i].equals("W")) {
								a[i]="E";
							}
							else if(a[i].equals("E")) {
								a[i]="W";
							}
						}
					}
					if(yneg) {
						for(int i = 0; i < a.length; i++) {
							if(a[i].equals("N")) {
								a[i]="S";
							}
							else if(a[i].equals("S")) {
								a[i]="N";
							}
						}
					}
					String answer="";
					for(int i =0;i<a.length;i++) {
						answer+=a[i];
					}
					System.out.println("Case #"+cas+": "+answer);
					continue;
				}
				else {
					int cx = (x^(-1))+1;
					String xng = Integer.toBinaryString(cx);
					while(xng.length()>=ybin.length() &&xng.length()>2&& xng.charAt(0)=='1'&&xng.charAt(1)=='1') {
						xng=xng.substring(1);
					}
					int xx = Integer.parseUnsignedInt(xng, 2);
					sumpl=xx+y+1;
					if(powers.containsKey(sumpl)) {
						int moves = powers.get(sumpl);
						String[] a= new String[moves];
						for(int i =0;i < moves; i++) {
							if((y>>i)%2== 1) {
								a[i]="N";
							}else {
								a[i]="W";
							}
						}
						for(int i = moves-1; i > -1;i--) {
							if(a[i].equals("W")) {
								a[i]="E";
								break;
						}
						}
						if(xneg) {
							for(int i = 0; i < a.length; i++) {
								if(a[i].equals("W")) {
									a[i]="E";
								}
								else if(a[i].equals("E")) {
									a[i]="W";
								}
							}
						}
						if(yneg) {
							for(int i = 0; i < a.length; i++) {
								if(a[i].equals("N")) {
									a[i]="S";
								}
								else if(a[i].equals("S")) {
									a[i]="N";
								}
							}
						}
						String answer="";
						for(int i =0;i<a.length;i++) {
							answer+=a[i];
						}
						System.out.println("Case #"+cas+": "+answer);
						continue;
					}
					else {
						int cy = (y^(-1))+1;
						String yng = Integer.toBinaryString(cy);
						while(yng.length()>=xbin.length() &&yng.length()>2 && yng.charAt(0)=='1'&&yng.charAt(1)=='1') {
							yng=yng.substring(1);
						}
						int yy = Integer.parseUnsignedInt(yng, 2);
						sumpl=x+yy+1;
						if(powers.containsKey(sumpl)) {
							int moves = powers.get(sumpl);
							String[] a= new String[moves];
							for(int i =0;i < moves; i++) {
								if((x>>i) % 2 == 1) {
									a[i]="E";
								}
								else {
									a[i]="S";
								}
							}
							for(int i = moves-1; i > -1;i--) {
								if(a[i].equals("S")) {
									a[i]="N";
									break;
							}}
							if(xneg) {
								for(int i = 0; i < a.length; i++) {
									if(a[i].equals("W")) {
										a[i]="E";
									}
									else if(a[i].equals("E")) {
										a[i]="W";
									}
								}
							}
							if(yneg) {
								for(int i = 0; i < a.length; i++) {
									if(a[i].equals("N")) {
										a[i]="S";
									}
									else if(a[i].equals("S")) {
										a[i]="N";
									}
								}
							}
							String answer="";
							for(int i =0;i<a.length;i++) {
								answer+=a[i];
							}
							System.out.println("Case #"+cas+": "+answer);
							continue;
						}
						else {
							cy = (y^(-1))+1;
							yng = Integer.toBinaryString(cy);
							while(yng.length()>2 && yng.charAt(0)=='1'&&yng.charAt(1)=='1') {
								yng=yng.substring(1);
							}
							cx = (x^(-1))+1;
							xng = Integer.toBinaryString(cx);
							while(xng.length()>2 && xng.charAt(0)=='1'&&xng.charAt(1)=='1') {
								xng=xng.substring(1);
							}

							while(xng.length()<yng.length() -1) {
								xng="1"+xng;
							}
							while(yng.length()<xng.length() -1) {
								yng="1"+yng;
							}
							yy = Integer.parseUnsignedInt(yng, 2);
							xx = Integer.parseUnsignedInt(xng, 2);
							sumpl=xx+yy+1;
							if(powers.containsKey(sumpl)) {
								int moves = powers.get(sumpl);
								String[] a= new String[moves];
								for(int i =0;i < moves; i++) {
									if((xx>>i) % 2 == 1) {
										a[i]="W";
										if(i == xng.length()-1)
											a[i]="E";
									}
									else if((yy>>i) %2 == 1) {
										a[i]="S";
										if(i == yng.length()-1)
											a[i]="N";
									}
								}
								if(xneg) {
									for(int i = 0; i < a.length; i++) {
										if(a[i].equals("W")) {
											a[i]="E";
										}
										else if(a[i].equals("E")) {
											a[i]="W";
										}
									}
								}
								if(yneg) {
									for(int i = 0; i < a.length; i++) {
										if(a[i].equals("N")) {
											a[i]="S";
										}
										else if(a[i].equals("S")) {
											a[i]="N";
										}
									}
								}
								String answer="";
								for(int i =0;i<a.length;i++) {
									answer+=a[i];
								}
								System.out.println("Case #"+cas+": "+answer);
								continue;
								}
							System.out.println("Case #"+cas+": IMPOSSIBLE");	
						}
					}
				}
//				System.out.println("Case #"+cas+": "+ans);

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




