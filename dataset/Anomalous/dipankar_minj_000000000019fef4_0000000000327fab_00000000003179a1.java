import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int u = scanner.nextInt();
            int[][] frequency = new int[26][10];
            for (int[] row : frequency) {
                Arrays.fill(row, 0);
            }

            for (int j = 1; j <= 10000; j++) {
                long m = scanner.nextLong();
                String s = scanner.next();
                if (s.length() != u) {
                    continue;
                }

                HashSet<Integer> uniqueChars = new HashSet<>();
                int length = s.length();
                long number = m;
                int index = length - 1;

                while (number > 0) {
                    int digit = (int) (number % 10);
                    char character = s.charAt(index);
                    int charIndex = character - 'A';
                    uniqueChars.add(charIndex);
                    frequency[charIndex][digit]++;
                    number /= 10;
                    index--;
                }

                char[] result = new char[10];
                Arrays.fill(result, ' ');

                for (int charIndex : uniqueChars) {
                    int maxFrequency = 0;
                    int maxDigit = 0;
                    for (int digit = 0; digit < 10; digit++) {
                        if (frequency[charIndex][digit] > maxFrequency) {
                            maxFrequency = frequency[charIndex][digit];
                            maxDigit = digit;
                        }
                    }
                    result[maxDigit] = (char) (charIndex + 'A');
                }

                System.out.print("Case #" + caseNumber + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}