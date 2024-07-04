import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            processCase(scanner, caseNumber);
        }
    }

    private static void processCase(Scanner scanner, int caseNumber) {
        int u = scanner.nextInt();
        Map<Character, Set<Integer>> characterMap = new HashMap<>();

        for (int i = 1; i <= 10000; i++) {
            String m = scanner.next();
            String r = scanner.next();

            if (m.length() == r.length()) {
                updateCharacterMap(characterMap, r.charAt(0), 1, m.charAt(0) - '0');
                for (int j = 1; j < r.length(); j++) {
                    characterMap.putIfAbsent(r.charAt(j), createRangeSet(0, 9));
                }
            } else {
                for (char c : r.toCharArray()) {
                    characterMap.putIfAbsent(c, createRangeSet(0, 9));
                }
            }
        }

        char[] result = new char[10];
        for (Map.Entry<Character, Set<Integer>> entry : characterMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                result[entry.getValue().iterator().next()] = entry.getKey();
            }
        }

        System.out.print("Case #" + caseNumber + ": ");
        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static void updateCharacterMap(Map<Character, Set<Integer>> characterMap, char character, int start, int end) {
        Set<Integer> range = createRangeSet(start, end);

        if (range.size() == 1) {
            removeCharacterFromOtherSets(characterMap, character, range.iterator().next());
        }

        characterMap.merge(character, range, (existingSet, newSet) -> {
            existingSet.retainAll(newSet);
            if (existingSet.size() == 1) {
                removeCharacterFromOtherSets(characterMap, character, existingSet.iterator().next());
            }
            return existingSet;
        });
    }

    private static void removeCharacterFromOtherSets(Map<Character, Set<Integer>> characterMap, char character, int value) {
        for (Map.Entry<Character, Set<Integer>> entry : characterMap.entrySet()) {
            if (entry.getKey() != character) {
                entry.getValue().remove(value);
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
}