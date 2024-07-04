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

        for (int cases = 1; cases <= testCases; cases++) {
            writer.print("Case #" + cases + ": ");
            int n = reader.nextInt();
            int d = reader.nextInt();
            long[ ] a = new long[n];
            map.clear();

            for(int i=0;i<n;i++) {
                a[i] = reader.nextLong();
                if(map.containsKey(a[i]))
                    map.put(a[i],map.get(a[i])+1);
                else
                    map.put(a[i],1);

            }
            int mx =0;
            for(int i=0;i<55;i++)
            {
                ans[i] = MAX;
                val[i]=0;
            }
            ans[0]=0;
            for(long key:map.keySet()){
                mx = Math.max(mx,map.get(key));
            }

            for(int i=0;i<=mx;i++)
                ans[i]=0;
            for(int i= mx+1;i<=d;i++){

                findMin(i);
            }
            writer.println(ans[d]);
        }
    }
    Map<Long, Integer> map = new HashMap<>();
    int ans[] = new int[55];
    long[] val= new long[55];
    private void findMin(int mx) {
        boolean flag =false;
        for(long key : map.keySet()){
            if(map.get(key) == mx-1){
                if(map.containsKey(2*key)){
                  //  writer.println(mx +" "+key);
                    ans[mx]  = Math.min(ans[mx], ans[map.get(key)]+1 );
                    ans[mx+1]  = Math.min(ans[mx+1], ans[map.get(key)]+1 );
                    flag =true;
                }
            }
        }
        if(!flag)
            ans[mx] = Math.min(ans[mx],ans[mx/2]+2);
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
