import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= testCases; i++) {
            int stringCount = Integer.parseInt(scanner.nextLine());
            ArrayList<String> strings = new ArrayList<>();
            
            for (int j = 0; j < stringCount; j++) {
                strings.add(scanner.nextLine());
            }
            
            String result = findLongestCommonSuffix(strings);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String findLongestCommonSuffix(ArrayList<String> strings) {
        String longestString = strings.get(0);

        for (String str : strings) {
            if (str.length() > longestString.length()) {
                longestString = str;
            }
        }

        char[] longestChars = longestString.toCharArray();
        
        for (String str : strings) {
            char[] currentChars = str.toCharArray();
            int longestIndex = longestChars.length - 1;
            
            for (int currentIndex = currentChars.length - 1; currentIndex >= 0; currentIndex--) {
                if (currentChars[currentIndex] == '*') {
                    longestIndex = 0;
                    break;
                } else if (longestChars[longestIndex] != currentChars[currentIndex]) {
                    return "*";
                }
                longestIndex--;
            }
            
            if (longestIndex > 0) {
                return "*";
            }
        }
        
        return longestString.substring(1);
    }
}