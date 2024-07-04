import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int U = Integer.parseInt(scanner.nextLine());
            Map<Character, Boolean> alphabetMap = new HashMap<>();
            Set<Character> nonZeroSet = new HashSet<>();
            Map<Character, Long> frequencyMap = new HashMap<>();

            for (int i = 1; i <= 10000; i++) {
                String caseStr = scanner.nextLine().trim();
                String[] pair = caseStr.split(" ");
                String erpStr = pair[1];

                char firstChar = erpStr.charAt(0);
                nonZeroSet.add(firstChar);
                frequencyMap.put(firstChar, frequencyMap.getOrDefault(firstChar, 0L) + 1);
                alphabetMap.put(firstChar, false);
            }

            char zeroChar = 'a';
            for (Character c : alphabetMap.keySet()) {
                if (!nonZeroSet.contains(c)) {
                    alphabetMap.put(c, true);
                    zeroChar = c;
                    break;
                }
            }

            StringBuilder alphabetOrder = new StringBuilder();
            alphabetOrder.append(zeroChar);

            for (int i = 1; i <= 9; i++) {
                long maxFrequency = Long.MIN_VALUE;
                char maxChar = zeroChar;

                for (Character c : alphabetMap.keySet()) {
                    if (alphabetMap.get(c)) continue;
                    long frequency = frequencyMap.getOrDefault(c, 0L);
                    if (frequency > maxFrequency) {
                        maxFrequency = frequency;
                        maxChar = c;
                    }
                }

                alphabetOrder.append(maxChar);
                alphabetMap.put(maxChar, true);
            }

            System.out.println("Case #" + caseIndex + ": " + alphabetOrder);
        }
    }
}