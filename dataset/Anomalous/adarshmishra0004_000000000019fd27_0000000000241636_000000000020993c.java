import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt(); // number of test cases

        while (testCases > 0) {
            testCases--;
            int sum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int size = scanner.nextInt(); // size of the matrix

            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int element = scanner.nextInt();
                    if (element > 0 && element <= size) {
                        matrix[i][j] = element;
                    }

                    if (i == j) {
                        sum += matrix[i][j]; // sum of diagonal elements
                    }
                }
            }

            // Check for duplicates in rows
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (rowSet.contains(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                    rowSet.add(matrix[i][j]);
                }
            }

            // Check for duplicates in columns
            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (colSet.contains(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                    colSet.add(matrix[i][j]);
                }
            }

            System.out.println("Case " + (testCases + 1) + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}