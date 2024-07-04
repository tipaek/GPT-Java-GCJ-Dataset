/**
 * ******* Created  on 4/4/20 8:50 AM*******
 */

import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    private static final int MAX = (int) (1E3 + 5);
    private static final int MOD = (int) (1E9 + 7);
    private static final long Inf = (long) (1E14 + 10);
    private static final double eps = (double) (1E-9);
    TreeSet<Integer>[] rows = new TreeSet[55];
    TreeSet<Integer>[] cols = new TreeSet[55];
    int[][] a = new int[55][55];
    private void solve() throws IOException {
        int tests = reader.nextInt();

        for(int i=0;i<55;i++) {
            rows[i] =  new TreeSet<>();
            cols[i] = new TreeSet<>();
        }
        for(int tt=1; tt <=tests;tt++){
            int n = reader.nextInt();
            int k = reader.nextInt();
            writer.print("Case #"+tt +": ");
            int av = n;
            int temp = k;

            for(int i=0;i<n;i++) {
                rows[i].clear();
                cols[i].clear();
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    rows[i].add(j+1);
                    cols[i].add(j+1);
                    a[i][j]=0;
                }
            }

            for(int i=0;i<n;i++){
                a[i][i] = Math.min(n, temp-(n-i-1));
                temp -=a[i][i];
                rows[i].remove(a[i][i]);
                cols[i].remove(a[i][i]);
            }

            for(int i=0;i < n;i++){
                for(int j=0;j<n;j++){
                    if(a[i][j] != 0)continue;
                    calculate(i,j,n);
                }
            }
            boolean flag =true;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    if(a[i][j]==-1)
                        flag =false;
            }
            int sum =0;
            for(int i=0;i<n;i++)
                sum +=a[i][i];
            if(sum !=k )
                flag =false;

            if(!flag){
                writer.println("IMPOSSIBLE");
                continue;
            }
            writer.println("POSSIBLE");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    writer.print(a[i][j]+" ");
                writer.println();
            }
        }
    }
    private void calculate(int x, int y, int n) {
        for(int i=n;i>=1;i--){
            if(rows[x].contains(i) && cols[y].contains(i)){
                a[x][y] = i;
                rows[x].remove(i);
                cols[y].remove(i);
                return;
            }
        }
        a[x][y]=-1;
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
