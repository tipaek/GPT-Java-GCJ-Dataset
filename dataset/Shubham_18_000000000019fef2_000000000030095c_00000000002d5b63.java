import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String []args) throws IOException {
    	FastScanner in  = new FastScanner(System.in);
    	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false);
    	solve(in, out);
    	in.close();
    	out.close();
    }
    static long gcd(long a, long b){ return (b==0) ? a : gcd(b, a%b); }
    static int gcd(int a, int b){ return (b==0) ? a : gcd(b, a%b); }
    private static int fact(int n) { int ans=1; for(int i=2;i<=n;i++) ans*=i; return ans; }
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
    
    private static void solve(FastScanner in, PrintWriter out){
        
        int T = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        outer:
        for(int t=0;t<T;t++) {
        	int m = (int)1e9;
            int p1[] = new int[] {-m/2, m/2, -m/2, m/2, 0};
            int p2[] = new int[] {-m/2, -m/2, m/2, m/2, 0};
            int mark[] = new int[5];
            for(int i=0;i<5;i++) {
            	System.out.println(p1[i]+" "+p2[i]);
//            	out.flush();
            	String s = in.next();
            	if(s.charAt(0)=='C') {
//        			out.println(p1[i]+" "+p2[i]);out.flush();
//        			String ss = in.next();
        			continue outer;
        		}
            	if(s.charAt(0)=='H') mark[i]=1;
            }
//            out.println("Mark: ");
//            for(int i:mark) out.println(i);
            int ans[] = new int[4];
            int ind=0;
            for(int i=0;i<5;i++) if(mark[i]==1) ind=i;
            
            int up = 1000000000;
        	int down = 0;
        	while(up>down) { // 1..
        		int mid = (up+down+1)/2;
        		System.out.println(p1[ind]+" "+mid);
//        		out.flush();
        		String tmp = in.next();
        		if(tmp.charAt(0)=='C') {
//        			out.println(p1[ind]+" "+mid);out.flush();
//        			String ss = in.next();
        			continue outer;
        		}
        		if(tmp.charAt(0)=='H') down = mid;
        		else up = mid-1;
        	}
        	ans[0]=up;
        	up = 0;
        	down = -1000000000;
        	while(up>down) { // 2..
        		int mid = (up+down-1)/2;
        		System.out.println(p1[ind]+" "+mid);
//        		out.flush();
        		String tmp = in.next();
        		if(tmp.charAt(0)=='C') {
//        			out.println(p1[ind]+" "+mid);out.flush();
//        			String ss = in.next();
        			continue outer;
        		}
        		if(tmp.charAt(0)=='H') up = mid;
        		else down = mid+1;
        	}
        	ans[1]=up;
        	up = 1000000000;
        	down = 0;
        	while(up>down) { // 3.. 
        		int mid = (up+down+1)/2;
        		System.out.println(mid+" "+p2[ind]);
//        		out.flush();
        		String tmp = in.next();
        		if(tmp.charAt(0)=='C') {
//        			out.println(p1[ind]+" "+mid);out.flush();
//        			String ss = in.next();
        			continue outer;
        		}
        		if(tmp.charAt(0)=='H') down = mid;
        		else up = mid-1;
        	}
        	ans[2]=up;
        	up = 0;
        	down = -1000000000;
        	while(up>down) { // 4..
        		int mid = (up+down-1)/2;
        		System.out.println(mid+" "+p2[ind]);
//        		out.flush();
        		String tmp = in.next();
        		if(tmp.charAt(0)=='C') {
//        			out.println(p1[ind]+" "+mid);out.flush();
//        			String ss = in.next();
        			continue outer;
        		}
        		if(tmp.charAt(0)=='H') up = mid;
        		else down = mid+1;
        	}
        	ans[3]=up;
        	ans[0]=(ans[0]+ans[1])/2;
        	ans[1]=(ans[2]+ans[3])/2;
        	System.out.println(ans[0]+" "+ans[1]);
        	if(in.next().charAt(0)!='C') System.exit(0);
        }
    }
    
    /************* SOLUTION ENDS HERE **********/
}