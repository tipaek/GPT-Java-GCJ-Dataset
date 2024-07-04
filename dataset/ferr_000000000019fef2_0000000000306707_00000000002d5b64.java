import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    int R, S;

    class Perm {
        public final byte[] arr;

        Perm() {
            arr = new byte[R * S];
            int k = 0;
            for (int j = 0; j < S; ++j) {
                for (int i = 0; i < R; ++i) {
                    arr[k++] = (byte) (i * S + j);
                }
            }
        }

        Perm(byte[] arr) {
            this.arr = arr;
        }

        Perm mutate(int A, int B) {
            byte[] b2 = arr.clone();
            for (int i = 0; i < B; ++i) {
                b2[i] = arr[A + i];
            }
            for (int i = 0; i < A; ++i) {
                b2[B + i] = arr[i];
            }
            return new Perm(b2);
        }

        boolean valid() {
            for (int i = 0; i + 1 < arr.length; ++i) {
                if (arr[i] / S > arr[i + 1] / S)
                    return false;
            }
            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Perm perm = (Perm) o;
            return Arrays.equals(arr, perm.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; ++i) {
                sb.append(String.format("(%d, %d) ", arr[i] / S + 1, arr[i] % S + 1));
            }
            return sb.toString();
        }
    }

    public String solveCase() {
        R = nextInt();
        S = nextInt();
        Perm p0 = new Perm();
        Queue<Perm> q = new LinkedList<>();
        Map<Perm, String> mp = new HashMap<>();
        Map<Perm, Perm> mp1 = new HashMap<>();
        q.add(p0);
        mp.put(p0, null);
        while (!q.isEmpty()) {
            Perm p = q.poll();
//            pw.println(p);
            if (p.valid()) {
                List<String> ans = new ArrayList<>();
                while (p != null) {
                    String ss = mp.get(p);
                    if (ss != null)
                        ans.add(ss);
                    p = mp1.get(p);
                }
                StringBuilder s = new StringBuilder();
                s.append("" + ans.size() + "\n");
                for (int i = 0; i < ans.size(); ++i) {
                    s.append(ans.get(ans.size() - i - 1) + "\n");
                }
                return s.toString().trim();
            }
            for (int a = 1; a < R * S; ++a) {
                for (int b = 1; a + b <= R * S; ++b) {
                    Perm pi = p.mutate(a, b);
                    if (!mp.containsKey(pi)) {
                        q.add(pi);
                        mp.put(pi, String.format("%d %d", a, b));
                        mp1.put(pi, p);
                    }
                }
            }
        }
        return "NO";
    }

    public void solve() {
        int t = nextInt();
        for (int i = 0; i < t; ++i) {
            String ans = solveCase();
            pw.printf("Case #%d: %s\n", i + 1, ans);
        }
    }

    static final String filename = "A";
    static final boolean fromConsole = true;

    public void run() {
        try {
            if (!fromConsole) {
                in = new BufferedReader(new FileReader(filename + ".in"));
                pw = new PrintWriter(filename + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            long st = System.currentTimeMillis();
            solve();
            //pw.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - st);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    boolean hasNext() {
        try {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return st.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String next() {
        return hasNext() ? st.nextToken() : null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}