import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            String[] input = reader.readLine().split(" ");
            int size = Integer.parseInt(input[0]);
            int trace = Integer.parseInt(input[1]);

            map = new int[size][size];

            if (findSolution(map, 0, trace, 0, 0)) {
                System.out.println("Case #" + caseNum + ": POSSIBLE");
                printMap(map);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean findSolution(int[][] map, int currentSum, int targetTrace, int row, int col) {
        if (row == map.length && col == 0 && currentSum == targetTrace) {
            return true;
        }
        if (row == map.length) {
            return false;
        }

        for (int num = 1; num <= map.length; num++) {
            if (isValid(map, row, col, num)) {
                int newSum = (row == col) ? currentSum + num : currentSum;
                if (newSum <= targetTrace) {
                    map[row][col] = num;
                    if (col < map[0].length - 1) {
                        if (findSolution(map, newSum, targetTrace, row, col + 1)) {
                            return true;
                        }
                    } else {
                        if (findSolution(map, newSum, targetTrace, row + 1, 0)) {
                            return true;
                        }
                    }
                    map[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] map, int row, int col, int num) {
        for (int i = 0; i < map.length; i++) {
            if (map[row][i] == num || map[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static void printMap(int[][] map) {
        for (int[] row : map) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}