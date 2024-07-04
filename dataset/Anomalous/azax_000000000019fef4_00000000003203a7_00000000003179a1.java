import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int[] numbers = new int[10000];
            String[] strings = new String[10000];

            scanner.nextLine();

            for (int i = 0; i < 10000; i++) {
                String[] inputLine = scanner.nextLine().split(" ");
                numbers[i] = Integer.parseInt(inputLine[0]);
                strings[i] = inputLine[1];
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + solve(numbers, strings));
        }

        scanner.close();
    }

    private static String solve(int[] numbers, String[] strings) {
        List<Integer> digits = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        Map<Character, Set<Integer>> charToDigitsMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String str = strings[i];
            for (int j = 0; j < str.length(); j++) {
                charToDigitsMap.putIfAbsent(str.charAt(j), new HashSet<>(digits));
                if (charToDigitsMap.size() == 10) break;
            }
        }

        for (int i = 0; i < 10000; i++) {
            int number = numbers[i];
            String str = strings[i];
            char firstChar = str.charAt(0);
            Set<Integer> possibleDigits = charToDigitsMap.get(firstChar);

            if (str.length() == 1) {
                possibleDigits.remove(0);
            }

            if (Integer.toString(number).length() == str.length()) {
                for (int j = getMostSignificantDigit(number) + 1; j < 10; j++) {
                    possibleDigits.remove(j);
                }
            }
        }

        char[] result = new char[10];
        for (Map.Entry<Character, Set<Integer>> entry : charToDigitsMap.entrySet()) {
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

    private static int getMostSignificantDigit(int number) {
        while (number >= 10) {
            number /= 10;
        }
        return number;
    }
}