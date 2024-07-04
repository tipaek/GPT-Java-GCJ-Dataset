import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        for (int currentCase = 1; currentCase <= testCases; currentCase++) {
            String input = scanner.nextLine();
            int[] digits = new int[input.length()];
            for (int i = 0; i < input.length(); i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }

            Map<Integer, Integer> frequencyMap = new HashMap<>();
            Set<Integer> uniqueDigits = new HashSet<>();
            for (int digit : digits) {
                uniqueDigits.add(digit);
                frequencyMap.put(digit, frequencyMap.getOrDefault(digit, 0) + 1);
            }

            int[] sortedUniqueDigits = uniqueDigits.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(sortedUniqueDigits);

            StringBuilder result = new StringBuilder();
            for (int i = sortedUniqueDigits.length - 1; i >= 0; i--) {
                int currentDigit = sortedUniqueDigits[i];
                if (currentDigit == sortedUniqueDigits[sortedUniqueDigits.length - 1]) {
                    result.append("(".repeat(currentDigit));
                }
                if (currentDigit != 0) {
                    result.append(String.valueOf(currentDigit).repeat(frequencyMap.get(currentDigit)));
                    result.append(')');
                }
            }

            if (frequencyMap.containsKey(0)) {
                result.append("0".repeat(frequencyMap.get(0)));
            }

            writer.println("Case #" + currentCase + ": " + result.toString());
        }

        writer.flush();
    }
}