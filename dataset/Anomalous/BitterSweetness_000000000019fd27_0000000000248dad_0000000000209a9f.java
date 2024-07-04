import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String binaryString = scanner.nextLine();
            Pattern pattern = Pattern.compile("0+|1+");
            Matcher matcher = pattern.matcher(binaryString);

            StringBuilder formattedOutput = new StringBuilder();

            while (matcher.find()) {
                String matchedGroup = matcher.group();
                if (matchedGroup.charAt(0) == '1') {
                    formattedOutput.append("(").append(matchedGroup).append(")");
                } else {
                    formattedOutput.append(matchedGroup);
                }
            }

            System.out.println("Case #" + caseIndex + ": " + formattedOutput);
        }
    }
}