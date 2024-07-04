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

		////log("hello");
		int T=sc.nextInt();
		int n=sc.nextInt();
		int CX=150;
		//log("T:"+T+" n:"+n);
		for (int t=1;t<=T;t++){

			
		
			int[][] ans=new int[n][CX];
			for (int i=0;i<n;i++)
				Arrays.fill(ans[i],-1);
			
			int[] typ=new int[n];
			
			
			
			// we do the same stuff
			int nseg=n/8;
			if (n%8!=0)
				nseg++;
			
			int u=0;
			int v=n-1;
		
			int[] ref=new int[2]; // ref for each type
			ref[0]=-1;
			ref[1]=-1;
			int[] rel=new int[n];
			int[] mem=new int[n];
			//log("nseg:"+nseg);
			for (int i=0;i<nseg;i++) {
				//log("============="+i);
				ArrayList<Integer>[] lst=new ArrayList[2];
				lst[0]=new ArrayList<Integer>();
				lst[1]=new ArrayList<Integer>();
				
				for (int e=0;e<4;e++) {
					int x=get(u);
					int y=get(v);
					mem[u]=x;
					mem[v]=y;
					int tp=0;
					if (x==y) {
						typ[u]=0;
						typ[v]=0;
					} else {
						typ[u]=1;
						typ[v]=1;
						tp=1;
					}
					lst[tp].add(u);
					if (ref[tp]==-1)
						ref[tp]=u;
					u++;
					v--;
					if (u>v) {
						u--;
						v++;
					}
				}
				//log("=======checking the reference points");
				int rd=0;
				for (int e=0;e<2;e++) {
					if (ref[e]!=-1) {
						rd++;
						int z=get(ref[e]);
						for (int uu:lst[e]) {
							if (mem[uu]==z) 
								rel[uu]=0;
							else
								rel[uu]=1;
							//log("uu:"+uu+" ref:"+ref[e]+" cur  val:"+mem[uu]+" ref val"+z+" rel:"+rel[uu]);
						}
					}
				}
			
				while (rd<2) {
					get(1);
					rd++;
				}
				//log("finishing");
			}
						
			// now we have read nseg*10
			// and every one is linked to ref[0] or ref[1]
			
			//log("last mile");
		
			int[] val=new int[n];
			
			for (int e=0;e<2;e++) {
				if (ref[e]!=-1) {
					val[ref[e]]=get(ref[e]);
				} 
			}
			
			for (int i=0;i<n/2;i++) {
				int tp=typ[i];
				int raoul=ref[tp];
				if (rel[tp]==0)
					val[i]=val[raoul];
				else
					val[i]=1-val[raoul];
				if (tp==0)
					val[n-1-i]=val[i];
				else
					val[n-1-i]=1-val[i];
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
