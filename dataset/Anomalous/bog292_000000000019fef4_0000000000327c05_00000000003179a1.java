import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
            solve(scanner, testCaseNumber);
        }
    }

    private static void solve(Scanner scanner, int testCaseNumber) {
        int u = scanner.nextInt();
        Map<Character, Set<Integer>> characterMap = new HashMap<>();
        String[] messages = new String[10000];
        String[] responses = new String[10000];

        for (int i = 0; i < 10000; i++) {
            messages[i] = scanner.next();
            responses[i] = scanner.next();
        }

        while (!isComplete(characterMap)) {
            for (int i = 0; i < 10000; i++) {
                if (messages[i].equals("-1")) {
                    for (int j = 1; j < responses[i].length(); j++) {
                        if (!characterMap.containsKey(responses[i].charAt(j))) {
                            updateCharacterMap(characterMap, responses[i].charAt(j), 0, 9);
                            optimize(characterMap);
                        }
                    }
                    removeCharacter(characterMap, responses[i].charAt(0), 0);
                } else {
                    if (messages[i].length() == responses[i].length()) {
                        updateCharacterMap(characterMap, responses[i].charAt(0), 1, messages[i].charAt(0) - '0');
                        for (int j = 1; j < responses[i].length(); j++) {
                            if (!characterMap.containsKey(responses[i].charAt(j))) {
                                updateCharacterMap(characterMap, responses[i].charAt(j), 0, 9);
                            }
                        }
                    } else {
                        for (int j = 0; j < responses[i].length(); j++) {
                            if (!characterMap.containsKey(responses[i].charAt(j))) {
                                updateCharacterMap(characterMap, responses[i].charAt(j), 0, 9);
                            }
                        }
                    }
                }
            }
            optimize(characterMap);
        }

        char[] result = new char[10];
        for (Character character : characterMap.keySet()) {
            Set<Integer> set = characterMap.get(character);
            if (set.size() == 1) {
                result[set.iterator().next()] = character;
            }
        }

        System.out.print("Case #" + testCaseNumber + ": ");
        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static void updateCharacterMap(Map<Character, Set<Integer>> map, char character, int start, int end) {
        Set<Integer> rangeSet = createRangeSet(start, end);
        if (rangeSet.size() == 1) {
            int value = rangeSet.iterator().next();
            removeCharacter(map, character, value);
        }

        if (!map.containsKey(character)) {
            map.put(character, rangeSet);
        } else {
            Set<Integer> existingSet = map.get(character);
            existingSet.retainAll(rangeSet);
            if (existingSet.size() == 1) {
                int value = existingSet.iterator().next();
                removeCharacter(map, character, value);
            }
        }
    }

    private static void removeCharacter(Map<Character, Set<Integer>> map, char character, int value) {
        for (Character key : map.keySet()) {
            if (key != character) {
                Set<Integer> set = map.get(key);
                set.remove(value);
            }
        }
    }

    private static Set<Integer> createRangeSet(int start, int end) {
        Set<Integer> rangeSet = new HashSet<>();
        for (int i = start; i <= end; i++) {
            rangeSet.add(i);
        }
        return rangeSet;
    }

    private static boolean isComplete(Map<Character, Set<Integer>> map) {
        if (map.isEmpty()) return false;
        for (Set<Integer> set : map.values()) {
            if (set.size() != 1) return false;
        }
        return true;
    }

    private static void optimize(Map<Character, Set<Integer>> map) {
        for (Character key : map.keySet()) {
            Set<Integer> set = map.get(key);
            if (set.size() == 1) {
                removeCharacter(map, key, set.iterator().next());
            }
        }
    }
}