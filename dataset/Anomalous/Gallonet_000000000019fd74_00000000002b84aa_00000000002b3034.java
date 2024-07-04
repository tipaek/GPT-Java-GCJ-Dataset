import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            int wordsToCheck = scanner.nextInt();
            scanner.nextLine();
            ArrayList<String> wordList = new ArrayList<>();
            boolean contains = false;
            String matchedWord = "";

            for (int j = 0; j < wordsToCheck; j++) {
                String input = scanner.nextLine();

                if (input.startsWith("*")) {
                    String afterAsterisk = input.split("\\*", 2)[1];
                    wordList.add(afterAsterisk);
                    if (j >= 1) {
                        String previousWord = wordList.get(j - 1);
                        if (afterAsterisk.contains(previousWord)) {
                            contains = true;
                            matchedWord = afterAsterisk;
                        } else if (previousWord.contains(afterAsterisk)) {
                            contains = true;
                        }
                    }
                }
            }

            if (contains) {
                System.out.println("Case #" + (i + 1) + ": " + matchedWord);
            } else {
                System.out.println("Case #" + (i + 1) + ": *");
            }
        }
    }
}