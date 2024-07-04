import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
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

	static String solveStupid(long L,long R) {
		boolean goon=true;
		int n=1;
		while (goon) {
			long min=Math.min(L,R);
			long max=Math.max(L, R);

			if (n>Math.max(L, R))
				return (n-1)+" "+L+" "+R;
			if (R>L) {
				R-=n;
			} else
				L-=n;
			//log((R-L));
			n++;
		}
		return n+" "+L+" "+R;
	}
	static long calc(long x) {

		long res=x;
		if (x%2==0) {
			res/=2;
			res*=x+1;
		} else {
			res*=(x+1)/2;
		}
		return res;
	}

	static void check(long x,long k) {

		long sum=0;
		long z=x;
		for (int i=0;i<k;i++) {
			sum+=z;
			z+=2;
		}
		log(sum);
		long alt=k*x+k*(k-1);
		//log(alt);

	}

	static long calc(long x,long k) {
		long alt=k*x+k*(k-1);
		return alt;
	}


	static long HI=2000000000;

	static long[] find(long x,long n) {
		//log("find");
		long lo=1;
		long hi=HI;
		while (lo+1<hi) {
			long mid=(lo+hi)/2;
			if (calc(n,mid)<=x) {
				lo=mid;
			} else
				hi=mid;
		}
		//log("done");
		return new long[] {n+2*(lo-1),x-calc(n,lo)};

	}

	static String solveSubtil(long L,long R) {
		boolean goon=true;
		long n=1;
		//log("solve subtil");
		if (L!=R) {
			//log("reducing gap");
			long diff=Math.abs(R-L);
			long lo=1;
			long hi=HI;
			while (lo+1<hi) {
				long mid=(lo+hi)/2;
				long A=calc(mid);
				if (A<=diff)
					lo=mid;
				else
					hi=mid;
			}
			n=lo;
			if (R>L) {
				R-=calc(n);
			} else
				L-=calc(n);
			n++;
		}
		// now the difference is minimal...
		// which mean we alternate
		long res=n-1;
		if (L>=R) {
			// start with L
			if (L>=n) {

				long[] bob=find(L,n);
				res=Math.max(res, bob[0]);
				L=bob[1];


				if (R>=n+1) {
					bob=find(R,n+1);
					res=Math.max(res, bob[0]);
					R=bob[1];
				}

			}

		} else {
			// start with R
			if (R>=n) {

				long[] bob=find(R,n);
				res=Math.max(res, bob[0]);
				R=bob[1];


				if (L>=n+1) {
					bob=find(L,n+1);
					res=Math.max(res, bob[0]);
					L=bob[1];
				}

			}
			
		}

		return res+" "+L+" "+R;
	}


	static void test2() {
		log("testing");
		for (long L=1;L<=10000;L++)
			for (long R=1;R<=10000;R++) {
				String s1=solveSubtil(L,R);
				String s2=solveStupid(L,R);
				if (!s1.contentEquals(s2)) {
					log("Error");
					log(L+" "+R);
					log("bad:"+s1+"#");
					log("good:"+s2+"#");
					return;
					
				}
				
			}
		log("done");
	}

	// Global vars
	static BufferedWriter out;



	static void process() throws Exception {
		Locale.setDefault(Locale.US);



		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);

		//test();

		//test2();
		//check(1,2);

		int T=sc.nextInt();
		for (int t=1;t<=T;t++){

			long L=sc.nextLong();
			long R=sc.nextLong();



			String ss="";

			ss+=solveSubtil(L,R);


			System.out.println("Case #"+t+": "+ss);
			//log("Case #"+t+": "+ss);


		}



		sc.close();



	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
