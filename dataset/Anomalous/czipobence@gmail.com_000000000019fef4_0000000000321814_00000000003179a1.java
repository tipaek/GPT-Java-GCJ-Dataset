import java.util.*;
import java.io.*;

public class Solution {

    public static String sortByValue(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            result.append(entry.getKey());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int u = scanner.nextInt();
            scanner.nextLine();

            String[] inputs = new String[10000];
            Set<Character> uniqueChars = new HashSet<>();
            Map<Character, Integer> msbCount = new HashMap<>();

            for (int j = 0; j < 10000; j++) {
                String input = scanner.nextLine();
                inputs[j] = input;
                String[] parts = input.split(" ");

                String randomString = parts[1];
                String digits = parts[0];

                if (uniqueChars.size() < 10) {
                    for (char c : randomString.toCharArray()) {
                        uniqueChars.add(c);
                    }
                }

                if (digits.length() == randomString.length()) {
                    char firstChar = randomString.charAt(0);
                    msbCount.put(firstChar, msbCount.getOrDefault(firstChar, 0) + 1);
                }
            }

            char zeroChar = '?';
            for (char key : uniqueChars) {
                if (!msbCount.containsKey(key)) {
                    zeroChar = key;
                    break;
                }
            }

            String sortedKeys = sortByValue(msbCount);
            System.out.println("Case #" + i + ": " + zeroChar + sortedKeys);
        }
    }
}