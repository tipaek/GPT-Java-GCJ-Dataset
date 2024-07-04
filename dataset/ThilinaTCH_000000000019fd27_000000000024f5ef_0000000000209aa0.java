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

        } else {
            return null;
        }
        return result;
    }
}
