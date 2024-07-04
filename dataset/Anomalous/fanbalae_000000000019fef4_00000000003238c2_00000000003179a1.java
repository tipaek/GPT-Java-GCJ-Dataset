import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int u = sc.nextInt();
            Map<Character, Integer> frequencyMap = new HashMap<>();
            int[] a = new int[10000];

            for (int i = 0; i < 10000; i++) {
                a[i] = sc.nextInt();
                String s = sc.next();
                for (char c : s.toCharArray()) {
                    frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
                }
            }

            List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            char[] answer = new char[10];
            int index = 0;
            for (Map.Entry<Character, Integer> entry : sortedEntries) {
                answer[index++] = entry.getKey();
                if (index == 10) break;
            }

            StringBuilder result = new StringBuilder();
            result.append(answer[0]);
            for (int i = 1; i < 10; i++) {
                result.append(answer[i]);
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}