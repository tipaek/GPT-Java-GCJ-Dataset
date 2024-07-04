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
			int a=r.nextInt(20)+1;
			int b=r.nextInt(20)+1;
			int c=r.nextInt(20)+1;
			int n=a+b+c;
			int st=0;
			int[] tm=new int[n];
			for (int i=0;i<a;i++)
				tm[st++]=1;
			for (int i=0;i<b;i++)
				tm[st++]=2;
			for (int i=0;i<c;i++)
				tm[st++]=3;
			boolean bob=generate(tm);
			if (!bob) {
				logWln("Error with ");
				log(tm);
				log("trying alternate");
				boolean ok=false;
				loop:for (int e=0;e<10;e++) {
					for (int i=0;i<n;i++)
						for (int j=i+1;j<n;j++) {
							if (tm[i]!=tm[j]) {
								int x=tm[i];
								tm[i]=tm[j];
								tm[j]=x;
								bob=generate(tm);
								if (bob) {
									log("cool !!!");
									ok=true;
									break loop;
								}

							}
						}
				}
				if (!ok) {
					log("unable to recover");
					return;
				}
			}


		}
		log("done");
		return;
	}


	static class Composite implements Comparable<Composite>{

		int v; 
		int idx;

		public int compareTo(Composite X) {
			if (v!=X.v)
				return -(v-X.v);
			return idx-X.idx;
		}

		public Composite(int v,int idx) {
			this.v = v;
			this.idx = idx;
		}

		public String toString() {
			return "("+v+" "+idx+")";
		}

	}

	static boolean isOk(int[] a,int K) {
		int n=a.length;
		int[] cnt=new int[n];
		int sum=0;
		for (int i=0;i<n;i++) {
			if (a[i]<=0)
				return false;
			if (a[i]>n)
				return false;
			cnt[a[i]-1]++;
			sum+=a[i];
		}
		if (sum!=K)
			return false;
		for (int i=0;i<n;i++)
			if (cnt[i]==n-1)
				return false;

		return true;

	}

	static String check2(int E,int F) {
		log("check 2");
		String rs="";
		for (int n=E;n<F;n++) {
			int[][] dp=new int[n*n+1][n+1];

			dp[0][0]=1;
			//log("step 1");
			for (int x=1;x<=n;x++) {
				int[][] nxt=new int[n*n+1][n+1];
				//log("---------------");
				for (int nb=n;nb>=0;nb--) {
					if (nb!=n-1) {
						int max=n*n-nb*x;
						//log("update x:"+x+" nb:"+nb);
						for (int y=max;y>=0;y--)

							for (int e=n-nb;e>=0;e--) {
								if (dp[y][e]==1) {
									nxt[y+x*nb][e+nb]=1;
									//log("ok for :"+(y+nb*x)+":"+(e+nb));
								}
							}
					}
				}
				dp=nxt;
			}
			for (int k=n;k<=n*n;k++) {
				//log("k:"+k+" //"+dp[k][n]);
				if (dp[k][n]!=1) {
					rs+=n+" "+k+" ";
					//log("impossible :  "+n+" "+k);
				}
			}
		}
		//
		log("check 2 done");
		return rs;
	}
	static String check(int E,int F) {

		String rs="";
		for (int n=E;n<F;n++) {
			for (int k=n;k<=n*n;k++) {
				int ref=k/n;
				int rem=k%n;
				int[] ans=new int[n];
				if (rem!=1 && rem!=n-1) {
					// we can do rem and n-rem
					int st=0;
					for (int i=0;i<rem;i++) {
						ans[st++]=ref+1;
					}
					for (int i=rem;i<n;i++) {
						ans[st++]=ref;
					}
					if (!isOk(ans,k)) {

						log("Error case 1");
						log(n+" "+k);
						log(ans);
						return "KO";
					}
				} else {
					// rem==1
					if (rem==1) {
						if (ref==1) {
							//log("impossible : "+n+" "+k);
							rs+=n+" "+k+" ";
						} else {
							// possible with (ref) n-3 times, ref-1,ref+1,ref+1
							int st=0; 
							for (int i=0;i<n-3;i++) {
								ans[st++]=ref;
							}
							ans[st++]=ref-1;
							ans[st++]=ref+1;
							ans[st++]=ref+1;
							if (!isOk(ans,k)) {
								log("Error case 2");
								log(n+" "+k);
								log(ans);

								return "KO";
							}
						}
					} 
					if (rem==n-1) {
						if (ref==n-1) {
							//log("impossible : "+n+" "+k);
							rs+=n+" "+k+" ";
						} else {

							// can do with (ref+1) n-3, ref 2, ref+2 1
							int st=0; 
							for (int i=0;i<n-3;i++) {
								ans[st++]=ref+1;
							}
							ans[st++]=ref;
							ans[st++]=ref;

							ans[st++]=ref+2;
							if (!isOk(ans,k)) {
								log("Error case 3 // ref:"+ref+" rem:"+rem);
								log(n+" "+k);
								log(ans);
								return "KO";
							}
						}
					}

				}
			}
		}
		return rs;
	}




	static int[][] znx;

	static boolean generate(int[] tm) {
		//logWln("try to generate for:");
		//log(tm);
		
		int n=tm.length;
		boolean same=true;
		for (int i=1;i<n;i++) {
			if (tm[i]!=tm[0])
				same=false;
		}
		int[][] mat=new int[n][n];
		znx=mat;
		
		if (same) {
			for (int i=0;i<n;i++) {
				mat[i][i]=tm[i];
				for (int e=1;e<n;e++) {
					mat[(i+e)%n][i]=(tm[i]-1+e)%n+1;
				}
			}
			return true;
			
			
		}
		
		long[] g_rmask=new long[n];
		long[] g_cmask=new long[n];
		long[] rmask=new long[n];
		long[] cmask=new long[n];
		
		int[] cnt=new int[n];
		
		for (int i=0;i<n;i++) {
			int x=tm[i]-1;
			mat[i][i]=tm[i];
			long msk=1L<<i;
			
			g_rmask[i]|=msk;
			g_cmask[i]|=msk;
			rmask[x]|=msk;
			cmask[x]|=msk;
			cnt[x]++;
		}

		Composite[] ar=new Composite[n];
		for (int u=0;u<n;u++) {
			ar[u]=new Composite(cnt[u],u);
		}
		Arrays.sort(ar);
		for (Composite X:ar) {
			int u=X.idx;
			//log("processing:"+u);

			while (cnt[u]<n) {
				int min=n;
				ArrayList<Integer> lst=new ArrayList<Integer>();
				for (int i=0;i<n;i++) {
					long msk=1L<<i;
					long intersect=cmask[u]&msk;
					if (intersect==0) {
						int av=n-Long.bitCount(g_rmask[i]|rmask[u]);
						if (av<min) {
							min=av;
							lst=new ArrayList<Integer>();
						}
						if (min==av)
							lst.add(i);
						//log("i:"+i+" av:"+av);
					}
				}
				//log("--------- u:"+u+" cnt[u]:"+cnt[u]+" min:"+min);
				if (lst.size()==0 ||min==0) {
					//log("failed for u:"+u+" cnt:"+cnt[u]);
					//for (int i=0;i<n;i++)
					//	log(mat[i]);
					return false;
				}
				boolean ok=false;

				min=n;
				ArrayList<int[]> nxt=new ArrayList<int[]>();
				for (int i:lst) {

					for (int j=0;j<n;j++) {
						long msk=1L<<j;
						long intersect=rmask[u]&msk;
						if (mat[i][j]==0 && intersect==0) {
							// available slot
							// but how much is lower ?
							int av=n-Long.bitCount(g_cmask[j]|cmask[u]);
							if (av<min) {
								min=av;
								nxt=new ArrayList<int[]>();
							}
							if (av==min) {
								nxt=new ArrayList<int[]>();
								nxt.add(new int[] {i,j});

							}
						}
					}
				}
				if (nxt.size()==0) {
					//log("bug");
					return false;
				}
				int max=-1;
				int tgi=-1;
				int tgj=-1;
				int[] tgt=null;
				for (int[] cand:nxt) {
					int ti=cand[0];
					int tj=cand[1];
					int avi=n-Long.bitCount(g_rmask[ti])-1;
					int avj=n-Long.bitCount(g_cmask[tj])-1;
					int av=Math.min(avi,avj);
					if (av>max) {
						max=av;
						tgi=ti;
						tgj=tj;
					}

				}


				mat[tgi][tgj]=u+1;
				rmask[u]|=1L<<tgj;
				cmask[u]|=1L<<tgi;
				g_rmask[tgi]|=1L<<tgj;
				g_cmask[tgj]|=1L<<tgi;

				cnt[u]++;
				//log("found target:"+tgi+" "+tgj+" for  u:"+u);
				ok=true;


			}
		}

		HashSet<Integer>[] column=new HashSet[n];
		HashSet<Integer>[] row=new HashSet[n];
		for (int i=0;i<n;i++) {
			column[i]=new HashSet<Integer>();
			row[i]=new HashSet<Integer>();

		}

		int sum=0;
		for (int i=0;i<n;i++)
			for (int j=0;j<n;j++) {
				int x=mat[i][j];
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
		if (rko>0 ||cko>0) {
			log("error");
			return false;
		}
		//for (int i=0;i<n;i++)
		//	log(mat[i]);

		znx=mat;

		//log("=========== all good");
		return true;
	}


	static String generateString(int[] tm) {
	
		
		int n=tm.length;
		//logWln("generating for n:"+n);
		//log(tm);
		Random r=new Random(0);
		boolean b=generate(tm);
		//log("initial b:"+b);
		
		int iter=0;
		while (!b && iter<10) {
			int i=r.nextInt(n);
			int j=r.nextInt(n);

			if (tm[i]!=tm[j]) {
				iter++;
				int x=tm[i];
				tm[i]=tm[j];
				tm[j]=x;
				b=generate(tm);
			}
		}
		if (!b) 
			return IMPOSSIBLE;

		String ss="POSSIBLE\n";
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) 
				ss+=znx[i][j]+" ";
			ss+="\n";
		}
		return ss;
	}

	static String IMPOSSIBLE="IMPOSSIBLE";
	
	static String solveSubtil(int n,int K) {
	
		String ss=IMPOSSIBLE;
		if (K==n*n-1) {
			return ss;
		}
		if (n==2) {
			if (K%2!=0)
				return ss;
			return generateString(new int[] {K/2,K/2});
		}
		if (n==3) {
			if (K%3!=0)
				return ss;
			return generateString(new int[] {K/3,K/3,K/3});
		}




		int ref=K/n;
		int rem=K%n;
		int[] ans=new int[n];
		if (rem!=1 && rem!=n-1) {
			// we can do rem and n-rem
			int st=0;
			for (int i=0;i<rem;i++) {
				ans[st++]=ref+1;
			}
			for (int i=rem;i<n;i++) {
				ans[st++]=ref;
			}
		} else {
			// rem==1
			if (rem==1) {
				if (ref==1) {
					//log("impossible : "+n+" "+k);
					return ss;
				} else {
					// possible with (ref) n-3 times, ref-1,ref+1,ref+1
					int st=0; 
					for (int i=0;i<n-3;i++) {
						ans[st++]=ref;
					}
					ans[st++]=ref-1;
					ans[st++]=ref+1;
					ans[st++]=ref+1;

				}
			} 
			if (rem==n-1) {
				if (ref==n-1) {
					//log("impossible : "+n+" "+k);
					return ss;
				} else {

					// can do with (ref+1) n-3, ref 2, ref+2 1
					int st=0; 
					for (int i=0;i<n-3;i++) {
						ans[st++]=ref+1;
					}
					ans[st++]=ref;
					ans[st++]=ref;

					ans[st++]=ref+2;

				}
			}

		}
		return generateString(ans);
	}


	



	static void check() {
		log("checking");
		for (int n=33;n<50;n++) {
			log("n:====="+n);
			for (int k=n;k<=n*n;k++) {
				//log("k:"+k);
				String s=solveSubtil(n,k);
				if (s==IMPOSSIBLE){
					log("failed for "+n+" "+k);
					if (n>3 && k!=n+1  && k!=n*n-1) {
						log("This is weired");
						return;
					}
				}
			}
		}
		log("done");
	}

	// Global vars
	static BufferedWriter out;



	static void process() throws Exception {
		Locale.setDefault(Locale.US);

		//test();
		
		
		//check();

		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);


		/*
		log(check2(2,4));
		String a=check(4,30);
		String b=check2(4,30);
		if (!a.contentEquals(b)) {
			log("error");
			log(a);
			log(b);
		} else {
			log("ok");
		}
		 */
		//check2();
		//test();
		//check();



		int T=sc.nextInt();
		for (int t=1;t<=T;t++){

			int n=sc.nextInt();
			int K=sc.nextInt();
			String ss=solveSubtil(n,K);




			//String ss="";
			System.out.println("Case #"+t+": "+ss);
			//log("Case #"+t+": "+ss);


		}



		sc.close();



	}



	public static void main(String[] args) throws Exception {


		process();


	}






}
