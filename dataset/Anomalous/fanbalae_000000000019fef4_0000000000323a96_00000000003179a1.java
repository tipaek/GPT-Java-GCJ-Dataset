import java.util.*;

public class Fan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int u = sc.nextInt();
            Map<Character, Integer> charFrequency = new HashMap<>();
            int[] numbers = new int[10000];

            for (int i = 0; i < 10000; i++) {
                numbers[i] = sc.nextInt();
                String s = sc.next();
                for (char c : s.toCharArray()) {
                    charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                }
            }

            List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(charFrequency.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            char[] result = new char[10];
            int index = 0;
            for (Map.Entry<Character, Integer> entry : sortedEntries) {
                if (index < 10) {
                    result[index++] = entry.getKey();
                } else {
                    break;
                }
            }

            StringBuilder answer = new StringBuilder("Case #" + caseNumber + ": ");
            for (char c : result) {
                answer.append(c);
            }

            System.out.println(answer);
            caseNumber++;
        }

        sc.close();
    }
}