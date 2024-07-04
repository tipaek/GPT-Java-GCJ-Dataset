/*****Author: Satyajeet Singh, Delhi Technological University************************************/
    import java.io.*;
    import java.util.*;
    import java.text.*; 
    import java.lang.*;
    import java.math.*;
public class Solution{
/*********************************************Constants******************************************/
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));        
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long mod=(long)1e9+7;
    static long mod1=998244353;
    static ArrayList<Integer> graph[];
    static int pptr=0,pptrmax=0;
    static String st[];
/*****************************************Solutions Begins***************************************/
    static char posx[]={'E','W'};
    static char posy[]={'N','S'};

    static String make(long x,long y){
        long x1=Math.abs(x);
        long y1=Math.abs(y);
        int f1=0;
        int f2=0;
        if(x<0)
            f1=1;
        if(y<0)
            f2=1;
        String xx=Long.toBinaryString(x1);
        String yy=Long.toBinaryString(y1);
        char op[]=new char[Math.max(xx.length(),yy.length())];
        Arrays.fill(op,'#');

        for(int i=0;i<xx.length();i++){
            if(xx.charAt(i)=='1'){
                op[xx.length()-1-i]=posx[f1];
            }
        }
        xx=yy;
        for(int i=0;i<xx.length();i++){
            if(xx.charAt(i)=='1'){
                op[xx.length()-1-i]=posy[f2];
            }
        }  
        for(int i=0;i<op.length;i++){
            if(op[i]=='#')
                return "IMPOSSIBLE";
        }
        return new String(op);      
    }
    public static void main(String args[]) throws Exception{
        int tt=pi();
        for(int ii=1;ii<=tt;ii++){
            long x=pl();
            long y=pl();
            
            long x1=Math.abs(x);
            long y1=Math.abs(y);

            String xx=Long.toBinaryString(x1);
            
            long mx=(1l<<xx.length());
            long a1=x1&y1;
            String ans="IMPOSSIBLE";
            ans=make(x,y);    
            if(a1==0&&!ans.equals("IMPOSSIBLE")){
                ;
            }
            else{
                ans="IMPOSSIBLE";
                
                if(x1>y1){
                    long nm=(mx-x1);
                    long a2=nm&y1;
                    if(a2==0){
                        if(x<0)
                            ans=make(nm,y)+'W';
                        else
                            ans=make(-nm,y)+'E';
                    }
                }
                else{
                    long nm=(mx-y1);
                    long a2=nm&x1;
                    if(a2==0){
                        if(y<0)
                            ans=make(x,nm)+'S';
                        else
                            ans=make(x,-nm)+'N';
                    }
                }
            }
            if(ans.charAt(0)=='I')
                ans="IMPOSSIBLE";
            out.println("Case #"+ii+": "+ans);
        }
/****************************************Solutions Ends**************************************************/
        out.flush();
        out.close();
    }
/****************************************Template Begins************************************************/
    static void nl() throws Exception{
        pptr=0;
        st=br.readLine().split(" ");
        pptrmax=st.length;
    }
    static void nls() throws Exception{
        pptr=0;
        st=br.readLine().split("");
        pptrmax=st.length;
    }
    static int pi() throws Exception{
        if(pptr==pptrmax)
            nl();
        return Integer.parseInt(st[pptr++]);
    }
    static long pl() throws Exception{
        if(pptr==pptrmax)
            nl();
        return Long.parseLong(st[pptr++]);
    }
    static double pd() throws Exception{
        if(pptr==pptrmax)
            nl();
        return Double.parseDouble(st[pptr++]);
    }
    static String ps() throws Exception{
        if(pptr==pptrmax)
            nl();
        return st[pptr++];
    }
/***************************************Precision Printing**********************************************/
    static void printPrecision(double d){
        DecimalFormat ft = new DecimalFormat("0.000000000000"); 
        out.print(ft.format(d));
    }
/**************************************Bit Manipulation**************************************************/
    static void printMask(long mask){
        System.out.println(Long.toBinaryString(mask));
    }
    static int countBit(long mask){
        int ans=0;
        while(mask!=0){
            mask&=(mask-1);
            ans++;
        }
        return ans;
    }
/******************************************Graph*********************************************************/
    static void Makegraph(int n){
        graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
    }
    static void addEdge(int a,int b){
        graph[a].add(b);
    }
    // static void addEdge(int a,int b,int c){
    //     graph[a].add(new Pair(b,c));
    // }    
/*********************************************PAIR********************************************************/
    static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int index=-1;
        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
        public int hashCode() {
            int hu = (int) (u ^ (u >>> 32));
            int hv = (int) (v ^ (v >>> 32));
            return 31 * hu + hv;
        }
        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return u == other.u && v == other.v;
        }
        public int compareTo(Pair other) {
            if(index!=other.index)
                return Long.compare(index, other.index);
            return Long.compare(v, other.v)!=0?Long.compare(v, other.v):Long.compare(u, other.u);
        }
        public String toString() {
            return "[u=" + u + ", v=" + v + "]";
        }
    }
/******************************************Long Pair*******************************************************/
    static class Pairl implements Comparable<Pairl> {
            int u;
            long v;
            int index=-1;
            public Pairl(int u, long v) {
                this.u = u;
                this.v = v;
            }
            public int hashCode() {
                int hu = (int) (u ^ (u >>> 32));
                int hv = (int) (v ^ (v >>> 32));
                return 31 * hu + hv;
            }
            public boolean equals(Object o) {
                Pairl other = (Pairl) o;
                return u == other.u && v == other.v;
            }
            public int compareTo(Pairl other) {
                if(index!=other.index)
                    return Long.compare(index, other.index);
                return Long.compare(v, other.v)!=0?Long.compare(v, other.v):Long.compare(u, other.u);
            }
            public String toString() {
                return "[u=" + u + ", v=" + v + "]";
            }
        }
/*****************************************DEBUG***********************************************************/
    public static void debug(Object... o){
        System.out.println(Arrays.deepToString(o));
    }
/************************************MODULAR EXPONENTIATION***********************************************/
    static long modulo(long a,long b,long c){
        long x=1;
        long y=a%c;
        while(b > 0){
            if(b%2 == 1)
                x=(x*y)%c;
            y = (y*y)%c;
            b /= 2;
        }
        return  x%c;
    }
/********************************************GCD**********************************************************/
    static long gcd(long x, long y){
        if(x==0)
            return y;
        if(y==0)
            return x;
        long r=0, a, b;
        a = (x > y) ? x : y; 
        b = (x < y) ? x : y;
        r = b;
        while(a % b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }
/********************************************End***********************************************************/
}