import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int tCase = 1; tCase <= testCases; tCase++) {
            int diagonalSum = 0;
            int duplicateRow = 0;
            int duplicateColumn = 0;
            int value = 0;
            int matrixSize = scanner.nextInt();
            int matrix[][] = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
//                BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
//                String input = scanner.nextInt();
                Map<Integer,Integer> map=new HashMap<>();
                boolean isRow=false;
//                String inputArr[] = input.trim().split(" ");
                for (int column = 0; column < matrixSize; column++) {
                    value =  scanner.nextInt();
                    matrix[row][column] = value;
                    if(map.containsKey(matrix[row][column])&& !isRow){
                        duplicateRow++;
                        isRow=true;
                    }else{
                        map.put(matrix[row][column],1);
                    }
                    if (isDiagonal(row, column)) {
                        diagonalSum += value;
                    }

                }

            }
            for (int column = 0; column < matrixSize; column++) {
                Map<Integer,Integer> map=new HashMap<>();
                boolean isRow=false;
                for (int row = 0; row < matrixSize; row++) {

                    if(map.containsKey(matrix[row][column])&& !isRow){
                        duplicateColumn++;
                        isRow=true;
                    }else{
                        map.put(matrix[row][column],1);
                    }
                }

            }
            System.out.println("Case #" + tCase + ": " + diagonalSum + " " + duplicateRow + " " + duplicateColumn);

        }

    }

    private static boolean isDiagonal(int row, int column) {
        return row == column;
    }
}
