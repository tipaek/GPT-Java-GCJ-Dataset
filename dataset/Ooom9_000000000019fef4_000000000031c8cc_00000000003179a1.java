/**
 * ******* Created  on 24/4/20 12:19 AM*******
 */

import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    private static final int MAX = (int) (1E4);
    private static final int MOD = (int) (1E9 + 7);
    private static final long Inf = (long) (1E14 + 10);
    private static final double eps = (double) (1E-9);
    class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a =a;
            this.b =b;
        }
    }
    private void solve() throws IOException {
        int testCases = reader.nextInt();
        Map<Integer,Set<String>> map = new HashMap<>();
        for (int cases = 1; cases <= testCases; cases++) {
            writer.print("Case #" + cases + ": ");
            int u = reader.nextInt();
            for(int i=0;i<MAX;i++){
                int q = reader.nextInt();
                String s = reader.next();
                if(map.containsKey(q)){
                    Set<String> temp = map.get(q);
                    temp.add(s);
                    map.put(q,temp);
                }else{
                    Set<String> arr = new HashSet<>();
                    arr.add(s);
                    map.put(q,arr);
                }
            }
        }
        String[] ans = new String[10+1];

        for(int i=1 ;i<=10;i++){
            Iterator<String> it = map.get(i).iterator();
            String h = it.next();
            ans[i] = h;
            for(int j=i+1;j<=10;j++){
                Set<String> temp = map.get(j);
                if(temp.contains(h))
                    temp.remove(h);
            }
        }
        writer.print(ans[10].charAt(1));
        for(int i=1;i<10;i++)
            writer.print(ans[i]);
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
