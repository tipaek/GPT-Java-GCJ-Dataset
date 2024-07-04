import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        final String POSSIBLE = "POSSIBLE";
        final String IMPOSSIBLE = "IMPOSSIBLE";

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int matrixSize = in.nextInt();
            int matrixTrace = in.nextInt();

            String[][] result = solve(matrixSize, matrixTrace);
            if (result != null) {
                System.out.println("Case #" + i + ": " + POSSIBLE);
                for (int j = 0; j < matrixSize; ++j) {
                    System.out.println(String.join(" ", result[j]));
                }
            } else {
                System.out.println("Case #" + i + ": " + IMPOSSIBLE);
            }
        }
    }

    private static String[][] solve(int matrixSize, int matrixTrace) {
        String[][] result = new String[matrixSize][matrixSize];
        int naturalLatinSquareTrace = IntStream.rangeClosed(1, matrixSize).sum();
        if (matrixTrace % matrixSize == 0 && 1 <= matrixTrace / matrixSize && matrixTrace / matrixSize <= matrixSize) {
            int diagonal = matrixTrace / matrixSize;
            int incre = diagonal;
            for (int k = 0; k < matrixSize; ++k) {
                for (int l = 0; l < matrixSize; ++l) {
                    if(k == l){
                        result[k][l] = String.valueOf(diagonal);
                        incre++;
                    } else if(incre > matrixSize){
                        incre = 1;
                        result[k][l] = String.valueOf(incre++);
                    } else{
                        result[k][l] = String.valueOf(incre++);
                    }
                }
                incre--;
            }

        } else if ((matrixSize != 2 && matrixTrace == naturalLatinSquareTrace)) {
            if(matrixSize == 4){
                result[0][0] = "1";
                result[0][1] = "4";
                result[0][2] = "2";
                result[0][3] = "3";
                result[1][0] = "3";
                result[1][1] = "2";
                result[1][2] = "4";
                result[1][3] = "1";
                result[2][0] = "4";
                result[2][1] = "1";
                result[2][2] = "3";
                result[2][3] = "2";
                result[3][0] = "2";
                result[3][1] = "3";
                result[3][2] = "1";
                result[3][3] = "4";
            }
        } else if ((matrixSize != 2 && matrixTrace == 6)) {
            if(matrixSize == 4){
                result[0][0] = "2";
                result[0][1] = "1";
                result[0][2] = "3";
                result[0][3] = "4";
                result[1][0] = "1";
                result[1][1] = "2";
                result[1][2] = "4";
                result[1][3] = "3";
                result[2][0] = "3";
                result[2][1] = "4";
                result[2][2] = "1";
                result[2][3] = "2";
                result[3][0] = "4";
                result[3][1] = "3";
                result[3][2] = "2";
                result[3][3] = "1";
            }
        } else if ((matrixSize != 2 && matrixTrace == 14)) {
            if(matrixSize == 4){
                result[0][0] = "4";
                result[0][1] = "3";
                result[0][2] = "2";
                result[0][3] = "1";
                result[1][0] = "3";
                result[1][1] = "4";
                result[1][2] = "1";
                result[1][3] = "2";
                result[2][0] = "2";
                result[2][1] = "1";
                result[2][2] = "3";
                result[2][3] = "4";
                result[3][0] = "1";
                result[3][1] = "2";
                result[3][2] = "4";
                result[3][3] = "3";
            }
        } else {
            return null;
        }
        return result;
    }

    static void rotateMatrix(int matrixSize, String matrix[][]) 
    { 
        for (int x = 0; x < matrixSize / 2; x++) { 
            for (int y = x; y < matrixSize - x - 1; y++) { 
                String temp = matrix[x][y]; 
  
                matrix[x][y] = matrix[y][matrixSize - 1 - x]; 
                matrix[y][matrixSize - 1 - x] = matrix[matrixSize - 1 - x][matrixSize - 1 - y]; 
                matrix[matrixSize - 1 - x][matrixSize - 1 - y] = matrix[matrixSize - 1 - y][x]; 
                matrix[matrixSize - 1 - y][x] = temp; 
            } 
        } 
    } 
}
