import java.util.*;

public class Fan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

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

            List<Map.Entry<Character, Long>> sortedEntries = new LinkedList<>(frequencyMap.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            LinkedHashMap<Character, Long> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<Character, Long> entry : sortedEntries) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            char[] ans = new char[10];
            int index = 0;
            for (char key : sortedMap.keySet()) {
                if (index < 10) {
                    ans[index++] = key;
                }
            }

            StringBuilder result = new StringBuilder();
            result.append(ans[0]);
            for (int i = 9; i >= 1; i--) {
                result.append(ans[i]);
            }

            System.out.println("Case #" + caseNumber++ + ": " + result);
        }

        sc.close();
    }
}