import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
class Solution{//PRACTICE
    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        for(int p1=0;p1<t;p1++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            String m=sc.next();
            int n=m.length();
            int flag=0;
            int ans=0;
            for(int i=0;i<n;i++){
                char ch=m.charAt(i);
                if(ch=='S'){
                    y=y-1;
                }
                else if(ch=='N'){
                    y=y+1;
                }
                else if(ch=='E'){
                    x=x+1;
                }
                else{
                    x=x-1;
                }
                int val=Math.abs(x)+Math.abs(y);
                if(val<=(i+1)){
                    ans=i+1;
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                System.out.println("Case #"+(p1+1)+": IMPOSSIBLE");
            }
            else{
                System.out.println("Case #"+(p1+1)+": "+ans);
            }
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}