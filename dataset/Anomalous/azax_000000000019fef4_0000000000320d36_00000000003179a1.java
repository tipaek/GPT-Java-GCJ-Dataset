import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            long[] numbers = new long[10000];
            String[] strings = new String[10000];

            scanner.nextLine(); // Skip the blank line

            for (int i = 0; i < 10000; i++) {
                String[] input = scanner.nextLine().split(" ");
                numbers[i] = Long.parseLong(input[0]);
                strings[i] = input[1];
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + solve(numbers, strings));
        }
        scanner.close();
    }

    private static String solve(long[] numbers, String[] strings) {
        List<Integer> referenceList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            referenceList.add(i);
        }

        Map<Character, Set<Integer>> charToPossibleDigits = new HashMap<>();
        for (String s : strings) {
            for (char c : s.toCharArray()) {
                charToPossibleDigits.putIfAbsent(c, new HashSet<>(referenceList));
                if (charToPossibleDigits.size() == 10) {
                    break;
                }
            }
        }

        for (int i = 0; i < 10000; i++) {
            long number = numbers[i];
            String str = strings[i];
            char firstChar = str.charAt(0);
            Set<Integer> possibleDigits = charToPossibleDigits.get(firstChar);

            if (str.length() == 1) {
                possibleDigits.remove(0);
            }
            if (Long.toString(number).length() == str.length()) {
                for (int j = getMostSignificantDigit(number) + 1; j < 10; j++) {
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