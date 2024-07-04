import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt(); // Number of cases

            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                int U = scanner.nextInt();
                SortedMap<Integer, Set<String>> queryMap = new TreeMap<>();
                Map<Integer, String> digitMapping = new HashMap<>();

                for (int i = 0; i < 10000; i++) {
                    int Q = scanner.nextInt();
                    String R = scanner.next();

                    queryMap.computeIfAbsent(Q, k -> new HashSet<>()).add(R);
                }

                for (int digit = 1; digit <= 10; digit++) {
                    for (int i = digit; i < Math.pow(10, U); i += 10) {
                        Set<String> responses = queryMap.get(i);
                        if (responses != null) {
                            responses.removeAll(digitMapping.values());

                            for (String response : responses) {
                                int length = String.valueOf(i).length();
                                if (response.length() == length) {
                                    String letter = String.valueOf(response.charAt(length - 1));
                                    digitMapping.put(digit == 10 ? 0 : digit, letter);
                                    break;
                                }
                            }
                        }
                        if (digitMapping.containsKey(digit % 10)) {
                            break;
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    result.append(Optional.ofNullable(digitMapping.get(i)).orElse("X"));
                }

                System.out.println("Case #" + caseNumber + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}