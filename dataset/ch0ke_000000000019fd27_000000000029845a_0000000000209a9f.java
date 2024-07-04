import java.util.*;
import java.io.*;

class FastReader {
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


public class Solution {
    public static String addL(String str, int n, int pos) {
        String str2 = str;
        while (n-- != 0)
            str2 = str2.substring(0, pos) + "(" + str2.substring(pos);
        return str2;
    }

    public static String addR(String str, int n, int pos) {
        String str2 = str;
        while (n-- != 0)
            str2 = str2.substring(0, pos) + ")" + str2.substring(pos);
        return str2;
    }

    public static String addLast(String str, int n) {
        String str2 = str;
        while (n-- != 0)
            str2 += ")";
        return str2;
    }

    public static String solve(String str) {
        String S = str;
        int r = 0;
        int lDig = 0;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                int d = Character.getNumericValue(S.charAt(i));
                if (lDig < d) {
                    int n = d - lDig;
                    S = addL(S, n, i);
                    i += n;
                    if (d > r)
                        r += d - r;
                } else if (lDig > d) {
                    int n = lDig - d;
                    S = addR(S, n, i);
                    i += n;
                    r -= n;
                }
                lDig = d;
            }
        }
        S = addLast(S, r);
        return S;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            String S = in.nextLine();
            String S2 = solve(S);
            System.out.printf("Case #%d: %s\n", i, S2);
        }
    }
}
