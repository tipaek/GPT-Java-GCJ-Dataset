import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        if (TEST_MODE) {
            try {
                System.setIn(new FileInputStream(System.getProperty("user.dir") + "/src/sample.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            Solution solutionInstance = new Solution();
            scanner.nextInt();  // Read and discard the integer
            String[] records = new String[10000];

            for (int j = 0; j < 10000; j++) {
                scanner.nextLong();  // Read and discard the long
                records[j] = scanner.nextLine().trim();
            }

            System.out.println("Case #" + i + ": " + solutionInstance.solve(records));
        }

        scanner.close();
    }

    private String solve(String[] records) {
        Map<Character, Long> frequencyMap = new HashMap<>();

        for (String record : records) {
            for (char character : record.toCharArray()) {
                frequencyMap.put(character, frequencyMap.getOrDefault(character, 0L) + 1);
            }
        }

        char[] result = new char[10];
        for (int i = 0; i < 10; i++) {
            char minChar = findMinFrequencyChar(frequencyMap);
            result[i] = minChar;
            frequencyMap.remove(minChar);
        }

        return new String(result);
    }

    private char findMinFrequencyChar(Map<Character, Long> frequencyMap) {
        char minChar = '\0';
        long minFrequency = Long.MAX_VALUE;

        for (Map.Entry<Character, Long> entry : frequencyMap.entrySet()) {
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                minChar = entry.getKey();
            }
        }

        return minChar;
    }

    private long countDigitInRangeAtDigit(long number, long divisor, int digit) {
        long entireDivisors = number / (divisor * 10);
        long remainder = (number / divisor) % 10;

        if (remainder == digit) {
            return entireDivisors * divisor + number % divisor + 1;
        } else if (remainder < digit) {
            return entireDivisors * divisor;
        } else {
            return (entireDivisors + 1) * divisor;
        }
    }

    public long countDigitInRange(long number, int digit) {
        long divisor = 1;
        long count = 0;

        while (number > 0) {
            count += countDigitInRangeAtDigit(number, divisor, digit);
            divisor *= 10;
            number /= 10;
        }

        return count;
    }
}