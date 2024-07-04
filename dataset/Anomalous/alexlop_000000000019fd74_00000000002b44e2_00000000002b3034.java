import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RoundOne {

    public static void processWords(String[] words, int caseNum) {
        Arrays.sort(words);
        
        String lastWord = words[words.length - 1];
        String longestSuffix = lastWord.substring(1);
        
        for (int i = 0; i < words.length - 1; i++) {
            if (!words[i].equals(longestSuffix.substring(0, longestSuffix.length()))) {
                System.out.println("Case #" + caseNum + ": *");
                return;
            }
        }
        
        System.out.println("Case #" + caseNum + ": " + longestSuffix);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int numWords = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] words = new String[numWords];
            
            for (int j = 0; j < numWords; j++) {
                words[j] = scanner.nextLine();
            }
            
            processWords(words, i + 1);
        }
        
        scanner.close();
    }
}