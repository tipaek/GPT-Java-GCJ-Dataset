import java.io.FileInputStream;
import java.io.PrintStream;
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
        // in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/round1c/B/B.in"));
        out = System.out;
        // out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int T = in.nextInt();

        List<String>[] digitsR = new ArrayList[10];
        Set<Character> allDigits = new HashSet<>();
        Set<Character> leadingDigits = new HashSet<>();

        for (int t = 1; t <= T; t++) {
            int U = in.nextInt();

            for (int i = 0; i < 10; i++) {
                digitsR[i] = new ArrayList<>();
            }

            // Query all
            for (int i = 0; i < 10000; i++) {
                int qi = in.nextInt();
                String ri = in.next();
                for (char ch : ri.toCharArray()) {
                    allDigits.add(ch);
                }
                leadingDigits.add(ri.charAt(0));

                Q[i] = qi;
                R[i] = ri;

                if (qi >= 0 && qi < 10) {
                    digitsR[qi].add(ri);
                }
            }

            char[] result = new char[10];

            Set<Character> neverLeading = new HashSet<>(allDigits);
            neverLeading.removeAll(leadingDigits);
            char zero = neverLeading.iterator().next();
            result[0] = zero;

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
        throw new RuntimeException("Did not find missing char");
    }
}