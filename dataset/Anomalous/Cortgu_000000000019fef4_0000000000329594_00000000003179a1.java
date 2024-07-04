import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt(); // Number of cases
            for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
                int U = scanner.nextInt();
                SortedMap<Long, Set<String>> queryResponseMap = new TreeMap<>();
                Map<Integer, String> digitToLetterMap = new HashMap<>();
                Set<String> allLetters = new HashSet<>();

                for (int i = 0; i < 10000; i++) {
                    long Q = scanner.nextLong();
                    String R = scanner.next();
                    allLetters.addAll(R.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toSet()));

                    queryResponseMap.computeIfAbsent(Q, k -> new HashSet<>()).add(R);
                }

                // Determine digits
                for (int digit = 0; digit < 10; digit++) {
                    for (Map.Entry<Long, Set<String>> entry : queryResponseMap.entrySet()) {
                        long query = entry.getKey();
                        if (String.valueOf(query).endsWith(String.valueOf(digit))) {
                            Set<String> responses = entry.getValue();
                            responses.removeAll(digitToLetterMap.values());

                            for (String response : responses) {
                                int length = String.valueOf(query).length();
                                if (response.length() == length) {
                                    String letter = String.valueOf(response.charAt(length - 1));
                                    digitToLetterMap.put(digit, letter);
                                    break;
                                }
                            }

                            if (digitToLetterMap.containsKey(digit)) {
                                break;
                            }
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    String letter = digitToLetterMap.get(i);
                    if (letter != null) {
                        result.append(letter);
                    } else {
                        if (digitToLetterMap.size() == 9) {
                            allLetters.removeAll(digitToLetterMap.values());
                            letter = allLetters.iterator().next();
                            result.append(letter);
                        } else {
                            result.append("X"); // Shouldn't happen
                        }
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