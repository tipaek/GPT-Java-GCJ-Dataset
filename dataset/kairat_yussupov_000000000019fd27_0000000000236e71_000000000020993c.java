import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws IOException {


        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
   
        int test_cases = Integer.parseInt(scanner.nextLine());

        for (int G = 0; G < test_cases; G++) {

            String readedLine  = scanner.nextLine();
            int matrix_size = Integer.parseInt(readedLine);

            int M[][] = new int[matrix_size][matrix_size];

            String line = null;
            int x = 0;
            while (x < matrix_size) {
                line = scanner.nextLine();
                String[] items = line.split(" ");
                for (int i = 0; i < items.length; i++) {
                    M[x][i] = Integer.parseInt(items[i]);
                }

                x++;
            }

            int matrixTrace = 0;

            for (int i = 0; i < M.length; i++) {
                matrixTrace += M[i][i];
            }


            int columns = 0;
            int rows = 0;

            for (int i = 0; i < M.length; i++) {
                found:
                for (int j = 0; j < M[i].length; j++) {
                    // M[i][j];

                    for (int k = j + 1; k < M[i].length; k++) {
                        // M[i][k];
                        if (M[i][j] == M[i][k]) {
                            rows++;
                            break found;
                        }
                    }
                }
            }


            for (int i = 0; i < M.length; i++) {
                found:
                for (int j = 0; j < M[i].length; j++) {
                    // M[j][i];

                    for (int k = j + 1; k < M[i].length; k++) {
                        // M[k][i];
                        if (M[j][i] == M[k][i]) {
                            columns++;
                            break found;
                        }
                    }
                }
            }

            System.out.println(" Case #" + G + ": " + matrixTrace + " " + rows + " " + columns);
        }
    }

}
