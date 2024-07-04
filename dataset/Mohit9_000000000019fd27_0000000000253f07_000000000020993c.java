import java.util.HashMap;
import java.util.Scanner;

public class prob1 {
    public static void main(String[] args) {
        int T = 0;
        Scanner scn = new Scanner(System.in);
        T = scn.nextInt();
        int Case = 0;
        while (T-- != 0) {
            Case++;
            int N = scn.nextInt();
            int[][] matrix = new int[N][N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scn.nextInt();
                    if (i == j) {
                        sum += matrix[i][j];
                    }
                }
            }

            int countRows = 0;
            for (int i = 0; i < N; i++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < N; j++) {
                    map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
                }
                for (int key : map.keySet()) {
                    if (map.get(key) > 1) {
                        countRows++;
                        break;
                    }
                }
            }

            int countCols = 0;
            for (int j = 0; j < N; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < N; i++) {
                    map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
                }
                for (int key : map.keySet()) {
                    if (map.get(key) > 1) {
                        countCols++;
                        break;
                    }
                }
            }
            System.out.println("case #" + Case + ":" + sum + " " + countRows + " " + countCols);

        }
    }

}