import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static Scanner in;
    private static PrintStream out;

    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    static int[] cnt = new int[128];
    static int nChars;

    static Set<Character> allDigits = new HashSet<>();
    static Set<Character> leadingDigits = new HashSet<>();

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
        out = System.out;

        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            allDigits.clear();
            leadingDigits.clear();
            nChars = 0;
            Arrays.fill(cnt, 0);

            int U = in.nextInt();

            for (int i = 0; i < 10000; i++) {
                long qi = in.nextLong();
                String ri = in.next();
                for (int j = 0; j < ri.length(); j++) {
                    char ch = ri.charAt(j);
                    cnt[ch]++;
                    allDigits.add(ch);
                }
                leadingDigits.add(ri.charAt(0));
            }

            Set<Character> neverLeading = new HashSet<>(allDigits);
            neverLeading.removeAll(leadingDigits);
            char zero = neverLeading.iterator().next();

            char[] result = new char[10];
            result[0] = zero;

            Set<Character> used = new HashSet<>();
            used.add(zero);
            for (int i = 1; i <= 9; i++) {
                int maxcnt = -1;
                char maxch = 0;

                for (char ch : allDigits) {
                    int cntch = cnt[ch];
                    if (!used.contains(ch) && cntch > maxcnt) {
                        maxcnt = cntch;
                        maxch = ch;
                    }
                }

                result[i] = maxch;
                used.add(maxch);
            }

            out.print(CASE_N);
            out.print(t);
            out.print(COLON_SPACE);
            out.print(new String(result));
            out.println();
        }
        out.flush();
    }
}