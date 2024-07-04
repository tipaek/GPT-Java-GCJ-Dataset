import java.util.Scanner;

class Codejam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            
            // Reading the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += arr[i][i];
            }
            
            // Counting rows with repeated values
            int rowCount = 0;
            for (int i = 0; i < N; i++) {
                int[] rowCheck = new int[N + 1];
                for (int j = 0; j < N; j++) {
                    rowCheck[arr[i][j]]++;
                    if (rowCheck[arr[i][j]] > 1) {
                        rowCount++;
                        break;
                    }
                }
            }
            
            // Counting columns with repeated values
            int colCount = 0;
            for (int i = 0; i < N; i++) {
                int[] colCheck = new int[N + 1];
                for (int j = 0; j < N; j++) {
                    colCheck[arr[j][i]]++;
                    if (colCheck[arr[j][i]] > 1) {
                        colCount++;
                        break;
                    }
                }
            }
            
            // Printing the result for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
        sc.close();
    }
}