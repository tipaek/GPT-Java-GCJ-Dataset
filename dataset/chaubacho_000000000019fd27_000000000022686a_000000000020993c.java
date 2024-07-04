import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());
        int index = 1;
        while (T > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            scanner.nextLine();

            int[] result = handle(matrix, N);
            System.out.println("Case #" + index + ": " + result[0] + " " + result[1] + " " + result[2]);
            
            ++index;
            --T;
        }
    }

    private static int[] handle(int[][] a, int N) {
        int countRow = 0;
        int countCol = 0;
        int sumDiagonal = 0;
        for (int i = 1; i <= N; i++) {
            Set<Integer> hashSetRow = new HashSet<>();
            Set<Integer> hashSetCol = new HashSet<>();
            for (int j = 1; j <= N; j++) {
                hashSetRow.add(a[i][j]);
                hashSetCol.add(a[j][i]);
            }
            if (hashSetRow.size() != N) ++countRow;
            if (hashSetCol.size() != N) ++countCol;
            sumDiagonal += a[i][i];
        }
        return new int[] {sumDiagonal, countRow, countCol};
    }
}
