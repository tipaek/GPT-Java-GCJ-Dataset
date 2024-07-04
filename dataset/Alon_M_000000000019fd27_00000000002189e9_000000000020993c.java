import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++){

            int rowCount  = 0;
            int colCount = 0;
            int trace = 0;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int k = 0; k < n; k++){
                for (int j = 0; j < n; j++){
                    matrix[k][j] = scanner.nextInt();
                }
            }


            //rows:
            for (int k = 0; k < n; k ++){
                boolean found = false;
                for (int j = 0 ; j < n && !found; j ++){
                    for (int q = j + 1; q < n && !found; q++){
                        if (matrix[k][q] == matrix[k][j] ) {
                            rowCount++;
                            found = true;
                        }
                    }

                }
            }


            //cols:
            for (int k = 0; k < n; k ++){
                boolean found = false;
                for (int j = 0; j < n && !found; j ++){
                    for (int q = j +1; q < n && !found; q++){
                        if (matrix[q][k] == matrix[j][k] ) {
                            colCount++;
                            found = true;
                        }
                    }

                }
            }


            //trace:
            for (int k = 0; k < n; k ++) {
                trace += matrix[k][k];
            }
            int caseNum = i+1;
            System.out.println("Case #" + (caseNum) + ": " + trace + " " + rowCount + " " + colCount);

        }

    }

}
