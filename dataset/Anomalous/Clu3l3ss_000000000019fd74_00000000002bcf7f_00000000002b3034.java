import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int numOfWords = Integer.parseInt(reader.readLine());
            System.out.print("Case #" + (t + 1) + ": ");
            String[] words = new String[numOfWords];

            for (int j = 0; j < numOfWords; j++) {
                words[j] = reader.readLine().substring(1);
            }

            String largestWord = words[0];
            for (int j = 1; j < numOfWords; j++) {
                if (words[j].length() > largestWord.length()) {
                    largestWord = words[j];
                } else if (words[j].length() == largestWord.length() && !words[j].equals(largestWord)) {
                    break;
                }
            }

            boolean isValid = true;
            for (int j = 0; j < numOfWords; j++) {
                if (!largestWord.endsWith(words[j])) {
                    System.out.println("*");
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println(largestWord);
            }
        }
    }
}