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

	

	// Global vars
	static BufferedWriter out;



	static void process() throws Exception {
		Locale.setDefault(Locale.US);



		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);

		//test();


		

		int T=sc.nextInt();
		for (int t=1;t<=T;t++){

			int R=sc.nextInt();
			int C=sc.nextInt();
			
			int[][] map=new int[R][C];
			for (int i=0;i<R;i++)
				for (int j=0;j<C;j++)
					map[i][j]=sc.nextInt();
			
			boolean goon=true;
			long ans=0;
			while (goon) {
				goon=false;
				int[][] nxt=new int[R][C];
				for (int i=0;i<R;i++)
					for (int j=0;j<C;j++) {
						if (map[i][j]!=0) {
							ans+=map[i][j];
							int nb=0;
							int av=0;
							int nj=j+1;
							while (nj<C && map[i][nj]==0)
								nj++;
							if (nj<C) {
								nb++;
								av+=map[i][nj];
							}
							nj=j-1;
							while (nj>=0 && map[i][nj]==0)
								nj--;
							if (nj>=0) {
								nb++;
								av+=map[i][nj];
							}
							int ni=i+1;
							while (ni<R && map[ni][j]==0)
								ni++;
							if (ni<R) {
								nb++;
								av+=map[ni][j];
							}
							ni=i-1;
							while (ni>=0 && map[ni][j]==0)
								ni--;
							if (ni>=0) {
								nb++;
								av+=map[ni][j];
							}
							if (nb*map[i][j]<av) {
								nxt[i][j]=0;
								goon=true;
								
							} else
								nxt[i][j]=map[i][j];
							
						}
					}
				map=nxt;
			}
			
			
			

			String ss="";
			ss+=ans;
			System.out.println("Case #"+t+": "+ss);
		


		}



		sc.close();



	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
