import java.util.Scanner;

class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= tests; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] inputMatrix = new int[N][N];

            for (int j = 0; j < N; j++) {
                String[] elems = scanner.nextLine().split("\\s+");
                for (int col = 0; col < N; col++) {
                    inputMatrix[j][col] = Integer.parseInt(elems[col]);
                }
            }

            analyzeMatrix(inputMatrix, N, i);
        }

        scanner.close();
    }

    private static void analyzeMatrix(int[][] matrix, int size, int caseNo) {
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                rowCount++;
            }
        }

        for (int i = 0; i < size; i++) {
            int[] col = new int[size];
            for (int j = 0; j < size; j++) {
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(col)) {
                colCount++;
            }
        }

        System.out.println("Case #" + caseNo + ": " + trace + " " + rowCount + " " + colCount);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}