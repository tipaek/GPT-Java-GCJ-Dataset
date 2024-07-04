import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int u = scanner.nextInt();
            HashSet<Integer>[] letterPossibleDigits = new HashSet[26];

            for (int i = 0; i < 26; i++) {
                letterPossibleDigits[i] = new HashSet<>();
            }

            int[] queries = new int[10000];
            String[] strings = new String[10000];

            for (int i = 0; i < 10000; i++) {
                queries[i] = scanner.nextInt();
                strings[i] = scanner.next();

                for (int j = 0; j < strings[i].length(); j++) {
                    int letterIndex = strings[i].charAt(j) - 'A';
                    if (letterPossibleDigits[letterIndex].isEmpty()) {
                        for (int k = 0; k < 10; k++) {
                            letterPossibleDigits[letterIndex].add(k);
                        }
                    }
                }
            }

            for (int i = 0; i < 10000; i++) {
                if (queries[i] == -1) continue;

                if (queries[i] == strings[i].length()) {
                    int firstLetterIndex = strings[i].charAt(0) - 'A';
                    for (int k = queries[i] + 1; k < 10; k++) {
                        letterPossibleDigits[firstLetterIndex].remove(k);
                    }
                }
            }

            int resolvedCount = 0;
            boolean[] resolvedLetters = new boolean[26];

            while (resolvedCount < 10) {
                for (int i = 0; i < 26; i++) {
                    if (letterPossibleDigits[i].isEmpty() || letterPossibleDigits[i].size() > 1 || resolvedLetters[i]) {
                        continue;
                    }

                    resolvedLetters[i] = true;
                    resolvedCount++;
                    int resolvedDigit = letterPossibleDigits[i].iterator().next();

                    for (int j = 0; j < 26; j++) {
                        if (j != i) {
                            letterPossibleDigits[j].remove(resolvedDigit);
                        }
                    }
                }
            }

            char[] digitMapping = new char[10];
            for (int i = 0; i < 26; i++) {
                for (Integer digit : letterPossibleDigits[i]) {
                    digitMapping[digit] = (char) ('A' + i);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + new String(digitMapping));
        }
        scanner.close();
    }
}