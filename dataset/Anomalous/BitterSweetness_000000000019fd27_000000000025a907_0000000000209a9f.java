import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            String binaryString = scanner.nextLine();
            Pattern pattern = Pattern.compile("0+|1+|2+|3+|4+|5+|6+|7+|8+|9");
            Matcher matcher = pattern.matcher(binaryString);
            StringBuilder output = new StringBuilder();
            int openBrackets = 0;
            
            while (matcher.find()) {
                String match = matcher.group(0);
                int currentDigit = Character.getNumericValue(match.charAt(0));
                
                if (currentDigit == 0) {
                    output.append(")".repeat(openBrackets)).append(match);
                    openBrackets = 0;
                } else {
                    if (openBrackets == 0) {
                        output.append("(".repeat(currentDigit)).append(match);
                        openBrackets = currentDigit;
                    } else {
                        if (currentDigit >= openBrackets) {
                            output.append("(".repeat(currentDigit - openBrackets)).append(match);
                        } else {
                            output.append(")".repeat(openBrackets - currentDigit)).append(match);
                        }
                        openBrackets = currentDigit;
                    }
                }
            }
            
            output.append(")".repeat(openBrackets));
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
        
        scanner.close();
    }
}