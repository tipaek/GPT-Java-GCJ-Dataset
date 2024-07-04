import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            int num = in.nextInt();
            List<int[]> res = getRes(num);
            System.out.println("Case #" + index + ": ");
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
            }
        }
    }

    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {-1, -1}, {1, 0}, {1, 1}};

    private static List<int[]> getRes(int val) {
        HashSet<Integer> visi = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        dfs(1, 1, val, list, visi);
        return list;
    }

    public static boolean dfs(int i, int j, long val, List<int[]> list, HashSet<Integer> visi) {
        if (val < getValue(i, j)) {
            return false;
        } else if (val == getValue(i, j)) {
            list.add(new int[]{i, j});
            return true;
        } else {
            list.add(new int[]{i, j});
            visi.add(getKey(i, j));
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                int key = getKey(ni, nj);
                if (visi.contains(key)) {
                    continue;
                }
                if (ni <= 0 || nj <= 0 || ni < nj || ni > 500) {
                    continue;
                }
                if (dfs(ni, nj, val - getValue(i, j), list, visi)) {
                    return true;
                }
            }
            visi.remove(getKey(i, j));
            list.remove(list.size() - 1);
        }
        return false;

    }

    public static int getKey(int i, int j) {

        return i * 501 + j;
    }

    private static int calValue(int row, int col) {
        int res = 1;
        if (col > row - col)
            col = row - col;
        for (int i = 0; i < col; ++i) {
            res *= (row - i);
            res /= (i + 1);
        }
        return res;
    }

    static long[][] pascalV = new long[501][501];

    public static long getValue(int i, int j) {
        if (pascalV[i][j] == 0) {
            pascalV[i][j] = calValue(i - 1, j - 1);
        }
        return pascalV[i][j];
    }
}