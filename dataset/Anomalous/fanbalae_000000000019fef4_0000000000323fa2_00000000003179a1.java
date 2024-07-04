import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = t;

        while (t > 0) {
            t--;
            int u = sc.nextInt();
            HashMap<Character, Integer> frequencyMap = new HashMap<>();
            int[] numbers = new int[10000];

            for (int i = 0; i < 10000; i++) {
                numbers[i] = sc.nextInt();
                String s = sc.next();
                for (char c : s.toCharArray()) {
                    frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
                }
            }

            List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(frequencyMap.entrySet());
            Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue));

            LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<Character, Integer> entry : entryList) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            Iterator<Map.Entry<Character, Integer>> iterator = sortedMap.entrySet().iterator();
            char[] result = new char[10];
            int index = 0;

            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = iterator.next();
                result[index] = entry.getKey();
                index++;
            }

            StringBuilder finalResult = new StringBuilder();
            finalResult.append(result[0]);
            for (int i = 9; i >= 1; i--) {
                finalResult.append(result[i]);
            }

            System.out.println("Case #" + (caseNumber - t) + ": " + finalResult);
        }

        sc.close();
    }
}