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

        boolean[] xSame = new boolean[N];
        boolean[] ySame = new boolean[N];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                final int value = scanner.nextInt();
                matrix[x][y] = value;

                if(!xSame[x]) {
                    for (int i = 0; i < y; i++) {
                        if(matrix[x][i] == value) {
                            xSame[x] = true;
                            break;
                        }
                    }
                }
                if(!ySame[y]) {
                    for (int i = 0; i < x; i++) {
                        if(matrix[i][y] == value) {
                            ySame[y] = true;
                            break;
                        }
                    }
                }

                if(x == y) {
                    trace += value;
                }
            }
        }
        return MessageFormat.format(SINGLE_RESULT_PATTERN, trace, countTrues(xSame), countTrues(ySame));
    }

    private static int countTrues(final boolean[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]) {
                result++;
            }
        }
        return result;
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
