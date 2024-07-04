package codejam;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        for (int x = 1; x <= t; x++) {
            int cur = 1;
            int known = 0;
            boolean[] result = new boolean[b];

            while (known < b) {
                if (known > 0 && cur % 10 == 1) {
                    boolean[] orig = Arrays.copyOf(result, known);
                    boolean[] comp = complementArray(orig);
                    boolean[] rev = reverseArray(orig);
                    boolean[] compRev = complementArray(rev);

                    boolean isCompSame = Arrays.equals(comp, orig);
                    boolean isRevSame = Arrays.equals(rev, orig);
                    if (!isRevSame && !isCompSame) isRevSame = Arrays.equals(rev, comp);

                    boolean isCRSame = Arrays.equals(compRev, orig);
                    if (!isCRSame && !isCompSame) isCRSame = Arrays.equals(compRev, comp);
                    if (!isCRSame && !isRevSame) isCRSame = Arrays.equals(compRev, rev);

                    if (isCompSame && isCRSame && isRevSame) {
                        known++;
                        System.out.println(known);
                        result[known - 1] = in.nextInt() == 1;
                        cur++;
                    } else {
                        handleBitFlip(in, cur, known, result, orig, comp, rev, compRev, isCompSame, isRevSame, isCRSame);
                    }
                } else {
                    known++;
                    System.out.println(known);
                    result[known - 1] = in.nextInt() == 1;
                    cur++;
                }
            }

            System.out.println(buildOutput(result, known));

            if (!"Y".equals(in.next())) break;
        }
    }

    private static void handleBitFlip(Scanner in, int cur, int known, boolean[] result, boolean[] orig, boolean[] comp, boolean[] rev, boolean[] compRev, boolean isCompSame, boolean isRevSame, boolean isCRSame) {
        int[] bitIndices;
        boolean res1, res2;

        if (isCompSame && isCRSame) {
            bitIndices = findOneBit(orig, rev);
            res1 = getBitResponse(in, cur, bitIndices[0]);
            if (res1 != orig[bitIndices[0]]) updateResult(result, rev, known);
        } else if (isCompSame && isRevSame) {
            bitIndices = findOneBit(orig, compRev);
            res1 = getBitResponse(in, cur, bitIndices[0]);
            if (res1 != orig[bitIndices[0]]) updateResult(result, compRev, known);
        } else if (isCRSame && isRevSame) {
            bitIndices = findOneBit(orig, comp);
            res1 = getBitResponse(in, cur, bitIndices[0]);
            if (res1 != orig[bitIndices[0]]) updateResult(result, comp, known);
        } else if (isCRSame) {
            bitIndices = findTwoBit(orig, comp, rev);
            res1 = getBitResponse(in, cur, bitIndices[0]);
            res2 = getBitResponse(in, cur, bitIndices[1]);
            updateResultBasedOnResponse(result, known, orig, comp, rev, res1, res2, bitIndices);
        } else if (isCompSame) {
            bitIndices = findTwoBit(orig, compRev, rev);
            res1 = getBitResponse(in, cur, bitIndices[0]);
            res2 = getBitResponse(in, cur, bitIndices[1]);
            updateResultBasedOnResponse(result, known, orig, compRev, rev, res1, res2, bitIndices);
        } else if (isRevSame) {
            bitIndices = findTwoBit(orig, compRev, comp);
            res1 = getBitResponse(in, cur, bitIndices[0]);
            res2 = getBitResponse(in, cur, bitIndices[1]);
            updateResultBasedOnResponse(result, known, orig, compRev, comp, res1, res2, bitIndices);
        } else {
            bitIndices = findTwoBit(orig, compRev, comp, rev);
            res1 = getBitResponse(in, cur, bitIndices[0]);
            res2 = getBitResponse(in, cur, bitIndices[1]);
            updateResultBasedOnResponse(result, known, orig, compRev, comp, rev, res1, res2, bitIndices);
        }
    }

    private static boolean getBitResponse(Scanner in, int cur, int bitIndex) {
        System.out.println(bitIndex + 1);
        cur++;
        return in.nextInt() == 1;
    }

    private static void updateResultBasedOnResponse(boolean[] result, int known, boolean[] orig, boolean[] arr1, boolean[] arr2, boolean res1, boolean res2, int[] bitIndices) {
        if (res1 != orig[bitIndices[0]] || res2 != orig[bitIndices[1]]) {
            if (res1 == arr1[bitIndices[0]] && res2 == arr1[bitIndices[1]]) {
                updateResult(result, arr1, known);
            } else {
                updateResult(result, arr2, known);
            }
        }
    }

    private static void updateResult(boolean[] result, boolean[] source, int known) {
        System.arraycopy(source, 0, result, 0, known);
    }

    private static String buildOutput(boolean[] result, int known) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < known; i++) {
            output.append(result[i] ? "1" : "0");
        }
        return output.toString();
    }

    private static boolean[] complementArray(boolean[] array) {
        boolean[] comp = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            comp[i] = !array[i];
        }
        return comp;
    }

    private static boolean[] reverseArray(boolean[] array) {
        boolean[] rev = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            rev[i] = array[array.length - 1 - i];
        }
        return rev;
    }

    private static int[] findOneBit(boolean[] a1, boolean[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return new int[]{i};
            }
        }
        return new int[]{0};
    }

    private static int[] findTwoBit(boolean[] a1, boolean[] a2, boolean[] a3) {
        return findTwoBit(a1, a2, a3, null);
    }

    private static int[] findTwoBit(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4) {
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1.length; j++) {
                if (isUniqueCombination(a1, a2, a3, a4, i, j)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 1};
    }

    private static boolean isUniqueCombination(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4, int i, int j) {
        String s1 = "" + a1[i] + a1[j];
        String s2 = "" + a2[i] + a2[j];
        String s3 = "" + a3[i] + a3[j];
        String s4 = (a4 != null) ? "" + a4[i] + a4[j] : null;

        return !s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3) && (s4 == null || (!s2.equals(s4) && !s1.equals(s4) && !s3.equals(s4)));
    }
}