import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


 
 class Pair implements Comparable<Pair>{
   int u,v,index;
   public Pair(int x,int y,int z){u=x;v=y;index = z;}
   public Pair(){}
   public int compareTo(Pair p){
       return u - p.u;
   }
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
      int n = s.nextInt();
      Pair[]act = new Pair[n];
      for(int i=0;i<n;i++){
          act[i] = new Pair(s.nextInt(),s.nextInt(),i);
      }
      Arrays.sort(act);
      char cur = 'C';
      char[]temp = new char[n];
     // char[]ans = new
      String ans = "C";
      temp[act[0].index]='C';
      int flag = 0;
      int prevC = act[0].v;
      int prevJ = 0;
      for(int i=1;i<n;i++){
          if(prevC <= prevJ && act[i].u >= prevC){
              temp[act[i].index] = 'C';
            //  ans += "C";
              prevC = act[i].v;
          }
          else if(prevJ <= prevC && act[i].u >= prevJ){
             // ans += "J";
              temp[act[i].index]='J';
              prevJ = act[i].v;
          }
          else{
              flag = 1;
              break;
          }
      }
     ans = new String(temp);
      if(flag == 1){
          ans = "IMPOSSIBLE";
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