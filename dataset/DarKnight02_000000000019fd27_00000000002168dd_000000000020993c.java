import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static boolean areDistinct(Integer arr[]) {
        Set<Integer> s = new HashSet<>(Arrays.asList(arr));
        return (s.size() == arr.length);
    }

    public static int countIdenticalRows(Integer mat[][]) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            if (!areDistinct(mat[i])) {
                count++;
            }
        }
        return count;
    }

    static Integer[][] rotateMatrix(int N, Integer mat[][]) {
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N - 1 - x];
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
                mat[N - 1 - y][x] = temp;
            }
        }
        return mat;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(next());
            Integer[][] grid = new Integer[N][N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(next());
                    grid[i][j] = num;
                    if (i == j) {
                        sum += num;
                    }
                }
            }
            int r = countIdenticalRows(grid);
            int c = countIdenticalRows(rotateMatrix(N, grid));
            System.out.println("Case #" + t + ": " + sum + " " + r + " " + c);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}
