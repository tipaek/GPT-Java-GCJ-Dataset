
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import java.util.*;


public class Solution {



        public static void main (String[]args) throws IOException {
            Scanner in = new Scanner(System.in);


            try (PrintWriter or = new PrintWriter(System.out)) {

             int t=in.nextInt();
             int cur=1;
             outer:
             while (t-->0){

                int c=0,j=0;
                int n=in.nextInt();
                Tempo[]a= new Tempo[n];
                 for (int i = 0; i < n; i++) {
                     int start=in.nextInt(),end=in.nextInt();
                     a[i]=new Tempo(start,end,i);
                 }
                 char[]ans=new char[n];
                 Arrays.sort(a, new Comparator<Tempo>() {
                     @Override
                     public int compare(Tempo o1, Tempo o2) {
                         if (o1.first!=o2.first)return o1.first-o2.first;
                         return o1.second-o2.second;
                     }
                 });
                 for (int i = 0; i < n; i++) {
                     int start =a[i].first,end=a[i].second;
                     if (c<=start){
                         c=end;
                         ans[a[i].third]='C';
                     }
                     else if (j<=start){
                         j=end;
                         ans[a[i].third]='J';
                     }
                     else {
                         or.println("Case #"+(cur++)+": IMPOSSIBLE");
                         continue outer;
                     }
                 }
                 or.println("Case #"+(cur++)+": "+new String(ans));



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