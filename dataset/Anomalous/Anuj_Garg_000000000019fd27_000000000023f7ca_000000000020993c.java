import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class UniqueMatrix {
    static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(reader.readLine());
        if (t < 0 || t >= 101) {
            System.exit(0);
        }

        int caseNumber = 1;
        while (t > 0) {
            int n = Integer.parseInt(reader.readLine());
            if (n <= 1 || n >= 101) {
                System.exit(0);
            }

            int[][] matrix = new int[n][n];
            int sum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                    if (i == j) {
                        sum += matrix[i][j];
                    }
                }
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            for (int i = 0; i < n; i++) {
                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }

            System.out.println("case#" + caseNumber + ": " + sum + " " + rowDuplicates + " " + columnDuplicates);
            t--;
            caseNumber++;
        }
    }
}