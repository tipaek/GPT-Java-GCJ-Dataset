import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int t = getInt();
        int b = getInt();
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
                    handleSpecialCase(bits, complementChecker, inverseChecker, isComplement);
                    guessNumber = 2;
                    continue;
                }

                bits = queryAndStore(bits, leftMark, b, isComplement, isInverse);

                if (complementChecker == -1 && bits[leftMark] == bits[b - 1 - leftMark]) {
                    complementChecker = leftMark;
                }
                if (inverseChecker == -1 && bits[leftMark] != bits[b - 1 - leftMark]) {
                    inverseChecker = leftMark;
                }

                guessNumber += 2;
                leftMark++;
            }

            printResult(bits, b, isComplement, isInverse);
        }
    }

    private static void handleSpecialCase(int[] bits, int complementChecker, int inverseChecker, boolean isComplement) throws IOException {
        if (complementChecker != -1) {
            System.out.println(complementChecker + 1);
            System.out.flush();
            int a = getInt();
            isComplement = !(a == bits[complementChecker]);
        } else {
            System.out.println(1);
            System.out.flush();
            getInt();
        }
        if (inverseChecker != -1) {
            System.out.println(inverseChecker + 1);
            System.out.flush();
            int a = getInt();
            isInverse = (isComplement && a == bits[inverseChecker]) || (!isComplement && a != bits[inverseChecker]);
        } else {
            System.out.println(1);
            System.out.flush();
            getInt();
        }
    }

    private static int[] queryAndStore(int[] bits, int leftMark, int b, boolean isComplement, boolean isInverse) throws IOException {
        System.out.println(leftMark + 1);
        System.out.flush();
        int x = getInt();
        bits[isInverse ? b - 1 - leftMark : leftMark] = isComplement ? (x == 0 ? 1 : 0) : x;

        System.out.println(b - leftMark);
        System.out.flush();
        x = getInt();
        bits[!isInverse ? b - 1 - leftMark : leftMark] = isComplement ? (x == 0 ? 1 : 0) : x;

        return bits;
    }

    private static void printResult(int[] bits, int b, boolean isComplement, boolean isInverse) {
        for (int j = 0; j < b; j++) {
            int out = isInverse ? bits[b - 1 - j] : bits[j];
            System.out.print(isComplement ? (out == 0 ? 1 : 0) : out);
        }
        System.out.println();
    }

    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt() throws IOException {
        int c = skipSpace();
        boolean isNeg = (char) c == '-';
        int out = 0;
        if (isNeg) c = input.read();
        do {
            out = out * 10 + (c - '0');
            c = input.read();
        } while (c >= '0' && c <= '9');
        return isNeg ? -out : out;
    }

    public static int skipSpace() throws IOException {
        int s = input.read();
        while (s == ' ' || s == '\n' || s == '\r') {
            s = input.read();
        }
        return s;
    }
}