import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());
        
        for (int test = 1; test <= testcase; test++) {
            int N = Integer.parseInt(sc.nextLine());
            int[][] square = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] s = sc.nextLine().split("\\s");
                for (int j = 0; j < N; j++) {
                    square[i][j] = Integer.parseInt(s[j]);
                }
            }

            int k = calculateDiagonalSum(square);
            int r = countDuplicateRows(square);
            int c = countDuplicateColumns(square);
            System.out.printf("Case #%d: %d %d %d%n", test, k, r, c);
        }
        sc.close();
    }

    private static int countDuplicateColumns(int[][] square) {
        int count = 0;

        for (int j = 0; j < square.length; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < square.length; i++) {
                map.put(square[i][j], map.getOrDefault(square[i][j], 0) + 1);
            }
            if (map.values().stream().anyMatch(value -> value > 1)) {
                count++;
            }
        }

        return count;
    }

    private static int calculateDiagonalSum(int[][] square) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] square) {
        int count = 0;

        for (int[] row : square) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int value : row) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            if (map.values().stream().anyMatch(value -> value > 1)) {
                count++;
            }
        }

        return count;
    }
}