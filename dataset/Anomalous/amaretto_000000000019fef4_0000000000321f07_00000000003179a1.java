import java.util.*;

public class Solution {
    public static HashSet<Character> glob;
    public static HashMap<Character, Character> res;

    public static Character mostFreq(List<Character> list) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (Character ch : list) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        int maxFrequency = 0;
        char mostFrequentChar = list.get(0);
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentChar = entry.getKey();
                glob.add(entry.getKey());
            }
        }
        return mostFrequentChar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int test = 1; test <= testCases; test++) {
            glob = new HashSet<>();
            res = new HashMap<>();
            Map<Character, List<Character>> map = new HashMap<>();
            for (char i = '0'; i <= '9'; i++) {
                map.put(i, new ArrayList<>());
            }
            int u = scanner.nextInt();
            int queries = 10000;
            Random random = new Random();
            while (queries-- > 0) {
                int q = scanner.nextInt();
                String response = scanner.next();
                int length = response.length();
                int tenPower = (int) Math.pow(10, length - 1);
                int maxVal = 9 * tenPower;
                int q2 = tenPower + random.nextInt(maxVal);
                if (q == -1) {
                    q = 1 + random.nextInt(q);
                }
                String qStr = Integer.toString(q).trim();
                if (qStr.length() != response.length()) {
                    q = -1;
                }
                String q2Str = Integer.toString(q2).trim();
                String validStr = (q != -1) ? qStr : q2Str;
                for (int i = 0; i < validStr.length(); i++) {
                    char key = validStr.charAt(i);
                    char value = response.charAt(i);
                    map.get(key).add(value);
                }
            }
            StringBuilder result = new StringBuilder();
            for (char ch = '0'; ch <= '9'; ch++) {
                result.append(mostFreq(map.get(ch)));
            }
            System.out.println("Case #" + test + ": " + result);
        }
    }
}