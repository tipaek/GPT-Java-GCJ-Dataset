import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            Word[] words = new Word[n];

            for (int i = 0; i < n; i++) {
                String wordStr = scanner.next();
                words[i] = solution.new Word(wordStr, wordStr.length());
            }

            Arrays.sort(words);

            boolean isValid = true;
            String longestWord = words[n - 1].text;

            if (longestWord.startsWith("*")) {
                longestWord = longestWord.substring(1);
            }

            for (int i = 0; i < n - 1; i++) {
                String word1 = words[i].text;
                String word2 = words[i + 1].text;

                if (word1.startsWith("*")) {
                    word1 = word1.substring(1);
                }
                if (word2.startsWith("*")) {
                    word2 = word2.substring(1);
                }

                if (!word2.endsWith(word1)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + caseNum + ": " + longestWord);
            } else {
                System.out.println("Case #" + caseNum + ": *");
            }
        }
    }

    class Word implements Comparable<Word> {
        String text;
        int length;

        public Word(String text, int length) {
            this.text = text;
            this.length = length;
        }

        @Override
        public int compareTo(Word other) {
            return this.length - other.length;
        }
    }
}