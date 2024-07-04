import java.util.*;import java.io.*;import java.math.*;
public class Solution
{
    static class Node{
        int x;
        int y;
        int ind;
        Node(int x,int y,int ind){
            this.x=x;
            this.y=y;
            this.ind=ind;
        }
    }

    public static class CustomSort implements Comparator<Node>{
        public int compare(Node a,Node b){
            if(a.x!=b.x)
                return (a.x-b.x);
            else
                return (a.y-b.y);
        }
    }
    public static void process(int tt)throws IOException
    {
        int n=ni();
        char[]ans=new char[n];
        Node[]A=new Node[n];
        for(int i=0;i<n;i++)
            A[i]=new Node(ni(),ni(),i);
        Arrays.sort(A,new CustomSort());
        int cc=-1,jj=-1;
        for(int i=0;i<n;i++)
        {
            if(A[i].x>=cc)
            {
                ans[A[i].ind]='C';
                cc=A[i].y;
            }
            else if(A[i].x>=jj)
            {
                ans[A[i].ind]='J';
                jj=A[i].y;
            }
            else
            {
                pn("Case #"+tt+": IMPOSSIBLE");
                return;
            }
        }
        p("Case #"+tt+": ");
        for(int i=0;i<n;i++)
            p(ans[i]);
        pn("");
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