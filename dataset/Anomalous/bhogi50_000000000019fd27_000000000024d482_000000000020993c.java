import java.util.ArrayList;
import java.util.Scanner;

class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(p);

            for (int row = 0; row < p; row++) {
                ArrayList<Integer> rowData = new ArrayList<>(p);
                for (int col = 0; col < p; col++) {
                    rowData.add(scanner.nextInt());
                }
                matrix.add(rowData);
            }

            int sum = 0;
            int duplicateRows = 0;

            // Calculate the sum of the diagonal elements
            for (int j = 0; j < p; j++) {
                sum += matrix.get(j).get(j);
            }

            // Check for duplicate elements in rows
            for (int row = 0; row < p; row++) {
                boolean hasDuplicates = false;
                for (int col = 0; col < p; col++) {
                    for (int innerCol = col + 1; innerCol < p; innerCol++) {
                        if (matrix.get(row).get(col).equals(matrix.get(row).get(innerCol))) {
                            duplicateRows++;
                            hasDuplicates = true;
                            break;
                        }
                    }
                    if (hasDuplicates) {
                        break;
                    }
                }
            }

            System.out.println(sum + " " + duplicateRows);
        }
        scanner.close();
    }
}