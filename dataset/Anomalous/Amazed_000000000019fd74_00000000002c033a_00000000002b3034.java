import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class ListComparator implements Comparator<List<String>> {
        @Override
        public int compare(List<String> l1, List<String> l2) {
            for (int i = 0; i < l1.size(); ++i) {
                int comparison = l1.get(i).compareTo(l2.get(i));
                if (comparison != 0) {
                    return comparison;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int wordCount = scanner.nextInt();
            List<String> words = new ArrayList<>(wordCount);

            for (int w = 0; w < wordCount; w++) {
                words.add(scanner.next());
            }

            List<List<String>> splitWords = new ArrayList<>();
            for (String word : words) {
                List<String> splitWord = new ArrayList<>();
                for (int i = 1; i < word.length(); i++) {
                    splitWord.add(word.substring(i, i + 1));
                }
                splitWord.add(0, Integer.toString(splitWord.size()));
                splitWords.add(splitWord);
            }

            splitWords.sort(new ListComparator());

            boolean isValid = true;
            List<String> lastWord = splitWords.get(splitWords.size() - 1);
            int lastWordSize = lastWord.size();

            for (int i = 0; i < splitWords.size() - 1; i++) {
                List<String> currentWord = splitWords.get(i);
                int lastIndex = lastWordSize - 1;

                for (int j = currentWord.size() - 1; j >= 1; j--) {
                    if (!currentWord.get(j).contentEquals(lastWord.get(lastIndex))) {
                        isValid = false;
                        break;
                    }
                    lastIndex--;
                }

                if (!isValid) {
                    break;
                }
            }

            writer.print("Case #" + (t + 1) + ": ");
            if (isValid) {
                for (int i = 1; i < lastWordSize; i++) {
                    writer.print(lastWord.get(i));
                }
            } else {
                writer.print("*");
            }
            writer.println();
        }

        writer.close();
    }
}