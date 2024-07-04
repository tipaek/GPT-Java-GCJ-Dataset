import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            handleCase(i + 1, x, y);
        }
    }

    private static void handleCase(int caseNum, int x, int y) {
        String failStr = "IMPOSSIBLE";
        boolean flipX = x < 0;
        boolean flipY = y < 0;
        x = Math.abs(x);
        y = Math.abs(y);

        ArrayList<Byte> xBits = new ArrayList<>();
        ArrayList<Byte> yBits = new ArrayList<>();
        populateBits(xBits, x);
        populateBits(yBits, y);

        if (processBits(xBits, yBits)) {
            String solution = translateSolution(xBits, yBits);
            solution = applyFlips(solution, flipX, flipY);
            printCaseResult(caseNum, solution);
        } else {
            printCaseResult(caseNum, failStr);
        }
    }

    private static boolean processBits(ArrayList<Byte> xBits, ArrayList<Byte> yBits) {
        int bit = 0;
        while (true) {
            if (xBits.get(bit) == 0 && yBits.get(bit) == 0) {
                if (allZeroesFrom(xBits, bit) && allZeroesFrom(yBits, bit)) {
                    return true;
                }
                return false;
            } else if (xBits.get(bit) == 1 && yBits.get(bit) == 1) {
                if (!shiftBitsIfPossible(xBits, bit) && !shiftBitsIfPossible(yBits, bit)) {
                    return false;
                }
            }
            bit++;
        }
    }

    private static boolean allZeroesFrom(ArrayList<Byte> bits, int bit) {
        for (int i = bit; i < bits.size(); i++) {
            if (bits.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private static String translateSolution(ArrayList<Byte> xBits, ArrayList<Byte> yBits) {
        StringBuilder solution = new StringBuilder();
        int bit = 0;
        while (!allZeroesFrom(xBits, bit) || !allZeroesFrom(yBits, bit)) {
            if (xBits.get(bit) != 0) {
                solution.append(xBits.get(bit) == 1 ? 'E' : 'W');
            } else if (yBits.get(bit) != 0) {
                solution.append(yBits.get(bit) == 1 ? 'N' : 'S');
            }
            bit++;
        }
        return solution.toString();
    }

    private static String applyFlips(String solution, boolean flipX, boolean flipY) {
        if (flipX) {
            solution = solution.replace('E', 'T').replace('W', 'E').replace('T', 'W');
        }
        if (flipY) {
            solution = solution.replace('N', 'T').replace('S', 'N').replace('T', 'S');
        }
        return solution;
    }

    private static boolean shiftBitsIfPossible(ArrayList<Byte> bits, int bit) {
        if (bit == 0 || bits.get(bit - 1) != 1) {
            return false;
        }
        if (bit == bits.size() - 1) {
            bits.set(bit - 1, (byte) -1);
            bits.set(bit, (byte) 0);
            bits.add((byte) 1);
            return true;
        } else if (bits.get(bit + 1) == 0) {
            bits.set(bit - 1, (byte) -1);
            bits.set(bit, (byte) 0);
            bits.set(bit + 1, (byte) 1);
            return true;
        }
        return false;
    }

    private static void populateBits(ArrayList<Byte> bits, int n) {
        for (int i = 0; i < 32; i++) {
            bits.add((byte) ((n & (1 << i)) != 0 ? 1 : 0));
        }
    }

    private static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}