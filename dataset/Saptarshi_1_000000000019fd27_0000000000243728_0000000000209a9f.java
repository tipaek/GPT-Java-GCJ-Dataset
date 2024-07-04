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
            String s=sc.next();
            int n=s.length();
            int a[]=new int[n];
            for(i=0;i<n;i++){
                a[i]=s.charAt(i)-48;
            }
            StringBuilder sb=new StringBuilder("");
            int prev=0;
            for(i=0;i<n;i++){
                int diff=a[i]-prev;
                while(diff>0){
                    sb.append("(");
                    diff--;
                }
                while(diff<0){
                    sb.append(")");
                    diff++;
                }
                sb.append(""+a[i]);
                prev=a[i];
            }
            int diff=a[n-1];
            while(diff>0){
                sb.append(")");
                diff--;
            }
            pw.println("Case #"+tt+": "+sb.toString());
        }
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;

        // int i;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
            // this.i=i;
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