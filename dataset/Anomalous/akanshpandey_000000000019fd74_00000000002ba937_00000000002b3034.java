import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int numStrings = scanner.nextInt();
            String[] strings = new String[numStrings];
            
            for (int j = 0; j < numStrings; j++) {
                strings[j] = scanner.next();
            }
            
            int maxLength = -1;
            int maxIndex = -1;
            
            for (int j = 0; j < numStrings; j++) {
                if (strings[j].length() > maxLength) {
                    maxLength = strings[j].length();
                    maxIndex = j;
                }
            }
            
            String longestString = strings[maxIndex].replaceAll("\\*", "");
            boolean isMatch = true;
            
            for (String str : strings) {
                String regex = str.replaceAll("\\*", "[A-Z]*");
                if (!Pattern.matches(regex, longestString)) {
                    isMatch = false;
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + (isMatch ? longestString : "*"));
        }
        
        scanner.close();
    }
}