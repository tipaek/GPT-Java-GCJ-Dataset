
import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static int a[],b;
    static FastReader sc;
    static int same,diff;
    public static void main(String[] args) throws Exception {
        sc = new FastReader();
        int t = sc.nextInt();
        b=sc.nextInt();a=new int[b];
        for (int tst = 1; tst <= t; tst++) {
            same=-1;diff=-1;
            int c=0;
            for (int i=0;i<5;i++){
                find(i);
            }
            change();
            while (c<b/2){
                int i=0;
                for (;i<4 && c<b/2;c++){
                    i++;
                    find(c);
                }
                if (i==4){
                    change();
                }
            }
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<b;i++){
                sb.append(a[i]);
            }
            System.out.println(sb);
            System.out.flush();
            String s=sc.next();
            if (s.equals("N")){
                return;
            }
            sc.close();
        }
    }
    static int q(int i){
        System.out.println(i+1);
        System.out.flush();
        int c=sc.nextInt();
        return c;
    }
    static void find(int i){
        a[i]=q(i);
        a[b-i-1]=q(b-i-1);
        if (same==-1 && a[i]==a[b-i-1])same=i;
        if (diff==-1 && a[i]==a[b-i-1])diff=i;
    }
    static void change(){
        int comp=0;
        if (same!=-1 && a[same]!=q(same)){
            comp=1;
        }
        int rv=comp;
        if (diff!=-1 && a[diff]!=q(diff)){
            rv=comp==0?1:0;
        }
        if (comp==1){
            for (int i=0;i<b;i++){
                if (a[i]==1)a[i]=0;
                else a[i]=1;
            }
        }
        if (rv==1){
            for (int i=0;i<b/2;i++){
                int tmp=a[i];
                a[i]=a[b-i-1];
                a[b-i-1]=tmp;
            }
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        public void close() throws Exception{
            br.close();
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}