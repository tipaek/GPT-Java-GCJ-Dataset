import java.io.*;
import java.util.*;

public class Solution {
    static int T, N, C;
    int[] numFound, currPen, toTest;
    int[][] numUsed;
    boolean[] successful;

    Solution(BufferedReader in, PrintWriter out) throws IOException {
        numUsed = new int[T][15];
        numFound = new int[T];
        currPen = new int[T];
        toTest = new int[T];
        successful = new boolean[T];

        boolean nonzero;
        while (true) {
            nonzero = false;
            // Decide pens to test
            for (int i = 0; i < T; i++) {
                if (currPen[i] != N && numFound[i] < 3 && numUsed[i][currPen[i]] >= 3) {
                    // Move on (used too many times)
                    currPen[i]++;
                }
                if (currPen[i] == N || numFound[i] >= 3) toTest[i] = -1;
                else {
                    nonzero = true;
                    toTest[i] = currPen[i];
                }
            }

            for (int i = 0; i < T; i++) {
                if (i != 0) out.print(' ');
                out.print(toTest[i] + 1);
            }
            out.println();
            out.flush();

            if (!nonzero) break;

            // Read results
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < T; i++) successful[i] = st.nextToken().charAt(0) == '1';

            for (int i = 0; i < T; i++) {
                if (toTest[i] == -1) continue;
                if (successful[i]) {
                    numUsed[i][toTest[i]]++;
                } else {
                    // Found bad pen
                    numUsed[i][toTest[i]] = -1;
                    numFound[i]++;
                    currPen[i]++;
                }
            }
        }

        // Guess pens
        int[][] toGuess = new int[T][2];
        for (int i = 0; i < T; i++) {
            int numGuessed = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (numUsed[i][j] != -1) {
                    toGuess[i][numGuessed++] = j;
                    if (numGuessed == 2) break;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            if (i != 0) out.print(' ');
            out.printf("%d %d", toGuess[i][0] + 1, toGuess[i][1] + 1);
        }
        out.println();
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        new Solution(in, out);
        in.close();
        out.close();
    }
}
