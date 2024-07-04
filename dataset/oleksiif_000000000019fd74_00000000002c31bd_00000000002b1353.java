import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    
    private static final int S = 500;
    private static final int max = 50;
    private static long[][] pascal = new long[max][max];
    private static final int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        pascal[0][0] = 1;
        for (int i = 1; i < max; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            System.out.println(String.format("Case #%s:", caseIndex));
            List<int[]> result = new ArrayList<>();
            dfs(new int[]{0, 0}, new boolean[max][max], result, N);
            for (int [] point: result) {
                System.out.println((point[0] + 1) + " " + (point[1] + 1));
            }
        }
    }

    private static boolean dfs(int[] start, boolean[][] visited, List<int[]> result, long remainder) {
        if (remainder == 0) {
            return true;
        }
        if (result.size() > S) return false;
        if (remainder > 0) {
            visited[start[0]][start[1]] = true;
            result.add(start);
            for (int [] direction: directions) {
                int x = start[0] + direction[0];
                int y = start[1] + direction[1];
                if (x >= 0 && y >= 0 && x < max && y < max && pascal[x][y] != 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    if(dfs(new int[] {x, y}, visited, result, remainder - pascal[start[0]][start[1]])) {
                        return true;
                    }
                    visited[x][y] = false;
                }
            }
            result.remove(result.size()-1);
            return false;
        } else {
            return false;
        }
    }  
}