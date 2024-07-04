import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, n);
            System.out.print(diagonalSum + " ");

            String rowOccurrences = calculateOccurrences(matrix, n, true);
            String colOccurrences = calculateOccurrences(matrix, n, false);

            int maxRowOccurrences = findMaxOccurrences(rowOccurrences);
            int maxColOccurrences = findMaxOccurrences(colOccurrences);

            System.out.print(maxRowOccurrences + " ");
            System.out.print(maxColOccurrences + " ");
            System.out.println();

            t--;
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static String calculateOccurrences(int[][] matrix, int n, boolean isRow) {
        StringBuilder occurrences = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                int count = 0;

                for (int k = 0; k < n; k++) {
                    if (isRow && value == matrix[i][k]) {
                        count++;
                    } else if (!isRow && value == matrix[k][j]) {
                        count++;
                    }
                }
                occurrences.append(count);
            }
        }

        return occurrences.toString();
    }

    private static int findMaxOccurrences(String occurrences) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < occurrences.length(); i++) {
            int count = Character.getNumericValue(occurrences.charAt(i));
            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}