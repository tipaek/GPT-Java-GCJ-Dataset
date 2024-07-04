import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    static String reverse(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }

    static void sort(int ar[]) {
        int n = ar.length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(ar[i]);
        Collections.sort(a);
        for (int i = 0; i < n; i++)
            ar[i] = a.get(i);
    }

    static long ncr(long n, long r, long mod) {
        if (r == 0)
            return 1;
        long val = ncr(n - 1, r - 1, mod);
        val = (n * val) % mod;
        val = (val * modInverse(r, mod)) % mod;
        return val;
    }

    public static void solve(InputReader sc, PrintWriter pw) {
        int i, j = 0;
        // int t = 1;
        int tt=1;
        int t=sc.nextInt();
        u: for(tt=1;tt<=t;tt++) {
            int n=sc.nextInt();
            String a[]=new String[n];
            String pre[]=new String[n];
            String suf[]=new String[n];
            int len=0, l=0;
            String lpr="",lsu="";
            for(i=0;i<n;i++){
                a[i]="x"+sc.next()+"x";
                for(j=0;j<a[i].length();j++){
                    if(a[i].charAt(j)=='*'){
                        pre[i]=a[i].substring(0,j);
                        // suf[i]=a[i].substring(j+1);
                        if(lpr.length()<pre[i].length()){
                            lpr=pre[i];
                        }
                        // if(lsu.length()<suf[i].length()){
                        //     lsu=suf[i];
                        // }
                        break;
                    }
                }
                for(j=a[i].length()-1;j>=0;j--){
                    if(a[i].charAt(j)=='*'){
                        // pre[i]=a[i].substring(0,j);
                        suf[i]=a[i].substring(j+1);
                        // if(lpr.length()<pre[i].length()){
                        //     lpr=pre[i];
                        // }
                        if(lsu.length()<suf[i].length()){
                            lsu=suf[i];
                        }
                        break;
                    }
                }
            }
            int f=0;
            for(i=0;i<n;i++){
                if(lpr.startsWith(pre[i])&&lsu.endsWith(suf[i])){
                    continue;
                }
                f=1;
            }
            if(f==1)
                pw.println("Case #"+tt+": *");
            else{
                pw.print("Case #"+tt+": "+lpr.substring(1));
                for(i=0;i<n;i++){
                    // System.out.println(a[i]);
                    String ar[]=a[i].split("\\*");
                    for(j=1;j<ar.length-1;j++){
                        pw.print(ar[j]);
                    }
                }
                pw.println(lsu.substring(0, lsu.length()-1));
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;
        int i;
        Pair(int a, int b, int i) {
            this.a = a;
            this.b = b;
            this.i=i;
        }

        public int compareTo(Pair p) {
            if (a != p.a)
                return (a - p.a);
            return (b - p.b);
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long fast_pow(long base, long n, long M) {
        if (n == 0)
            return 1;
        if (n == 1)
            return base % M;
        long halfn = fast_pow(base, n / 2, M);
        if (n % 2 == 0)
            return (halfn * halfn) % M;
        else
            return (((halfn * halfn) % M) * base) % M;
    }

    static long modInverse(long n, long M) {
        return fast_pow(n, M - 2, M);
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}