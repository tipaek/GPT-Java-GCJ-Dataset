import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            for (int i = 1; i <= t; i++) {
                int n = Integer.parseInt(br.readLine());
                boolean[][] rowMatrix = new boolean[n][n];
                boolean[][] colMatrix = new boolean[n][n];
                long trace = 0;
                int rCnt = 0, cCnt = 0;

                for (int j = 0; j < n; j++) {
                    String[] data = br.readLine().split(" ");
                    for (int k = 0; k < n; k++) {
                        int element = Integer.parseInt(data[k]);
                        rowMatrix[j][element - 1] = true;
                        colMatrix[element - 1][k] = true;
                        if (j == k) {
                            trace += element;
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    boolean rowHasAll = true;
                    boolean colHasAll = true;
                    for (int k = 0; k < n; k++) {
                        if (!rowMatrix[j][k]) {
                            rowHasAll = false;
                        }
                        if (!colMatrix[k][j]) {
                            colHasAll = false;
                        }
                    }
                    if (!rowHasAll) {
                        rCnt++;
                    }
                    if (!colHasAll) {
                        cCnt++;
                    }
                }

                System.out.println("Case #" + i + ": " + trace + " " + rCnt + " " + cCnt);
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}