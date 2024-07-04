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
            int n = in.nextInt();
            int act[][] = new int[n][4];
            for(int i=0;i<n;i++){
                act[i][0] = in.nextInt();
                act[i][1] = in.nextInt();
                act[i][2] = i;
                act[i][3] = 0;
            }
            Arrays.sort(act, new Comparator<int[]>(){
                public int compare(int[] a,int[] b){
                    if(a[1]!=b[1]) return a[1]-b[1];
                    else if(a[0]!=b[0]) return a[0]-b[0];
                    return a[2]-b[2];
                }
            });
            int s1=0,s2=0,f=0;
            for(int i=0;i<n;i++){
                if(act[i][0]>=s1){
                    s1 = act[i][1];
                    act[i][3] = 1;
                }else if(act[i][0]>=s2){
                    s2 = act[i][1];
                    act[i][3] = 2;
                }else f=1;
            }
            if(f==1) {out.write("IMPOSSIBLE\n");continue;}
            else{
                for(int i=0;i<n;i++){
                    if(act[i][3]!=1 && act[i][3]!=2) f=1;
                }
                if(f==1) {out.write("IMPOSSIBLE\n");continue;}
                else{
                    Arrays.sort(act, new Comparator<int[]>(){
                        public int compare(int[] a,int[] b){
                            return a[2]-b[2];
                        }
                    });
                    for(int i=0;i<n;i++){
                        if(act[i][3]==1) out.write("C");
                        else out.write("J");
                    }
                    out.write("\n");
                }
            }
        }
    }
    /************* SOLUTION ENDS HERE **********/
}