import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

     public static int [] parseTokens(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());
       for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            int [] [] arr = new int [n][n];
            for (int x = 0; x < n; x++) {
                arr[x] = parseTokens(br.readLine());
            }
            solve(i, arr);
        }
    }

    private static void solve(int i, int[][] arr) {
        int n = arr.length;
        int trace = 0;
        for (int j = 0; j < n; j++) {
            trace += arr[j][j];
        }

        int row = 0;
        for (int x = 0; x < n; x++) {
            Set<Integer> count = new HashSet<>();
            for (int y = 0; y < n; y++) {
                count.add(arr[x][y]);
            }
            if (count.size() < n) {
                row++;
            }
        }

        int col = 0;
        for (int x = 0; x < n; x++) {
            Set<Integer> count = new HashSet<>();
            for (int y = 0; y < n; y++) {
                count.add(arr[y][x]);
            }
            if (count.size() < n) {
                col++;
            }
        }

        System.out.println(String.format("Case #%d: %d %d %d", i, trace, row, col));
    }
}