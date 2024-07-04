import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  

        for (int xx = 1; xx <= t; xx++) {
            int u = in.nextInt();  
            Map<Character, Integer> charToIndex = new HashMap<>();
            int[] frequency = new int[10];
            int currentIndex = 0;

            for (int i = 0; i < 10000; i++) {
                long m = in.nextLong();
                String s = in.next();

                char c = s.charAt(0);
                int index = charToIndex.getOrDefault(c, currentIndex);
                if (!charToIndex.containsKey(c)) {
                    charToIndex.put(c, currentIndex++);
                }
                frequency[index]++;
            }

            Map<Integer, Character> indexToChar = new HashMap<>();
            List<Integer> sortedFrequencies = new ArrayList<>();

            for (Map.Entry<Character, Integer> entry : charToIndex.entrySet()) {
                int freq = frequency[entry.getValue()];
                indexToChar.put(freq, entry.getKey());
                sortedFrequencies.add(freq);
            }

            Collections.sort(sortedFrequencies);

            StringBuilder result = new StringBuilder();
            result.append(indexToChar.get(sortedFrequencies.get(0)));
            for (int i = 9; i > 0; i--) {
                result.append(indexToChar.get(sortedFrequencies.get(i)));
            }

            System.out.println("Case #" + xx + ": " + result.toString());
        }
    }
}