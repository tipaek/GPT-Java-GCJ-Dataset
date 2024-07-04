import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = t;

        while (t > 0) {
            t--;
            int u = sc.nextInt();
            HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
            long[] numbers = new long[10000];

            for (int i = 0; i < 10000; i++) {
                numbers[i] = sc.nextLong();
                String s = sc.next();

                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
                }
            }

            List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(charFrequencyMap.entrySet());
            Collections.sort(entryList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

            HashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<Character, Integer> entry : entryList) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            char[] resultChars = new char[10];
            int index = 0;
            for (char c : sortedMap.keySet()) {
                resultChars[index++] = c;
            }

            StringBuilder result = new StringBuilder();
            result.append(resultChars[0]);
            for (int i = 9; i >= 1; i--) {
                result.append(resultChars[i]);
            }

            System.out.println("Case #" + (caseNumber - t) + ": " + result);
        }

        sc.close();
    }
}