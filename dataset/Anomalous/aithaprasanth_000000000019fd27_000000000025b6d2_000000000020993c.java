import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testCase = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            int[][] matrix = new int[n][n];
            Map<String, Set<Integer>> map = new HashMap<>();
            int trace = 0;

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] numbers = line.split(" ");
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(numbers[j]);
                    matrix[i][j] = num;

                    if (i == j) {
                        trace += num;
                    }

                    map.computeIfAbsent("row" + i, k -> new HashSet<>()).add(num);
                    map.computeIfAbsent("col" + j, k -> new HashSet<>()).add(num);
                }
            }

            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (map.get("row" + i).size() != n) {
                    rowDuplicates++;
                }
            }

            int colDuplicates = 0;
            for (int j = 0; j < n; j++) {
                if (map.get("col" + j).size() != n) {
                    colDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase++, trace, rowDuplicates, colDuplicates);
        }

        scanner.close();
    }
}