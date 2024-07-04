import java.util.*;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (T < 1 || T > 100) {
            System.out.println("1 <= T <= 100");
            return;
        }

        List<String> results = new ArrayList<>();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            if (N < 2 || N > 100) {
                System.out.println("2 <= N <= 100");
                return;
            }

            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (matrix[i][j] < 1 || matrix[i][j] > N) {
                        System.out.println("Input should be in the range of matrix size N");
                        return;
                    }
                }
            }

            int trace = calculateTrace(matrix, N);
            int repeatedRows = countRepeatedRows(matrix, N);
            int repeatedColumns = countRepeatedColumns(matrix, N);

            results.add("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countRepeatedColumns(int[][] matrix, int size) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}