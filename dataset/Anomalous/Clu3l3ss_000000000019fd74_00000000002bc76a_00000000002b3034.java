import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int numWords = Integer.parseInt(reader.readLine());
            System.out.print("Case #" + (t + 1) + ": ");
            String[] words = new String[numWords];

            for (int w = 0; w < numWords; w++) {
                words[w] = reader.readLine().substring(1);
            }

            String longestWord = words[0];
            for (int w = 1; w < numWords; w++) {
                if (words[w].length() > longestWord.length()) {
                    longestWord = words[w];
                } else if (words[w].length() == longestWord.length() && !words[w].equals(longestWord)) {
                    break;
                }
            }

            boolean isValid = true;
            for (String word : words) {
                if (!longestWord.contains(word)) {
                    System.out.println("*");
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println(longestWord);
            }
        }
    }
}