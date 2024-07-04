import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

    public static boolean overlap(int i, int[] si, int[] ei) {
        int n = si.length;
        for (int j = 0; j < n; j++) {
            if ((si[i] > si[j] && si[i] < ei[j]) || (ei[i] > si[j] && ei[i] < ei[j])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int T = input.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = input.nextInt();
            int[] si = new int[n];
            int[] ei = new int[n];
            ArrayList<Integer> c = new ArrayList<>();
            ArrayList<Integer> j = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                si[i] = input.nextInt();
                ei[i] = input.nextInt();
            }

            StringBuilder as = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (overlap(i, si, ei)) {
                    as.append("C");
                    c.add(i);
                } else {
                    as.append("J");
                    j.add(i);
                }
            }

            boolean impossible = false;

            for (int i = 0; i < c.size(); i++) {
                for (int k = 0; k < c.size(); k++) {
                    if (i != k && ((si[c.get(i)] > si[c.get(k)] && si[c.get(i)] < ei[c.get(k)])
                            || (ei[c.get(i)] > si[c.get(k)] && ei[c.get(i)] < ei[c.get(k)]))) {
                        impossible = true;
                        break;
                    }
                }
                if (impossible) break;
            }

            if (!impossible) {
                for (int i = 0; i < j.size(); i++) {
                    for (int k = 0; k < j.size(); k++) {
                        if (i != k && ((si[j.get(i)] > si[j.get(k)] && si[j.get(i)] < ei[j.get(k)])
                                || (ei[j.get(i)] > si[j.get(k)] && ei[j.get(i)] < ei[j.get(k)]))) {
                            impossible = true;
                            break;
                        }
                    }
                    if (impossible) break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + as.toString());
            }
        }
    }
}