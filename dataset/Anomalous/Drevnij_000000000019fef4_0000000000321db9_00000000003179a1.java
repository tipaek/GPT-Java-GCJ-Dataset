import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int u = scanner.nextInt();
            Map<Character, Integer> characterMap = new HashMap<>();
            int[] frequency = new int[10];
            int currentIndex = 0;

            for (int i = 0; i < 10000; i++) {
                long m = scanner.nextLong();
                String s = scanner.next();
                char firstChar = s.charAt(0);

                if (!characterMap.containsKey(firstChar)) {
                    characterMap.put(firstChar, currentIndex++);
                }
                frequency[characterMap.get(firstChar)]++;

                if (currentIndex == 9 && !characterMap.containsKey(s.charAt(s.length() - 1))) {
                    characterMap.put(s.charAt(s.length() - 1), currentIndex++);
                }
            }

            Map<Integer, Character> frequencyToChar = new HashMap<>();
            List<Integer> frequencyList = new ArrayList<>();

            for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
                int charFrequency = frequency[entry.getValue()];
                frequencyToChar.put(charFrequency, entry.getKey());
                frequencyList.add(charFrequency);
            }

            Collections.sort(frequencyList);

            StringBuilder result = new StringBuilder().append(frequencyToChar.get(frequencyList.get(0)));
            for (int i = 9; i > 0; i--) {
                result.append(frequencyToChar.get(frequencyList.get(i)));
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}