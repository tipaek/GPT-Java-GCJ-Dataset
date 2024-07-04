import java.util.Scanner;

class Ques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int[][] A = new int[n][n];
            int sum = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }

            // Calculating the sum of the main diagonal
            for (int i = 0; i < n; i++) {
                sum += A[i][i];
            }

            System.out.print("Case #" + t + ": " + sum + " ");

            int maxRowRepeats = 0;
            int maxColRepeats = 0;

            // Check for row and column repeats
            for (int i = 0; i < n; i++) {
                int rowRepeats = 0;
                int colRepeats = 0;

                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    // Check row repeats
                    if (!rowSet.add(A[i][j])) {
                        rowRepeats++;
                    }

                    // Check column repeats
                    if (!colSet.add(A[j][i])) {
                        colRepeats++;
                    }
                }

                maxRowRepeats = Math.max(maxRowRepeats, rowRepeats);
                maxColRepeats = Math.max(maxColRepeats, colRepeats);
            }

            System.out.print(maxRowRepeats + " ");
            System.out.print(maxColRepeats + " ");
            System.out.println();

            t--;
        }

        scanner.close();
    }
}