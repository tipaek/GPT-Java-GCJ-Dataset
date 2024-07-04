import java.util.*;
import java.io.*;

public class Solution {
    private static List<int[]> possibilities;
    private static Set<Integer> possibilitiesHash;
    private static int N, K;
    private static int[][] solution;
    private static boolean possible;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int testCases = Integer.parseInt(in.readLine());
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(": ");

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
                if (possible) break;

                possible = true;
                solution = new int[N][N];
                for (int i = 0; i < N; i++) {
                    solution[i][i] = p[i];
                }

                for (int i = 0; i < N; i++) {
                    boolean[] used = new boolean[N + 1];
                    used[p[i]] = true;

                    possible = fillRowCol(i, 0, used);
                    if (!possible) break;
                }
            }

            if (!possible) {
                output.append("IMPOSSIBLE\n");
            } else {
                output.append("POSSIBLE\n");
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (j > 0) output.append(" ");
                        output.append(solution[i][j]);
                    }
                    output.append("\n");
                }
            }
        }

        out.print(output);
        in.close();
        out.close();
    }

    private static boolean fillRowCol(int r, int c, boolean[] used) {
        if (c == N) {
            return true;
        }

        if (r == c) {
            return fillRowCol(r, c + 1, used);
        }

        boolean[] tempUsed = used.clone();
        for (int _r = 0; _r < r; _r++) {
            tempUsed[solution[_r][c]] = true;
        }
        tempUsed[solution[c][c]] = true;

        for (int v = 1; v <= N; v++) {
            if (!tempUsed[v]) {
                used[v] = true;
                solution[r][c] = v;
                if (fillRowCol(r, c + 1, used)) {
                    return true;
                }
                used[v] = false;
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
        } else if (r > 0 && i < N) {
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
}