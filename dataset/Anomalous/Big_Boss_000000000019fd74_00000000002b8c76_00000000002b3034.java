import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            String[] words = new String[n];
            String longestWord = "";
            int maxLength = 0;
            
            for (int j = 0; j < n; j++) {
                words[j] = removeCharAt(in.next(), 0);
                if (words[j].length() > maxLength) {
                    longestWord = words[j];
                    maxLength = words[j].length();
                }
            }
            
            for (String word : words) {
                if (!longestWord.contains(word)) {
                    longestWord = "*";
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + longestWord);
        }
    }
    
    public static String removeCharAt(String str, int index) {
        return str.substring(0, index) + str.substring(index + 1);
    }
}