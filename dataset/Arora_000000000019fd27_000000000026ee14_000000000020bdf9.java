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
    static class pair{
        int st,ed,idx;
        pair(int a,int b,int i){
            st=a;
            ed=b;
            idx=i;
        }
    }
    static class sort implements Comparator<pair>{
        public int compare(pair a,pair b){
            return a.st-b.st;
        }
    }
    public static void main(String args[]){
        FastScanner sc=new FastScanner(System.in);
        int t=sc.nextInt();
        for(int p=0;p<t;p++){
            int n=sc.nextInt();
            pair p1[]=new pair[n];
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                p1[i]=new pair(a,b,i);
            }
            Arrays.sort(p1,new sort());
            char ch[]=new char[n];
            int jst=0,jed=0,cst=0,ced=0;
            int flag=0;
            for(int i=0;i<n;i++){
                if(p1[i].st>=jed){
                    ch[p1[i].idx]='J';
                    jst=p1[i].st;
                    jed=p1[i].ed;
                }
                else if(p1[i].st>=ced){
                    ch[p1[i].idx]='C';
                    cst=p1[i].st;
                    ced=p1[i].ed;
                }
                else{
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                System.out.println("Case #"+(p+1)+": IMPOSSIBLE");
            }
            else{
                System.out.println("Case #"+(p+1)+": "+String.valueOf(ch));
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