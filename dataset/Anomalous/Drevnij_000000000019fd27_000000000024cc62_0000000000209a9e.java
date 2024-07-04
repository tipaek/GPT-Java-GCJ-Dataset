import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
                    boolean[] orig = new boolean[known];
                    boolean[] comp = new boolean[known];
                    boolean[] rev = new boolean[known];
                    boolean[] compRev = new boolean[known];

                    for (int i = 0; i < known / 2; i++) {
                        orig[i] = result[i];
                        orig[known - i - 1] = result[b - i - 1];
                    }

                    for (int i = 0; i < known; i++) {
                        comp[i] = !orig[i];
                        rev[i] = orig[known - i - 1];
                        compRev[i] = !orig[known - i - 1];
                    }

                    boolean isCompSame = arraysEqual(comp, orig);
                    boolean isRevSame = arraysEqual(rev, orig) || arraysEqual(rev, comp);
                    boolean isCRSame = arraysEqual(compRev, orig) || arraysEqual(compRev, comp) || arraysEqual(compRev, rev);

                    if (isCompSame && isCRSame && isRevSame) {
                        int index = known % 2 == 0 ? known / 2 + 1 : b - (known / 2);
                        System.out.println(index);
                        int bit = in.nextInt();
                        result[index - 1] = (bit == 1);
                        known++;
                        cur++;
                    } else {
                        handleBitComparisons(in, b, known, result, orig, comp, rev, compRev, isCompSame, isRevSame, isCRSame);
                        cur++;
                    }
                } else {
                    int index = known % 2 == 0 ? known / 2 + 1 : b - (known / 2);
                    System.out.println(index);
                    int bit = in.nextInt();
                    result[index - 1] = (bit == 1);
                    known++;
                    cur++;
                }
            }

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < known; i++) {
                output.append(result[i] ? "1" : "0");
            }

            System.out.println(output.toString());
            String answer = in.next();
            if (!"Y".equals(answer)) break;
        }
    }

    private static boolean arraysEqual(boolean[] a1, boolean[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    private static void handleBitComparisons(Scanner in, int b, int known, boolean[] result, boolean[] orig, boolean[] comp, boolean[] rev, boolean[] compRev, boolean isCompSame, boolean isRevSame, boolean isCRSame) {
        if (isCompSame && isCRSame) {
            handleCompAndCR(in, b, known, result, orig, rev);
        } else if (isCompSame && isRevSame) {
            handleCompAndRev(in, b, known, result, orig, compRev);
        } else if (isCRSame && isRevSame) {
            handleCRAndRev(in, b, known, result, orig, comp);
        } else if (isCRSame) {
            handleCR(in, b, known, result, orig, comp, rev);
        } else if (isCompSame) {
            handleComp(in, b, known, result, orig, compRev, rev);
        } else if (isRevSame) {
            handleRev(in, b, known, result, orig, compRev, comp);
        } else {
            handleDefault(in, b, known, result, orig, compRev, comp, rev);
        }
    }

    private static void handleCompAndCR(Scanner in, int b, int known, boolean[] result, boolean[] orig, boolean[] rev) {
        int bit = findOneBit(orig, rev);
        int index = bit < known / 2 ? bit : bit + b - known;
        System.out.println(index);
        boolean res = in.nextInt() == 1;
        if (res != orig[bit]) {
            for (int i = 0; i < known / 2; i++) {
                result[i] = rev[i];
                result[b - i - 1] = rev[known - i - 1];
            }
        }
    }

    private static void handleCompAndRev(Scanner in, int b, int known, boolean[] result, boolean[] orig, boolean[] compRev) {
        int bit = findOneBit(orig, compRev);
        int index = bit % 2 == 0 ? bit / 2 + 1 : b - (bit / 2);
        System.out.println(index);
        boolean res = in.nextInt() == 1;
        if (res != orig[bit]) {
            for (int i = 0; i < known / 2; i++) {
                result[i] = compRev[i];
                result[b - i - 1] = compRev[known - i - 1];
            }
        }
    }

    private static void handleCRAndRev(Scanner in, int b, int known, boolean[] result, boolean[] orig, boolean[] comp) {
        int bit = findOneBit(orig, comp);
        int index = bit % 2 == 0 ? bit / 2 + 1 : b - (bit / 2);
        System.out.println(index);
        boolean res = in.nextInt() == 1;
        if (res != orig[bit]) {
            for (int i = 0; i < known / 2; i++) {
                result[i] = comp[i];
                result[b - i - 1] = comp[known - i - 1];
            }
        }
    }

    private static void handleCR(Scanner in, int b, int known, boolean[] result, boolean[] orig, boolean[] comp, boolean[] rev) {
        int[] bit = findTwoBit(orig, comp, rev);
        int index1 = bit[0] % 2 == 0 ? bit[0] / 2 + 1 : b - (bit[0] / 2);
        System.out.println(index1);
        boolean res1 = in.nextInt() == 1;
        int index2 = bit[1] % 2 == 0 ? bit[1] / 2 + 1 : b - (bit[1] / 2);
        System.out.println(index2);
        boolean res2 = in.nextInt() == 1;
        if (res1 != orig[bit[0]] || res2 != orig[bit[1]]) {
            if (res1 == comp[bit[0]] && res2 == comp[bit[1]]) {
                for (int i = 0; i < known / 2; i++) {
                    result[i] = comp[i];
                    result[b - i - 1] = comp[known - i - 1];
                }
            } else {
                for (int i = 0; i < known / 2; i++) {
                    result[i] = rev[i];
                    result[b - i - 1] = rev[known - i - 1];
                }
            }
        }
    }

    private static void handleComp(Scanner in, int b, int known, boolean[] result, boolean[] orig, boolean[] compRev, boolean[] rev) {
        int[] bit = findTwoBit(orig, compRev, rev);
        int index1 = bit[0] % 2 == 0 ? bit[0] / 2 + 1 : b - (bit[0] / 2);
        System.out.println(index1);
        boolean res1 = in.nextInt() == 1;
        int index2 = bit[1] % 2 == 0 ? bit[1] / 2 + 1 : b - (bit[1] / 2);
        System.out.println(index2);
        boolean res2 = in.nextInt() == 1;
        if (res1 != orig[bit[0]] || res2 != orig[bit[1]]) {
            if (res1 == compRev[bit[0]] && res2 == compRev[bit[1]]) {
                for (int i = 0; i < known / 2; i++) {
                    result[i] = compRev[i];
                    result[b - i - 1] = compRev[known - i - 1];
                }
            } else {
                for (int i = 0; i < known / 2; i++) {
                    result[i] = rev[i];
                    result[b - i - 1] = rev[known - i - 1];
                }
            }
        }
    }

    private static void handleRev(Scanner in, int b, int known, boolean[] result, boolean[] orig, boolean[] compRev, boolean[] comp) {
        int[] bit = findTwoBit(orig, compRev, comp);
        int index1 = bit[0] % 2 == 0 ? bit[0] / 2 + 1 : b - (bit[0] / 2);
        System.out.println(index1);
        boolean res1 = in.nextInt() == 1;
        int index2 = bit[1] % 2 == 0 ? bit[1] / 2 + 1 : b - (bit[1] / 2);
        System.out.println(index2);
        boolean res2 = in.nextInt() == 1;
        if (res1 != orig[bit[0]] || res2 != orig[bit[1]]) {
            if (res1 == compRev[bit[0]] && res2 == compRev[bit[1]]) {
                for (int i = 0; i < known / 2; i++) {
                    result[i] = compRev[i];
                    result[b - i - 1] = compRev[known - i - 1];
                }
            } else {
                for (int i = 0; i < known / 2; i++) {
                    result[i] = comp[i];
                    result[b - i - 1] = comp[known - i - 1];
                }
            }
        }
    }

    private static void handleDefault(Scanner in, int b, int known, boolean[] result, boolean[] orig, boolean[] compRev, boolean[] comp, boolean[] rev) {
        int[] bit = findTwoBit(orig, compRev, comp, rev);
        int index1 = bit[0] % 2 == 0 ? bit[0] / 2 + 1 : b - (bit[0] / 2);
        System.out.println(index1);
        boolean res1 = in.nextInt() == 1;
        int index2 = bit[1] % 2 == 0 ? bit[1] / 2 + 1 : b - (bit[1] / 2);
        System.out.println(index2);
        boolean res2 = in.nextInt() == 1;
        if (res1 != orig[bit[0]] || res2 != orig[bit[1]]) {
            if (res1 == compRev[bit[0]] && res2 == compRev[bit[1]]) {
                for (int i = 0; i < known / 2; i++) {
                    result[i] = compRev[i];
                    result[b - i - 1] = compRev[known - i - 1];
                }
            } else if (res1 == comp[bit[0]] && res2 == comp[bit[1]]) {
                for (int i = 0; i < known / 2; i++) {
                    result[i] = comp[i];
                    result[b - i - 1] = comp[known - i - 1];
                }
            } else {
                for (int i = 0; i < known / 2; i++) {
                    result[i] = rev[i];
                    result[b - i - 1] = rev[known - i - 1];
                }
            }
        }
    }

    private static int findOneBit(boolean[] a1, boolean[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return i;
        }
        return 0;
    }

    private static int[] findTwoBit(boolean[] a1, boolean[] a2, boolean[] a3) {
        int[] result = new int[2];
        for (int i = 0; i < a1.length; i++) {
            for (int j = i + 1; j < a1.length; j++) {
                if (distinctPairs(a1, a2, a3, i, j)) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    private static int[] findTwoBit(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4) {
        int[] result = new int[2];
        for (int i = 0; i < a1.length; i++) {
            for (int j = i + 1; j < a1.length; j++) {
                if (distinctPairs(a1, a2, a3, a4, i, j)) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    private static boolean distinctPairs(boolean[]... arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                if (arraysEqual(arrays[i], arrays[j])) return false;
            }
        }
        return true;
    }

    private static boolean distinctPairs(boolean[] a1, boolean[] a2, boolean[] a3, int i, int j) {
        String s1 = "" + a1[i] + a1[j];
        String s2 = "" + a2[i] + a2[j];
        String s3 = "" + a3[i] + a3[j];
        return !s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3);
    }

    private static boolean distinctPairs(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4, int i, int j) {
        String s1 = "" + a1[i] + a1[j];
        String s2 = "" + a2[i] + a2[j];
        String s3 = "" + a3[i] + a3[j];
        String s4 = "" + a4[i] + a4[j];
        return !s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3) && !s2.equals(s4) && !s1.equals(s4) && !s3.equals(s4);
    }
}