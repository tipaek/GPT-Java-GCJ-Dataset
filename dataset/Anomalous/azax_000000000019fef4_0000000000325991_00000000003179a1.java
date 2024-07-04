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

            boolean isSadCase = (numbers[0] == -1);

            if (!isSadCase) {
                System.out.println("Case #" + (caseIndex + 1) + ": " + solve(numbers, strings));
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": " + solveSadCase(strings));
            }
        }
        scanner.close();
    }

    private static String solve(long[] numbers, String[] strings) {
        List<Integer> referenceList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            referenceList.add(i);
        }

        Map<Character, Set<Integer>> charMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String str = strings[i];
            for (int j = 0; j < str.length(); j++) {
                charMap.putIfAbsent(str.charAt(j), new HashSet<>(referenceList));
                if (charMap.size() == 10) {
                    break;
                }
            }
        }

        for (int i = 0; i < 10000; i++) {
            long num = numbers[i];
            String str = strings[i];
            char firstChar = str.charAt(0);
            Set<Integer> set = charMap.get(firstChar);
            set.remove(0);

            if (Long.toString(num).length() == str.length()) {
                for (int j = getMostSignificantDigit(num) + 1; j < 10; j++) {
                    set.remove(j);
                }
            }
        }

        char[] result = new char[10];
        for (Map.Entry<Character, Set<Integer>> entry : charMap.entrySet()) {
            Character key = entry.getKey();
            Set<Integer> valueSet = entry.getValue();
            if (valueSet.contains(0)) {
                result[0] = key;
            } else {
                for (int i = 9; i > 0; i--) {
                    if (valueSet.contains(i)) {
                        result[i] = key;
                        break;
                    }
                }
            }
        }

        return new String(result);
    }

    private static String solveSadCase(String[] strings) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String str = strings[i];
            for (int j = 0; j < str.length(); j++) {
                frequencyMap.putIfAbsent(str.charAt(j), 0);
                if (frequencyMap.size() == 10) {
                    break;
                }
            }
        }

        for (int i = 0; i < 10000; i++) {
            String str = strings[i];
            if (str.length() == 16) {
                frequencyMap.put(str.charAt(0), frequencyMap.get(str.charAt(0)) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue());

        char[] result = new char[10];
        for (int i = 0; i < 10; i++) {
            result[i] = sortedEntries.get(i).getKey();
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