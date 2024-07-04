import java.util.*;

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
        String resultString = "";

        int[] letterCounts = new int[26];
        for (String result : results) {
            letterCounts[result.charAt(0) - 'A']++;
        }

        for (int i = 0; i < 9; i++) {
            int maxCount = 0;
            int bestIndex = 0;
            for (int j = 0; j < 26; j++) {
                if (letterCounts[j] > maxCount) {
                    maxCount = letterCounts[j];
                    bestIndex = j;
                }
            }
            letterCounts[bestIndex] = 0;
            char selectedChar = (char) (bestIndex + 'A');
            usedCharacters.add(selectedChar);
            resultString += selectedChar;
        }

        outerLoop:
        for (String result : results) {
            for (char character : result.toCharArray()) {
                if (!usedCharacters.contains(character)) {
                    resultString = character + resultString;
                    System.out.println(resultString);
                    return;
                }
            }
        }

        throw new RuntimeException("No valid character found");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfProblems = scanner.nextInt();
        for (int problemIndex = 0; problemIndex < numberOfProblems; problemIndex++) {
            System.out.print("Case #" + (problemIndex + 1) + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }
}