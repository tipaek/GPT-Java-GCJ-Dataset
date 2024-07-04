import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt();
            for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
                int U = scanner.nextInt();
                SortedMap<Integer, Set<String>> queryResponses = new TreeMap<>();
                Map<Integer, String> digitMap = new HashMap<>();

                for (int i = 0; i < 10000; i++) {
                    int Q = scanner.nextInt();
                    String R = scanner.next();
                    queryResponses.computeIfAbsent(Q, k -> new HashSet<>()).add(R);
                }

                for (int j = 1; j <= 10; j++) {
                    for (int i = j; i < Math.pow(10, U); i += 10) {
                        Set<String> responses = queryResponses.get(i);
                        if (responses != null) {
                            responses.removeAll(digitMap.values());
                            for (String response : responses) {
                                int length = String.valueOf(i).length();
                                if (response.length() == length) {
                                    String letter = String.valueOf(response.charAt(length - 1));
                                    if (j == 10) {
                                        digitMap.put(0, letter);
                                    } else {
                                        digitMap.put(j, letter);
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
                    result.append(digitMap.get(i));
                }
                System.out.println("Case #" + caseNo + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}