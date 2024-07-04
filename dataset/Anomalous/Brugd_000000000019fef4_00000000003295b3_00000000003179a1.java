import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int T = input.nextInt();
        int sz = 10000;

        int[] Q = new int[sz];
        String[] R = new String[sz];

        for (int i = 0; i < T; i++) {
            int U = input.nextInt();
            for (int j = 0; j < sz; j++) {
                Q[j] = input.nextInt();
                R[j] = input.next();
            }

            String result = solve(U, Q, R);
            output.printf("Case #%d: %s%n", i + 1, result);
            output.flush();
        }

        input.close();
        output.close();
    }

    private static char getCharacterAtIndex(int index, int[] Q, String[] R, Set<Character> seen) {
        for (int i = 0; i < Q.length; i++) {
            if (R[i].isEmpty()) {
                continue;
            }

            char currentChar = R[i].charAt(0);
            if (Q[i] < index && !seen.contains(currentChar)) {
                seen.add(currentChar);
                return currentChar;
            }
        }
        return ' ';
    }

    private static String solve(int U, int[] Q, String[] R) {
        char[] result = new char[10];
        Set<Character> seenCharacters = new HashSet<>();

        for (int i = 1; i <= 10; i++) {
            result[i - 1] = getCharacterAtIndex(i, Q, R, seenCharacters);
        }

        return new String(result);
    }
}