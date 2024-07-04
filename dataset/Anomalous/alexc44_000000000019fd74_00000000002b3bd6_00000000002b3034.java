import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;
        
        for (int i = 0; i < cases; i++) {
            int curr = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("Case #" + (i + 1) + ": " + generatePattern(curr, scanner));
        }
        scanner.close();
    }

    public static String generatePattern(int length, Scanner scanner) {
        String pattern = "";
        
        for (int i = 0; i < length; i++) {
            String curr = scanner.nextLine().substring(1);
            
            if (pattern.isEmpty()) {
                pattern = curr;
            } else {
                String shorter = curr.length() <= pattern.length() ? curr : pattern;
                String longer = curr.length() > pattern.length() ? curr : pattern;
                
                if (!isSuffixMatch(shorter, longer)) {
                    return "*";
                }
                pattern = longer;
            }
        }
        return pattern;
    }

    private static boolean isSuffixMatch(String shorter, String longer) {
        int shorterLength = shorter.length();
        int longerLength = longer.length();
        
        for (int j = 0; j < shorterLength; j++) {
            if (shorter.charAt(shorterLength - j - 1) != longer.charAt(longerLength - j - 1)) {
                return false;
            }
        }
        return true;
    }
}