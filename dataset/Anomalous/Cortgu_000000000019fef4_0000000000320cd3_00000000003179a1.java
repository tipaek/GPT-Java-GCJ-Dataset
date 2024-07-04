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
                Map<Integer, String> digitMapping = new HashMap<>();
                
                for (int i = 0; i < 10000; i++) {
                    int Q = scanner.nextInt();
                    String R = scanner.next();
                    queryMap.computeIfAbsent(Q, k -> new HashSet<>()).add(R);
                }

                // Determine digits 1 to 9
                Set<Integer> missingDigits = new HashSet<>();
                for (int i = 1; i < 10; i++) {
                    Set<String> possibleStrings = queryMap.get(i);
                    if (possibleStrings != null) {
                        possibleStrings.removeAll(digitMapping.values());
                        digitMapping.put(i, possibleStrings.iterator().next());
                    } else {
                        missingDigits.add(i);
                    }
                }

                // Determine digit 0
                Set<String> zeroStrings = queryMap.get(10);
                if (zeroStrings != null) {
                    zeroStrings.removeAll(digitMapping.values());
                    digitMapping.put(0, String.valueOf(zeroStrings.iterator().next().charAt(1)));
                }

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    result.append(digitMapping.get(i));
                }
                System.out.println("Case #" + caseNo + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}