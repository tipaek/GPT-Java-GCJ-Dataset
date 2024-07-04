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
    static HashSet<Integer> graph[];
    static int pptr=0,pptrmax=0;
    static String st[];
/*****************************************Solutions Begins***************************************/
    static boolean flag=true;
    static String valid(ArrayList<String> ls){
        String prev="";
        flag=true;
        for(String str:ls){
            if(prev.length()<str.length())prev=str;
        }
        for(String str:ls){
            for(int i=0;i<str.length();i++){
                if(prev.charAt(i)!=str.charAt(i)){
                    flag=false;
                    break;
                }
            }
            if(!flag)return "";
        }
        return prev;
    }
    static void prn(ArrayList<String> ls){
        for(String s:ls){
            out.print(s);
        }
    }
    static String reverse(String str){
        char r[]=new char[str.length()];
        int j=0;
        for(int i=str.length()-1;i>=0;i--){
            r[j]=str.charAt(i);
            j++;
        }
        return new String(r);
    }
    public static void main(String args[]) throws Exception{
        int tt=pi();
        for(int i1=1;i1<=tt;i1++){
            int n=pi();
            String input[]=new String[n];
            ArrayList<String> ls1=new ArrayList<>();
            ArrayList<String> ls2=new ArrayList<>();
            ArrayList<String> bet=new ArrayList<>();
            for(int i=0;i<n;i++){
                String cur=ps();
                input[i]=cur;
                String arr[]=cur.split("\\*");
                int start=0,end=arr.length;

                if(cur.charAt(0)!='*'){
                    ls1.add(arr[0]);
                    start++;
                }
                if(cur.charAt(cur.length()-1)!='*'){
                    ls2.add(reverse(arr[arr.length-1]));
                    end--;
                }
            
                for(int j=start;j<end;j++){
                    bet.add(arr[j]);
                }
            }
            out.print("Case #"+i1+": ");
            String str1=valid(ls1);
            boolean b1=flag;
            String str2=reverse(valid(ls2));
            boolean b2=flag;
            //debug(bet);

            if(b1&&b2){
                out.print(str1);
                prn(bet);
                out.print(str2);
            }
            else{
                out.print("*");
            }
            out.println();
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
        graph=new HashSet[n];
        for(int i=0;i<n;i++){
            graph[i]=new HashSet<>();
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