
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import java.util.*;


public class Main {



        public static void main (String[]args) throws IOException {
            Scanner in = new Scanner(System.in);


            try (PrintWriter or = new PrintWriter(System.out)) {

             int t=in.nextInt();
             int cur=1;
             while (t-->0){
                 int n = in.nextInt();
                 BitSet r= new BitSet(n),c=new BitSet(n);
                 int[][] a=new  int[n][n];
                 int rr=0,cc=0;
                 for (int i = 0; i < n; i++) {
                     Set<Integer>set= new HashSet<>();
                     for (int j = 0; j < n; j++) {
                         a[i][j]=in.nextInt();
                         if (set.contains(a[i][j])){
                             if (!r.get(i))++rr;
                             r.set(i);
                         }
                         set.add(a[i][j]);
                     }
                 }
                 for (int i = 0; i < n; i++) {
                     Set<Integer>set= new HashSet<>();
                     for (int j = 0; j < n; j++) {

                         if (set.contains(a[j][i])){
                             if (!c.get(i))++cc;
                             c.set(i);
                         }
                         set.add(a[j][i]);
                     }
                 }
                 int ans=0;
                 for (int i = 0; i < n; i++) {
                     ans+=a[i][i];
                 }

                 or.println("Case #"+(cur++)+": "+ans+" "+rr+" "+cc);
             }



            }
        }


        static class PairString{
            String first,second;

            public PairString(String first, String second) {
                this.first = first;
                this.second = second;
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

    String first;
    int second;

    public Tempo(String first, int second) {
        this.first = first;
        this.second = second;
    }
}