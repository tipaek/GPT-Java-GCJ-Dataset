import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();
        for (int i = 1; i <= cases; i++) {
            int square = scan.nextInt();

            int[][] matrix = new int[square][square];
            for (int k = 0; k < square; k++) {
                for (int l = 0; l < square; l++) {
                    matrix[k][l] = scan.nextInt();
                }
            }
            int trace = 0;
            for (int j = 0; j < square; j++) {
                trace += matrix[j][j];
            }

            int row = 0;
            for (int columns = 0; columns < square; columns++) {
                int [] array = new int[100];
                for (int rows = 0; rows < square; rows++) {
                    array[matrix[columns][rows]]++;
                    if(array[matrix[columns][rows]] == 2){
                        row++;
                        break;
                    }
                }

            }

            //System.out.println();
            int col = 0;
            for (int columns = 0; columns < square; columns++) {
                int [] array = new int[100];
                for (int rows = 0; rows < square; rows++) {
                    array[matrix[rows][columns]]++;
                    if(array[matrix[rows][columns]] == 2){
                        col++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);


        }
    }
}
