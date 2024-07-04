import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {
    //Solution by Sathvik Kuthuru
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = scan.nextInt();
        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
            int n = scan.nextInt(), m = scan.nextInt();
            boolean[][] done = new boolean[n][m];
            long[][] a = new long[n][m];
            long ans = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) a[i][j] = scan.nextLong();
            }
            while(true) {
                ArrayList<int[]> remove = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(done[i][j]) continue;
                        ans += a[i][j];
                        int count = 0, total = 0;
                        for(int k = 0; k < 4; k++) {
                            int at = 1;
                            while(true) {
                                int ii = i + dy[k] * at, jj = j + dx[k] * at;
                                if (ii >= n || ii < 0 || jj >= m || jj < 0) break;
                                else if(!done[ii][jj]) {
                                    count++;
                                    total += a[ii][jj];
                                    break;
                                }
                                at++;
                            }
                        }
                        if(a[i][j] * count < total) {
                            remove.add(new int[] {i, j});
                        }
                    }
                }
                if(remove.isEmpty()) break;
                for(int[] x : remove) done[x[0]][x[1]] = true;
            }
            out.println(ans);
        }
    }

    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}