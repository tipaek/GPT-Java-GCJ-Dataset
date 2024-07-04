import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<String> words = new ArrayList<>();
            int longestWordIndex = 0;
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                String word = scanner.next();
                if (word.length() > maxLength) {
                    maxLength = word.length();
                    longestWordIndex = i;
                }
                words.add(word);
            }

            boolean isPossible = true;
            outerLoop:
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    char[] word1 = words.get(i).toCharArray();
                    char[] word2 = words.get(j).toCharArray();
                    int idx1 = word1.length - 1;
                    int idx2 = word2.length - 1;

                    while (idx1 >= 0 && idx2 >= 0) {
                        if (word1[idx1] != word2[idx2]) {
                            isPossible = false;
                            break outerLoop;
                        }
                        idx1--;
                        idx2--;
                    }
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + words.get(longestWordIndex).substring(1));
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }

    public static int sum(int x, int y) {
        return x + y;
    }
}