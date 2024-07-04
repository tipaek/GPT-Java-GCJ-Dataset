import java.util.Scanner;

class Mine {

    public static void main(String[] args) {
        Mine my = new Mine(); 
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int k = 1; k <= T; k++) {
            int N = scan.nextInt();
            int sum = 0;
            int[][] matrix = new int[N][N];

            // Reading the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            // Calculating the sum of the diagonal elements
            for (int l = 0; l < N; l++) {
                sum += matrix[l][l];
            }

            System.out.println("Case #" + k + ": " + sum + "0 0");
        }

        scan.close();
    }
}