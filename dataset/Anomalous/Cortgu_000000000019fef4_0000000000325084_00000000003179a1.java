import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt(); // Number of cases
            for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
                int U = scanner.nextInt();
                SortedMap<Integer, Set<String>> queryMap = new TreeMap<>();
                Map<Integer, String> digitMap = new HashMap<>();
                
                for (int i = 0; i < 10000; i++) {
                    int Q = scanner.nextInt();
                    String R = scanner.next();
                    
                    queryMap.computeIfAbsent(Q, k -> new HashSet<>()).add(R);
                }

                // Determine digits
                for (int j = 1; j <= 10; j++) {
                    for (int i = j; i < Math.pow(10, U); i += 10) {
                        Set<String> candidates = queryMap.get(i);
                        if (candidates != null) {
                            candidates.removeAll(digitMap.values());
                            for (String candidate : candidates) {
                                int length = String.valueOf(i).length();
                                if (candidate.length() == length) {
                                    String digit = String.valueOf(candidate.charAt(length - 1));
                                    if (j == 10) {
                                        digitMap.put(0, digit);
                                    } else {
                                        digitMap.put(j, digit);
                                    }
                                    break;
                                }
                            }
                        }
                        if (digitMap.containsKey(j % 10)) {
                            break;
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    String letter = digitMap.get(i);
                    if (letter != null) {
                        result.append(letter);
                    } else {
                        result.append("X"); // Shouldn't happen
                    }
                }
                System.out.println("Case #" + caseNo + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}