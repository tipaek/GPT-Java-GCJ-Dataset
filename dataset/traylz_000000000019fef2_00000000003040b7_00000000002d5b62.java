
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

import static java.math.BigInteger.*;

public class Solution {

    public static final String IMPOSSIBURU = "IMPOSSIBLE";
    public static final int[] NO_RESULT = new int[0];
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            final String[] coordinates = in.readLine().split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            String result = solve(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solve(long x, long y) {
        BigInteger sum = BigInteger.valueOf(x).abs().add(BigInteger.valueOf(y).abs());
        if (!sum.remainder(TWO).equals(ONE)) {
            return IMPOSSIBURU;
        } else if (x != 0 && y != 0 && maxPowOfTwo(BigInteger.valueOf(x).abs()) == maxPowOfTwo(BigInteger.valueOf(y).abs())) {
            return IMPOSSIBURU;
        }
        for (int numOfMoves = 0; numOfMoves < 10000; numOfMoves++) {
            int[] signs = seek(sum, numOfMoves);
            if (signs.length == 0) {
                continue;
            } else {
                int[] xMoves = gatherFrom(signs, x);
                if (xMoves.length == 0) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < numOfMoves; i++) {
                    if (xMoves[i] != 0) {
                        if ((xMoves[i] == 1) ^ (x < 0)) {
                            sb.append('E');
                        } else {
                            sb.append('W');
                        }
                    } else {
                        if (signs[i] == 1 ^ (y < 0)) {
                            sb.append('N');
                        } else {
                            sb.append('S');
                        }
                    }
                }
                return sb.toString();
            }
        }
        return IMPOSSIBURU;
    }

    private static int[] gatherFrom(int[] signs, long x) {
        BigInteger restToGather = BigInteger.valueOf(x).abs();
        final int[] positiveOutcome = tryGather(signs, restToGather);
        if (positiveOutcome.length == 0) {
            final int[] negativeOutcome = tryGather(signs, restToGather.abs().negate());
            for (int i = 0; i < signs.length; i++) {
                negativeOutcome[i] = -negativeOutcome[i];
            }
            return negativeOutcome;
        }
        return positiveOutcome;
    }

    private static int[] tryGather(int[] signs, BigInteger restToGather) {
        final int[] restPossibleMoves = Arrays.copyOf(signs, signs.length);
        int[] result = new int[restPossibleMoves.length];
        while (!restToGather.equals(ZERO)) {
            int maxPowOfTwo = maxPowOfTwo(restToGather.abs());
            if (maxPowOfTwo >= signs.length) {
                return NO_RESULT;
            }
            final int sign = restPossibleMoves[maxPowOfTwo];
            if (sign == 0) {
                return NO_RESULT;
            } else {
                restPossibleMoves[maxPowOfTwo] = 0;
            }
            result[maxPowOfTwo] = sign;
            restToGather = restToGather.subtract(BigInteger.valueOf(sign).multiply(TWO.pow(maxPowOfTwo)));
        }
        return result;
    }

    private static int maxPowOfTwo(BigInteger restToGather) {
        int pow = 0;
        while (restToGather.remainder(TWO).equals(ZERO)) {
            restToGather = restToGather.divide(TWO);
            pow++;
        }
        return pow;
    }

    public static int[] seek(BigInteger desiredSum, int numOfMoves) {
        int[] result = new int[numOfMoves];
        BigInteger currentSum = BigInteger.ZERO;
        for (int i = numOfMoves; i >= 1; i--) {
            if (currentSum.compareTo(desiredSum) < 0) {
                currentSum = currentSum.add(TWO.pow(i - 1));
                result[i - 1] = +1;
            } else if (currentSum.compareTo(desiredSum) > 0) {
                currentSum = currentSum.subtract(TWO.pow(i - 1));
                result[i - 1] = -1;
            } else {
                return NO_RESULT;
            }
        }
        if (currentSum.compareTo(desiredSum) == 0) {
            return result;
        } else {
            return NO_RESULT;
        }
    }
}
