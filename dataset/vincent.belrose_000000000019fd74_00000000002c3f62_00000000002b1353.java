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
	static void log(long[] X){if (verb) {for (long U:X) System.err.print(U+" ");System.err.println("");}}

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

	static int MAX=100;
	static long[][] binom=new long[MAX+1][MAX+1];
	static long[][] toRight=new long[MAX+1][MAX+1];


	static long LIM=1000000000000000L;
	static void init() {
		binom[0][0]=1;
		long max=0;
		long min=Long.MAX_VALUE;
		
		for (int i=1;i<MAX;i++){
			binom[i][0]=1;
			binom[i][i]=1;
			for (int j=0;2*j<=i;j++) {
				binom[i+1][j+1]=binom[i][j]+binom[i][j+1];
				int nj=i-j;
				binom[i+1][nj]=binom[i+1][j+1];
				if (binom[i+1][j+1]>=LIM)
					break;
			}
			

		}
		for (int i=1;i<MAX+1;i++) {
			for (int j=i-1;j>=0;j--) {
				toRight[i][j]=binom[i][j+1]+toRight[i][j+1];
			}
		}
		log("max:"+max);
		log("min:"+min);
	}

	// Global vars
	static BufferedWriter out;

	static boolean solve(int n) {
	
		int i=0;
		int j=0;
		long cur=1;
		int steps=1;
		long diff=n-cur;
		ArrayList<int[]> moves=new ArrayList<int[]>();
		moves.add(new int[] {i,j});
		while (diff>0) {
			
			if (steps+diff<=500) {

				if (j<i) {
					moves.add(new int[] {i,j+1});
					cur+=binom[i][j+1];
					j++;
				} else {
					moves.add(new int[] {i+1,j+1});
					cur+=1;
					i++;
					j++;
				}
				steps++;
				diff=n-cur;

			} else {
				//log("i:"+i+" j:"+j+" cur:"+cur+" moveToRight:"+toRight[i][j]+" tot:"+(cur+toRight[i][j])+" target:"+n+" diff:"+diff+" nsteps:"+steps);
				long best=-1;
				int tj=-1;
				for (int nj:new int[] {j,j+1}) {
					long newval=cur+binom[i+1][nj];
					if (newval+toRight[i+1][nj]<=n) {
						if (newval>=best) {
							best=newval;
							tj=nj;
						}
					}
				}
				if (best>=0) {
					moves.add(new int[] {i+1,tj});
					cur+=binom[i+1][tj];
					steps++;
					j=tj;
					i=i+1;
				} else {

					moves.add(new int[] {i,j+1});
					cur+=binom[i][j+1];
					j=j+1;
				}
				steps++;
				diff=n-cur;
			}
		}



	
		long bob=0;
		for (int[] tm:moves) {
			System.out.println((tm[0]+1)+" "+(tm[1]+1));
			if (tm[0]==tm[1])
				bob++;
			else
				bob+=binom[tm[0]][tm[1]];
		}
		if (bob!=n) {
			log("Error "+bob+" "+n);
			return false;
			
			
			
		}
		return true;
		
		//log("Case #"+t+": "+ss);
	}


	static void process() throws Exception {
		Locale.setDefault(Locale.US);



		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);

		//test();
	

		init();
		
		/*
		for (int u=0;u<6;u++)
			log(binom[u]);
		Random r=new Random();
		log("testing");
		for (int t=0;t<100000;t++) {
			int n=r.nextInt(1000000000)+1;
			log("n:"+n);
		
			if (!solve(n)) {
				log("stop for b:"+n);
				break;
			}
			log("done");
		}
*/
		int T=sc.nextInt();
		for (int t=1;t<=T;t++){
			int n=sc.nextInt();
			String ss="";
			System.out.println("Case #"+t+": "+ss);
			solve(n);
			


		}



		sc.close();



	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
