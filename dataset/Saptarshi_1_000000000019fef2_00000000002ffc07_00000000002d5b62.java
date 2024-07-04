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
        int tt=1;
        // int t = 1;
        int t=sc.nextInt();
        u: for(tt=1;tt<=t;tt++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            ArrayList<Integer> ar1=new ArrayList<>();
            ArrayList<Integer> ar2=new ArrayList<>();
            int n=0;
            int h=(x>0)?0:1;
            int g=(y>0)?0:1;
            x=Math.abs(x);
            y=Math.abs(y);
            while(x>0||y>0){
                ar1.add(x%2);
                ar2.add(y%2);
                x/=2;
                y/=2;
                n++;
            }
            if((ar1.get(n-1)&ar2.get(n-1))==1){
                ar1.add(0);
                ar2.add(0);
                n++;
            }
            int f=0;
            for(i=0;i<n;i++){
                if(ar1.get(i)==2){
                    ar1.remove(i);
                    ar1.add(i,0);
                    int val=ar1.get(i+1);
                    ar1.remove(i+1);
                    ar1.add(i+1,val+1);
                }
                else if(ar2.get(i)==2){
                    ar2.remove(i);
                    ar2.add(i,0);
                    int val=ar2.get(i+1);
                    ar2.remove(i+1);
                    ar2.add(i+1,val+1);
                }
                if(ar1.get(i)==0&&ar2.get(i)==0){
                    f=1;
                    break;
                }
                if(ar1.get(i)==1&&ar2.get(i)==1){
                    f=1;
                    break;
                }
                if(i<n-1&&ar1.get(i+1)==1&&ar2.get(i+1)==1){
                    if(ar1.get(i)==1){
                        ar1.remove(i);
                        ar1.add(i,-1);
                        int val=ar1.get(i+1);
                        ar1.remove(i+1);
                        ar1.add(i+1,val+1);
                    }
                    else{
                        ar2.remove(i);
                        ar2.add(i,-1);
                        int val=ar2.get(i+1);
                        ar2.remove(i+1);
                        ar2.add(i+1,val+1);
                    }
                }
            }
            if(f==1)
                pw.println("Case #"+tt+": IMPOSSIBLE");
            else{
                pw.print("Case #"+tt+": ");
                for(i=0;i<n;i++){
                    if(ar1.get(i)==1){
                        pw.print((h==0)?"E":"W");
                    }
                    else if(ar1.get(i)==-1){
                        pw.print((h==0)?"W":"E");
                    }
                    else if(ar2.get(i)==1){
                        pw.print((g==0)?"N":"S");
                    }
                    else if(ar2.get(i)==-1){
                        pw.print((g==0)?"S":"N");
                    }
                }
                pw.println();
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