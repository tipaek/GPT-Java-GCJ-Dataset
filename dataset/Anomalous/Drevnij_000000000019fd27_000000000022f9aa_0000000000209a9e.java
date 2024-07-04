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
                    boolean[] comp = new boolean[known];
                    boolean[] rev = new boolean[known];
                    boolean[] compRev = new boolean[known];

                    for (int i = 0; i < known; i++) {
                        comp[i] = !result[i];
                        rev[i] = result[known - i - 1];
                        compRev[i] = !result[known - i - 1];
                    }

                    boolean isCompSame = Arrays.equals(comp, orig);
                    boolean isRevSame = Arrays.equals(rev, orig);
                    if (!isRevSame && !isCompSame) {
                        isRevSame = Arrays.equals(rev, comp);
                    }
                    boolean isCRSame = Arrays.equals(compRev, orig);
                    if (!isCRSame && !isCompSame) {
                        isCRSame = Arrays.equals(compRev, comp);
                    }
                    if (!isCRSame && !isRevSame) {
                        isCRSame = Arrays.equals(compRev, rev);
                    }

                    if (isCompSame && isCRSame && isRevSame) {
                        known++;
                        System.out.println(known);
                        result[known - 1] = in.nextInt() == 1;
                        cur++;
                    } else if (isCompSame && isCRSame) {
                        handleCase(orig, rev, in, result);
                        cur++;
                    } else if (isCompSame && isRevSame) {
                        handleCase(orig, compRev, in, result);
                        cur++;
                    } else if (isCRSame && isRevSame) {
                        handleCase(orig, comp, in, result);
                        cur++;
                    } else if (isCRSame) {
                        handleTwoBitCase(orig, comp, rev, in, result);
                        cur += 2;
                    } else if (isCompSame) {
                        handleTwoBitCase(orig, compRev, rev, in, result);
                        cur += 2;
                    } else if (isRevSame) {
                        handleTwoBitCase(orig, compRev, comp, in, result);
                        cur += 2;
                    } else {
                        handleTwoBitCase(orig, compRev, comp, rev, in, result);
                        cur += 2;
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

    private static void handleCase(boolean[] orig, boolean[] other, Scanner in, boolean[] result) {
        int bit = findOneBit(orig, other);
        int index = bit + 1;
        System.out.println(index);
        boolean res = in.nextInt() == 1;
        if (res != orig[bit]) {
            System.arraycopy(other, 0, result, 0, orig.length);
        }
    }

    private static void handleTwoBitCase(boolean[] a1, boolean[] a2, boolean[] a3, Scanner in, boolean[] result) {
        int[] bits = findTwoBit(a1, a2, a3);
        int index1 = bits[0] + 1;
        System.out.println(index1);
        boolean res1 = in.nextInt() == 1;
        int index2 = bits[1] + 1;
        System.out.println(index2);
        boolean res2 = in.nextInt() == 1;

        if (res1 != a1[bits[0]] || res2 != a1[bits[1]]) {
            if (res1 == a2[bits[0]] && res2 == a2[bits[1]]) {
                System.arraycopy(a2, 0, result, 0, a1.length);
            } else {
                System.arraycopy(a3, 0, result, 0, a1.length);
            }
        }
    }

    private static void handleTwoBitCase(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4, Scanner in, boolean[] result) {
        int[] bits = findTwoBit(a1, a2, a3, a4);
        int index1 = bits[0] + 1;
        System.out.println(index1);
        boolean res1 = in.nextInt() == 1;
        int index2 = bits[1] + 1;
        System.out.println(index2);
        boolean res2 = in.nextInt() == 1;

        if (res1 != a1[bits[0]] || res2 != a1[bits[1]]) {
            if (res1 == a2[bits[0]] && res2 == a2[bits[1]]) {
                System.arraycopy(a2, 0, result, 0, a1.length);
            } else if (res1 == a3[bits[0]] && res2 == a3[bits[1]]) {
                System.arraycopy(a3, 0, result, 0, a1.length);
            } else {
                System.arraycopy(a4, 0, result, 0, a1.length);
            }
        }
    }

    private static int findOneBit(boolean[] a1, boolean[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] findTwoBit(boolean[] a1, boolean[] a2, boolean[] a3) {
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1.length; j++) {
                if (isUniquePair(a1[i], a1[j], a2[i], a2[j], a3[i], a3[j])) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    private static int[] findTwoBit(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4) {
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1.length; j++) {
                if (isUniquePair(a1[i], a1[j], a2[i], a2[j], a3[i], a3[j], a4[i], a4[j])) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    private static boolean isUniquePair(boolean... bits) {
        Set<String> pairs = new HashSet<>();
        for (int i = 0; i < bits.length; i += 2) {
            pairs.add("" + bits[i] + bits[i + 1]);
        }
        return pairs.size() == bits.length / 2;
    }

    private static String buildOutput(boolean[] result, int known) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < known; i++) {
            output.append(result[i] ? "1" : "0");
        }
        return output.toString();
    }
}