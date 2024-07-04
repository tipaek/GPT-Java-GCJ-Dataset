import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int a = 0; a < t; a++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int dia = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
                dia += arr[i][i];
            }

            int c = 0, r = 0;

            // Checking for duplicate values in rows and columns
            for (int i = 0; i < n; i++) {
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (!rowDuplicate && arr[i][j] == arr[i][k]) {
                            c++;
                            rowDuplicate = true;
                        }
                        if (!colDuplicate && arr[j][i] == arr[k][i]) {
                            r++;
                            colDuplicate = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + (a + 1) + ": " + dia + " " + c + " " + r);
        }
    }
}