import java.util.Scanner;

public class Solution {
    
    public static String helper(String str) {
        if (str.isEmpty()) {
            return "";
        }
        
        int i = 1;
        while (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
            i++;
        }
        
        if (i == str.length()) {
            return str.charAt(0) == '0' ? str : "(" + str + ")";
        } else {
            String prefix = str.substring(0, i);
            String suffix = helper(str.substring(i));
            return str.charAt(0) == '0' ? prefix + suffix : "(" + prefix + ")" + suffix;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            String result = "Case #" + caseNumber + ": " + helper(input);
            System.out.println(result);
        }
        
        scanner.close();
    }
}