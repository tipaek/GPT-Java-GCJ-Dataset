import java.util.Scanner;

class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += arr[i][j];
                    }
                }
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                boolean foundDuplicate = false;
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[i][j] == arr[i][k]) {
                            rowDuplicates++;
                            foundDuplicate = true;
                            break;
                        }
                    }
                    if (foundDuplicate) break;
                }
            }

            // Check for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                boolean foundDuplicate = false;
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[j][i] == arr[k][i]) {
                            colDuplicates++;
                            foundDuplicate = true;
                            break;
                        }
                    }
                    if (foundDuplicate) break;
                }
            }

            System.out.println(diagonalSum + " " + rowDuplicates + " " + colDuplicates);
            t--;
        }
        sc.close();
    }
}