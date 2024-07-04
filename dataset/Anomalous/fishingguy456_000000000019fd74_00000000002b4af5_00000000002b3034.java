import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int testCases = sc.nextInt();

        for (int caseNum = 0; caseNum < testCases; caseNum++) {
            int n = sc.nextInt();
            Word[] words = new Word[n];

            for (int i = 0; i < n; i++) {
                String wordString = sc.next();
                words[i] = solution.new Word(wordString, wordString.length());
            }

            Arrays.sort(words);
            boolean isValid = true;
            String longestWord = words[n - 1].wordString;

            if (longestWord.startsWith("*")) {
                longestWord = longestWord.substring(1);
            }

            for (int i = 0; i < n - 1; i++) {
                String currentWord = words[i].wordString;
                String nextWord = words[i + 1].wordString;

                if (currentWord.startsWith("*")) {
                    currentWord = currentWord.substring(1);
                }
                if (nextWord.startsWith("*")) {
                    nextWord = nextWord.substring(1);
                }
                if (!nextWord.endsWith(currentWord)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + (caseNum + 1) + ": " + longestWord);
            } else {
                System.out.println("Case #" + (caseNum + 1) + ": *");
            }
        }
    }

    class Word implements Comparable<Word> {
        String wordString;
        int length;

        public Word(String wordString, int length) {
            this.wordString = wordString;
            this.length = length;
        }

        @Override
        public int compareTo(Word other) {
            return this.length - other.length;
        }
    }
}