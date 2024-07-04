/**
 * ******* Created  on 24/4/20 12:19 AM*******
 */

import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    private static final int MAX = (int) (1E5 + 5);
    private static final int MOD = (int) (1E9 + 7);
    private static final long Inf = (long) (1E14 + 10);
    private static final double eps = (double) (1E-9);

    private void solve() throws IOException {
        int testCases = reader.nextInt();

        for (int cases = 1; cases <= testCases; cases++) {
            writer.print("Case #" + cases + ": ");
            int x = reader.nextInt();
            int y = reader.nextInt();
            String s = reader.next();
            int n = s.length();
            int[] dx = new int[n+1];
            int[] dy = new int[n+1];
            dx[0] =x;dy[0]=y;
            for(int i=0;i<n;i++){

                if(s.charAt(i)=='S') {
                    dx[i+1] = dx[i];
                    dy[i+1] =dy[i]-1;
                }
                if(s.charAt(i)=='N') {
                    dx[i+1] = dx[i];
                    dy[i+1] =dy[i]+1;
                }

                if(s.charAt(i)=='W') {
                    dx[i+1] = dx[i]-1;
                    dy[i+1] =dy[i];
                }

                if(s.charAt(i)=='W') {
                    dx[i+1] = dx[i]+1;
                    dy[i+1] =dy[i];
                }
            }
            int t =0;
            boolean flag =false;
            for(int i=0;i<=n;i++){
                int val = Math.abs(dx[i]) + Math.abs(dy[i]);
                if(val <=t){
                    flag =true;
                    break;
                }
                t++;
            }
            if(flag)
                writer.println(t);
            else
                writer.println("IMPOSSIBLE");
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
        String nextLine() throws IOException;

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

        @Override
        public String nextLine() throws IOException {
            return reader.readLine();
        }
    }
}
