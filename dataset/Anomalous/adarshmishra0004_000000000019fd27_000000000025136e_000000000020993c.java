import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int element = scanner.nextInt();
                    if (element > 0 && element <= size) {
                        matrix[i][j] = element;
                    }
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = countRowDuplicates(matrix, size);
            int columnDuplicates = countColumnDuplicates(matrix, size);

            System.out.printf("case %d: %d %d %d%n", caseNumber, diagonalSum, rowDuplicates, columnDuplicates);
        }
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> seenElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seenElements.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;

        for (int j = 0; j < size; j++) {
            Set<Integer> seenElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!seenElements.add(matrix[i][j])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }
}