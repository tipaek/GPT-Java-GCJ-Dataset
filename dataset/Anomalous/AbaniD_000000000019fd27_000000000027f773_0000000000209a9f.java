import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int length = input.length();
            boolean isStarted = false;
            int openBraces = 0;
            
            for (int i = 0; i < length; i++) {
                if (isStarted) {
                    while (i < length && input.charAt(i) != '0' && input.charAt(i) != input.charAt(i - 1)) {
                        result.append("(").append(input.charAt(i));
                        openBraces++;
                        i++;
                    }
                    while (i < length && input.charAt(i) != '0' && input.charAt(i) == input.charAt(i - 1)) {
                        result.append(input.charAt(i));
                        i++;
                    }
                    while (openBraces > 0) {
                        result.append(")");
                        openBraces--;
                    }
                    isStarted = false;
                }
                if (i < length) {
                    if (input.charAt(i) != '0') {
                        openBraces = 1;
                        result.append("(").append(input.charAt(i));
                        isStarted = true;
                    } else {
                        result.append(input.charAt(i));
                    }
                }
            }
            if (isStarted) {
                result.append(")");
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }
}