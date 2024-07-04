import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int x = 1; x <= t; x++) {
            boolean[] result = new boolean[b];
            int known = 0, cur = 1;

            while (known < b) {
                if (known > 0 && cur % 10 == 1) {
                    boolean[] orig = Arrays.copyOf(result, known);
                    boolean[] comp = invertArray(orig);
                    boolean[] rev = reverseArray(orig);
                    boolean[] compRev = invertArray(rev);

                    boolean isCompSame = checkEquality(orig, comp);
                    boolean isRevSame = checkEquality(orig, rev) || checkEquality(comp, rev);
                    boolean isCRSame = checkEquality(orig, compRev) || checkEquality(comp, compRev) || checkEquality(rev, compRev);

                    if (isCompSame && isCRSame && isRevSame) {
                        int index = getIndex(known, b);
                        result[index - 1] = readBit(in, index);
                        known++;
                        cur++;
                    } else if (isCompSame && isCRSame) {
                        updateResult(in, orig, rev, result, known, b);
                        cur += 2;
                    } else if (isCompSame && isRevSame) {
                        updateResult(in, orig, compRev, result, known, b);
                        cur += 2;
                    } else if (isCRSame && isRevSame) {
                        updateResult(in, orig, comp, result, known, b);
                        cur += 2;
                    } else if (isCRSame) {
                        updateResult(in, orig, comp, rev, result, known, b);
                        cur += 4;
                    } else if (isCompSame) {
                        updateResult(in, orig, compRev, rev, result, known, b);
                        cur += 4;
                    } else if (isRevSame) {
                        updateResult(in, orig, compRev, comp, result, known, b);
                        cur += 4;
                    } else {
                        updateResult(in, orig, compRev, comp, rev, result, known, b);
                        cur += 4;
                    }
                } else {
                    int index = getIndex(known, b);
                    result[index - 1] = readBit(in, index);
                    known++;
                    cur++;
                }
            }

            String output = buildOutput(result, known);
            System.out.println(output);

            if (!"Y".equals(in.next())) break;
        }
    }

    private static boolean[] invertArray(boolean[] arr) {
        boolean[] inverted = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            inverted[i] = !arr[i];
        }
        return inverted;
    }

    private static boolean[] reverseArray(boolean[] arr) {
        boolean[] reversed = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    private static boolean checkEquality(boolean[] a1, boolean[] a2) {
        return Arrays.equals(a1, a2);
    }

    private static int getIndex(int known, int b) {
        return known % 2 == 0 ? known / 2 + 1 : b - (known / 2);
    }

    private static boolean readBit(Scanner in, int index) {
        System.out.println(index);
        return in.nextInt() == 1;
    }

    private static void updateResult(Scanner in, boolean[] orig, boolean[] alt1, boolean[] result, int known, int b) {
        int bit = findOneBit(orig, alt1);
        int index = getIndex(bit, known, b);
        boolean res = readBit(in, index);
        if (res != orig[bit]) {
            System.arraycopy(alt1, 0, result, 0, known / 2);
            System.arraycopy(alt1, 0, result, b - known, known / 2);
            if (known % 2 == 1) result[known / 2] = alt1[known / 2];
        }
    }

    private static void updateResult(Scanner in, boolean[] orig, boolean[] alt1, boolean[] alt2, boolean[] result, int known, int b) {
        int[] bits = findTwoBits(orig, alt1, alt2);
        int index1 = getIndex(bits[0], known, b);
        boolean res1 = readBit(in, index1);
        int index2 = getIndex(bits[1], known, b);
        boolean res2 = readBit(in, index2);
        if (res1 != orig[bits[0]] || res2 != orig[bits[1]]) {
            if (res1 == alt1[bits[0]] && res2 == alt1[bits[1]]) {
                System.arraycopy(alt1, 0, result, 0, known / 2);
                System.arraycopy(alt1, 0, result, b - known, known / 2);
                if (known % 2 == 1) result[known / 2] = alt1[known / 2];
            } else {
                System.arraycopy(alt2, 0, result, 0, known / 2);
                System.arraycopy(alt2, 0, result, b - known, known / 2);
                if (known % 2 == 1) result[known / 2] = alt2[known / 2];
            }
        }
    }

    private static void updateResult(Scanner in, boolean[] orig, boolean[] alt1, boolean[] alt2, boolean[] alt3, boolean[] result, int known, int b) {
        int[] bits = findTwoBits(orig, alt1, alt2, alt3);
        int index1 = getIndex(bits[0], known, b);
        boolean res1 = readBit(in, index1);
        int index2 = getIndex(bits[1], known, b);
        boolean res2 = readBit(in, index2);
        if (res1 != orig[bits[0]] || res2 != orig[bits[1]]) {
            if (res1 == alt1[bits[0]] && res2 == alt1[bits[1]]) {
                System.arraycopy(alt1, 0, result, 0, known / 2);
                System.arraycopy(alt1, 0, result, b - known, known / 2);
                if (known % 2 == 1) result[known / 2] = alt1[known / 2];
            } else if (res1 == alt2[bits[0]] && res2 == alt2[bits[1]]) {
                System.arraycopy(alt2, 0, result, 0, known / 2);
                System.arraycopy(alt2, 0, result, b - known, known / 2);
                if (known % 2 == 1) result[known / 2] = alt2[known / 2];
            } else {
                System.arraycopy(alt3, 0, result, 0, known / 2);
                System.arraycopy(alt3, 0, result, b - known, known / 2);
                if (known % 2 == 1) result[known / 2] = alt3[known / 2];
            }
        }
    }

    private static int findOneBit(boolean[] a1, boolean[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return i;
        }
        return 0;
    }

    private static int[] findTwoBits(boolean[] a1, boolean[] a2, boolean[] a3) {
        for (int i = 0; i < a1.length; i++) {
            for (int j = i + 1; j < a1.length; j++) {
                if (!comparePairs(a1, a2, a3, i, j)) return new int[]{i, j};
            }
        }
        return new int[]{0, 1};
    }

    private static int[] findTwoBits(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4) {
        for (int i = 0; i < a1.length; i++) {
            for (int j = i + 1; j < a1.length; j++) {
                if (!comparePairs(a1, a2, a3, a4, i, j)) return new int[]{i, j};
            }
        }
        return new int[]{0, 1};
    }

    private static boolean comparePairs(boolean[] a1, boolean[] a2, boolean[] a3, int i, int j) {
        return comparePairs(a1, a2, a3, null, i, j);
    }

    private static boolean comparePairs(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4, int i, int j) {
        String s1 = "" + a1[i] + a1[j];
        String s2 = "" + a2[i] + a2[j];
        String s3 = "" + a3[i] + a3[j];
        if (a4 != null) {
            String s4 = "" + a4[i] + a4[j];
            return s1.equals(s2) || s1.equals(s3) || s1.equals(s4) || s2.equals(s3) || s2.equals(s4) || s3.equals(s4);
        }
        return s1.equals(s2) || s1.equals(s3) || s2.equals(s3);
    }

    private static int getIndex(int bit, int known, int b) {
        return bit < known / 2 || (bit == known / 2 && known % 2 == 1) ? bit + 1 : bit + b - known + 1;
    }

    private static String buildOutput(boolean[] result, int known) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < known; i++) {
            output.append(result[i] ? "1" : "0");
        }
        return output.toString();
    }
}