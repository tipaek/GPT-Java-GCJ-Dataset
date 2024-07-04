import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int wordCount = Integer.parseInt(scanner.nextLine().trim());
            List<String> words = new ArrayList<>();
            for (int j = 0; j < wordCount; j++) {
                words.add(scanner.nextLine().trim());
            }
            System.out.println("Case #" + caseNumber + ": " + processWords(words));
        }
    }

    private static String processWords(List<String> words) {
        int[] forwardPointers = new int[words.size()];
        StringBuilder resultBuilder = new StringBuilder();

        while (true) {
            Set<Character> currentChars = new HashSet<>();
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).charAt(forwardPointers[i]) != '*') {
                    currentChars.add(words.get(i).charAt(forwardPointers[i]));
                }
            }
            if (currentChars.isEmpty()) break;
            if (currentChars.size() > 1) return "*";

            for (int i = 0; i < words.size(); i++) {
                if (currentChars.contains(words.get(i).charAt(forwardPointers[i]))) {
                    forwardPointers[i]++;
                }
            }
            resultBuilder.append(currentChars.iterator().next());
        }

        int[] backwardPointers = new int[words.size()];
        StringBuilder suffixBuilder = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            backwardPointers[i] = words.get(i).length() - 1;
        }

        while (true) {
            Set<Character> currentChars = new HashSet<>();
            for (int i = 0; i < words.size(); i++) {
                if (backwardPointers[i] > forwardPointers[i] && words.get(i).charAt(backwardPointers[i]) != '*') {
                    currentChars.add(words.get(i).charAt(backwardPointers[i]));
                }
            }
            if (currentChars.isEmpty()) break;
            if (currentChars.size() > 1) return "*";

            for (int i = 0; i < words.size(); i++) {
                if (currentChars.contains(words.get(i).charAt(backwardPointers[i]))) {
                    backwardPointers[i]--;
                }
            }
            suffixBuilder.append(currentChars.iterator().next());
        }

        return resultBuilder.toString() + suffixBuilder.reverse().toString();
    }
}