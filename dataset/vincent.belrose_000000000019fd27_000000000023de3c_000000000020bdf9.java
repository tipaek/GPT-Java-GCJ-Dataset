import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
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


	static class Composite implements Comparable<Composite>{
		int time;
		int v; 
		int idx;
		
		public int compareTo(Composite X) {
			if (time!=X.time)
				return time-X.time;
			if (v!=X.v)
				return v-X.v;
			return idx-X.idx;
		}

		public Composite(int time, int v, int idx) {
			this.time = time;
			this.v = v;
			this.idx = idx;
		}
		
		
		
	}
	
	// Global vars
	static BufferedWriter out;



	static void process() throws Exception {
		Locale.setDefault(Locale.US);



		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);

		//test();

		int T=sc.nextInt();
		for (int t=1;t<=T;t++){

			int n=sc.nextInt();
		
			Composite[] ar=new Composite[2*n];
			
	
			int cur=0;
			
			for (int i=0;i<n;i++) {
				int e=sc.nextInt();
				int f=sc.nextInt();
				ar[cur++]=new Composite(e,1,i);
				ar[cur++]=new Composite(f,-1,i);
			}
			Arrays.sort(ar);
			int[] occ=new int[2];
			int[] target=new int[n];
			boolean ok=true;
			loop:for (Composite X:ar) {
				if (X.v==-1) {
					occ[target[X.idx]]=0;
				} else {
					if (occ[0]==0) {
						target[X.idx]=0;
						occ[0]=1;
					} else if (occ[1]==0) {
						target[X.idx]=1;
						occ[1]=1;
					} else {
						ok=false;
						break loop;
					}
				}
			}
	
			String par="CJ";
			String ss="";
			if (!ok)
				ss="IMPOSSIBLE";
			else {
				char[] ans=new char[n];
				for (int i=0;i<n;i++)
					ans[i]=par.charAt(target[i]);
				ss=new String(ans);
			}
			
			System.out.println("Case #"+t+": "+ss);
			//log("Case #"+t+": "+ss);


		}



		sc.close();
	


	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
