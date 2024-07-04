import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        
        while (testcases > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            
            int m = 0;
            // Checking for duplicate columns
            for (int i = 0; i < n; i++) {
                int c = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (a[j][i] == a[k][i]) {
                            c++;
                        }
                    }
                }
                if (c > n) {
                    m++;
                }
            }
            
            int con = 0;
            // Checking for duplicate rows
            for (int i = 0; i < n; i++) {
                int c = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (a[i][j] == a[i][k]) {
                            c++;
                        }
                    }
                }
                if (c > n) {
                    con++;
                }
            }
            
            // Calculating the sum of the diagonal
            int t = 0;
            for (int i = 0; i < n; i++) {
                t += a[i][i];
            }
            
            // Printing the results
            System.out.println("case #" + testcases + ": " + t + " " + m + " " + con);
            testcases--;
        }
    }
}