// package cc;
import java.util.*;
import java.io.*;

class Solution {
    static class Interval{
        int s,e;
        public Interval(int a, int b){s=a;e=b;}
    }
    
    public static void main(String[] args) {
        solve();
    }
    
    public static void solve(){
        int t = _int();
        for(int ti=1;ti<=t;ti++){
            int n = _int();
            StringBuilder strb = new StringBuilder();
            Interval[] ivl = new Interval[n];
            int time[] = new int[1441];
            int maxov=0;
            for(int i=0;i<n;i++){
                int x = _int(),y = _int();
                ivl[i] = new Interval(x,y);
                while(x<y){
                    time[x++]++;
                    maxov = max(maxov,time[x-1]);
                }
            }
            
            if(maxov>2){
                printf("Case #%d: IMPOSSIBLE\n",ti);
            } else {
//                Arrays.sort(ivl,(x,y)->{
//                    return (x.s==y.s)?(x.e-y.e):(x.s-y.s);
//                });
                for(Interval ival : ivl){
//                    println("# " + time[ival.s]);
                    if(time[ival.s]==1)strb.append("C");
                    else strb.append("J");
                }
                printf("Case #%d: %s\n",ti,strb.toString());
            }
            
        }
        
    }
    
    
    
    static int max(int a, int b) {return a > b ? a : b;}
    static int min(int a, int b) {return a < b ? a : b;}
    static void print(Object o) {System.out.print(o);}
    static void printf(String f,Object...o) {System.out.printf(f,o);}
    static void println(Object o) {System.out.println(o);}
    static BufferedReader br;
    static StringTokenizer st;
    static {br = new BufferedReader(new InputStreamReader(System.in));}
    static String _next() {while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken();}
    static int _int() {return Integer.parseInt(_next());}
    static long _long() {return Long.parseLong(_next());}
    static double _double() {return Double.parseDouble(_next());}
    static String _line() {String str = ""; try { str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } return str;}

}
