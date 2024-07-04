import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = createScaner();

        int testCases;

        testCases = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= testCases; i++) {
            StringBuilder sb = new StringBuilder();
            int N = in.nextInt();
            in.nextLine();
            for (int a = 0; a < N; a++) {
                sb.append(in.nextLine());
                sb.append(" ");
            }
            int[] numbs = Arrays.stream(sb.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] matrix = new int[N][N];

            int arrLoc = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    matrix[x][y] = numbs[arrLoc];
                    System.out.print(matrix[x][y]);
                    arrLoc++;
                }
                System.out.println("\n");
            }
            solve(i, N, matrix, numbs);
        }


    }

    private static void solve(int testCase, int N, int[][] matrix, int[] numbs) {
        int trace = 0;
        int rowsCount = 0;
        int colomnsCount = 0;

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        System.out.print("Case #" + testCase + ": " + trace + " ");

        for (int[] ints : matrix) {
            for (int col = 0; col < N; col++) {
                int num = ints[col];
                for (int otherCol = col + 1; otherCol < matrix.length; otherCol++) {
                    if (num == ints[otherCol]) {
                        rowsCount++;
                        break;
                    }
                }
            }
        }

        System.out.print(rowsCount + " " + colomnsCount);

        System.out.println();
    }

    public static Scanner createScaner() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return sc;
    }
}