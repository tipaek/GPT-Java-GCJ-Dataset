import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNum = 1;

        while (t-- > 0) {
            long u = sc.nextLong();
            HashMap<Character, Long> frequencyMap = new HashMap<>();
            long[] a = new long[10000];

            for (int i = 0; i < 10000; i++) {
                a[i] = sc.nextLong();
                String s = sc.next();
                for (char c : s.toCharArray()) {
                    frequencyMap.put(c, frequencyMap.getOrDefault(c, 0L) + 1);
                }
            }

            List<Map.Entry<Character, Long>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            char[] result = new char[10];
            int index = 0;
            for (Map.Entry<Character, Long> entry : sortedEntries) {
                result[index++] = entry.getKey();
            }

            StringBuilder finalResult = new StringBuilder();
            finalResult.append(result[0]);
            for (int i = 9; i >= 1; i--) {
                finalResult.append(result[i]);
            }

            System.out.println("Case #" + caseNum++ + ": " + finalResult);
        }

        sc.close();
    }
}