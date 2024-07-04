
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import java.util.*;


public class Solution {

    static Scanner in;
    static int b,a[],same,diff;

    static boolean state;


   static int quary(int i) throws IOException {
        System.out.println(i+1);
        int ans=in.nextInt();
        return ans;
    }
   static void findChange() throws IOException {
    boolean com=false;
    if (same!=-1&&a[same]!=quary(same))com=true;
    boolean rev=com;
        if (diff!=-1&&a[diff]!=quary(diff))rev=!com;

        if (com){
            for (int i = 0; i < b; i++) {
                a[i]=a[i]==0?1:0;
            }
        }
        
        if (rev){
            for (int i = 0; i < b/2; i++) {
                int d=a[i];
                a[i]=a[b-1-i];
                a[b-1-i]=d;
            }
        }


    }
   static void findPair(int i) throws IOException {
        a[i]=quary(i);
        a[b-1-i]=quary(b-1-i);

        if (same==-1&&a[i]==a[b-1-i]){
            same=i;
        }
        if (diff==-1&&a[i]!=a[b-1-i])diff=i;
    }
   static void solve() throws IOException {
        same=-1;
        diff=-1;
        quary(0);
        int i=0;
        for ( i = 0; i < 5; ++i) {
            findPair(i);
        }
        findChange();

        while (i<b/2){
            int w=0;
            for ( w = 0; w <4&i<b/2 ; ++i,++w) {
                findPair(i);
            }
            if (w==4)findChange();
        }
       for (int j = 0; j < b; j++) {
           System.out.print(a[i]);
       }
       System.out.println();
       char ok=in.next().charAt(0);
       if (ok=='N')state=true;
    }

        public static void main (String[]args) throws IOException {
             in = new Scanner(System.in);


            try (PrintWriter or = new PrintWriter(System.out)) {

                int t=in.nextInt(),b=in.nextInt();
                for (int i = 1; i <=t ; i++) {
                        solve();
                        if (state)return;
                }



            }
        }



    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    static int getlen(int r,int l,int a){
        return (r-l+1+1)/(a+1);
    }






    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++) {
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec) {
                        f *= 10;
                    }
                }
            }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

    }
}

class Pair implements Comparable<Pair> {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }


    @Override
    public int compareTo(Pair o) {
        if (first!=o.first)return first-o.first;
        return second-o.second;
    }
}

class Tempo {

   int first,second,third;

    public Tempo(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}