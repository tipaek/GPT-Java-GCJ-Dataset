import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Solution {
    static long LINF = Long.MAX_VALUE / 4;
    static int IINF = Integer.MAX_VALUE / 4;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        _case:
        for (int t = 1; t <= T; t++) {
            StringBuilder b = new StringBuilder();
            sb.append("Case #" + t + ": ");
            int N = sc.nextInt();
            char[][] input = new char[N][];
            int maxLength = 0;
            for (int i = 0; i < N; i++) {
                input[i] = sc.next().toCharArray();
                maxLength = max(maxLength, input[i].length);
            }
            int[] firstAst = new int[N];
            Arrays.fill(firstAst, IINF);
            int[] lastAst = new int[N];
            Arrays.fill(lastAst, -1);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < input[i].length; j++) {
                    if (input[i][j] == '*') {
                        firstAst[i] = min(firstAst[i], j);
                        lastAst[i] = max(lastAst[i], j);
                    }
                }
            }
            for (int j = 0; j < maxLength; j++) {
                boolean found = false;
                char c = '-';
                boolean works = true;
                for (int i = 0; i < N; i++) {
                    int index = j;
                    if ( index >= 0 && index < input[i].length && index < firstAst[i]) {
                        if (!found) {
                            found = true;
                            c = input[i][index];
                        }
                        if (input[i][index] != c) {
                            sad(sb);
                            continue _case;
                        }
                    }
                } // end each string
                if (found)
                    b.append(c);
            }
            StringBuilder b2 = new StringBuilder();
            for (int j = 0; j < maxLength; j++) { // from the back of the string
                boolean found = false;
                char c = '-';
                boolean works = true;
                for (int i = 0; i < N; i++) {
                    int index = input[i].length - 1 - j;
                    if ( index >= 0 && index < input[i].length && index > lastAst[i]) {
                        if (!found) {
                            found = true;
                            c = input[i][index];
                        }
                        if (input[i][index] != c) {
                            sad(sb);
                            continue _case;
                        }
                    }
                } // end each string
                if (found)
                    b2.append(c);
            }

            StringBuilder b3 = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = firstAst[i]; j < lastAst[i]; j++) {
                    if (input[i][j] != '*') {
                        b3.append(input[i][j]);
                    }
                }
            }
            sb.append(b).append(b3).append(b2.reverse());
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void sad(StringBuilder sb) {
        sb.append("*\n");
    }

    static void Assert(boolean b) {
        if (!b) throw new Error("Assertion Failed");
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
            this(new InputStreamReader(System.in));
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
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}
/*
4
3
ADDS*SDFSDFKLJSD
*FFDJHF
ADDSDJFKD*DFSDSDF
3
ADasdfDS*SDFSDFKLJSD
*FFDJHF
ADDSDJFKD*DFSDSDF
3
*aba*
cra*b*y
cra*flaksdfjsdf*sty
4
aaaa*aaa*aaa*aa
aaaaclassy*asdf*classyaa
aaaaclassy*classyaa
aaaaclassy**********classyaa
 */


/*
Case #1: ADDSDJFKD
Case #2: *
 */








