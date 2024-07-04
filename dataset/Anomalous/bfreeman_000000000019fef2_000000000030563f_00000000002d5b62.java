import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            processCase(i + 1, x, y);
        }
    }

    private static void processCase(int caseNumber, int x, int y) {
        String impossible = "IMPOSSIBLE";
        boolean flipX = x < 0;
        boolean flipY = y < 0;

        if (flipX) x = -x;
        if (flipY) y = -y;

        ArrayList<Byte> xBits = new ArrayList<>();
        ArrayList<Byte> yBits = new ArrayList<>();
        populateBits(xBits, x);
        populateBits(yBits, y);

        if (solve(caseNumber, xBits, yBits, impossible)) {
            String solution = convertSolution(xBits, yBits);
            solution = applyFlips(solution, flipX, flipY);
            printResult(caseNumber, solution);
        }
    }

    private static boolean solve(int caseNumber, ArrayList<Byte> xBits, ArrayList<Byte> yBits, String impossible) {
        int bit = 0;
        while (true) {
            if (xBits.get(bit) == 0 && yBits.get(bit) == 0) {
                if (allZeroesFromBit(xBits, bit) && allZeroesFromBit(yBits, bit)) {
                    return true;
                } else if (!shiftBits(xBits, bit, 2) && !shiftBits(yBits, bit, 2)) {
                    printResult(caseNumber, impossible);
                    return false;
                }
            } else if (xBits.get(bit) == 1 && yBits.get(bit) == 1) {
                if (!shiftBits(xBits, bit, 1) && !shiftBits(yBits, bit, 1)) {
                    printResult(caseNumber, impossible);
                    return false;
                }
            }
            bit++;
        }
    }

    private static boolean allZeroesFromBit(ArrayList<Byte> bits, int bit) {
        for (int i = bit; i < bits.size(); i++) {
            if (bits.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private static String convertSolution(ArrayList<Byte> xBits, ArrayList<Byte> yBits) {
        StringBuilder solution = new StringBuilder();
        int bit = 0;
        while (!allZeroesFromBit(xBits, bit) || !allZeroesFromBit(yBits, bit)) {
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

    private static boolean shiftBits(ArrayList<Byte> bits, int bit, int type) {
        if (bit == 0) return false;

        if (type == 2 && bits.get(bit) == 0) {
            if (bits.get(bit - 1) == 1) {
                bits.set(bit - 1, (byte) -1);
                bits.set(bit, (byte) 1);
                return true;
            }
        } else if (type == 1 && bits.get(bit - 1) == 1) {
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
        }

        return false;
    }

    private static void populateBits(ArrayList<Byte> bits, int number) {
        for (int i = 0; i < 32; i++) {
            bits.add((number & (1 << i)) != 0 ? (byte) 1 : (byte) 0);
        }
    }

    private static void printResult(int caseNumber, String result) {
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }
}