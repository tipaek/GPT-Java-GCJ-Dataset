import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int size = Integer.parseInt(scanner.nextLine());
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] rowInput = scanner.nextLine().split(" ");
                boolean[] rowCheck = new boolean[101];

                for (int j = 0; j < size; j++) {
                    int value = Integer.parseInt(rowInput[j]);
                    matrix[i][j] = value;

                    if (rowCheck[value]) {
                        rowDuplicates++;
                        rowCheck[value] = false;  // Prevent double counting within the same row
                    } else {
                        rowCheck[value] = true;
                    }

                    if (i == j) {
                        trace += value;
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                boolean[] colCheck = new boolean[101];

                for (int i = 0; i < size; i++) {
                    int value = matrix[i][j];

                    if (colCheck[value]) {
                        colDuplicates++;
                        colCheck[value] = false;  // Prevent double counting within the same column
                    } else {
                        colCheck[value] = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}