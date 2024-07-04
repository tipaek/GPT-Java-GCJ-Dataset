import java.io.*;
import java.util.*;

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
            long[][] a = new long[n][m];
            long ans = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) a[i][j] = scan.nextLong();
            }
            TreeMap<Integer, TreeSet<Integer>> y = new TreeMap<>(), x = new TreeMap<>();
            for(int i = 0; i < n; i++) {
                TreeSet<Integer> curr = new TreeSet<>();
                for(int j = 0; j < m; j++) curr.add(j);
                y.put(i, curr);
            }
            for(int i = 0; i < m; i++) {
                TreeSet<Integer> curr = new TreeSet<>();
                for(int j = 0; j < n; j++) curr.add(j);
                x.put(i, curr);
            }
            while(true) {
                ArrayList<int[]> remove = new ArrayList<>();
                for(int i : y.keySet()) {
                    TreeSet<Integer> curr = y.get(i);
                    for(int j : curr) {
                        ans += a[i][j];
                        Integer left = curr.lower(j), right = curr.higher(j);
                        Integer up = x.get(j).lower(i), down = x.get(j).higher(i);
                        int count = 0, total = 0;
                        if(left != null) {
                            count++;
                            total += a[i][left];
                        }
                        if(right != null) {
                            count++;
                            total += a[i][right];
                        }
                        if(up != null) {
                            count++;
                            total += a[up][j];
                        }
                        if(down != null) {
                            count++;
                            total += a[down][j];
                        }
                        if(a[i][j] * count < total) remove.add(new int[] {i, j});
                    }
                }
                if(remove.isEmpty()) break;
                for(int[] c : remove) {
                    y.get(c[0]).remove(c[1]);
                    x.get(c[1]).remove(c[0]);
                    if(y.get(c[0]).isEmpty()) y.remove(c[0]);
                    if(x.get(c[1]).isEmpty()) x.remove(c[1]);
                }
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