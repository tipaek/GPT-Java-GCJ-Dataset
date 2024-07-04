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
	static void output(Object o){System.out.println(""+o);System.out.flush();	}
	//static void outputWln(Object o){try {out.write(""+ o);} catch (Exception e) {}}


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


	static int get(int i) {
		output((i+1));
		return sc.nextInt();
	}
	
	static Scanner sc;

	
	
	static void process() throws Exception {
		Locale.setDefault(Locale.US);

		//test();
		
		
		sc=new Scanner(System.in);
		sc.useLocale(Locale.US);

		//log("hello");
		int T=sc.nextInt();
		int n=sc.nextInt();
		int CX=150;
		log("T:"+T+" n:"+n);
		for (int t=1;t<=T;t++){

			
		
			int[][] ans=new int[n][CX];
			for (int i=0;i<n;i++)
				Arrays.fill(ans[i],-1);
			
			int[] typ=new int[n];
			
			int time=0;
			// basic
			int[] val=new int[n];
			for (int i=0;i<n/2;i++) {
				int x=get(i);
				
				int y=get(n-1-i);
				val[i]=x;
				val[n-1-i]=y;
				if (x==y) {
					typ[i]=0;
					typ[n-1-i]=0;
				} else {
					typ[i]=1;
					typ[n-1-i]=1;
				}
				time+=2;
				ans[i][time]=x;
				ans[n-1-i][time]=y;
			}
			
			String rs="";
			for (int i=0;i<n;i++)
				rs+=val[i];
			
			output(rs);
			String judge=sc.next();
			if (judge.charAt(0)=='N') {
				sc.close();
				return;
			}

		}



		sc.close();



	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
