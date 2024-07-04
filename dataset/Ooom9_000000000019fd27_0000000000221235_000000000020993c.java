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
        int[][] a = new int[MAX][MAX];
        for(int tt=1; tt <=tests;tt++){
            writer.print("Case #"+tt+": ");
            int n = reader.nextInt();

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    a[i][j] = reader.nextInt();
            }
            int sum=0,row =0, col =0;
            for(int i=0;i<n;i++)
                sum +=a[i][i];
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<n;i++){
                set.clear();
                for(int j =0;j < n;j++){
                    if(set.contains(a[i][j])){
                        row++;
                        break;
                    }
                    set.add(a[i][j]);
                }
                set.clear();
                for(int j=0;j<n;j++){
                    if(set.contains(a[j][i])) {
                        col++;
                        break;
                    }
                    set.add(a[j][i]);
                }
            }
            writer.println(sum+" "+row+" "+col);
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
