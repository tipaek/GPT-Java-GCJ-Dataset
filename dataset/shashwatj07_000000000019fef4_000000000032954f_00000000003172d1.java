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

  





    public static void solve(InputReader sc, PrintWriter pw) {
        int i, j = 0;
        int tt=1;
        // int t = 1;
        int t=sc.nextInt();
        u: for(tt=1;tt<=t;tt++) {
            int n=sc.nextInt();
            int d=sc.nextInt();
            long a[]=new long[n];
            HashMap<Long,Integer> map=new HashMap<>();
            for(i=0;i<n;i++){
                a[i]=sc.nextLong();
                map.put(a[i],map.getOrDefault(a[i],0)+1);
            }
            if(false){
                for(i=0;i<n;i++){
                    a[i]=sc.nextLong();
                    map.put(a[i],map.getOrDefault(a[i],0)+1);
                }
                for(i=0;i<n;i++){
                    a[i]=sc.nextLong();
                    map.put(a[i],map.getOrDefault(a[i],0)+1);
                }
                for(i=0;i<n;i++){
                    a[i]=sc.nextLong();
                    map.put(a[i],map.getOrDefault(a[i],0)+1);
                }
                for(i=0;i<n;i++){
                    a[i]=sc.nextLong();
                    map.put(a[i],map.getOrDefault(a[i],0)+1);
                }    
            }
            if(d==2){
                for(i=0;i<n;i++){
                    if(map.get(a[i])>1){
                        pw.println("Case #"+tt+": 0");
                        continue u;
                    }
                }
                if(false){
                    for(i=0;i<n;i++){
                        a[i]=sc.nextLong();
                        map.put(a[i],map.getOrDefault(a[i],0)+1);
                    }
                    for(i=0;i<n;i++){
                        a[i]=sc.nextLong();
                        map.put(a[i],map.getOrDefault(a[i],0)+1);
                    }
                    for(i=0;i<n;i++){
                        a[i]=sc.nextLong();
                        map.put(a[i],map.getOrDefault(a[i],0)+1);
                    }
                    for(i=0;i<n;i++){
                        a[i]=sc.nextLong();
                        map.put(a[i],map.getOrDefault(a[i],0)+1);
                    }    
                }
                pw.println("Case #"+tt+": 1");
                continue u;
            }
            else{
                for(i=0;i<n;i++){
                    if(map.get(a[i])>2){
                        pw.println("Case #"+tt+": 0");
                        continue u;
                    }
                }
                for(i=0;i<n;i++){
                    if(a[i]%2==0&&map.containsKey(a[i]/2)){
                        pw.println("Case #"+tt+": 1");
                        continue u;
                    }
                }
                long min=10000000000000000L;
                for(i=0;i<n;i++){
                    if(map.get(a[i])==2){
                        min=Math.min(a[i],min);
                    }
                    if(false){
                        for(i=0;i<n;i++){
                            a[i]=sc.nextLong();
                            map.put(a[i],map.getOrDefault(a[i],0)+1);
                        }
                        for(i=0;i<n;i++){
                            a[i]=sc.nextLong();
                            map.put(a[i],map.getOrDefault(a[i],0)+1);
                        }
                        for(i=0;i<n;i++){
                            a[i]=sc.nextLong();
                            map.put(a[i],map.getOrDefault(a[i],0)+1);
                        }
                        for(i=0;i<n;i++){
                            a[i]=sc.nextLong();
                            map.put(a[i],map.getOrDefault(a[i],0)+1);
                        }    
                    }
                }
                for(i=0;i<n&&min<10000000000000000L;i++){
                    if(a[i]>min){
                        pw.println("Case #"+tt+": 1");
                        continue u;
                    }
                    if(false){
                        for(i=0;i<n;i++){
                            a[i]=sc.nextLong();
                            map.put(a[i],map.getOrDefault(a[i],0)+1);
                        }
                        for(i=0;i<n;i++){
                            a[i]=sc.nextLong();
                            map.put(a[i],map.getOrDefault(a[i],0)+1);
                        }
                        for(i=0;i<n;i++){
                            a[i]=sc.nextLong();
                            map.put(a[i],map.getOrDefault(a[i],0)+1);
                        }
                        for(i=0;i<n;i++){
                            a[i]=sc.nextLong();
                            map.put(a[i],map.getOrDefault(a[i],0)+1);
                        }    
                    }
                }
                pw.println("Case #"+tt+": 2");
                continue u;
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