/*Author: Satyajeet Singh, Delhi Technological University*/
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
    static boolean sieve[];
    static ArrayList<Integer> primes;
    static long factorial[],invFactorial[];
    static ArrayList<Pair> graph[];
    static int pptr=0;
    static String st[];
/****************************************Solutions Begins***************************************/
    public static void main(String[] args) throws Exception{
        nl();
        int t=pi();
        for(int tc=1;tc<=t;tc++){
            nls();
            int n=st.length;
            int s=0;
            ArrayList<Character> ls=new ArrayList<>();
            for(int i=0;i<n;i++){
                int a=pi();
                char ch=(char)('0'+a);
                while(s<a){
                    ls.add('(');
                    s++;
                }
                while(s>a){
                    ls.add(')');
                    s--;
                }
                ls.add(ch);
            }
                while(s>0){
                    ls.add(')');
                    s--;
                }
            char output[]=new char[ls.size()];
            for(int i=0;i<ls.size();i++){
                output[i]=ls.get(i);
            }            
            String op=new String(output);
            out.println("Case #"+tc+": "+op);
        }       
/****************************************Solutions Ends**************************************************/
        out.flush();
        out.close();
    }
/****************************************Template Begins************************************************/
    static void nl() throws Exception{
        pptr=0;
        st=br.readLine().split(" ");
    }
    static void nls() throws Exception{
        pptr=0;
        st=br.readLine().split("");
    }
    static int pi(){
        return Integer.parseInt(st[pptr++]);
    }
    static long pl(){
        return Long.parseLong(st[pptr++]);
    }
    static double pd(){
        return Double.parseDouble(st[pptr++]);
    }
    static String ps(){
        return st[pptr++];
    }
/***************************************Precision Printing**********************************************/
    static void printPrecision(double d){
        DecimalFormat ft = new DecimalFormat("0.000000000000000000000"); 
        out.print(ft.format(d));
    }
/**************************************Bit Manipulation**************************************************/
    static void printMask(long mask){
        System.out.println(Long.toBinaryString(mask));
    }
    static long countBit(long mask){
        long ans=0;
        while(mask!=0){
            if(mask%2==1){
                ans++;
            }
            mask/=2;
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
        graph[a].add(new Pair(b,1));
    }
    static void addEdge(int a,int b,int c){
        graph[a].add(new Pair(b,c));
    }    
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
            long u;
            long v;
            int index=-1;
            public Pairl(long u, long v) {
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
            if(b%2 == 1){
                x=(x*y)%c;
            }
            y = (y*y)%c; // squaring the base
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
        a = (x > y) ? x : y; // a is greater number
        b = (x < y) ? x : y; // b is smaller number
        r = b;
        while(a % b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }
/******************************************SIEVE**********************************************************/
    static void sieveMake(int n){
        sieve=new boolean[n];
        Arrays.fill(sieve,true);
        sieve[0]=false;
        sieve[1]=false;
        for(int i=2;i*i<n;i++){
            if(sieve[i]){
                for(int j=i*i;j<n;j+=i){
                    sieve[j]=false;
                }
            }
        }
        primes=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(sieve[i]){
                primes.add(i);
            }
        }        
    }
/********************************************End***********************************************************/
}