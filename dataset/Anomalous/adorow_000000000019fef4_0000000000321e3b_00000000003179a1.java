import java.util.*;

public class Solution {

    private static Scanner in;
    private static PrintStream out;

    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    static int[] Q = new int[10001];
    static String[] R = new String[10001];

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
        out = System.out;

        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int U = in.nextInt();

            LinkedList<String>[] digitsR = new LinkedList[10];
            Set<Character> allDigits = new HashSet<>();
            Set<Character> leadingDigits = new HashSet<>();

            for (int i = 0; i < 10; i++) {
                digitsR[i] = new LinkedList<>();
            }

            for (int i = 0; i < 10000; i++) {
                int qi = in.nextInt();
                String ri = in.next();
                for (char ch : ri.toCharArray()) {
                    allDigits.add(ch);
                }
                leadingDigits.add(ri.charAt(0));

                Q[i] = qi;
                R[i] = ri;

                if (qi < 10 && qi >= 0) {
                    digitsR[qi].add(ri);
                }
            }

            char[] result = new char[10];

            for (int i = 1; i <= 9; i++) {
                for (String ri : digitsR[i]) {
                    char ch = ri.charAt(0);
                    boolean found = false;
                    for (int j = 1; j < i; j++) {
                        if (ch == result[j]) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        result[i] = ch;
                        break;
                    }
                }
            }

            char zero = findMissing(allDigits, result, 1, 9);
            result[0] = zero;

            out.print(CASE_N);
            out.print(t);
            out.print(COLON_SPACE);
            out.print(new String(result));
            out.println();
        }
        out.flush();
    }

    private static char findMissing(Set<Character> allDigits, char[] result, int firstInclusive, int lastInclusive) {
        for (char ch : allDigits) {
            boolean found = false;
            for (int i = firstInclusive; i <= lastInclusive; i++) {
                if (ch == result[i]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return ch;
            }
        }
        throw new RuntimeException("Did not find missing character");
    }
}