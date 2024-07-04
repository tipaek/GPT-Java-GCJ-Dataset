import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int maxEntries = 10000;

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int U = scanner.nextInt();
            String[] responses = new String[maxEntries];
            int[] frequency = new int[10];
            char[] characters = new char[10];
            boolean[] canBeZero = new boolean[10];
            int uniqueCharCount = 0;

            for (int i = 0; i < 10; i++) {
                canBeZero[i] = true;
            }

            for (int i = 0; i < maxEntries; i++) {
                String query = scanner.next();
                responses[i] = scanner.next();

                for (int j = 0; j < responses[i].length(); j++) {
                    char currentChar = responses[i].charAt(j);
                    boolean isSeen = false;

                    for (int k = 0; k < uniqueCharCount; k++) {
                        if (currentChar == characters[k]) {
                            frequency[k]++;
                            isSeen = true;
                            if (j == 0) {
                                canBeZero[k] = false;
                            }
                            break;
                        }
                    }

                    if (!isSeen) {
                        characters[uniqueCharCount] = currentChar;
                        frequency[uniqueCharCount]++;
                        if (j == 0) {
                            canBeZero[uniqueCharCount] = false;
                        }
                        uniqueCharCount++;
                    }
                }
            }

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                if (canBeZero[i]) {
                    result.append(characters[i]);
                    frequency[i] = -1;
                    break;
                }
            }

            for (int i = 1; i < 10; i++) {
                int maxFrequency = -1;
                int index = -1;

                for (int j = 0; j < 10; j++) {
                    if (frequency[j] > maxFrequency) {
                        maxFrequency = frequency[j];
                        index = j;
                    }
                }

                if (index != -1) {
                    result.append(characters[index]);
                    frequency[index] = -1;
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }

        scanner.close();
    }
}