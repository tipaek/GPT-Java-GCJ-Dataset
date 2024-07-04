import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int caseNumber = 1;

        while (T-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(arr[i][j])) {
                        rowFlag = true;
                        break;
                    }
                }
                if (rowFlag) {
                    rowDuplicates++;
                }
            }

            for (int i = 0; i < N; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int j = 0; j < N; j++) {
                    if (!colSet.add(arr[j][i])) {
                        colFlag = true;
                        break;
                    }
                }
                if (colFlag) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            caseNumber++;
        }
    }
}