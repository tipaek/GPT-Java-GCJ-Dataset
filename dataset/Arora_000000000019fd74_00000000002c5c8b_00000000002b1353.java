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
            int n=sc.nextInt();
            if(n<=501){
                System.out.println("Case #"+(p1+1)+":");
                case1(n);
            }
        }
    }
    static void case1(int n){
        if(n==1){
            System.out.println("1 1");
            return;
        }
        if(n==2){
            System.out.println("1 1");
            System.out.println("2 2");
            return;
        }
        for(int i=1;i<n;i++){
            if(i==2){
                System.out.println("2 1");
                System.out.println("2 2");
            }
            else{
                System.out.println(i+" "+i);
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