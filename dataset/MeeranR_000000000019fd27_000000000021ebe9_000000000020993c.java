import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputTestCase = scan.nextInt();
        for (int t = 1; t <= inputTestCase; t++) {
            int inputSize = scan.nextInt();
            BigInteger[][] matrix = new BigInteger[inputSize][inputSize];
            BigInteger k = BigInteger.ZERO;
            Long r = 0L;
            Long c = 0L;
            for (int i = 0; i < inputSize; i++) {
                Map<BigInteger, Integer> row = new HashMap<>();
                for (int j = 0; j < inputSize; j++) {
                    //BigInteger tempBT = new BigInteger(temp[j]);
                    matrix[i][j] = scan.nextBigInteger();
                    if (i == j)
                        k = k.add(matrix[i][j]);
                    if (row.containsKey(matrix[i][j])) {
                        row.put(matrix[i][j], row.get(matrix[i][j]) + 1);
                    } else {
                        row.put(matrix[i][j], 1);
                    }
                }

                Long tempr = row.entrySet().stream().filter(key -> key.getValue() > 1).count();
                if (tempr > 0)
                        r++;
            }
            for (int i = 0; i < inputSize; i++) {
                Map<BigInteger, Integer> column = new HashMap<>();
                for (int j = 0; j < inputSize; j++) {
                    if (column.containsKey(matrix[j][i])) {
                        column.put(matrix[j][i], column.get(matrix[j][i]) + 1);
                    } else {
                        column.put(matrix[j][i], 1);
                    }
                }
                Long tempc = column.entrySet().stream().filter(key -> key.getValue() > 1).count();
                if (tempc > 0)
                    c++;
            }
            System.out.println("Case #" + t + ": " + k + " " + r+ " " + c);
        }
    }
}