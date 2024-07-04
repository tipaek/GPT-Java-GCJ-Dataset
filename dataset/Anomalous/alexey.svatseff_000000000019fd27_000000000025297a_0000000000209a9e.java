import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    static int T;
    static int B;

    private static boolean solveCase(int caseNumber, Scanner in, PrintStream out) throws Exception {
        int[] a = new int[B];
        int lookupDepth = 0;
        int maxLookupDepth = B / 2;
        boolean isCheckCenterElement = B % 2 == 1;

        int inversionCheckIndex = -1, inversionCheckValue = -1;
        int rotationCheckIndex = -1, rotationCheckValue = -1;
        boolean isPalindromeMargin = true, isNegationMargin = true;

        for (int section = 0; section < 15; ++section) {
            int[] stepsRemaining = new int[]{10};
            if (section > 0) {
                if (isPalindromeMargin) {
                    int actualValue = lookupInteraction(in, out, inversionCheckIndex, stepsRemaining);
                    if (actualValue != inversionCheckValue) {
                        invert(a);
                        inversionCheckValue = actualValue;
                    }
                } else if (isNegationMargin) {
                    int actualValue = lookupInteraction(in, out, rotationCheckIndex, stepsRemaining);
                    if (actualValue != rotationCheckValue) {
                        rotate(a);
                        rotationCheckValue = actualValue;
                    }
                } else {
                    int actualValue = lookupInteraction(in, out, inversionCheckIndex, stepsRemaining);
                    if (actualValue != inversionCheckValue) {
                        invert(a);
                        inversionCheckValue = actualValue;
                        rotationCheckValue = 1 - rotationCheckValue;
                    }
                    actualValue = lookupInteraction(in, out, rotationCheckIndex, stepsRemaining);
                    if (actualValue != rotationCheckValue) {
                        rotate(a);
                        rotationCheckValue = actualValue;
                    }
                }
            }

            int lookupPairsCount = Math.min(stepsRemaining[0] / 2, maxLookupDepth - lookupDepth);
            for (int i = 0; i < lookupPairsCount; ++i) {
                int iLeft = lookupDepth, iRight = B - lookupDepth - 1;
                int leftValue = lookupInteraction(in, out, iLeft, stepsRemaining);
                int rightValue = lookupInteraction(in, out, iRight, stepsRemaining);
                ++lookupDepth;

                a[iLeft] = leftValue;
                a[iRight] = rightValue;

                if (leftValue == rightValue) {
                    isNegationMargin = false;
                    if (inversionCheckIndex == -1) {
                        inversionCheckIndex = iLeft;
                        inversionCheckValue = leftValue;
                    }
                } else {
                    isPalindromeMargin = false;
                    if (rotationCheckIndex == -1) {
                        rotationCheckIndex = iLeft;
                        rotationCheckValue = leftValue;
                    }
                }
            }

            if (lookupDepth == maxLookupDepth) {
                if (isCheckCenterElement) {
                    if (stepsRemaining[0] == 0) continue;
                    a[maxLookupDepth] = lookupInteraction(in, out, maxLookupDepth, stepsRemaining);
                }

                char[] result = new char[B];
                for (int i = 0; i < B; ++i)
                    result[i] = a[i] == 1 ? '1' : '0';
                out.println(new String(result));
                out.flush();

                String judge = in.nextLine();
                return "Y".equals(judge.trim());
            } else {
                while (stepsRemaining[0] > 0)
                    lookupInteraction(in, out, 0, stepsRemaining);
            }
        }

        throw new IllegalStateException();
    }

    private static void rotate(int[] a) {
        for (int i = 0; i < a.length / 2; ++i) {
            int tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }
    }

    private static void invert(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            a[i] = 1 - a[i];
        }
    }

    private static int lookupInteraction(Scanner in, PrintStream out, int idx, int[] stepsRemaining) {
        --stepsRemaining[0];
        out.println(1 + idx);
        out.flush();
        return Integer.parseInt(in.nextLine());
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);

            try (Scanner in = openInput(args);
                 PrintStream out = openOutput(args)) {

                T = in.nextInt();
                B = in.nextInt();
                in.nextLine();
                for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
                    if (!solveCase(caseNumber, in, out))
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Scanner openInput(String[] args) throws FileNotFoundException {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static PrintStream openOutput(String[] args) throws IOException {
        return System.out;
    }
}