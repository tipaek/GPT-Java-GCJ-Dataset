import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    static AbstractMap.SimpleEntry<List<Integer>, Integer> findCompetitors(int i, int j, int rows, int cols, int[][] map) {
        List<Integer> competitors = new ArrayList<>();
        int sum = 0;

        // Check upwards
        for (int a = i - 1; a >= 0; --a) {
            if (map[a][j] != 0) {
                competitors.add(map[a][j]);
                sum += map[a][j];
                break;
            }
        }

        // Check downwards
        for (int a = i + 1; a < rows; ++a) {
            if (map[a][j] != 0) {
                competitors.add(map[a][j]);
                sum += map[a][j];
                break;
            }
        }

        // Check leftwards
        for (int b = j - 1; b >= 0; --b) {
            if (map[i][b] != 0) {
                competitors.add(map[i][b]);
                sum += map[i][b];
                break;
            }
        }

        // Check rightwards
        for (int b = j + 1; b < cols; ++b) {
            if (map[i][b] != 0) {
                competitors.add(map[i][b]);
                sum += map[i][b];
                break;
            }
        }

        return new AbstractMap.SimpleEntry<>(competitors, sum);
    }

    static int solve(int rows, int cols, int[][] map, int round) {
        int interestRound = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                interestRound += map[i][j];
            }
        }

        int[][] newMap = new int[rows][cols];
        boolean eliminated = false;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (map[i][j] == 0) {
                    continue;
                }

                AbstractMap.SimpleEntry<List<Integer>, Integer> competitors = findCompetitors(i, j, rows, cols, map);
                if (competitors.getKey().isEmpty()) {
                    newMap[i][j] = map[i][j];
                    continue;
                }

                double average = (double) competitors.getValue() / competitors.getKey().size();
                if (average <= map[i][j]) {
                    newMap[i][j] = map[i][j];
                } else {
                    eliminated = true;
                }
            }
        }

        if (!eliminated) {
            return interestRound;
        }

        return interestRound + solve(rows, cols, newMap, round + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] map = new int[rows][cols];

            for (int row = 0; row < rows; ++row) {
                for (int col = 0; col < cols; ++col) {
                    map[row][col] = scanner.nextInt();
                }
            }

            int result = solve(rows, cols, map, 1);
            System.out.printf("Case #%d: %d%n", testCase, result);
        }

        scanner.close();
    }
}