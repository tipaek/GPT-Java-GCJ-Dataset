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
        int b=sc.nextInt();
        u: for(tt=1;tt<=t;tt++) {
            if(b==10){
                int a[]=new int[11];
                for(i=1;i<11;i++){
                    System.out.println(i);
                    System.out.flush();
                    a[i]=sc.nextInt();
                }
                for(i=1;i<11;i++)
                    System.out.print(a[i]);
                System.out.println();
                System.out.flush();
                char ans=sc.next().charAt(0);
                if(ans!='Y')
                    break;
            }
            else if(b==20){
                int a[]=new int[21];
                for(i=1;i<6;i++){
                    System.out.println(i);
                    System.out.flush();
                    a[i]=sc.nextInt();
                }
                for(i=16;i<21;i++){
                    System.out.println(i);
                    System.out.flush();
                    a[i]=sc.nextInt();
                }
                int f=0,g=0;
                for(i=1;i<6;i++){
                    if(a[i]==a[21-i])
                        f=i;
                    else
                        g=i;
                }
                if(f==0||g==0){
                    System.out.println(1);
                    System.out.flush();
                    int y=sc.nextInt();
                    if(y!=a[1]){
                        for(i=1;i<6;i++)
                            a[i]=1-a[i];
                        for(i=16;i<21;i++)
                            a[i]=1-a[i];
                    }
                    System.out.println(1);
                    System.out.flush();
                    y=sc.nextInt();
                }
                else{
                    System.out.println(f);
                    System.out.flush();
                    int y=sc.nextInt();
                    System.out.println(g);
                    System.out.flush();
                    int z=sc.nextInt();
                    if(y==a[f]){
                        if(z!=a[g]){
                            for(i=1;i<6;i++){
                                int temp=a[i];
                                a[i]=a[21-i];
                                a[21-i]=temp;
                            }
                        }
                    }
                    else{
                        if(z!=a[g]){
                            for(i=1;i<6;i++)
                                a[i]=1-a[i];
                            for(i=16;i<21;i++)
                                a[i]=1-a[i];
                        }
                        else{
                            for(i=1;i<6;i++)
                                a[i]=1-a[i];
                            for(i=16;i<21;i++)
                                a[i]=1-a[i];
                            for(i=1;i<6;i++){
                                int temp=a[i];
                                a[i]=a[21-i];
                                a[21-i]=temp;
                            }
                        }
                    }
                }
                for(i=6;i<10;i++){
                    System.out.println(i);
                    System.out.flush();
                    a[i]=sc.nextInt();
                }
                for(i=12;i<16;i++){
                    System.out.println(i);
                    System.out.flush();
                    a[i]=sc.nextInt();
                }
                f=0;
                g=0;
                for(i=1;i<10;i++){
                    if(a[i]==a[21-i])
                        f=i;
                    else
                        g=i;
                }
                if(f==0||g==0){
                    System.out.println(1);
                    System.out.flush();
                    int y=sc.nextInt();
                    if(y!=a[1]){
                        for(i=1;i<10;i++)
                            a[i]=1-a[i];
                        for(i=12;i<21;i++)
                            a[i]=1-a[i];
                    }
                    System.out.println(1);
                    System.out.flush();
                    y=sc.nextInt();
                }
                else{
                    System.out.println(f);
                    System.out.flush();
                    int y=sc.nextInt();
                    System.out.println(g);
                    System.out.flush();
                    int z=sc.nextInt();
                    if(y==a[f]){
                        if(z!=a[g]){
                            for(i=1;i<10;i++){
                                int temp=a[i];
                                a[i]=a[21-i];
                                a[21-i]=temp;
                            }
                        }
                    }
                    else{
                        if(z!=a[g]){
                            for(i=1;i<10;i++)
                                a[i]=1-a[i];
                            for(i=12;i<21;i++)
                                a[i]=1-a[i];
                        }
                        else{
                            for(i=1;i<10;i++)
                                a[i]=1-a[i];
                            for(i=12;i<21;i++)
                                a[i]=1-a[i];
                            for(i=1;i<10;i++){
                                int temp=a[i];
                                a[i]=a[21-i];
                                a[21-i]=temp;
                            }
                        }
                    }
                    
                    System.out.println(10);
                    System.out.flush();
                    a[10]=sc.nextInt();
        
                    System.out.println(11);
                    System.out.flush();
                    a[11]=sc.nextInt();
                
                    for(i=1;i<21;i++)
                        System.out.print(a[i]);
                    System.out.println();
                    System.out.flush();
                    char ans=sc.next().charAt(0);
                    if(ans!='Y')
                        break;
                }
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