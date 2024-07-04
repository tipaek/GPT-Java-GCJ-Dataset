import java.io.*;
import java.util.*;

public class OverRandomized {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int U = scanner.nextInt();
        HashSet<Character>[] impossibleDigits = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            impossibleDigits[i] = new HashSet<>();
        }
        HashSet<Character> allCharacters = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            long M = scanner.nextLong();
            if (M == -1) {
                M = (long) Math.pow(10, U) - 1;
            }
            String R = scanner.next();
            long min = (long) Math.pow(10, R.length() - 1);
            long max = Math.min(M, (long) Math.pow(10, R.length()) - 1);

            for (int j = R.length() - 1; j >= 0; j--) {
                for (int k = 0; k < min % 10; k++) {
                    impossibleDigits[k].add(R.charAt(j));
                }
                if (max < 10) {
                    for (int k = (int) max % 10 + 1; k < 10; k++) {
                        impossibleDigits[k].add(R.charAt(j));
                    }
                }
                allCharacters.add(R.charAt(j));
                min /= 10;
                max /= 10;
            }
        }

        HashSet<Character>[] possibleDigits = new HashSet[10];
        for (int i = 0; i < 10; i++) {
            possibleDigits[i] = new HashSet<>();
        }

        for (int i = 0; i < 10; i++) {
            HashSet<Character> tempSet = new HashSet<>(allCharacters);
            tempSet.removeAll(impossibleDigits[i]);
            possibleDigits[i].addAll(tempSet);
        }

        char[] result = new char[10];
        int remaining = 10;

        while (remaining > 0) {
            for (int i = 0; i < 10; i++) {
                if (possibleDigits[i].size() == 1) {
                    remaining--;
                    char determinedChar = possibleDigits[i].iterator().next();
                    result[i] = determinedChar;

                    for (int j = 0; j < 10; j++) {
                        possibleDigits[j].remove(determinedChar);
                    }
                }
            }
        }

        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();
    }
}