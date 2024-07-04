import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            int trace = 0, r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                    if (i == j)
                        trace += mat[i][j];
                }
            }
            outerRow: for (int row = 0; row < n; row++) {
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (mat[row][i] == mat[row][j]) {
                            r++;
                            continue outerRow;
                        }
                    }
                }
            }
            outerColumn: for (int col = 0; col < n; col++) {
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (mat[i][col] == mat[j][col]) {
                            c++;
                            continue outerColumn;
                        }
                    }
                }
            }
            System.out.println("CASE #" + test + ": " + trace + " " + r + " " + c);
        }
        sc.close();
    }
}