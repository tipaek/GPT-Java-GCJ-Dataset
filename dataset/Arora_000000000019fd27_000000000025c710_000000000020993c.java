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
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int k=0,r=0,c=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                    if(i==j){
                        k+=a[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++){
                HashSet<Integer> row=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(row.contains(a[i][j])){
                        r++;
                        break;
                    }
                    else{
                        row.add(a[i][j]);
                    }
                }
            }
            for(int j=0;j<n;j++){
                HashSet<Integer> col=new HashSet<>();
                for(int i=0;i<n;i++){
                    if(col.contains(a[i][j])){
                        c++;
                        break;
                    }
                    else{
                        col.add(a[i][j]);
                    }
                }
            }
            System.out.println("Case #"+(p1+1)+": "+k+" "+r+" "+c);
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