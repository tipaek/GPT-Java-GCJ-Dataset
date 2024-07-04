import java.util.*;
import java.io.*;

public class Solution {

    public static String sortByValue(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        StringBuilder sortedChars = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            sortedChars.append(entry.getKey());
        }

        return sortedChars.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int u = scanner.nextInt();
            scanner.nextLine();

            Set<Character> uniqueChars = new HashSet<>();
            Map<Character, Integer> msbCounts = new HashMap<>();

            for (int j = 0; j < 10000; j++) {
                String[] input = scanner.nextLine().split(" ");
                String randomString = input[1];

                if (uniqueChars.size() < 10) {
                    for (char c : randomString.toCharArray()) {
                        uniqueChars.add(c);
                    }
                }

                char firstChar = randomString.charAt(0);
                msbCounts.put(firstChar, msbCounts.getOrDefault(firstChar, 0) + 1);
            }

            char zeroChar = '?';
            for (char c : uniqueChars) {
                if (!msbCounts.containsKey(c)) {
                    zeroChar = c;
                    break;
                }
            }

            String sortedKeys = sortByValue(msbCounts);
            System.out.println("Case #" + i + ": " + zeroChar + sortedKeys);
        }
    }
}