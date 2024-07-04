
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
             while (t-->0){

                 char[]a=in.next().toCharArray();
                 Stack<Character>stack =new Stack<>();
                 StringBuilder ans= new StringBuilder();
                 for (int i = 0; i < a.length; i++) {
                     if (a[i]=='0'){
                         if (stack.isEmpty())
                         ans.append('0');
                         else{
                             while (!stack.isEmpty()){
                                 stack.pop();
                                 ans.append(1);
                             }
                             ans.append(')');
                             ans.append(0);
                         }

                     }
                     else {
                         if (stack.isEmpty()){
                             ans.append('(');
                         }
                         stack.push('(');
                     }
                 }
                 if (!stack.isEmpty()){
                     while (!stack.isEmpty()){
                         stack.pop();
                         ans.append(1);
                     }
                     ans.append(')');
                 }
                 or.println("Case #"+(cur++)+": "+ans);


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

    String first;
    int second;

    public Tempo(String first, int second) {
        this.first = first;
        this.second = second;
    }
}