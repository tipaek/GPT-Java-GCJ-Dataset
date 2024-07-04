// package cc;
import java.util.*;
import java.io.*;

class Solution {
        
    public static void main(String[] args) {
        solve();
    }
    
    public static void solve(){
        int t = _int();
        for(int ti=1;ti<=t;ti++){
            long x = _long();
            long y = _long();
            String str = _next();
            long dist = Integer.MAX_VALUE;
            long minTime=Integer.MAX_VALUE;
            boolean flag=false;
            
            long dist2 = abs(x)+abs(y);
            long time=0;
            if(dist2<=time){flag=true;dist=dist2;minTime=time;}
            for(char c : str.toCharArray()){
                if(c=='N')y++;
                else if(c=='S')y--;
                else if(c=='E')x++;
                else if(c=='W')x--;
                
                long curDist = abs(x)+abs(y);
                time++;
                
                if(curDist<=time){
                    flag=true;
                    dist = min(curDist,dist);
                    minTime = min(time,minTime);
                }
            }
            if(flag)printf("Case %d: %d\n",ti,minTime);
            else printf("Case %d: IMPOSSIBLE\n",ti);
            
        }
        
    }
    
    
    static long abs(long x){return x>0?x:-x;}
    static int max(int a, int b) {return a > b ? a : b;}
    static long min(long a, long b) {return a < b ? a : b;}
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
