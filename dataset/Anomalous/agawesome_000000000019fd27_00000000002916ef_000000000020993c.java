import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            int[][] arr = new int[size][size];
            int trace = 0, rows = 0, columns = 0;

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    arr[j][k] = scanner.nextInt();
                }
            }

            for (int j = 0; j < size; j++) {
                trace += arr[j][j];
            }

            for (int j = 0; j < size; j++) {
                HashSet<Integer> rowCheck = new HashSet<>();
                boolean rowRepeat = false;

                for (int k = 0; k < size; k++) {
                    if (!rowCheck.add(arr[j][k])) {
                        rows++;
                        rowRepeat = true;
                        break;
                    }
                }
                if (rowRepeat) continue;
            }

            for (int k = 0; k < size; k++) {
                HashSet<Integer> colCheck = new HashSet<>();
                boolean colRepeat = false;

                for (int j = 0; j < size; j++) {
                    if (!colCheck.add(arr[j][k])) {
                        columns++;
                        colRepeat = true;
                        break;
                    }
                }
                if (colRepeat) continue;
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rows + " " + columns);
        }
    }
}