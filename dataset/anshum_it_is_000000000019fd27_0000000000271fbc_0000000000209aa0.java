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
static boolean ispos(int[][]arr,int i,int j,int value){
    int n = arr.length;
    for(int x=0;x<i;x++){
        if(arr[x][j]==value)return false;
    }
    for(int x=0;x<j;x++){
        if(arr[i][x]==value)return false;
    }
    return true;
}
 static boolean fill(int[][]arr,int i,int j,int k){
     int n = arr.length;
     if(j == n){
         j = 0;
         i++;
     }
     if(i == n){
         return true;
     }
     
     if(i == j){
       for(int x=Math.max(1,k-(n-i-1)*n);x<= Math.min(k-(n-i-1),n);x++){
           if(ispos(arr,i,j,x)){
               arr[i][j] = x;
               if(fill(arr,i,j+1,k-x)){
                   return true;
               }
               else {
                   arr[i][j] = 0;
               }
           }
       }
       return false;
     }
     else{
         for(int x=1;x<=n;x++){
             if(ispos(arr,i,j,x)){
                 arr[i][j]=x;
                 if(fill(arr,i,j+1,k)){
                     return true;
                 }
                 else arr[i][j]=0;
             }
         }
         return false;
     }
     
 }
 public static void solve() throws Exception {
   // solve the problem here
   MyScanner s = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
   int t = s.nextInt();
   int tc = 1;
   while(tc<=t){
             int n = s.nextInt();
             int k = s.nextInt();
             int[][]arr=new int[n][n];
             int flag = 0;
             
             if(fill(arr,0,0,k)){
                 System.out.println("Case #"+tc+":"+" "+"POSSIBLE");
                 for(int i=0;i<n;i++){
                     for(int j=0;j<n;j++){
                         System.out.print(arr[i][j]+" ");
                     }
                     System.out.println();
                 }
             }
             else {
                 System.out.println("Case #"+tc+":"+" "+"IMPOSSIBLE");
             }
             
             ////System.out.println("Case #"+tc+":"+" "+ans);
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