import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            List<String> reversedStrings = new ArrayList<>();
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                String reversed = new StringBuilder(scanner.next()).reverse().toString();
                maxLength = Math.max(maxLength, reversed.length());
                reversedStrings.add(reversed);
            }

            StringBuilder result = new StringBuilder();
            int currentIndex = 0;
            boolean isMismatch = false;

            while (!reversedStrings.isEmpty()) {
                char currentChar = '8';
                Iterator<String> iterator = reversedStrings.iterator();

                while (iterator.hasNext()) {
                    String currentString = iterator.next();
                    if (currentIndex >= currentString.length() || currentString.charAt(currentIndex) == '*') {
                        iterator.remove();
                    } else {
                        char charAtCurrentIndex = currentString.charAt(currentIndex);
                        if (currentChar == '8') {
                            currentChar = charAtCurrentIndex;
                        } else if (currentChar != charAtCurrentIndex) {
                            isMismatch = true;
                            break;
                        }
                    }
                }

                if (isMismatch || currentIndex == maxLength || result.length() == 10000) {
                    break;
                }

                result.append(currentChar);
                currentIndex++;
            }

            if (isMismatch) {
                System.out.println("Case #" + (k + 1) + ": *");
            } else {
                System.out.println("Case #" + (k + 1) + ": " + result.reverse().toString());
            }
        }

        scanner.close();
    }
}