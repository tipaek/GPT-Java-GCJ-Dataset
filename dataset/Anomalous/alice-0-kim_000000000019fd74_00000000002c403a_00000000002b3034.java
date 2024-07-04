import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numStrings = scanner.nextInt();
            scanner.nextLine();
            String[] strings = new String[numStrings];
            
            for (int i = 0; i < numStrings; i++) {
                strings[i] = new StringBuilder(scanner.nextLine()).reverse().toString().replace("*", "");
            }
            
            Arrays.sort(strings);
            
            String longestString = strings[numStrings - 1];
            for (int i = 0; i < numStrings - 1; i++) {
                if (!longestString.startsWith(strings[i])) {
                    longestString = "*";
                    break;
                }
            }
            
            System.out.printf("Case #%d: %s\n", t, new StringBuilder(longestString).reverse().toString());
        }
        
        scanner.close();
    }
}