

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        outer:for (int t = 0; t < test; t++) {
            int[] nk = getArray(br.readLine());
            int n = nk[0];
            int k = nk[1];
            int[][][] solution = new int[1][n][n];
            int[][] cache = new int[n][n];
            for (int[] c : cache) {
                Arrays.fill(c, -1);
            }
            boolean[] success = new boolean[1];
            dfs(solution, cache, 0, 0, n, k, success);
            if(!success[0]){
                System.out.println("IMPOSSIBLE");
                continue outer;
            }
            for (int[] soln : solution[0]) {
                StringBuilder builder = new StringBuilder();
                for (int num : soln) {
                    builder.append(num + " ");
                }
                System.out.println(builder.toString().trim());
            }
        }


    }

    private static void dfs(int[][][] solution, int[][] cache, int row, int col, int n, int k, boolean[] flag) {
        if (col == n) {
            row++;
            col = 0;
        }
        if (row == n) {
            int trace = 0;
            for (int index = 0; index < n; index++) {
                trace += cache[index][index];
            }
            if (trace == k) {
                solution[0] = cache;
                flag[0] = true;
            }
            return;
        }
        int[] repeatedElement = new int[n + 1];
        for (int index = 0; index < col; index++) {
            repeatedElement[cache[row][index]]++;
        }
        for (int index = 0; index < row; index++) {
            repeatedElement[cache[index][col]]++;
        }
        for (int tempNum = 1; tempNum <= n; tempNum++) {
            if (repeatedElement[tempNum]==0) {
                cache[row][col] = tempNum;
                dfs(solution, cache, row, col + 1, n, k, flag);
                if (flag[0]) {
                    return;
                }
            }
        }
    }

    private static int[] getArray(String line) {
        String[] s = line.split(" ");
        int[] array = new int[s.length];
        int index = 0;
        for (String temp : s) {
            array[index++] = Integer.parseInt(temp);
        }
        return array;
    }
}
