import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vestigium {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            for (int i = 1; i <= t; i++) {
                int n = Integer.parseInt(br.readLine());
                int[][] matrix = new int[n][n];
                boolean[][] rowCheck = new boolean[n][n];
                boolean[][] colCheck = new boolean[n][n];
                long trace = 0;
                int rCnt = 0, cCnt = 0;

                for (int j = 0; j < n; j++) {
                    String[] data = br.readLine().split(" ");
                    for (int k = 0; k < n; k++) {
                        int element = Integer.parseInt(data[k]);
                        matrix[j][k] = element;
                        rowCheck[j][element - 1] = true;
                        colCheck[element - 1][k] = true;
                        if (j == k) {
                            trace += element;
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (!rowCheck[j][k]) {
                            rCnt++;
                            break;
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (!colCheck[k][j]) {
                            cCnt++;
                            break;
                        }
                    }
                }

                System.out.println("Case #" + i + ": " + trace + " " + rCnt + " " + cCnt);
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}