import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] input = new int[t][2];

        for (int i = 0; i < t; i++) {
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            int n = input[i][0];
            int m = input[i][1];
            System.out.println("Case #" + (i + 1) + ": " + solveCase(n, m));
        }
    }

    private static String solveCase(int n, int m) {
        if (m < n || n * n < m) {
            return "IMPOSSIBLE";
        }

        int[][] matrix = new int[n][n];
        int num = m / n;
        int remainder = m % n;

        if (remainder == 0) {
            for (int j = 0; j < n; j++) {
                matrix[j][j] = num;
            }
        } else {
            List<Integer> numList = new ArrayList<>();
            for (int u = 1; u <= n; u++) {
                numList.add(u);
            }

            int sum = numList.stream().mapToInt(Integer::intValue).sum();
            if (sum != m) {
                adjustNumList(numList, sum, m, n);
            }

            Collections.sort(numList, Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                matrix[j][j] = numList.get(j);
            }
        }

        if (isImpossible(matrix, n)) {
            return "IMPOSSIBLE";
        }

        fillMatrix(matrix, n);
        return formatMatrix(matrix);
    }

    private static void adjustNumList(List<Integer> numList, int sum, int target, int n) {
        if (sum > target) {
            int index = n - 1;
            while (sum != target) {
                if (numList.get(index) - 1 > 0) {
                    numList.set(index, numList.get(index) - 1);
                    sum = numList.stream().mapToInt(Integer::intValue).sum();
                }
                index = (index - 1 + n) % n;
            }
        } else {
            int index = 0;
            while (sum != target) {
                if (numList.get(index) + 1 <= n) {
                    numList.set(index, numList.get(index) + 1);
                    sum = numList.stream().mapToInt(Integer::intValue).sum();
                }
                index = (index + 1) % n;
            }
        }
    }

    private static boolean isImpossible(int[][] matrix, int n) {
        Set<Integer> uniqueValues = new HashSet<>();
        for (int j = 0; j < n; j++) {
            uniqueValues.add(matrix[j][j]);
        }
        return uniqueValues.size() != 1 && (n - (uniqueValues.size() + 1)) >= (n % 2 == 0 ? n / 2 : n / 2 + 1);
    }

    private static void fillMatrix(int[][] matrix, int n) {
        for (int j = 0; j < n; j++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j == j2 || matrix[j][j2] != 0) continue;

                List<Integer> availableNumbers = new ArrayList<>();
                for (int k = 1; k <= n; k++) {
                    availableNumbers.add(k);
                }

                for (int k = 0; k < n; k++) {
                    availableNumbers.remove((Integer) matrix[j][k]);
                    availableNumbers.remove((Integer) matrix[k][j2]);
                }

                if (availableNumbers.isEmpty()) {
                    throw new IllegalStateException("IMPOSSIBLE");
                }

                matrix[j][j2] = availableNumbers.get(0);
            }
        }
    }

    private static String formatMatrix(int[][] matrix) {
        StringBuilder result = new StringBuilder("POSSIBLE\n");
        for (int[] row : matrix) {
            for (int val : row) {
                result.append(val).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}