import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputTestCase = scan.nextInt();
        for (int t = 1; t <= inputTestCase; t++) {
            String str = "C";
            BigInteger inputSize = scan.nextBigInteger();
            int[][] matrix = new int[inputSize.intValue()][2];
            for (int i = 0; i < inputSize.intValue(); i++) {
                matrix[i][0] = scan.nextInt();
                matrix[i][1] = scan.nextInt();
            }
            int[][] givenMatrix = matrix.clone();
            Arrays.sort(matrix, (a, b) -> Integer.compare(a[1], b[1]));
            Arrays.sort(matrix, (a, b) -> Integer.compare(a[0], b[0]));
            int[] startTime = new int[inputSize.intValue()];
            int[] endTime = new int[inputSize.intValue()];
            for (int i = 0; i < inputSize.intValue(); i++) {
                startTime[i] = matrix[i][0];
                endTime[i] = matrix[i][1];
            }
            int cIndex = 0;
            int jIndex = 0;
            for (int i = 1; i < inputSize.intValue(); i++) {
                if (endTime[cIndex] <= startTime[i]) {
                    cIndex = i;
                    str = str + 'C';
                } else if (jIndex == 0) {
                    jIndex = i;
                    str = str + 'J';
                } else if (endTime[jIndex] <= startTime[i]) {
                    jIndex = i;
                    str = str + 'J';
                } else {
                    str = "IMPOSSIBLE";
                    i = inputSize.intValue() + 1;
                }
            }
            char[] s = new char[inputSize.intValue()];
            if (!str.equals("IMPOSSIBLE")) {
                for (int i = 0; i < inputSize.intValue(); i++) {
                    for (int j = 0; j < inputSize.intValue(); j++) {
                        if (givenMatrix[i][0] == matrix[j][0] && givenMatrix[i][1] == matrix[j][1])
                            s[i] = str.charAt(j);
                    }
                }
                str = new String(s);
            }
            System.out.println("Case #" + t + ": " + str);
        }
    }
}