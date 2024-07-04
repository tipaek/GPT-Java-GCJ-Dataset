import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt();
            for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
                int U = scanner.nextInt();
                SortedMap<Long, Set<String>> queryMap = new TreeMap<>();
                Map<Integer, String> digitToCharMap = new HashMap<>();
                Set<String> allCharacters = new HashSet<>();

                for (int i = 0; i < 10000; i++) {
                    long Q = scanner.nextLong();
                    String R = scanner.next();
                    allCharacters.addAll(Arrays.asList(R.split("")));

                    queryMap.computeIfAbsent(Q, k -> new HashSet<>()).add(R);
                }

                for (int digit = 0; digit < 10; digit++) {
                    for (Map.Entry<Long, Set<String>> entry : queryMap.entrySet()) {
                        long query = entry.getKey();
                        if (String.valueOf(query).endsWith(String.valueOf(digit))) {
                            Set<String> possibleStrings = new HashSet<>(entry.getValue());
                            possibleStrings.removeAll(digitToCharMap.values());

                            for (String possibleString : possibleStrings) {
                                if (possibleString.length() == String.valueOf(query).length()) {
                                    String character = String.valueOf(possibleString.charAt(possibleString.length() - 1));
                                    digitToCharMap.put(digit == 10 ? 0 : digit, character);
                                    break;
                                }
                            }

                            if (digitToCharMap.containsKey(digit % 10)) {
                                break;
                            }
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    String character = digitToCharMap.get(i);
                    if (character != null) {
                        result.append(character);
                    } else {
                        if (digitToCharMap.size() == 9) {
                            allCharacters.removeAll(digitToCharMap.values());
                            result.append(allCharacters.iterator().next());
                        } else {
                            result.append("X");
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