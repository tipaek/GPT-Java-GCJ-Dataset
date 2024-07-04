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
	
	static String solve(String[] pat) {

		int n=pat.length;
		String left="";
		String right="";
		String core="";
		
		for (int i=0;i<n;i++) {
			int L=pat[i].length();
			log("L:"+L);
			int leftu=0;
			int rightu=L-1;
			if (pat[i].charAt(0)!='*') {
				log("case 1");
				int u=0;
				while (u<L && pat[i].charAt(u)!='*')
					u++;
				String sub=pat[i].substring(0,u);
				int LL=Math.min(sub.length(),left.length());
				if (!sub.substring(0,LL).contentEquals(left.substring(0,LL))) {
					log("issue sub:"+sub+" left:"+left);
					return "*";
				}
				if (sub.length()>left.length())
					left=sub;
				
				leftu=u;
				
			}
			if (pat[i].charAt(L-1)!='*') {
				log("case 2");
				int u=L-1;
				while (u>=0 && pat[i].charAt(u)!='*')
					u--;
				rightu=u;
				String sub=pat[i].substring(u+1,L);
				log("sub:"+sub);
				int LL=Math.min(sub.length(),right.length());
				if (!sub.substring(sub.length()-LL,sub.length()).contentEquals(right.substring(right.length()-LL,right.length()))) {
					log("issue sub:"+sub+" right:"+right);
					log(sub.substring(sub.length()-LL,sub.length()));
					log(right.substring(right.length()-LL,right.length()));
					
					return "*";
				}
				if (sub.length()>right.length())
					right=sub;
			}
			
			if (leftu<=rightu) {
				for (int e=leftu;e<=rightu;e++)
					if (pat[i].charAt(e)!='*')
						core+=pat[i].charAt(e);
			}
			
		}
		return left+core+right;
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
			String[] pat=new String[n];
			for (int i=0;i<n;i++)
				pat[i]=sc.next();
			
			
			
			
			String ss="";
			
			ss+=solve(pat);

			System.out.println("Case #"+t+": "+ss);
			//log("Case #"+t+": "+ss);


		}



		sc.close();
	


	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
