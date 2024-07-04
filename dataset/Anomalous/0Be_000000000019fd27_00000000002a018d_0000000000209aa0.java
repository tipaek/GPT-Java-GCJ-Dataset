import java.util.*;
import java.io.*;

public class Solution {
    private static List<int[]> possibilities;
    private static Set<Integer> possibilitiesHash;
    private static int N, K;
    private static int[][] solution;
    private static boolean possible;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int TT = Integer.parseInt(in.readLine());
        StringBuilder output = new StringBuilder();

        for (int currTT = 1; currTT <= TT; currTT++) {
            output.append("Case #").append(currTT).append(": ");

            String[] input = in.readLine().split("\\s+");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);

            possibilities = new ArrayList<>();
            possibilitiesHash = new HashSet<>();

            int max = Math.min(N, K / 2);
            for (int i = 1; i <= max; i++) {
                int[] used = new int[N];
                used[0] = i;
                findPossibilities(1, K - i, used);
            }

            possible = false;
            for (int[] p : possibilities) {
                solution = new int[N][N];
                for (int i = 0; i < N; i++) {
                    solution[i][i] = p[i];
                }

                boolean[][] usedR = new boolean[N][N + 1];
                boolean[][] usedC = new boolean[N][N + 1];
                for (int i = 0; i < N; i++) {
                    usedR[i][p[i]] = true;
                    usedC[i][p[i]] = true;
                }

                if (fill(0, 0, usedR, usedC)) {
                    possible = true;
                    break;
                }
            }

            if (!possible) {
                output.append("IMPOSSIBLE\n");
            } else {
                output.append("POSSIBLE\n");
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - 1; j++) {
                        output.append(solution[i][j]).append(" ");
                    }
                    output.append(solution[i][N - 1]).append("\n");
                }
            }
        }

        out.print(output);
        in.close();
        out.close();
    }

    private static boolean fill(int r, int c, boolean[][] usedR, boolean[][] usedC) {
        if (r == N) {
            return true;
        }
        if (c == N) {
            return fill(r + 1, 0, usedR, usedC);
        }
        if (r == c) {
            return fill(r, c + 1, usedR, usedC);
        }

        for (int v = 1; v <= N; v++) {
            if (!usedR[r][v] && !usedC[c][v]) {
                usedR[r][v] = true;
                usedC[c][v] = true;
                solution[r][c] = v;
                if (fill(r, c + 1, usedR, usedC)) {
                    return true;
                }
                usedR[r][v] = false;
                usedC[c][v] = false;
                solution[r][c] = 0;
            }
        }
        return false;
    }

    private static void findPossibilities(int i, int r, int[] used) {
        if (r == 0 && i == N) {
            int[] newPossibility = used.clone();
            Arrays.sort(newPossibility);
            int hash = Arrays.hashCode(newPossibility);
            if (!possibilitiesHash.contains(hash)) {
                possibilitiesHash.add(hash);
                possibilities.add(newPossibility);
            }
            return;
        } else if (r == 0 || i == N) {
            return;
        }

        int max = Math.min(N, r);
        for (int j = 1; j <= max; j++) {
            if (r - j >= 0) {
                used[i] = j;
                findPossibilities(i + 1, r - j, used);
                used[i] = 0;
            }
        }
    }
}