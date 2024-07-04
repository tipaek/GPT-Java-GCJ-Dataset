import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static final Scanner IN = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUT = System.out;

    public static void main(String[] args) {
        int T = IN.nextInt();
        int B = IN.nextInt();

        for (int t = 1; t <= T; t++) {
            StringBuilder answer = initializeAnswer(B);
            int index = 0;
            int readPairsCount = 5;
            int totalCharsRead = 0;

            while (index < B / 2) {
                totalCharsRead += readPairs(readPairsCount, index, answer);
                index += readPairsCount;

                if (index < B / 2) {
                    int[] indices = findIndices(answer, index, B);
                    int charsRead = transformAnswer(answer, indices[0], indices[1]);
                    if (charsRead == 1) {
                        readCharAt(1);
                        charsRead = 2;
                    }
                    totalCharsRead += charsRead;
                    readPairsCount = Math.min(4, B / 2 - index);
                }
            }

            OUT.println(answer);
            OUT.flush();
            String verdict = IN.next();
            if (verdict.equals("N")) {
                System.exit(1);
            }
        }
    }

    private static int[] findIndices(StringBuilder answer, int index, int B) {
        int eqIdx = -1, neIdx = -1, search = -1;
        while ((eqIdx == -1 || neIdx == -1) && ++search < index) {
            char left = answer.charAt(search);
            char right = answer.charAt(B - search - 1);
            if (left == right) {
                eqIdx = search;
            } else {
                neIdx = search;
            }
        }
        return new int[]{eqIdx, neIdx};
    }

    private static int transformAnswer(StringBuilder answer, int eqIdx, int neIdx) {
        int charsRead;
        if (eqIdx > -1 && neIdx > -1) {
            char eqBefore = answer.charAt(eqIdx);
            char neBefore = answer.charAt(neIdx);
            char eqAfter = readCharAt(eqIdx + 1);
            char neAfter = readCharAt(neIdx + 1);

            if (eqBefore == eqAfter) {
                if (neBefore != neAfter) {
                    reverse(answer);
                }
            } else {
                if (neBefore == neAfter) {
                    flip(answer);
                    reverse(answer);
                } else {
                    flip(answer);
                }
            }
            charsRead = 2;
        } else if (neIdx > -1) {
            char neBefore = answer.charAt(neIdx);
            char neAfter = readCharAt(neIdx + 1);
            if (neBefore != neAfter) {
                flip(answer);
            }
            charsRead = 1;
        } else {
            char eqBefore = answer.charAt(eqIdx);
            char eqAfter = readCharAt(eqIdx + 1);
            if (eqBefore != eqAfter) {
                flip(answer);
            }
            charsRead = 1;
        }
        return charsRead;
    }

    private static int readPairs(int count, int insertAt, StringBuilder sb) {
        for (int i = 0; i < count; i++) {
            sb.setCharAt(insertAt + i, readCharAt(insertAt + i + 1));
            sb.setCharAt(sb.length() - insertAt - i - 1, readCharAt(sb.length() - insertAt - i));
        }
        return 2 * count;
    }

    private static char readCharAt(int pos) {
        OUT.println(pos);
        OUT.flush();
        return (char) (IN.nextInt() + 48);
    }

    private static StringBuilder initializeAnswer(int B) {
        StringBuilder sb = new StringBuilder(B);
        for (int i = 0; i < B; i++) {
            sb.append("X");
        }
        return sb;
    }

    private static void reverse(StringBuilder sb) {
        sb.reverse();
    }

    private static void flip(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, flipChar(sb.charAt(i)));
        }
    }

    private static char flipChar(char c) {
        return c == '0' ? '1' : c == '1' ? '0' : c;
    }
}