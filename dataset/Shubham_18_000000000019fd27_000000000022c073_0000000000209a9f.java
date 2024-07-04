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
            char s[] = in.next().trim().toCharArray();
            int n = s.length;
            StringBuilder str = new StringBuilder();
            int k = 0, u = 0;
            for(int i=0;i<n;i++){
                u = (int)(s[i]-'0');
                if(u>k){
                    for(int j=k;j<u;j++){
                        str.append("(");
                    }
                    str.append(s[i]);
                    if(i==n-1){
                        for(int j=u;j>0;j--){
                            str.append(")");
                        }
                    }
                }else if(u<k){
                    for(int j=k;j>u;j--){
                        str.append(")");
                    }
                    str.append(s[i]);
                    if(i==n-1){
                        for(int j=u;j>0;j--){
                            str.append(")");
                        }
                    }
                }else str.append(s[i]);
                k = u;
            }
            out.write(str.toString()+"\n");
        }
    }
    
    /************* SOLUTION ENDS HERE **********/
}