
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";
    public static final String SINGLE_RESULT_PATTERN = "{0} {1} {2}";

    private static String getSolution(final Scanner scanner) {
        final int N = scanner.nextInt();
        int[][] matrix = new int[N][N];
        int trace = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                final int value = scanner.nextInt();
                matrix[x][y] = value;

                if(x == y) {
                    trace += value;
                }
            }
        }

        int xCount = 0;
        for (int x = 0; x < N; x++) {
            y: for (int y = 0; y < N; y++) {
                for (int i = 0; i < y; i++) {
                    if(matrix[x][y] == matrix[x][i]) {
                        xCount++;
                        break y;
                    }
                }
            }
        }

        int yCount = 0;
        for (int y = 0; y < N; y++) {
            x: for (int x = 0; x < N; x++) {
                for (int i = 0; i < x; i++) {
                    if(matrix[x][y] == matrix[i][y]) {
                        yCount++;
                        break x;
                    }
                }
            }
        }

        return MessageFormat.format(SINGLE_RESULT_PATTERN, trace, xCount, yCount);
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
//        final Scanner scanner = new Scanner(new FileInputStream("A.in"));

        final int testCases = scanner.nextInt();
        for(int i = 1; i<= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }
}
