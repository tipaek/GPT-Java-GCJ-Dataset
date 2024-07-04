import java.util.*;import java.io.*;import java.math.*;
public class Solution
{
    public static void process(int cas)throws IOException
    {
        int n=ni();
        int d=ni();
        long[]A=nal(n);
        Arrays.sort(A);
        if(d==2)
        {
            for(int i=0;i<n-1;i++)
                if(A[i]==A[i+1])
                {
                    pn("Case #"+cas+": 0");
                    return;
                }
            pn("Case #"+cas+": 1");
        }
        else
        {
            for(int i=0;i<n-2;i++)
                if(A[i]==A[i+1] && A[i]==A[i+2])
                {
                    pn("Case #"+cas+": 0");
                    return;
                }
            if(n>2)
            {
                for(int i=0;i<n-2;i++)
                if(A[i]==A[i+1])
                {
                    pn("Case #"+cas+": 1");
                    return;
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(A[i]*2==A[j])
                    {
                        pn("Case #"+cas+": 1");
                        return;
                    }
                }
            }
            pn("Case #"+cas+": 2");

        }
    }

    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        boolean oj = true;
        if(oj){sc=new AnotherReader();out=new PrintWriter(System.out);}
        else{sc=new AnotherReader(100);out=new PrintWriter("output.txt");}
        int t=1;
        t=ni();
        for(int i=1;i<=t;i++) {process(i);}
        out.flush();out.close();  
    }

    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static int[] nai(int N)throws IOException{int[]A=new int[N];for(int i=0;i!=N;i++){A[i]=ni();}return A;}
    static long[] nal(int N)throws IOException{long[]A=new long[N];for(int i=0;i!=N;i++){A[i]=nl();}return A;}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}

/////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class AnotherReader{BufferedReader br; StringTokenizer st;
    AnotherReader()throws FileNotFoundException{
    br=new BufferedReader(new InputStreamReader(System.in));}
    AnotherReader(int a)throws FileNotFoundException{
    br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}}
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}