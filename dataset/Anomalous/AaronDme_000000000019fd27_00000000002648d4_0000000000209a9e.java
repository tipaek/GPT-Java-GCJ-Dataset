import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] tb = input.readLine().split("\\s+");
        int t = Integer.parseInt(tb[0]);
        int b = Integer.parseInt(tb[1]);

        for (int i = 1; i <= t; i++) {
            int[] bits = new int[b];
            Arrays.fill(bits, -1);
            int leftMark = 0;
            boolean isComplement = false;
            boolean isInverse = false;
            int complementChecker = -1;
            int inverseChecker = -1;
            int guessNumber = 0;

            while (leftMark * 2 < b) {
                if (guessNumber == 10) {
                    handleSpecialCase(input, bits, complementChecker, inverseChecker);
                    guessNumber = 2;
                    continue;
                }

                int leftValue = queryBit(input, leftMark + 1);
                bits[isInverse ? b - 1 - leftMark : leftMark] = applyComplement(leftValue, isComplement);

                int rightValue = queryBit(input, b - leftMark);
                bits[!isInverse ? b - 1 - leftMark : leftMark] = applyComplement(rightValue, isComplement);

                updateCheckers(bits, leftMark, b, complementChecker, inverseChecker);

                guessNumber += 2;
                leftMark++;
            }

            outputResult(bits, b, isComplement, isInverse);
            if (input.readLine().equals("N")) {
                break;
            }
        }
    }

    private static void handleSpecialCase(BufferedReader input, int[] bits, int complementChecker, int inverseChecker) throws IOException {
        if (complementChecker != -1) {
            int a = queryBit(input, complementChecker + 1);
            isComplement = !(a == bits[complementChecker]);
        } else {
            queryBit(input, 1);
        }

        if (inverseChecker != -1) {
            int a = queryBit(input, inverseChecker + 1);
            isInverse = (isComplement && a == bits[inverseChecker]) || (!isComplement && a != bits[inverseChecker]);
        } else {
            queryBit(input, 1);
        }
    }

    private static int queryBit(BufferedReader input, int position) throws IOException {
        System.out.println(position);
        System.out.flush();
        return Integer.parseInt(input.readLine());
    }

    private static int applyComplement(int value, boolean isComplement) {
        return isComplement ? (value == 0 ? 1 : 0) : value;
    }

    private static void updateCheckers(int[] bits, int leftMark, int b, int complementChecker, int inverseChecker) {
        if (complementChecker == -1 && bits[leftMark] == bits[b - 1 - leftMark]) {
            complementChecker = leftMark;
        }
        if (inverseChecker == -1 && bits[leftMark] != bits[b - 1 - leftMark]) {
            inverseChecker = leftMark;
        }
    }

    private static void outputResult(int[] bits, int b, boolean isComplement, boolean isInverse) {
        for (int j = 0; j < b; j++) {
            int out = isInverse ? bits[b - 1 - j] : bits[j];
            System.out.print(isComplement ? (out == 0 ? 1 : 0) : out);
        }
        System.out.println();
        System.out.flush();
    }
}