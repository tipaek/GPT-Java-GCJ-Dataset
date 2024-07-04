import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            int lines = 0;
            int columns = 0;
            int trace = 0;

            Set<Integer> line = new HashSet<>();
            Set<Integer> column = new HashSet<>();

            for (int j = 0; j < n; j++) {
                line.clear();
                boolean flag = false;
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                    if (line.contains(arr[j][k])) {
                        if (!flag) {
                            flag = true;
                            lines++;
                        }
                    }
                    line.add(arr[j][k]);
                }
            }


            for (int j = 0; j < n; j++) {
                column.clear();
                boolean flag = false;
                for (int k = 0; k < n; k++) {
                    if (column.contains(arr[k][j])) {
                        if (!flag) {
                            flag = true;
                            columns++;
                        }
                    }
                    column.add(arr[k][j]);
                }
            }

            for (int j = 0; j < n; j++) {
                trace += arr[j][j];
            }


            result.append("case#" + (i + 1) + ": " + trace + " " + lines + " " + columns + "\n");
        }


        System.out.println(result);
    }
}
