import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static final boolean DEBUG = false;
    private static final int QUERIES = 10000;
    private static int U;
    private static long[] Q;
    private static String[] QS;
    private static String[] R;
    private static Set<Character> possibleChars = new HashSet<>();

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        if (DEBUG) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            U = sc.nextInt();
            Q = new long[QUERIES];
            QS = new String[QUERIES];
            R = new String[QUERIES];
            int[] counts = new int[26];
            for (int i = 0; i < QUERIES; i++) {
                Q[i] = sc.nextLong();
                QS[i] = String.valueOf(Q[i]);
                R[i] = sc.next();
                for (char ch : R[i].toCharArray()) {
                    possibleChars.add(ch);
                    counts[ch - 'A']++;
                }
            }
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        char[] results = new char[10];
        List<Set<Character>> possibilities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            possibilities.add(new HashSet<>(possibleChars));
        }

        for (int i = 0; i < QUERIES; i++) {
            if (QS[i].length() != R[i].length()) {
                continue;
            }
            long M = Q[i];
            int firstDigit = QS[i].charAt(0) - '0';
            char ch = R[i].charAt(0);
            if (M != -1) {
                for (int c = firstDigit + 1; c <= 9; c++) {
                    possibilities.get(c).remove(ch);
                }
            }
            possibilities.get(0).remove(ch);
        }

        int solved = 0;
        char removeChar = '\0';
        if (possibilities.get(0).size() == 1) {
            results[0] = possibilities.get(0).iterator().next();
            removeChar = results[0];
            solved++;
        }

        while (solved < 10) {
            for (Set<Character> possibility : possibilities) {
                possibility.remove(removeChar);
            }

            for (int i = 0; i < possibilities.size(); i++) {
                if (possibilities.get(i).size() == 1) {
                    removeChar = possibilities.get(i).iterator().next();
                    results[i] = removeChar;
                    solved++;
                    break;
                }
            }
        }

        return new String(results);
    }

    private static String joinValues(List<?> list, String delim) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static String joinValues(int[] arr, String delim) {
        return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(delim));
    }

    private static int[] readInts(Scanner sc, int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printDebug(Object str) {
        if (DEBUG) {
            System.out.println("DEBUG: " + str);
        }
    }
}