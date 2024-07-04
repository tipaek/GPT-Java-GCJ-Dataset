import java.util.*;
import java.io.*;

public class Solution {
    static int n;

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        int T = sc.nextInt();
        n = sc.nextInt();

        for (int ca = 1; ca <= T; ca++) {
            int round = 0;
            int[] type = new int[n];
            int[] prev = new int[n];
            Arrays.fill(type, -1);
            Arrays.fill(prev, -1);
            List<Integer> same = new ArrayList<>();
            List<Integer> diff = new ArrayList<>();

            int index = 0;
            while (++round < 150 && index < n / 2) {
                if (round % 10 == 1 && round != 1) {
                    round++;
                    handlePeriodicQueries(sc, same, diff, prev, type);
                } else {
                    int query = (round % 2 == 1) ? n - index : index + 1;
                    System.out.println(query);
                    System.out.flush();
                    type[query - 1] = sc.nextInt();

                    if (round % 2 == 0) {
                        if (type[index] == type[n - index - 1]) {
                            same.add(index);
                        } else {
                            diff.add(index);
                        }
                        index++;
                    }
                }

                if (round % 10 == 0) {
                    System.arraycopy(type, 0, prev, 0, n);
                }
            }

            for (int e : type) {
                System.out.print(e);
            }
            System.out.println();
            System.out.flush();

            char ans = sc.next().charAt(0);
            if (ans == 'N') {
                return;
            }
        }
    }

    static void handlePeriodicQueries(FastScanner sc, List<Integer> same, List<Integer> diff, int[] prev, int[] type) throws IOException {
        if (!same.isEmpty() && !diff.isEmpty()) {
            int receivedSame = queryAndReceive(sc, same.get(0));
            int receivedDiff = queryAndReceive(sc, diff.get(0));

            if (isSame(receivedSame, prev, same.get(0))) {
                if (!isSame(receivedDiff, prev, diff.get(0))) {
                    reverse(type);
                }
            } else {
                if (isSame(receivedSame, prev, diff.get(0))) {
                    reverse(type);
                }
                complement(type);
            }
        } else {
            if (!same.isEmpty()) {
                int receivedSame = queryAndReceive(sc, same.get(0));
                if (!isSame(receivedSame, prev, same.get(0))) {
                    complement(type);
                }
            } else {
                int receivedDiff = queryAndReceive(sc, diff.get(0));
                if (!isSame(receivedDiff, prev, diff.get(0))) {
                    complement(type);
                }
            }
            System.out.println(1);
            System.out.flush();
            sc.nextInt();
        }
    }

    static int queryAndReceive(FastScanner sc, int index) throws IOException {
        int query = index + 1;
        System.out.println(query);
        System.out.flush();
        return sc.nextInt();
    }

    static boolean isSame(int newType, int[] prev, int index) {
        return newType == prev[index];
    }

    static void reverse(int[] type) {
        for (int i = 0; i < n / 2; i++) {
            int temp = type[i];
            type[i] = type[n - 1 - i];
            type[n - 1 - i] = temp;
        }
    }

    static void complement(int[] type) {
        for (int i = 0; i < n; i++) {
            type[i] = 1 - type[i];
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}