import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            final int numberOfCases = scanner.nextInt(); // Number of cases
            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                final int U = scanner.nextInt();
                SortedMap<Long, Set<String>> queriesMap = new TreeMap<>();
                Map<Integer, String> digitsMap = new HashMap<>();

                for (int i = 0; i < 10000; i++) {
                    final long Q = scanner.nextLong();
                    final String R = scanner.next();

                    queriesMap.computeIfAbsent(Q, k -> new HashSet<>()).add(R);
                }

                // Extract digits
                for (int digit = 0; digit < 10; digit++) {
                    for (Map.Entry<Long, Set<String>> entry : queriesMap.entrySet()) {
                        final long query = entry.getKey();
                        if (String.valueOf(query).endsWith(String.valueOf(digit))) {
                            Set<String> responses = new HashSet<>(entry.getValue());
                            responses.removeAll(digitsMap.values());

                            for (String response : responses) {
                                if (response.length() == String.valueOf(query).length()) {
                                    final String letter = String.valueOf(response.charAt(response.length() - 1));
                                    digitsMap.put(digit == 10 ? 0 : digit, letter);
                                    break;
                                }
                            }

                            if (digitsMap.containsKey(digit % 10)) {
                                break;
                            }
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    result.append(digitsMap.getOrDefault(i, "X")); // Shouldn't happen
                }

                System.out.println("Case #" + caseNumber + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}