import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;


public class Solution {

	static boolean verb=true;
	static void log(Object X){if (verb) System.err.println(X);}
	static void log(Object[] X){if (verb) {for (Object U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X){if (verb) {for (int U:X) System.err.print(U+" ");System.err.println("");}}
	static void logWln(Object X){if (verb) System.err.print(X);}
	static void info(Object o){	System.out.println(o);}
	static void output(Object o){outputWln(""+o+"\n");	}
	static void outputWln(Object o){try {out.write(""+ o);} catch (Exception e) {}}


	static void test(){
		log("testing");
		int NTESTS=1000000;
		Random r=new Random();
		for (int t=0;t<NTESTS;t++){

		}
		log("done");
		return;
	}


	// Global vars
	static BufferedWriter out;

	static class Composite implements Comparable<Composite>{

		int v;
		int idx;

		public int compareTo(Composite X) {
			if (v!=X.v)
				return v-X.v;
			return idx-X.idx;
		}

		public Composite(int v, int idx) {
			this.v = v;
			this.idx = idx;
		}

		public String toString() {
			return v+" "+idx;
		}
		
	}


	static String solveSimple(int D,int[][] mat,int[] x) {
		int n=x.length;
		ArrayList<Integer> source=new ArrayList<Integer>();
		source.add(0);
		PriorityQueue<Composite> pq=new PriorityQueue<Composite>();
		for (int i=1;i<n;i++) {
			pq.add(new Composite(-x[i],i));
		}
		int MX=1000000;
		int[] res=new int[D];
		Arrays.fill(res,MX);
		int[] tm=new int[n];
		int time=0; // maxTime of all	

		while (pq.size()>0) {
			Composite P=pq.peek();
			int val=P.v;
			ArrayList<Integer> lst=new ArrayList<Integer>();
			while (pq.size()>0 && pq.peek().v==val) {
				Composite X=pq.poll();
				lst.add(X.idx);
			}
			time++;

			for (int u:lst) {
				tm[u]=time;
				loop:for (int v:source) {
					if (mat[u][v]>0) {
						int d=mat[u][v]-1;
						res[d]=tm[u]-tm[v];
						break loop;
					}
				}
			}
			for (int u:lst)
				source.add(u);

			// now we have lst...
			// for each we pick and
		}
		String rs="";
		for (int d=0;d<D;d++)
			rs+=res[d]+" ";
		return rs;
	}

	static String solveSubtil(int D,int[][] mat,int[] x) {
		int n=x.length;
		ArrayList<Integer> source=new ArrayList<Integer>();
		source.add(0);
		PriorityQueue<Composite> pq=new PriorityQueue<Composite>();
		PriorityQueue<Composite> fixed=new PriorityQueue<Composite>();

		for (int i=1;i<n;i++) {
			if (x[i]<0)
				pq.add(new Composite(-x[i],i));
			else
				fixed.add(new Composite(x[i],i));
		}
		int MX=1000000;
		int[] res=new int[D];
		Arrays.fill(res,MX);
		int[] tm=new int[n];
		int time=0; // maxTime of all	
		
		while (pq.size()>0) {
			Composite P=pq.peek();
			int val=P.v;
			ArrayList<Integer> add=new ArrayList<Integer>();
			int cnt=source.size();
			int prevTime=time;
			while (cnt<val) {
				// we need to integrate more guys
				// we integrate time accordingly
				Composite X=fixed.poll();
				int u=X.idx;
				tm[u]=X.v;
				for (int v:source) {
					if (mat[u][v]>0) {
						int d=mat[u][v]-1;
						res[d]=tm[u]-tm[v];
						break;
					}
				}
				time=Math.max(time,tm[u]);
				add.add(u);
				cnt++;
			
			}
			source.addAll(add);
			// we need to change time anyway
			time++;
			
			ArrayList<Integer> lst=new ArrayList<Integer>();
			while (pq.size()>0 && pq.peek().v==val) {
				Composite X=pq.poll();
				lst.add(X.idx);
			}
			for (int u:lst) {
				tm[u]=time;
				loop:for (int v:source) {
					if (mat[u][v]>0) {
						int d=mat[u][v]-1;
						res[d]=tm[u]-tm[v];
						break loop;
					}
				}
			}
			for (int u:lst)
				source.add(u);

			// now we have lst...
			// for each we pick and
		}
		// may be we still ahve fixed
		log("finalizing ???");
		while (fixed.size()>0) {
			Composite X=fixed.poll();
			log(X);
			int u=X.idx;
			tm[u]=X.v;
			for (int v:source) {
				if (mat[u][v]>0) {
					int d=mat[u][v]-1;
					res[d]=tm[u]-tm[v];
					break;
				}
			}
		}
		
		
		String rs="";
		for (int d=0;d<D;d++)
			rs+=res[d]+" ";
		return rs;
	}

	static void process() throws Exception {
		Locale.setDefault(Locale.US);



		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);

		//test();

		int T=sc.nextInt();
		for (int t=1;t<=T;t++){


			int n=sc.nextInt();
			int D=sc.nextInt();
			int[][] mat=new int[n][n];

			int[] x=new int[n];
			for (int i=1;i<n;i++)
				x[i]=sc.nextInt();



			for (int i=0;i<D;i++) {
				int u=sc.nextInt()-1;
				int v=sc.nextInt()-1;
				mat[u][v]=i+1;
				mat[v][u]=i+1;

			}



			String ss="";

			ss+=solveSubtil(D,mat,x);



			System.out.println("Case #"+t+": "+ss);
			//log("Case #"+t+": "+ss);


		}



		sc.close();



	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
