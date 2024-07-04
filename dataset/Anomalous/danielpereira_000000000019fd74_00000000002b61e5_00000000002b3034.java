import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numWords = Integer.parseInt(reader.readLine());
            List<String> wordList = new ArrayList<>(numWords);
            
            for (int j = 0; j < numWords; j++) {
                wordList.add(reader.readLine());
            }
            
            wordList.sort((word1, word2) -> word2.length() - word1.length());
            boolean isMatch = true;
            
            for (int j = 0; j < wordList.size() - 1; j++) {
                if (!wordList.get(j).substring(1).endsWith(wordList.get(j + 1).substring(1))) {
                    isMatch = false;
                    break;
                }
            }
            
            String resultWord = wordList.get(0).replaceFirst("\\*", "");
            if (isMatch) {
                System.out.printf("Case #%d: %s%n", testCase, resultWord);
            } else {
                System.out.printf("Case #%d: *%n", testCase);
            }
        }
    }
}