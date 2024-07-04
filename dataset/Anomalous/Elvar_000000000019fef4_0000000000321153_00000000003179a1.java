import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int maxEntries = 10000;

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int U = scanner.nextInt();
            String[] responses = new String[maxEntries];
            int[] frequency = new int[10];
            char[] characters = new char[10];
            boolean[] canBeZero = new boolean[10];
            int charCount = 0;

            for (int i = 0; i < 10; i++) {
                canBeZero[i] = true;
            }

            for (int i = 0; i < maxEntries; i++) {
                String Q = scanner.next();
                responses[i] = scanner.next();
                for (int m = 0; m < responses[i].length(); m++) {
                    char currentChar = responses[i].charAt(m);
                    boolean seen = false;

                    for (int j = 0; j < charCount; j++) {
                        if (currentChar == characters[j]) {
                            frequency[j] += responses[i].length() - m;
                            seen = true;
                            if (m == 0) canBeZero[j] = false;
                        }
                    }

                    if (!seen) {
                        characters[charCount] = currentChar;
                        frequency[charCount] += responses[i].length() - m;
                        if (m == 0) canBeZero[charCount] = false;
                        charCount++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                if (canBeZero[i]) {
                    result.append(characters[i]);
                    frequency[i] = -1;
                }
            }

            for (int i = 1; i < 10; i++) {
                int maxFrequency = -1;
                int maxIndex = -1;
                for (int j = 0; j < 10; j++) {
                    if (frequency[j] > maxFrequency) {
                        maxFrequency = frequency[j];
                        maxIndex = j;
                    }
                }
                if (maxIndex != -1) {
                    result.append(characters[maxIndex]);
                    frequency[maxIndex] = -1;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}