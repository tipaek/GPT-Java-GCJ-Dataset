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
            String s = _line();
            StringBuilder strb = new StringBuilder();
            int nums[] = new int[s.length()+2];
            int i=1;
            for(char c : s.toCharArray())nums[i++]=c-'0';
            int leftover=0;
            for(i=1;i<nums.length;i++){
                int j = nums[i]-nums[i-1];
//                println("# " + j);
                leftover+=j;
                if(j>0){
                    while(j-->0)strb.append("(");
                } else if(j<0){
                    j=-j;
                    while(j-->0)strb.append(")");
                }
                if(i!=nums.length-1)strb.append(nums[i]);
            }
            while(leftover-->0){
                strb.append(")");
            }
            
            printf("Case #%d: %s\n",ti,strb.toString());
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
