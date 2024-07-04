import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testCase = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            scanner.nextLine(); // Consume the newline character

            int trace = 0;
            Map<String, Set<Integer>> rowMap = new HashMap<>();
            Map<String, Set<Integer>> colMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(line[j]);
                    matrix[i][j] = num;

                    if (i == j) {
                        trace += num;
                    }

                    rowMap.computeIfAbsent("row" + i, k -> new HashSet<>()).add(num);
                    colMap.computeIfAbsent("col" + j, k -> new HashSet<>()).add(num);
                }
            }

            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (rowMap.get("row" + i).size() != n) {
                    rowDuplicates++;
                }
            }

            int colDuplicates = 0;
            for (int j = 0; j < n; j++) {
                if (colMap.get("col" + j).size() != n) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            testCase++;
        }

        scanner.close();
    }
}