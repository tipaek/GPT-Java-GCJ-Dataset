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
			HashSet<Integer>[] column=new HashSet[n];
			HashSet<Integer>[] row=new HashSet[n];
			for (int i=0;i<n;i++) {
				column[i]=new HashSet<Integer>();
				row[i]=new HashSet<Integer>();
				
			}
			
			int sum=0;
			for (int i=0;i<n;i++)
				for (int j=0;j<n;j++) {
					int x=sc.nextInt();
					row[i].add(x);
					column[j].add(x);
					if (i==j)
						sum+=x;
				}
			
			
			int rko=0;
			int cko=0;
			for (int i=0;i<n;i++) {
				if (row[i].size()<n)
					rko++;
				if (column[i].size()<n)
					cko++;
			}
			
			String ss="";
			ss+=sum+" "+rko+" "+cko;


			System.out.println("Case #"+t+": "+ss);
			//log("Case #"+t+": "+ss);


		}



		sc.close();
	


	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
