import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();       //testCases
        int sum = 0;         //k
        int row = 0;        //r
        int column = 0;     //c

        for (int t = 1; t <= T; t++) {
            int size = scanner.nextInt();
            int[][] latinMatrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    latinMatrix[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < size; i++) {
                sum = sum + latinMatrix[i][i];
            }

            for (int i = 0; i < size; i++) {

                for (int j = 0; j < size - 1; j++) {

                    if (latinMatrix[i][j] != latinMatrix[i][j + 1]) {
                        row = 0;
                    } else if (latinMatrix[i][j] == latinMatrix[i][j + 1]) {
                        row += 1;
                    }
                }
            }
            System.out.println("Case #" + t + ":" + " " + sum + " " + row + " " + column);
            sum = 0;
            row = 0;
            column = 0;
        }
    }
}