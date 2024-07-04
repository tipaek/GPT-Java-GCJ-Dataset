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

            scanner.nextLine(); // Skip the line with 2 or 16

            for (int i = 0; i < 10000; i++) {
                String[] line = scanner.nextLine().split(" ");
                numbers[i] = Long.parseLong(line[0]);
                strings[i] = line[1];
            }

            boolean isSad = (numbers[0] == -1);

            if (!isSad) {
                System.out.println("Case #" + (caseIndex + 1) + ": " + solve(numbers, strings));
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": " + solveSadly(strings));
            }
        }

        scanner.close();
    }

    private static String solve(long[] numbers, String[] strings) {
        List<Integer> reference = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            reference.add(i);
        }

        Map<Character, Set<Integer>> charMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String str = strings[i];
            for (int j = 0; j < str.length(); j++) {
                charMap.putIfAbsent(str.charAt(j), new HashSet<>(reference));
                if (charMap.size() == 10) {
                    break;
                }
            }
        }

        for (int i = 0; i < 10000; i++) {
            long number = numbers[i];
            String str = strings[i];

            char firstChar = str.charAt(0);
            Set<Integer> digitSet = charMap.get(firstChar);
            digitSet.remove(0);

            if (Long.toString(number).length() == str.length()) {
                for (int j = getMostSignificantDigit(number) + 1; j < 10; j++) {
                    digitSet.remove(j);
                }
            }
        }

        char[] result = new char[10];
        for (Map.Entry<Character, Set<Integer>> entry : charMap.entrySet()) {
            Character character = entry.getKey();
            Set<Integer> digitSet = entry.getValue();
            if (digitSet.contains(0)) {
                result[0] = character;
            } else {
                for (int i = 9; i > 0; i--) {
                    if (digitSet.contains(i)) {
                        result[i] = character;
                        break;
                    }
                }
            }
        }

        return new String(result);
    }

    private static String solveSadly(String[] strings) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (String str : strings) {
            for (int j = 0; j < str.length(); j++) {
                frequencyMap.putIfAbsent(str.charAt(j), 0);
                if (frequencyMap.size() == 10) {
                    break;
                }
            }
        }

        for (String str : strings) {
            if (str.length() == 16) {
                frequencyMap.put(str.charAt(0), frequencyMap.get(str.charAt(0)) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(Comparator.comparingInt(Map.Entry::getValue));

        char[] result = new char[10];
        result[0] = sortedEntries.get(0).getKey();
        for (int i = 0; i < 9; i++) {
            result[i + 1] = sortedEntries.get(9 - i).getKey();
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