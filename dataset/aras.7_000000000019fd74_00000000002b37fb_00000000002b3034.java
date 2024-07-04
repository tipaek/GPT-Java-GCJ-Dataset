import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String []args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCount = in.nextInt();
        for (int testNumber = 1; testNumber <= testCount; testNumber++) {
            int n = in.nextInt();

            List<String> patterns = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                patterns.add(in.next());
            }

            patterns.sort(Comparator.comparingInt(String::length));

            // for (int i = 0; i < n; i++) {
            //     System.out.println(patterns.get(i));
            // }

            if (canSolveIt(patterns)) {
                System.out.printf("Case #%d: %s\n", testNumber, patterns.get(patterns.size() - 1).substring(1));
            } else {
                System.out.printf("Case #%d: *\n", testNumber);
            }
        }
    }

    private static boolean canSolveIt(List<String> patterns) {
        String lastWord = patterns.get(patterns.size() - 1);
        for (int i = 0; i < patterns.size() - 1; i++) {
            String word = patterns.get(i).substring(1);
            String wordToMatch = lastWord.substring(lastWord.length() - word.length());

//            System.out.printf("comparing %s == %s | %s\n", word, wordToMatch, lastWord);

            if (!word.equals(wordToMatch)) {
                return false;
            }
        }

        return true;
    }
}