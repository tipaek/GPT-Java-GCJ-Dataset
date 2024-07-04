import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numWords = scanner.nextInt();
            List<String> words = new ArrayList<>(numWords);

            for (int i = 0; i < numWords; i++) {
                words.add(scanner.next());
            }

            List<List<String>> splitWords = new ArrayList<>();
            for (String word : words) {
                List<String> splitWord = new ArrayList<>();
                for (int j = 1; j < word.length(); j++) {
                    splitWord.add(word.substring(j, j + 1));
                }
                splitWord.add(0, Integer.toString(splitWord.size()));
                splitWords.add(splitWord);
            }

            int maxIndex = 0;
            int maxLength = 0;
            for (int i = 0; i < splitWords.size(); i++) {
                int length = Integer.parseInt(splitWords.get(i).get(0));
                if (length > maxLength) {
                    maxIndex = i;
                    maxLength = length;
                }
            }

            boolean isCommonSuffix = true;
            for (List<String> splitWord : splitWords) {
                int suffixIndex = splitWords.get(maxIndex).size() - 1;
                for (int j = splitWord.size() - 1; j >= 1; j--) {
                    if (!splitWord.get(j).equals(splitWords.get(maxIndex).get(suffixIndex))) {
                        isCommonSuffix = false;
                        break;
                    }
                    suffixIndex--;
                }
                if (!isCommonSuffix) {
                    break;
                }
            }

            if (!isCommonSuffix) {
                writer.printf("Case #%d: *%n", t + 1);
            } else {
                writer.printf("Case #%d: ", t + 1);
                for (int i = 1; i < splitWords.get(maxIndex).size(); i++) {
                    writer.print(splitWords.get(maxIndex).get(i));
                }
                writer.println();
            }
        }
        writer.close();
    }
}