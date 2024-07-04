import java.util.*;

public class Solution {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i < cases; i++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            for(int j = 0; j < size; j++) {
                for(int k = 0; k < size; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int trace = 0;

            //count diagonally from left to right bottom corner
            for(int j = 0; j < size; j++) {
                trace += matrix[j][j];
            }

            int repeatedRows = 0;
            int repeatedCols = 0;
            //for every col
            for(int j = 0; j < size; j++) {
                //for every row
                List<Integer> elements = new ArrayList<>();
                for(int k = 0; k < size; k++) {

                    
                    if(elements.indexOf(matrix[k][j]) != -1) {
                        repeatedRows++;
                        break;
                    } else {
                        elements.add(matrix[k][j]);
                    }
                } 
            }

            for(int j = 0; j < size; j++) {
                //for every row
                List<Integer> elements = new ArrayList<>();
                for(int k = 0; k < size; k++) {

                    
                    if(elements.indexOf(matrix[j][k]) != -1) {
                        repeatedCols++;
                        break;
                    } else {
                        elements.add(matrix[j][k]);
                    }
                } 
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, repeatedCols, repeatedRows);
        }
    }
}