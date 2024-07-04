import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private static String vestigium(int[][] mtx) {
        int trace = 0;
        int N = mtx.length;
        int M = mtx.length;
        int rowCnt = 0, colCnt = 0;

        Set<Integer> rowSet;
        for (int r = 0; r < N; r++) {
            rowSet = new HashSet<>();
            for (int c = 0; c < M; c++) {
                if (rowSet.contains(mtx[r][c])) {
                    rowCnt += 1;
                    break;
                }
                rowSet.add(mtx[r][c]);
            }
        }

        Set<Integer> colSet;
        for (int c = 0; c < M; c++) {
            colSet = new HashSet<>();
            for (int r = 0; r < N; r++) {
                if (colSet.contains(mtx[r][c])) {
                    colCnt += 1;
                    break;
                }
                colSet.add(mtx[r][c]);
            }
        }

        for (int n = 0; n < N; n++) {
            trace += mtx[n][n];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(trace).append(" ").append(rowCnt).append(" ").append(colCnt);

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][][] cases = readInput();
        for (int i = 0; i < cases.length; i++) {
            String ans = vestigium(cases[i]);
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(i+1).append(": ").append(ans);
            System.out.println(sb.toString());
        }
    }
    private static int[][][] readInput() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); sc.nextLine();
        int[][][] cases = new int[3][][];

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); sc.nextLine();
            cases[t] = new int[N][N];
            for (int n = 0; n < N; n++) {
                String line = sc.nextLine();
                String[] toks = line.split(" ");
                for (int i = 0; i < toks.length; i++) {
                    cases[t][n][i] = Integer.parseInt(toks[i]);
                }
            }
        }
        return cases;
    }
}