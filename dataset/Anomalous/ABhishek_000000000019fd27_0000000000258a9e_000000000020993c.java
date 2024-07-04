import java.util.Scanner;

class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int k = 0; k < T; k++) {
            int N = sc.nextInt();
            int r = 0;
            int c = 0;
            int count = 0;

            int[][] M = new int[N][N];

            // Reading the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }

            // Counting the diagonal elements
            for (int i = 0; i < N; i++) {
                count += M[i][i];
            }

            // Checking for consecutive equal elements in rows and columns
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if (M[i][j] == M[i][j + 1]) {
                        c++;
                    }
                    if (M[j][i] == M[j + 1][i]) {
                        r++;
                    }
                }
            }

            System.out.println("Case #" + (k + 1) + ": " + count + " " + r + " " + c);
        }
    }
}