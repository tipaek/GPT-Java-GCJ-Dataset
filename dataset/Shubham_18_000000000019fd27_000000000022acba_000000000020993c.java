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
        for(int t = 1; t <= T; t++)
        {
            out.write("Case #"+t+": ");
            int k = 0,r = 0,c = 0;
            int n = in.nextInt();
            int a[][] = new int[n][n];
            boolean row[][] = new boolean[n+1][n+1];
            boolean col[][] = new boolean[n+1][n+1];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j] = in.nextInt();
                    if(row[i][a[i][j]]) {row[i][0] = true;}
                    if(col[a[i][j]][j]) {col[0][j] = true;}
                    row[i][a[i][j]] = true;
                    col[a[i][j]][j] = true;
                }
                k += a[i][i];
            }
            for(int i=0;i<n;i++){
                if(row[i][0]) r++;
                if(col[0][i]) c++;
            }
            out.write(k+" "+r+" "+c+"\n");
        }
    }
    
    /************* SOLUTION ENDS HERE **********/
}