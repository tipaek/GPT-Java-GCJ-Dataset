import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < N; i++) {
                diagonalSum += matrix[i][i];
            }

            System.out.print("Case #" + t + ": " + diagonalSum + " ");

            int maxRowDuplicates = 0;
            int maxColDuplicates = 0;

            for (int i = 0; i < N; i++) {
                maxRowDuplicates = Math.max(maxRowDuplicates, countDuplicates(matrix[i]));
            }

            for (int j = 0; j < N; j++) {
                int[] col = new int[N];
                for (int i = 0; i < N; i++) {
                    col[i] = matrix[i][j];
                }
                maxColDuplicates = Math.max(maxColDuplicates, countDuplicates(col));
            }

            System.out.print(maxRowDuplicates + " ");
            System.out.print(maxColDuplicates + " ");
            System.out.println();
        }

        scanner.close();
    }

    private static int countDuplicates(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxDuplicates = 0;
        for (int count : frequencyMap.values()) {
            if (count > 1) {
                maxDuplicates = Math.max(maxDuplicates, count - 1);
            }
        }

        return maxDuplicates;
    }
}