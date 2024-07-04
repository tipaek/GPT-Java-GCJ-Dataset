import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String []args) throws IOException {
    	FastScanner in  = new FastScanner(System.in);
    	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false);
    	solve(in, out);
    	in.close();
    	out.close();
    }
    static long gcd(long a, long b){ return (b==0) ? a : gcd(b, a%b); }
    static int gcd(int a, int b){ return (b==0) ? a : gcd(b, a%b); }
    public static int[] generatePrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, 2, n + 1, true);
		for (int i = 2; i * i <= n; i++)
			if (prime[i])
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
		int[] primes = new int[n + 1];
		int cnt = 0;
		for (int i = 0; i < prime.length; i++)
			if (prime[i])
				primes[cnt++] = i;
		return Arrays.copyOf(primes, cnt);
	}
    static class FastScanner{
	BufferedReader reader;
	StringTokenizer st;
	FastScanner(InputStream stream){reader=new BufferedReader(new InputStreamReader(stream));st=null;}
	String next(){while(st == null || !st.hasMoreTokens()){try{String line = reader.readLine();if(line == null){return null;}
	     st = new StringTokenizer(line);}catch (Exception e){throw new RuntimeException();}}return st.nextToken();}
	String nextLine()  {String s=null;try{s=reader.readLine();}catch(IOException e){e.printStackTrace();}return s;}
	int    nextInt()   {return Integer.parseInt(next());}
	long   nextLong()  {return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
	char   nextChar()  {return next().charAt(0);}
	int[]  nextIntArray(int n)         {int[] arr= new int[n];   int i=0;while(i<n){arr[i++]=nextInt();}  return arr;}
	long[] nextLongArray(int n)        {long[]arr= new long[n];  int i=0;while(i<n){arr[i++]=nextLong();} return arr;}
	int[]  nextIntArrayOneBased(int n) {int[] arr= new int[n+1]; int i=1;while(i<=n){arr[i++]=nextInt();} return arr;}
	long[] nextLongArrayOneBased(int n){long[]arr= new long[n+1];int i=1;while(i<=n){arr[i++]=nextLong();}return arr;}
	void   close(){try{reader.close();}catch(IOException e){e.printStackTrace();}}
    }
    
    /********* SOLUTION STARTS HERE ************/
    static ArrayList<Integer> g[],wt[];
    static int ans[], anss[];
    static boolean vis[];
    static int add;
    
    private static void solve(FastScanner in, PrintWriter out){
        int u,v;
        int T = in.nextInt();
        for(int t = 1; t <= T; t++)
        {
        	int c = in.nextInt();
        	int d = in.nextInt();
        	out.print("Case #"+t+": ");
        	int a[] = new int[c];
        	ans = new int[c];
        	ans[0]=1;
        	for(int i=0;i<c-1;i++){
        	    a[i] = in.nextInt();
        	    ans[i+1] = 1-a[i];
        	}
        	edge edges[] = new edge[d];
        	for(int i=0;i<d;i++){
        	    u = in.nextInt()-1;
        	    v = in.nextInt()-1;
        	    edges[i] = new edge(u,v);
        	}
        	int mn = 100000000;
        	for(edge i: edges){
        	    i.wt = ans[i.des] - ans[i.src];
        	    if(i.src!=0 && i.des!=0){
        	        mn = Math.min(mn, i.wt);
        	        i.wt += 1;
        	    }else{
        	        mn = Math.min(mn, i.wt);
        	    }
        	    
        	}
        	if(mn<0){
        	    for(edge i: edges){
            	    i.wt += 1-mn;
            	    if(i.src!=0 && i.des!=0){
            	        i.wt-=1;
            	    }
            	}
        	}
        	for(edge i: edges){
        	    out.print(i.wt+" ");
        	}out.println();
        }
    }
    static class edge{
    	int src,des,wt;
    	edge(int s, int d){
			src = s;
    		des = d;
    	}
    }
    /************* SOLUTION ENDS HERE **********/
}