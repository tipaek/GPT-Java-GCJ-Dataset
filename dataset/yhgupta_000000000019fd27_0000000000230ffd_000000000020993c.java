import java.util.*;

class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] M = new int[N][N];

            int sum = 0;
            for (int i = 0; i < N; i++) {
                String[] integers = scanner.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    M[i][j] = Integer.parseInt(integers[j]);
                }
            }

            int[][] m1 = new int[N][N];
            int[][] m2 = new int[N][N];

            for (int i = 0; i < N; i++) {
                sum += M[i][i];
                for (int j = 0; j < N; j++) {
                    m1[i][j] = M[i][j];
                    m2[i][j] = M[j][i];
                }
            }

            int rowCount = 0;
            for (int i = 0; i < N; i++) {
                Arrays.sort(m1[i]);
                for (int j = 0; j < N - 1; j++) {
                    if (m1[i][j] == m1[i][j + 1]) {
                        rowCount++;
                        break;
                    }
                }
            }

            int colCount = 0;
            for (int i = 0; i < N; i++) {
                Arrays.sort(m2[i]);
                for (int j = 0; j < N - 1; j++) {
                    if (m2[i][j] == m2[i][j + 1]) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + sum + " " + rowCount + " " + colCount);
        }


    }

}


