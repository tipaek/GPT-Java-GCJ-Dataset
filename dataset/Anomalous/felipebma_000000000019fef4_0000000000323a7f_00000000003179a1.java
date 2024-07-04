import java.util.*;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int i = 1; i <= numberOfCases; i++) {
            solveCase(i);
        }
    }

    private static void solveCase(int caseNumber) {
        System.out.printf("Case #%d: ", caseNumber);
        long u = scanner.nextLong();
        long maxQueries = (long) 1e4;
        HashSet<Character>[] possibleDigits = new HashSet[10];
        HashSet<Character> allLetters = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            possibleDigits[i] = new HashSet<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                possibleDigits[i].add(c);
            }
        }

        for (long i = 0; i < maxQueries; i++) {
            long m = scanner.nextLong();
            String r = scanner.next();
            updatePossibleDigits(m, r, possibleDigits, allLetters);
        }

        char[] resultDigits = new char[10];
        Arrays.fill(resultDigits, 'a');

        for (int h = 0; h < 10; h++) {
            for (int i = 0; i < 10; i++) {
                possibleDigits[i].removeIf(c -> !allLetters.contains(c));
                if (possibleDigits[i].size() == 1) {
                    char determinedChar = possibleDigits[i].iterator().next();
                    resultDigits[i] = determinedChar;
                    for (int j = 0; j < 10; j++) {
                        possibleDigits[j].remove(determinedChar);
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : resultDigits) {
            result.append(c);
        }
        System.out.println(result);
    }

    private static void updatePossibleDigits(long m, String r, HashSet<Character>[] possibleDigits, HashSet<Character> allLetters) {
        if (m == -1) return;

        for (int i = 0; i < r.length(); i++) {
            char c = r.charAt(i);
            allLetters.add(c);
        }

        long power = 0, tempM = m;
        int lastDigit = 0;

        while (tempM > 0) {
            power++;
            lastDigit = (int) (tempM % 10);
            tempM /= 10;
        }

        char firstChar = r.charAt(0);

        if (r.length() < power) {
            return;
        }

        for (int i = lastDigit + 1; i < 10; i++) {
            possibleDigits[i].remove(firstChar);
        }

        if (power > 0) {
            possibleDigits[0].remove(firstChar);
        }
    }
}