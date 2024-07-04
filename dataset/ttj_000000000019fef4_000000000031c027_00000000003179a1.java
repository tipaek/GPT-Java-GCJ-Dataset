import java.util.*;

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
            for (int k = 0; k < 10; k++) {
                charMap.put(k, new HashSet<>());
            }

            for (int j = 0; j < 10000; j++) {
                int maxValue = scanner.nextInt();
                String rand = scanner.next();

                for (Character c : rand.toCharArray()) {
                    charSet.add(c);
                }

                if (maxValue > 0) {
                    int expectedLength = (int)(Math.log10(maxValue) + 1);
                    if (rand.length() == expectedLength) {
                        int firstDigit = maxValue / (int)(Math.pow(10, expectedLength - 1));
                        char firstChar = rand.charAt(0);
                        charMap.get(firstDigit).add(firstChar);
                    }
                }
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
