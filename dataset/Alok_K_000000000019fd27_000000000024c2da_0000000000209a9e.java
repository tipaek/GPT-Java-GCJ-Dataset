import java.util.*;
import java.io.*;
  class Solution {
     
static BufferedReader s1;
static BufferedWriter out;
static String read() throws IOException{String line="";while(line.length()==0){line=s1.readLine();continue;}return line;}
static int int_v (String s1){return Integer.parseInt(s1);}
static long long_v(String s1){return Long.parseLong(s1);}
static int[] int_arr() throws IOException{String[] a=read().split(" ");int[] b=new int[a.length];for(int i=0;i<a.length;i++){b[i]=int_v(a[i]);}return b;}
static long[] long_arr() throws IOException{String[] a=read().split(" ");long[] b=new long[a.length];for(int i=0;i<a.length;i++){b[i]=long_v(a[i]);}return b;}
static void assign(){s1=new BufferedReader(new InputStreamReader(System.in));out=new BufferedWriter(new OutputStreamWriter(System.out));}
     
   static void solve(int b) throws  IOException {
       if(b!=10){return;}
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<10;i++){
        out.write(i+1+"\n");
    out.flush();
    String s=read();
    sb.append(s.charAt(0));
    }
   out.write(sb.toString());
   out.flush();
   return;
  }

  public static void main(String args[]) throws  IOException {
      assign();
    int[] t1 = int_arr();
    int t=t1[0],b=t1[1];
    for (int ks = 1; ks <= t; ks++) {
     
      solve(b);
    }
    
  }
}