import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
class Solution{
    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        for(int p1=0;p1<t;p1++){
            String s=sc.next();
            int n=s.length();
            StringBuilder ans=new StringBuilder();
            int open=0,prev=0;
            for(int i=0;i<n;i++){
                char ch=s.charAt(i);
                int val=ch-'0';
                int val1=prev-val;
                if(val1<0){
                    for(int j=1;j<=Math.abs(val1);j++){
                        ans.append('(');
                    }
                }
                if(val1>0){
                    for(int j=1;j<=val1;j++){
                        ans.append(')');
                    }
                }
                ans.append(ch);
                open=open-val1;
                prev=val;
            }
            for(int i=1;i<=open;i++){
                ans.append(')');
            }
            System.out.println("Case #"+(p1+1)+": "+ans);
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