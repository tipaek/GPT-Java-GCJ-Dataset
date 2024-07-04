import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
    private Scanner sc = new Scanner(System.in);
    private PrintWriter pw = new PrintWriter(System.out);

    int ask(int pos) {
        pw.println(pos);
        pw.flush();
        int value = sc.nextInt();
        return value;
    }

    int[] solve(int b) {
        int[] vals = new int[b + 1];
        boolean[] same = new boolean[b + 1];

        // 100
        int firstS = -1;
        int firstC = -1;
        for (int i = 1; i <= b / 2; i++) {
            vals[i] = ask(i);
            vals[b + 1 - i] = ask(b + 1 - i);

            same[i] = (vals[b + 1 - i] == vals[i]);
            if (same[i] && firstS == -1) {
                firstS = i;
            } else if ((!same[i]) && firstC == -1){
                firstC = i;
            }
        }

        // 10
        int[] valsS = new int[b + 1];
        Arrays.fill(valsS, 2);
        if (firstS > 0) {
            int nQueries = 0;
            for (int i = 1; i <= b / 2; i++) {
                if (same[i]) {
                    valsS[i] = ask(i);
                    nQueries++;
                    i = 5 * ((i - 1) / 5) + 5;
                }
            }

            for (int i = 0; i < 10 - nQueries; i++) {
                ask(firstS);
            }
        }

        // 10
        int[] valsC = new int[b + 1];
        Arrays.fill(valsC, 2);
        if (firstC > 0) {
            int nQueries = 0;
            for (int i = 1; i <= b / 2; i++) {
                if (!same[i]) {
                    valsC[i] = ask(i);
                    nQueries++;
                    i = 5 * ((i - 1) / 5) + 5;
                }
            }

            for (int i = 0; i < 10 - nQueries; i++) {
                ask(firstC);
            }
        }

        int[] crtVals = new int[b + 1];
        if (firstS > 0) {
            crtVals[firstS] = ask(firstS);
        }
        if (firstC > 0) {
            crtVals[firstC] = ask(firstC);
        }

        for (int i = 1; i <= b / 2; i++) {
            if (same[i]) {
                boolean equalsFirst;
                if (valsS[i] != 2) {
                    equalsFirst = valsS[i] == valsS[firstS];
                } else {
                    int j = i;
                    while (true) {
                        j--;
                        if (valsS[j] != 2) {
                            equalsFirst = (valsS[j] == valsS[firstS]) == (vals[j] == vals[i]);
                            break;
                        }
                    }
                }

                if (equalsFirst) {
                    crtVals[i] = crtVals[firstS];
                } else {
                    crtVals[i] = 1 - crtVals[firstS];
                }
                crtVals[b + 1 - i] = crtVals[i];
            } else {
                boolean equalsFirst;
                if (valsC[i] != 2) {
                    equalsFirst = valsC[i] == valsC[firstC];
                } else {
                    int j = i;
                    while (true) {
                        j--;
                        if (valsC[j] != 2) {
                            equalsFirst = (valsC[j] == valsC[firstC]) == (vals[j] == vals[i]);
                            break;
                        }
                    }
                }

                if (equalsFirst) {
                    crtVals[i] = crtVals[firstC];
                } else {
                    crtVals[i] = 1 - crtVals[firstC];
                }
                crtVals[b + 1 - i] = 1 - crtVals[i];
            }
        }

        return crtVals;
    }

    private void solveTest(int b) {
        int[] vals = solve(b);

        for (int i = 1; i <= b; i++) {
            pw.print(vals[i]);
        }
        pw.println();
        pw.flush();

        char c = sc.next().charAt(0);
        if (c != 'Y' && c != 'y') {
            System.exit(0);
        }
    }

    private void run() {
        int nTests = sc.nextInt();
        int b = sc.nextInt();

        for (int test = 1; test <= nTests; test++) {
            solveTest(b);
        }

        pw.close();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.run();
    }
}
