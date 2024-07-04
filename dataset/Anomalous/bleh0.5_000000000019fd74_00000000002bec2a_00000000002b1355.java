import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) solver.solve(i, scan, out);
        out.close();
    }

    static class Task {
        static final int INF = Integer.MAX_VALUE;

        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            long sum = 0;
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] arr = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            while (true) {
                ArrayList<Long> changes = new ArrayList<>();
                boolean changed = false;

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (arr[i][j] > 0) {
                            sum += arr[i][j];
                            int neighborSum = 0;
                            int neighborCount = 0;

                            // Check above
                            for (int k = i - 1; k >= 0; k--) {
                                if (arr[k][j] > 0) {
                                    neighborSum += arr[k][j];
                                    neighborCount++;
                                    break;
                                }
                            }

                            // Check below
                            for (int k = i + 1; k < r; k++) {
                                if (arr[k][j] > 0) {
                                    neighborSum += arr[k][j];
                                    neighborCount++;
                                    break;
                                }
                            }

                            // Check left
                            for (int k = j - 1; k >= 0; k--) {
                                if (arr[i][k] > 0) {
                                    neighborSum += arr[i][k];
                                    neighborCount++;
                                    break;
                                }
                            }

                            // Check right
                            for (int k = j + 1; k < c; k++) {
                                if (arr[i][k] > 0) {
                                    neighborSum += arr[i][k];
                                    neighborCount++;
                                    break;
                                }
                            }

                            if (neighborCount > 0 && (neighborSum + neighborCount - 1) / neighborCount > arr[i][j]) {
                                changes.add((long) i * 500000 + j);
                                changed = true;
                            }
                        }
                    }
                }

                for (long x : changes) {
                    arr[(int) (x / 500000)][(int) (x % 500000)] = 0;
                }

                if (!changed) break;
            }

            pw.printf("Case #%d: %d%n", testNumber, sum);
        }
    }

    static long binpow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }

    static void sort(int[] x) {
        shuffle(x);
        Arrays.sort(x);
    }

    static void sort(long[] x) {
        shuffle(x);
        Arrays.sort(x);
    }

    static class Tuple implements Comparable<Tuple> {
        int a, b;

        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Tuple o) {
            return Integer.compare(o.b, b);
        }
    }

    static void shuffle(int[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = rand.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = rand.nextInt(a.length);
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