import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    static AbstractMap.SimpleEntry<List<Long>, Long> findCompetitors(int i, int j, int rows, int cols, long[][] map) {
        List<Long> competitors = new ArrayList<>();
        long sum = 0;

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

        // Check left
        for (int b = j - 1; b >= 0; --b) {
            if (map[i][b] != 0) {
                competitors.add(map[i][b]);
                sum += map[i][b];
                break;
            }
        }

        // Check right
        for (int b = j + 1; b < cols; ++b) {
            if (map[i][b] != 0) {
                competitors.add(map[i][b]);
                sum += map[i][b];
                break;
            }
        }

        return new AbstractMap.SimpleEntry<>(competitors, sum);
    }

    static long solve(int rows, int cols, long[][] map, int round) {
        long interestSum = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                interestSum += map[i][j];
            }
        }

        long[][] newMap = new long[rows][cols];
        boolean hasEliminations = false;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (map[i][j] == 0) continue;

                AbstractMap.SimpleEntry<List<Long>, Long> competitors = findCompetitors(i, j, rows, cols, map);
                if (competitors.getKey().isEmpty()) {
                    newMap[i][j] = map[i][j];
                    continue;
                }

                double averageCompetitorValue = (double) competitors.getValue() / competitors.getKey().size();
                if (averageCompetitorValue <= map[i][j]) {
                    newMap[i][j] = map[i][j];
                } else {
                    hasEliminations = true;
                }
            }
        }

        if (!hasEliminations) {
            return interestSum;
        }

        return interestSum + solve(rows, cols, newMap, round + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; ++t) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            long[][] map = new long[rows][cols];

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    map[i][j] = scanner.nextLong();
                }
            }

            long result = solve(rows, cols, map, 1);
            System.out.printf("Case #%d: %d%n", t, result);
        }

        scanner.close();
    }
}