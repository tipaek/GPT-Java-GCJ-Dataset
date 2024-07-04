import java.io.*;
import java.util.*;

public class Solution {
  
    private static void solver(InputReader sc, PrintWriter out) throws Exception{
        int test = sc.nextInt();
        for(int ii=0; ii<test;ii++){
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            long trace = 0;
            for(int i=0; i<n; i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                    if(i==j)
                        trace += arr[i][j];
                }
            }
            int r=0,c=0;
            for(int j=0;j<n;j++){
                Set<Integer> hs = new HashSet<>();
                for(int k=0;k<n;k++){
                    hs.add(arr[k][j]);
                }
                if(hs.size()!=n)
                    c++;
            }
            for(int i=0; i<n; i++){
                Set<Integer> hs = new HashSet<>();
                for(int k=0;k<n;k++){
                    hs.add(arr[i][k]);
                }
                if(hs.size()!=n)
                    r++;
            }
            out.println("Case #"+(ii+1)+": "+trace+" "+r+" "+c);
        }

    }

    private static int gcd (int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd (b, a % b);
    }
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solver(in,out);
        out.close();
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
        public int[] readIntArray(int n){
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i] = nextInt();
            return arr;
        }
    }
}
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x &&
                y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}