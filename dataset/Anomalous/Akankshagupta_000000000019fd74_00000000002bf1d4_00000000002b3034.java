import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= cases; caseNumber++) {
            int patternsCount = Integer.parseInt(scanner.nextLine());
            String startPattern = "";
            String endPattern = "";
            boolean isValid = true;

            for (int i = 0; i < patternsCount; i++) {
                String pattern = scanner.nextLine();
                int starIndex = pattern.indexOf('*');

                String startPart = pattern.substring(0, starIndex);
                String endPart = pattern.substring(starIndex + 1);

                if (startPart.length() > startPattern.length()) {
                    if (startPart.startsWith(startPattern)) {
                        startPattern = startPart;
                    } else {
                        isValid = false;
                    }
                } else {
                    if (!startPattern.startsWith(startPart)) {
                        isValid = false;
                    }
                }

                if (endPart.length() > endPattern.length()) {
                    if (endPart.endsWith(endPattern)) {
                        endPattern = endPart;
                    } else {
                        isValid = false;
                    }
                } else {
                    if (!endPattern.endsWith(endPart)) {
                        isValid = false;
                    }
                }
            }

            String result = isValid ? startPattern + endPattern : "*";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}