import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        for (int x = 1; x <= t; x++) {
            boolean[] result = new boolean[b];
            int known = 0;
            int cur = 1;

            while (known < b) {
                if (known > 0 && cur % 10 == 1) {
                    boolean[] orig = Arrays.copyOf(result, known);
                    boolean[] comp = new boolean[known];
                    boolean[] rev = new boolean[known];
                    boolean[] compRev = new boolean[known];
                    
                    for (int i = 0; i < known; i++) {
                        comp[i] = !orig[i];
                        rev[i] = orig[known - i - 1];
                        compRev[i] = !rev[i];
                    }

                    boolean isCompSame = Arrays.equals(comp, orig);
                    boolean isRevSame = Arrays.equals(rev, orig);
                    boolean isCRSame = Arrays.equals(compRev, orig);

                    if (!isRevSame && !isCompSame) {
                        isRevSame = Arrays.equals(rev, comp);
                    }

                    if (!isCRSame && !isCompSame) {
                        isCRSame = Arrays.equals(compRev, comp);
                    }

                    if (!isCRSame && !isRevSame) {
                        isCRSame = Arrays.equals(compRev, rev);
                    }

                    if (isCompSame && isCRSame && isRevSame) {
                        int index = known % 2 == 0 ? known / 2 + 1 : b - (known / 2);
                        System.out.println(index);
                        result[index - 1] = in.nextInt() == 1;
                        known++;
                        cur++;
                    } else {
                        handleTransformations(in, result, orig, rev, comp, compRev, known, b);
                        cur += 2;
                    }
                } else {
                    int index = known % 2 == 0 ? known / 2 + 1 : b - (known / 2);
                    System.out.println(index);
                    result[index - 1] = in.nextInt() == 1;
                    known++;
                    cur++;
                }
            }

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < known; i++) {
                output.append(result[i] ? "1" : "0");
            }
            System.out.println(output.toString());

            if (!"Y".equals(in.next())) break;
        }
    }

    private static void handleTransformations(Scanner in, boolean[] result, boolean[] orig, boolean[] rev, boolean[] comp, boolean[] compRev, int known, int b) {
        int[] bits = findTwoBit(orig, comp, rev, compRev);
        int index1 = bits[0] < known / 2 ? bits[0] + 1 : bits[0] + b - known + 1;
        System.out.println(index1);
        boolean res1 = in.nextInt() == 1;

        int index2 = bits[1] < known / 2 ? bits[1] + 1 : bits[1] + b - known + 1;
        System.out.println(index2);
        boolean res2 = in.nextInt() == 1;

        if (res1 != orig[bits[0]] || res2 != orig[bits[1]]) {
            if (res1 == compRev[bits[0]] && res2 == compRev[bits[1]]) {
                System.arraycopy(compRev, 0, result, 0, known);
            } else if (res1 == comp[bits[0]] && res2 == comp[bits[1]]) {
                System.arraycopy(comp, 0, result, 0, known);
            } else {
                System.arraycopy(rev, 0, result, 0, known);
            }
        }
    }

    private static int[] findTwoBit(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4) {
        int[] result = new int[2];
        for (int i = 0; i < a1.length; i++) {
            for (int j = i + 1; j < a1.length; j++) {
                String s1 = "" + a1[i] + a1[j];
                String s2 = "" + a2[i] + a2[j];
                String s3 = "" + a3[i] + a3[j];
                String s4 = "" + a4[i] + a4[j];
                if (!s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3) && !s2.equals(s4) && !s1.equals(s4) && !s3.equals(s4)) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}