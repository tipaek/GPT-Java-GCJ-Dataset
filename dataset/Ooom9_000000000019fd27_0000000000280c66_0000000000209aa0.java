/**
 * ******* Created  on 4/4/20 10:41 PM*******
 */

import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    private static final int MAX = (int) (1E5 + 5);
    private static final int MOD = (int) (1E9 + 7);
    private static final long Inf = (long) (1E14 + 10);
    private static final double eps = (double) (1E-9);
    TreeSet<Integer>[] rows = new TreeSet[55];
    TreeSet<Integer>[] cols = new TreeSet[55];
    int[][] a = new int[55][55];
    int k;
    private void solve() throws IOException {
        int tests = reader.nextInt();

        for(int i=0;i<55;i++) {
            rows[i] =  new TreeSet<>();
            cols[i] = new TreeSet<>();
        }
        List<Integer> test = new ArrayList<>();
        for(int i=0;i<130;i++)
            perm[i] = new ArrayList();

        for(int tt=1; tt <=tests;tt++) {
            int n = reader.nextInt();
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    a[i][j]=0;
            for(int i=0;i<=ind;i++)
                perm[i].clear();
            ind =0;
            flag =false;
            k= reader.nextInt();
            test.clear();
            for(int i=0;i<n;i++)
                test.add(i+1);
            generatePerm(test,0,n-1);

            writer.print("Case #" + tt + ": ");
            calculate(0,0,n);
            if(!flag) {
                writer.println("IMPOSSIBLE");
                continue;
            }
            writer.println("POSSIBLE");
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++){
                    writer.print(a[i][j]+" ");
                }
                writer.println();
            }
        }
    }
    boolean flag=false;
    private void calculate(int s,int p, int n) {
        if(s == n){

            if(flag)return ;
            flag = check(a,n);
            for(int i=0;i<5;i++) {
                rows[i].clear();
                cols[i].clear();
            }
            return;
        }
        for(int i= p;i<ind && !flag;i++){
            for(int j=0;j<perm[i].size();j++)
                a[s][j] = (int) perm[i].get(j);
            calculate(s+1,i+1,n);
        }
    }

    private boolean check(int[][] a, int n) {
        int sum =0;
        for(int i=0;i<n;i++){
            sum +=a[i][i];
        }
        if(sum != k)
            return  false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!rows[i].contains(a[i][j]))
                    rows[i].add(a[i][j]);
                else
                    return false;
                if(!cols[j].contains(a[i][j]))
                    cols[j].add(a[i][j]);
                else
                    return false;
            }
        }
        return true;
    }

    List[] perm = new List[150];
    int ind =0;
    private void generatePerm(List<Integer>a, int l, int h) {
        if(l == h){
            for(int i=0;i<=h;i++)
                perm[ind].add(a.get(i));
            ind++;
            return;
        }
        for(int i =l;i<=h;i++){
            Collections.swap(a,i,l);
            generatePerm(a,l+1,h);
            Collections.swap(a,i,l);
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
