import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    private static Scanner in;
    private static PrintStream out;

    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    private static final int MAX_QUERIES = 10000;
    private static final int MAX_DIGITS = 10;
    private static final int ASCII_SIZE = 255;

    private static int[] Q = new int[MAX_QUERIES + 1];
    private static String[] R = new String[MAX_QUERIES + 1];

    private static int[] charIndex = new int[ASCII_SIZE];
    private static int[] charCount = new int[ASCII_SIZE];
    private static int numChars;

    private static LinkedList<String>[] digitStrings = new LinkedList[MAX_DIGITS];
    private static HashSet<Character> allChars = new HashSet<>();
    private static HashSet<Character> leadingChars = new HashSet<>();

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
        out = System.out;

        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            resetData();

            int U = in.nextInt();

            for (int i = 0; i < MAX_DIGITS; i++) {
                digitStrings[i] = new LinkedList<>();
            }

            processQueries();

            char[] result = determineDigitOrder();

            printResult(t, result);
        }
        out.flush();
    }

    private static void resetData() {
        allChars.clear();
        leadingChars.clear();
        numChars = 0;
        Arrays.fill(charIndex, -1);
        Arrays.fill(charCount, 0);
    }

    private static void processQueries() {
        for (int i = 0; i < MAX_QUERIES; i++) {
            int qi = in.nextInt();
            String ri = in.next();

            for (char ch : ri.toCharArray()) {
                if (charIndex[ch] == -1) {
                    charIndex[ch] = numChars++;
                }
                charCount[ch]++;
                allChars.add(ch);
            }

            leadingChars.add(ri.charAt(0));

            Q[i] = qi;
            R[i] = ri;

            if (qi >= 0 && qi < MAX_DIGITS) {
                digitStrings[qi].add(ri);
            }
        }
    }

    private static char[] determineDigitOrder() {
        char[] result = new char[MAX_DIGITS];

        Set<Character> neverLeading = new HashSet<>(allChars);
        neverLeading.removeAll(leadingChars);
        char zero = neverLeading.iterator().next();
        result[0] = zero;

        Set<Character> usedChars = new HashSet<>();
        usedChars.add(zero);

        for (int i = 1; i < MAX_DIGITS; i++) {
            char maxChar = findMaxChar(usedChars);
            result[i] = maxChar;
            usedChars.add(maxChar);
        }

        return result;
    }

    private static char findMaxChar(Set<Character> usedChars) {
        int maxCount = -1;
        char maxChar = 0;

        for (char ch : allChars) {
            int count = charCount[ch];
            if (!usedChars.contains(ch) && count > maxCount) {
                maxCount = count;
                maxChar = ch;
            }
        }

        return maxChar;
    }

    private static void printResult(int caseNumber, char[] result) {
        out.print(CASE_N);
        out.print(caseNumber);
        out.print(COLON_SPACE);
        out.print(new String(result));
        out.println();
    }
}