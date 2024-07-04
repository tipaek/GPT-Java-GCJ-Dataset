import java.util.*;
import java.io.*;

public class Solution {
    static final long LINF = Long.MAX_VALUE / 4;
    static final int IINF = Integer.MAX_VALUE / 4;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            sb.append("Case #").append(t).append(": ");
            int N = sc.nextInt();
            char[][] input = new char[N][];
            int maxLength = 0;

            for (int i = 0; i < N; i++) {
                input[i] = sc.next().toCharArray();
                maxLength = Math.max(maxLength, input[i].length);
            }

            int[] firstAst = new int[N];
            Arrays.fill(firstAst, IINF);
            int[] lastAst = new int[N];
            Arrays.fill(lastAst, -1);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < input[i].length; j++) {
                    if (input[i][j] == '*') {
                        firstAst[i] = Math.min(firstAst[i], j);
                        lastAst[i] = Math.max(lastAst[i], j);
                    }
                }
            }

            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            StringBuilder middle = new StringBuilder();

            if (!processSegment(input, firstAst, maxLength, prefix, true) || 
                !processSegment(input, lastAst, maxLength, suffix, false)) {
                sb.append("*\n");
                continue;
            }

            for (int i = 0; i < N; i++) {
                for (int j = firstAst[i]; j < lastAst[i]; j++) {
                    if (input[i][j] != '*') {
                        middle.append(input[i][j]);
                    }
                }
            }

            sb.append(prefix).append(middle).append(suffix.reverse()).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean processSegment(char[][] input, int[] astPos, int maxLength, StringBuilder result, boolean isPrefix) {
        for (int j = 0; j < maxLength; j++) {
            boolean found = false;
            char c = '-';
            for (int i = 0; i < input.length; i++) {
                int index = isPrefix ? j : input[i].length - 1 - j;
                if (index >= 0 && index < input[i].length && (isPrefix ? index < astPos[i] : index > astPos[i])) {
                    if (!found) {
                        found = true;
                        c = input[i][index];
                    }
                    if (input[i][index] != c) {
                        return false;
                    }
                }
            }
            if (found) {
                result.append(c);
            }
        }
        return true;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
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

        String readNextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }
    }
}