import java.io.*;
import java.util.*;

class Solution {
    static class Reader {
        private BufferedReader br;
        private StringTokenizer st;
        private BufferedWriter bw;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        void print(String s) {
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(String s) {
            try {
                bw.write(s + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void close() {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static int getLength(int x) {
        return Integer.toString(x).length();
    }

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int q = reader.nextInt();

        for (int itr = 1; itr <= q; ++itr) {
            reader.print("Case #" + itr + ": ");
            int u = reader.nextInt();
            int[] a = new int[26];
            char[] ans = new char[10];
            Arrays.fill(a, Integer.MAX_VALUE);

            for (int i = 0; i < 10000; ++i) {
                int m = reader.nextInt();
                char[] ch = reader.next().toCharArray();

                if (m == -1) continue;

                int n = ch.length;
                String[] M = Integer.toString(m).split("");
                int k = M.length;

                if (k == n) {
                    int p = ch[0] - 'A';
                    int x = Integer.parseInt(M[0]);
                    a[p] = Math.min(a[p], x);
                    int prev = x;

                    for (int j = 1; j < n; ++j) {
                        p = ch[j] - 'A';
                        x = Integer.parseInt(M[j]);
                        if ((j == 1 && prev == 1) || (prev == 0)) {
                            a[p] = Math.min(a[p], x);
                        } else {
                            a[p] = Math.min(a[p], 9);
                        }
                        prev = a[p];
                    }
                } else {
                    for (char c : ch) {
                        int p = c - 'A';
                        a[p] = Math.min(a[p], 9);
                    }
                }
            }

            for (int i = 0; i < 26; ++i) {
                if (a[i] != Integer.MAX_VALUE) {
                    ans[a[i]] = (char) (i + 'A');
                }
            }

            for (char c : ans) {
                reader.print(c + "");
            }
            reader.println("");
        }
        reader.close();
    }
}