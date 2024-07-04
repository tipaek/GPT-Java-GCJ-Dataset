import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            long[] quantities = new long[10000];
            String[] strings = new String[10000];

            scanner.nextLine(); // Skip the line with 2 or 16

            for (int i = 0; i < 10000; i++) {
                String[] line = scanner.nextLine().split(" ");
                quantities[i] = Long.parseLong(line[0]);
                strings[i] = line[1];
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + solve(quantities, strings));
        }
        scanner.close();
    }

    private static String solve(long[] quantities, String[] strings) {
        List<Integer> referenceList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            referenceList.add(i);
        }

        Map<Character, Set<Integer>> charToPossibleDigits = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String s = strings[i];
            for (int j = 0; j < s.length(); j++) {
                charToPossibleDigits.putIfAbsent(s.charAt(j), new HashSet<>(referenceList));
                if (charToPossibleDigits.size() == 10) {
                    break;
                }
            }
        }

        for (int i = 0; i < 10000; i++) {
            long quantity = quantities[i];
            String s = strings[i];
            char firstChar = s.charAt(0);
            Set<Integer> possibleDigits = charToPossibleDigits.get(firstChar);
            possibleDigits.remove(0);

            if (Long.toString(quantity).length() == s.length()) {
                for (int j = getMostSignificantDigit(quantity) + 1; j < 10; j++) {
                    possibleDigits.remove(j);
                }
            }
        }

        char[] result = new char[10];
        for (Map.Entry<Character, Set<Integer>> entry : charToPossibleDigits.entrySet()) {
            char character = entry.getKey();
            Set<Integer> possibleDigits = entry.getValue();
            if (possibleDigits.contains(0)) {
                result[0] = character;
            } else {
                for (int i = 9; i > 0; i--) {
                    if (possibleDigits.contains(i)) {
                        result[i] = character;
                        break;
                    }
                }
            }
        }
        return new String(result);
    }

    private static int getMostSignificantDigit(long number) {
        while (number >= 10) {
            number /= 10;
        }
        return (int) number;
    }
}