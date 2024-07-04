import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int count = 1;
        while (t > 0) {
            int matrixSize = in.nextInt();
            long[] colunasArray = new long[matrixSize];
            long[] linhasArray = new long[matrixSize];

            int k = 0;
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    long element = in.nextLong();

                    colunasArray[j] ^= element;
                    linhasArray[i] ^= element;

                    if (i == j) {
                        k += element;
                    }
                }
            }
            long countColunas = Arrays.stream(colunasArray).filter(coluna -> !(coluna == 0)).count();
            long countLinhas = Arrays.stream(linhasArray).filter(linha -> !(linha == 0)).count();

            System.out.println(String.format("Case #%d: %d %d %d", count, k, countColunas, countLinhas));
            count++;
            t--;
        }

    }
}
