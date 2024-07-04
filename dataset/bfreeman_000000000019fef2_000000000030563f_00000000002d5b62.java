import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            runCase(i + 1, x, y);
        }
    }

    public static void runCase(int caseNum, int x, int y) {
        String failStr = "IMPOSSIBLE";
        boolean flipx = false;
        boolean flipy= false;
        if (x < 0) {
            x = -x;
            flipx = true;
        }
        if (y < 0) {
            y = -y;
            flipy = true;
        }
        ArrayList<Byte> xbs = new ArrayList<>();
        ArrayList<Byte> ybs = new ArrayList<>();
        getBits(xbs, x);
        getBits(ybs, y);
        boolean solved = false;
        int bit = 0;
        while (!solved) {
            if (xbs.get(bit) == 0 && ybs.get(bit) == 0) {
                if (zeroed(xbs, bit) && zeroed(ybs, bit)) {
                    solved = true;
                } else if (!shiftIfAble2(xbs, bit) && !shiftIfAble2(ybs, bit)){
                    printCaseResult(caseNum, failStr);
                    return;
                }
            } else if (xbs.get(bit) == 1 && ybs.get(bit) == 1) {
                if (!shiftIfAble1(xbs, bit) && !shiftIfAble1(ybs, bit)) { // TODO: may need to shift one or the other more intelligently
                    printCaseResult(caseNum, failStr);
                    return;
                }
            }
            bit++;
        }

        String solution = transcribeSolution(xbs, ybs);
        solution = flip(solution, flipx, flipy);

        printCaseResult(caseNum, solution);
    }

    private static boolean zeroed(ArrayList<Byte> bs, int bit) {
        for (int i = bit; i < bs.size(); i++) {
            if (bs.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private static String transcribeSolution(ArrayList<Byte> xbs, ArrayList<Byte> ybs) {
        StringBuilder solution = new StringBuilder();
        int bit = 0;
        while (!zeroed(xbs, bit) || !zeroed(ybs, bit)) {
            if (xbs.get(bit) != 0) {
                if (xbs.get(bit) == 1) {
                    solution.append('E');
                } else {
                    solution.append('W');
                }
            } else if (ybs.get(bit) != 0) {
                if (ybs.get(bit) == 1) {
                    solution.append('N');
                } else {
                    solution.append('S');
                }
            }
            bit++;
        }
        return solution.toString();
    }

    private static String flip(String solStr, boolean flipx, boolean flipy) {
        if (flipx) {
            solStr = solStr.replace('E', 'T');
            solStr = solStr.replace('W', 'E');
            solStr = solStr.replace('T', 'W');
        }
        if (flipy) {
            solStr = solStr.replace('N', 'T');
            solStr = solStr.replace('S', 'N');
            solStr = solStr.replace('T', 'S');
        }
        return solStr;
    }

    private static boolean shiftIfAble2(ArrayList<Byte> bs, int bit) {
        if (bs.get(bit) != 0 || bit == 0) {
            return false;
        } else {
            if (bs.get(bit - 1) == 1) {
                bs.set(bit - 1, (byte) -1);
                bs.set(bit, (byte) 1);
                return true;
            } else {
                return false;
            }
        }
    }

    private static boolean shiftIfAble1(ArrayList<Byte> bs, int bit) {
        if (bit == 0) {
            return false;
        } else if (bs.get(bit - 1) == 1) {
                if (bit == bs.size() - 1){
                    bs.set(bit - 1, (byte) -1);
                    bs.set(bit, (byte) 0);
                    bs.add((byte) 1);
                    return true;
                } else if (bs.get(bit + 1) == 0) {
                    bs.set(bit - 1, (byte) -1);
                    bs.set(bit, (byte) 0);
                    bs.set(bit + 1, (byte) 1);
                    return true;
                } else {
                    return false;
                }
        } else {
            return false;
        }
    }

    /*private static int bitsNeeded(int n) {
        int bits = 1;
        int compare = 1;
        while (n > compare) {
            bits++;
            compare *= 2;
        }
        return bits;
    }*/

    private static void getBits(ArrayList<Byte> bs, int n) {
        //int bits = bitsNeeded(n);
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                bs.add((byte) 1);
            } else {
                bs.add((byte) 0);
            }
        }
    }

    public static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}
