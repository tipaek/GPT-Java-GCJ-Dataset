import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        int currentCase = 1;

        while (currentCase <= testCases) {
            String input = scanner.nextLine();
            int[] digits = new int[input.length()];

            for (int i = 0; i < input.length(); i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }

            Map<Integer, Integer> digitCount = new HashMap<>();
            Set<Integer> uniqueDigits = new HashSet<>();

            for (int digit : digits) {
                uniqueDigits.add(digit);
                digitCount.put(digit, digitCount.getOrDefault(digit, 0) + 1);
            }

            int[] sortedUniqueDigits = uniqueDigits.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(sortedUniqueDigits);

            StringBuilder result = new StringBuilder();

            for (int i = sortedUniqueDigits.length - 1; i >= 0; i--) {
                int currentDigit = sortedUniqueDigits[i];
                if (currentDigit == sortedUniqueDigits[sortedUniqueDigits.length - 1]) {
                    for (int j = 0; j < currentDigit; j++) {
                        result.append('(');
                    }
                }
                if (currentDigit != 0) {
                    for (int j = 0; j < digitCount.get(currentDigit); j++) {
                        result.append(currentDigit);
                    }
                    result.append(')');
                }
            }

            if (digitCount.containsKey(0)) {
                for (int i = 0; i < digitCount.get(0); i++) {
                    result.append('0');
                }
            }

            writer.println("Case #" + currentCase + ": " + result.toString());
            currentCase++;
        }

        writer.flush();
        writer.close();
    }
}