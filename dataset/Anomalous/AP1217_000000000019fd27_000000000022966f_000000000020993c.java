import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        ArrayList<Integer[][]> matrices = new ArrayList<>();

        for (int t = 0; t < testCase; t++) {
            int size = Integer.parseInt(sc.nextLine());
            Integer[][] matrix = new Integer[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = sc.nextInt();
                }
                if (sc.hasNextLine()) {
                    sc.nextLine(); // Consume the newline character after each row
                }
            }
            matrices.add(matrix);
        }

        for (int i = 0; i < matrices.size(); i++) {
            Integer[][] matrix = matrices.get(i);

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculate the trace
            for (int j = 0; j < matrix.length; j++) {
                trace += matrix[j][j];
            }

            // Calculate row repetitions
            for (int row = 0; row < matrix.length; row++) {
                Set<Integer> seen = new HashSet<>();
                for (int col = 0; col < matrix[row].length; col++) {
                    if (!seen.add(matrix[row][col])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Calculate column repetitions
            for (int col = 0; col < matrix[0].length; col++) {
                Set<Integer> seen = new HashSet<>();
                for (int row = 0; row < matrix.length; row++) {
                    if (!seen.add(matrix[row][col])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        sc.close();
    }
}