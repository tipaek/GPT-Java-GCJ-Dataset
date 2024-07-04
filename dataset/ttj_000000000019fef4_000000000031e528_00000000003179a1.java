import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            scanner.nextInt(); // max length, unused
            Set<Character> charSet = new HashSet<>();
            Map<Integer, Set<Character>> charMap = new HashMap<>();
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int k = 0; k < 10; k++) {
                charMap.put(k, new HashSet<>());
            }

            for (int j = 0; j < 10000; j++) {
                long maxValue = scanner.nextLong();
                String rand = scanner.next();

                for (Character c : rand.toCharArray()) {
                    charSet.add(c);
                }

                char firstChar = rand.charAt(0);
                if (maxValue > 0) {
                    int expectedLength = (int)(Math.log10(maxValue) + 1);
                    if (rand.length() == expectedLength) {
                        long firstDigit = maxValue / (long)(Math.pow(10, expectedLength - 1));
                        charMap.get((int)firstDigit).add(firstChar);
                    }
                }

                if (!freqMap.containsKey(firstChar)) {
                    freqMap.put(firstChar, 0);
                }
                freqMap.put(firstChar, freqMap.get(firstChar) + 1);
            }

            char[] solution = new char[10];
            Set<Character> inOrderCharSet = new HashSet<>();
            for (int l = 1; l < 10; l++) {
                for (Character c : charMap.get(l)) {
                    if (!inOrderCharSet.contains(c)) {
                        inOrderCharSet.add(c);
                        solution[l] = c;
                        break;
                    }
                }
            }

            if (inOrderCharSet.isEmpty()) {
                List<Map.Entry<Character, Integer>> orderedList = freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
                if (orderedList.size() < 9) {
                    break;
                }
                for (int m = 0; m < 9; m++) {
                    Character c = orderedList.get(m).getKey();
                    inOrderCharSet.add(c);
                    solution[9 - m] = c;
                }
            }

            for (Character c : charSet) {
                if (!inOrderCharSet.contains(c)) {
                    inOrderCharSet.add(c);
                    solution[0] = c;
                    break;
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            System.out.print(String.valueOf(solution));
            if (i != n - 1)
                System.out.println();
        }
    }
}
