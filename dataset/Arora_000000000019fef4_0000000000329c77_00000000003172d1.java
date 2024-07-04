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
            int d=sc.nextInt();
            long a[]=new long[n];
            HashMap<Long,Integer> map=new HashMap<>();
            int max=0;
            long omax=0,cmax=0;
            for(int i=0;i<n;i++){
                a[i]=sc.nextLong();
                omax=Math.max(omax,a[i]);
                if(map.containsKey(a[i])){
                    int k=map.get(a[i]);
                    map.put(a[i],k+1);
                    if(max<=k+1){
                        max=k+1;
                        cmax=Math.max(cmax,a[i]);
                    }
                }
                else{
                    map.put(a[i],1);
                    if(max<=1){
                        max=1;
                        cmax=Math.max(cmax,a[i]);
                    }
                }
            }
            int ans=0;
            if(d==2){
                if(max>=2){
                    ans=0;
                }
                else{
                    ans=1;
                }
            }
            else if(d==3){
                if(max>=3){
                    ans=0;
                }
                else if(n==2){
                    if(cmax%2==0 && map.containsKey(cmax/2)){
                        ans=1;
                    }
                    else{
                        ans=2;
                    }
                }
                else if(max==1){
                    ans=2;
                }
                else{
                    if(cmax<omax){
                        ans=1;
                    }
                    else{
                        ans=2;
                    }
                }
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