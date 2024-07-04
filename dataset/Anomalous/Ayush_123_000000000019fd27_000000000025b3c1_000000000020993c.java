import java.util.Scanner;

class CJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] trace = new int[t];
        int[] rowRepeats = new int[t];
        int[] colRepeats = new int[t];

        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0, cr = 0, cc = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        sum += matrix[i][j];
                    }
                }
            }

            // Checking for repeated elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        cr++;
                        break;
                    }
                }
            }

            // Checking for repeated elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        cc++;
                        break;
                    }
                }
            }

            trace[l] = sum;
            rowRepeats[l] = cr;
            colRepeats[l] = cc;
        }

        // Output results
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + rowRepeats[i] + " " + colRepeats[i]);
        }
    }
}