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

            int indexWithMaxLength = 0;
            int maxLength = 0;
            for (int i = 0; i < splitWords.size(); i++) {
                int length = Integer.parseInt(splitWords.get(i).get(0));
                if (length > maxLength) {
                    indexWithMaxLength = i;
                    maxLength = length;
                }
            }

            boolean isCommonSuffix = true;
            for (int i = 0; i < splitWords.size(); i++) {
                if (i == indexWithMaxLength) continue;

                int maxIndex = splitWords.get(indexWithMaxLength).size() - 1;
                for (int j = splitWords.get(i).size() - 1; j >= 1; j--) {
                    String currentChar = splitWords.get(i).get(j);
                    String maxChar = splitWords.get(indexWithMaxLength).get(maxIndex);
                    if (!currentChar.equals(maxChar)) {
                        isCommonSuffix = false;
                        break;
                    }
                    maxIndex--;
                }
                if (!isCommonSuffix) {
                    break;
                }
            }

            writer.print("Case #" + (t + 1) + ": ");
            if (isCommonSuffix) {
                for (int i = 1; i < splitWords.get(indexWithMaxLength).size(); i++) {
                    writer.print(splitWords.get(indexWithMaxLength).get(i));
                }
            } else {
                writer.print("*");
            }
            writer.println();
        }
        writer.close();
    }
}