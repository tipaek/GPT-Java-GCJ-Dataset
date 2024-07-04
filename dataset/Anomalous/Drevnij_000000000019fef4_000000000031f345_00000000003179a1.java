import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int xx = 1; xx <= t; xx++) {
            int u = in.nextInt();

            Map<Character, Integer> frequencyMap = new HashMap<>();
            int[] charCount = new int[10];

            int currentIndex = 0;
            for (int i = 0; i < 10000; i++) {
                long m = in.nextLong();
                String s = in.next();
                for (char c : s.toCharArray()) {
                    int index = frequencyMap.getOrDefault(c, currentIndex);
                    if (!frequencyMap.containsKey(c)) {
                        frequencyMap.put(c, currentIndex++);
                    }
                    charCount[index]++;
                }
            }

            Map<Integer, Character> sortedCharMap = new HashMap<>();
            List<Integer> countList = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                sortedCharMap.put(charCount[entry.getValue()], entry.getKey());
                countList.add(charCount[entry.getValue()]);
            }
            Collections.sort(countList);

            StringBuilder result = new StringBuilder();
            result.append(sortedCharMap.get(countList.get(0)));
            for (int i = 9; i > 0; i--) {
                result.append(sortedCharMap.get(countList.get(i)));
            }

            System.out.println("Case #" + xx + ": " + result);
        }
    }
}