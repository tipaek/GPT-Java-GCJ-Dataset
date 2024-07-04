/**
 * ******* Created  on 4/4/20 8:50 AM*******
 */

import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    private static final int MAX = (int) (1E2 + 5);
    private static final int MOD = (int) (1E9 + 7);
    private static final long Inf = (long) (1E14 + 10);
    private static final double eps = (double) (1E-9);

    private void solve() throws IOException {
        int tests = reader.nextInt();
        for(int tt=1; tt <=tests;tt++){
            String s = reader.next();
            int n = s.length();
            int cnt =0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                int val =s.charAt(i)-'0';
                int j = i;
                while(j+1 < n && s.charAt(i) == s.charAt(j+1))j++;

                while(cnt > val){
                    cnt--;
                    sb.append(")");
                }

                for(int k=cnt; k < val;k++)
                    sb.append("(");
                for(int k=i;k<=j;k++)
                    sb.append(s.charAt(i));
                cnt += val> cnt ? val-cnt :0;
                i=j;
            }
            for(int i=0;i<cnt;i++)
                sb.append(")");
            writer.println("Case #"+tt+": "+sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        try (Input reader = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            new Solution().run();
        }
    }

    StandardInput reader;
    PrintWriter writer;

    @Override
    public void run() {
        try {
            reader = new StandardInput();
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    interface Input extends Closeable {
        String next() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        default double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        default int[] readIntArray() throws IOException {
            return readIntArray(nextInt());
        }

        default int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        default long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }
    }
}
