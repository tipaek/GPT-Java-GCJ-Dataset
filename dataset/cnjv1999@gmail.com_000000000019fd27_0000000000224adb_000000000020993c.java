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
            int n = _int(),trace=0,dr=0,dc=0;
            int mat[][] = new int[n][n];
            
            for(int i=0;i<n;i++){
                HashSet<Integer> set = new HashSet<>();
                for(int j=0;j<n;j++){
                    mat[i][j]=_int();
                    if(i==j)trace+=mat[i][j];
                    set.add(mat[i][j]);
                }
                if(set.size()!=n)dr++;
            }
            for(int i=0;i<n;i++){
                HashSet<Integer> set = new HashSet<>();
                for(int j=0;j<n;j++){
                    set.add(mat[j][i]);
                }
                if(set.size()!=n)dc++;
            }
            
            printf("Case #%d: %d %d %d\n",ti,trace,dr,dc);
//            println(map);
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
