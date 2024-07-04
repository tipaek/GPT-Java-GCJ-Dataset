import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final int N = 10000;

    private void solve(Scanner scanner) {
        int u = scanner.nextInt();
        String[] inputs = new String[N];
        String[] results = new String[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = scanner.next();
            results[i] = scanner.next();
        }

        Set<Character> usedCharacters = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < N; j++) {
                if (inputs[j].charAt(0) == ('0' + i) && inputs[j].length() == results[j].length()) {
                    char firstChar = results[j].charAt(0);
                    if (!usedCharacters.contains(firstChar)) {
                        usedCharacters.add(firstChar);
                        result.append(firstChar);
                        break;
                    }
                }
            }
        }

        for (String res : results) {
            for (char c : res.toCharArray()) {
                if (!usedCharacters.contains(c)) {
                    result.insert(0, c);
                    System.out.println(result.toString());
                    return;
                }
            }
        }

        throw new RuntimeException("Unexpected error occurred");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }
}