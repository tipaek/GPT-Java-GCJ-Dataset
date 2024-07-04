import java.util.Scanner;

class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int diagonalSum = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and calculate the sum of the diagonal elements
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += arr[i][j];
                    }
                }
            }

            // Check for duplicates in each row
            for (int i = 0; i < n; i++) {
                boolean foundDuplicate = false;
                for (int j = 0; j < n - 1 && !foundDuplicate; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[i][j] == arr[i][k]) {
                            rowDuplicates++;
                            foundDuplicate = true;
                            break;
                        }
                    }
                }
            }

            // Check for duplicates in each column
            for (int i = 0; i < n; i++) {
                boolean foundDuplicate = false;
                for (int j = 0; j < n - 1 && !foundDuplicate; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[j][i] == arr[k][i]) {
                            colDuplicates++;
                            foundDuplicate = true;
                            break;
                        }
                    }
                }
            }

            System.out.println(diagonalSum + " " + rowDuplicates + " " + colDuplicates);
            t--;
        }
    }
}