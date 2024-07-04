import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][][] matrices = new int[T][][];

        for (int k = 0; k < T; k++) {
            int N = sc.nextInt();
            matrices[k] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrices[k][i][j] = sc.nextInt();
                }
            }
        }

        int[][] results = new int[T][3];

        for (int k = 0; k < T; k++) {
            int trace = 0, rowCount = 0, columnCount = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            // Calculate trace and row repetitions
            for (int i = 0; i < matrices[k].length; i++) {
                trace += matrices[k][i][i];
                map.clear();
                for (int j = 0; j < matrices[k][i].length; j++) {
                    if (map.containsKey(matrices[k][i][j])) {
                        rowCount++;
                        break;
                    } else {
                        map.put(matrices[k][i][j], 0);
                    }
                }
            }

            // Calculate column repetitions
            for (int i = 0; i < matrices[k].length; i++) {
                map.clear();
                for (int j = 0; j < matrices[k].length; j++) {
                    if (map.containsKey(matrices[k][j][i])) {
                        columnCount++;
                        break;
                    } else {
                        map.put(matrices[k][j][i], 0);
                    }
                }
            }

            results[k][0] = trace;
            results[k][1] = rowCount;
            results[k][2] = columnCount;
        }

        for (int i = 0; i < T; i++) {
            System.out.println("case #" + (i + 1) + ": " + results[i][0] + " " + results[i][1] + " " + results[i][2]);
        }
    }
}