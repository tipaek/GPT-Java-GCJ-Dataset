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

    static int[] ix = new int[255];
    static int[] cnt = new int[255];
    static int nChars;

    static LinkedList<String>[] digitsR = new LinkedList[10];
    static HashSet<Character> allDigits = new HashSet<>();
    static HashSet<Character> leadingDigits = new HashSet<>();

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
//        in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/round1c/B/B.in"));
        out = System.out;
        //out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            allDigits.clear();
            leadingDigits.clear();
            nChars = 0;
            Arrays.fill(ix, -1);
            Arrays.fill(cnt, 0);

            int U = in.nextInt();

            for (int i = 0; i < 10; i++) {
                digitsR[i] = new LinkedList<>();
            }

            // query all
            for (int i = 0; i < 10000; i++) {
                int qi = in.nextInt();
                String ri = in.next();
                for (int j = 0; j < ri.length(); j++) {
                    char ch = ri.charAt(j);
                    if (ix[ch] == -1) {
                        ix[ch] = nChars++;
                    }
                    cnt[ch]++;
                    allDigits.add(ch);
                }
                // zero may never be a leading digit
                leadingDigits.add(ri.charAt(0));

                Q[i] = qi;
                R[i] = ri;

                if (qi < 10 && qi > -1) {
                    digitsR[qi].add(ri);
                }
            }

            char[] result = new char[10];

            Set<Character> neverLeading = new HashSet<>(allDigits);
            neverLeading.removeAll(leadingDigits);
            // given the amount of samples, only ZERO should never appear as a leading digit
            char zero = neverLeading.iterator().next();
            result[0] = zero;

            // using probability to find the numbers by distribution (given randomness, should have more 1s, then , 2s, 3s, etc.. 9s and then 0s (but zeros we know they wone ever be leading)
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

//            // -------
//            out.println("Distribution:");
//            for (char ch: allDigits) {
//                out.print(ch);
//                out.print(": ");
//                out.print("ix=");
//                out.print(ix[ch]);
//                out.print(", cnt=");
//                out.print(cnt[ch]);
//                out.println();
//            }
//            out.println();
//            // -------

            out.println();
        }
        out.flush();
    }

}
