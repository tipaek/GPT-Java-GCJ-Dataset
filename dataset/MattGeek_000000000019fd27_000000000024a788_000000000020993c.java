import java.util.Scanner;

/**
 * @author Mattia D'ambrosio
 * Created on 04/04/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte testCases = scanner.nextByte();

        for (byte i = 1; i <= testCases; i++) {
            byte size = scanner.nextByte();
            int[][] matrix = new int[size][size];
            scanner.nextLine();

            for(byte j=0; j < size; j++){
                String[] x = scanner.nextLine().split(" ");
                for (byte k = 0; k < size; k++) {
                    matrix[j][k] = Integer.parseInt(x[k]);
                }
            }
            int[] result = computeMatrix(matrix, size);
            System.out.println("Case #"+i+": "+result[0]+" "+result[1]+" "+result[2]);
        }

    }

    private static int[] computeMatrix(int[][] m, byte size){
        int[] out = {0, 0, 0};
        boolean[] cRepeated = new boolean[size];
        for (byte i = 0; i < size; i++) {
            boolean rRepeated = false;
            for (byte j = 0; j < size; j++) {
                if (i == j)
                    out[0] += m[i][j];
                for (int k = 0; k < size; k++) {
                    if (k != j && m[i][k] == m[i][j] && !rRepeated){
                        out[1]++;
                        rRepeated = true;
                    }
                    if (k != i && m[k][j] == m[i][j] && !cRepeated[j]){
                        out[2]++;
                        cRepeated[j] = true;
                    }

                }
            }

        }

        return out;
    }
}
