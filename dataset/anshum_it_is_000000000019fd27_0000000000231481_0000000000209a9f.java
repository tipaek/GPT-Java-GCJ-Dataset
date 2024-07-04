import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


 
 class Pair{
   int u,v;
   public Pair(int x,int y){u=x;v=y;}
   public Pair(){}
 }

public class Solution{
  public static int gcd(int a,int b)
  {
    if(a<b)
      return gcd(b,a);
    if(b==0)
      return a;
    return gcd(b,a%b);
    
  }

    public static void main(String[] args) throws Exception {
       new Thread(null, null, "Anshum Gupta", 99999999) {
            public void run() {
                try {
                    solve();
                } catch(Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

 
 public static void solve() throws Exception {
   // solve the problem here
   MyScanner s = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
   int t = s.nextInt();
   int tc = 1;
   while(tc<=t){
       String str = s.next();
       int cnt = 0;
       String ans = "";
       for(int i=0;i<str.length();i++){
           int cur = (str.charAt(i)-'0');
           if(cur > cnt){
               int dif = cur - cnt;
               for(int j=0;j<dif;j++){
                   ans += "(";
               }
               ans += str.charAt(i);
               cnt = cur;
           }
           else if(cur==cnt){
               
               ans += str.charAt(i);
           }
           else{
               int dif = cnt-cur;
               for(int j=0;j<dif;j++){
                   ans += ")";
               }
               ans += str.charAt(i);
               cnt = cur;
           }
       }
       int dif = cnt;
               for(int j=0;j<dif;j++){
                   ans += ")";
               }
       
             System.out.println("Case #"+tc+":"+" "+ans);
             tc++;
   }
   
  }
 
     
 
 
 
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
 
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
         
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    //--------------------------------------------------------
}