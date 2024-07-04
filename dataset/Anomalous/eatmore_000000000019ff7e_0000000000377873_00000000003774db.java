import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static void solve() throws Exception {
        String s1 = readString(), s2 = readString();
        int n1 = s1.length(), n2 = s2.length();
        int[][] minDist = new int[n1 + 1][n2 + 1];
        
        for (int i = 1; i <= n1; i++) {
            minDist[i][0] = i;
        }
        for (int i = 1; i <= n2; i++) {
            minDist[0][i] = i;
        }
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                minDist[i][j] = Math.min(Math.min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1), minDist[i - 1][j - 1] + cost);
            }
        }

        int p1 = n1, p2 = n2;
        int d1 = minDist[n1][n2] / 2, d2 = minDist[n1][n2] - d1;
        char[] result = new char[n1 + n2];
        int len = 0;
        
        while (p1 != 0 || p2 != 0) {
            if (p1 != 0 && minDist[p1][p2] == minDist[p1 - 1][p2] + 1) {
                --p1;
                if (d1 > 0) {
                    --d1;
                } else {
                    result[len++] = s1.charAt(p1);
                    --d2;
                }
            } else if (p2 != 0 && minDist[p1][p2] == minDist[p1][p2 - 1] + 1) {
                --p2;
                if (d2 > 0) {
                    --d2;
                } else {
                    result[len++] = s2.charAt(p2);
                    --d1;
                }
            } else {
                if (p1 != 0 && p2 != 0 && minDist[p1][p2] == minDist[p1 - 1][p2 - 1] && s1.charAt(p1 - 1) == s2.charAt(p2 - 1)) {
                    result[len++] = s1.charAt(p1 - 1);
                } else if (p1 != 0 && p2 != 0 && minDist[p1][p2] == minDist[p1 - 1][p2 - 1] + 1) {
                    if (d1 > 0) {
                        --d1;
                        result[len++] = s2.charAt(p2 - 1);
                    } else {
                        --d2;
                        result[len++] = s1.charAt(p1 - 1);
                    }
                } else {
                    throw new AssertionError();
                }
                --p1;
                --p2;
            }
        }

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            char temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        printCase();
        out.write(result, 0, len);
        out.println();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    static long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    static String readString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(input.readLine());
        }
        return tokenizer.nextToken();
    }

    static void printCase() {
        out.print("Case #" + testNumber + ": ");
    }

    static BufferedReader input;
    static PrintWriter out;
    static StringTokenizer tokenizer;
    static int testNumber;

    public static void main(String[] args) {
        try {
            input = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCases = readInt();
            for (testNumber = 1; testNumber <= testCases; testNumber++) {
                solve();
            }
            input.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}