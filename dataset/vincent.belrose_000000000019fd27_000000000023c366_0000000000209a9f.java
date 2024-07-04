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

			
			String s=sc.next();
			int L=s.length();
			int cur=0;
			String ans="";
			for (int i=0;i<L;i++) {
				int x=s.charAt(i)-'0';
				if (x<cur) {
					for (int j=x;j<cur;j++)
						ans+=")";
					
				} else if (x>cur) {
					for (int j=cur;j<x;j++)
						ans+="(";
				}
				cur=x;
				ans+=x;
			}
			while (cur>0) {
				ans+=')';
				cur--;
			}
			

			String ss="";
			ss=ans;
			System.out.println("Case #"+t+": "+ss);
			//log("Case #"+t+": "+ss);


		}



		sc.close();
	


	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
