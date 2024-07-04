import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int length = input.length();
            boolean inGroup = false;
            int openBraces = 0;

            for (int i = 0; i < length; i++) {
                char currentChar = input.charAt(i);

                if (inGroup) {
                    while (i < length && currentChar != '0') {
                        if (i > 0 && currentChar != input.charAt(i - 1)) {
                            result.append('(').append(currentChar);
                            openBraces++;
                        } else {
                            result.append(currentChar);
                        }
                        i++;
                        if (i < length) {
                            currentChar = input.charAt(i);
                        }
                    }
                    while (openBraces > 0) {
                        result.append(')');
                        openBraces--;
                    }
                    inGroup = false;
                }

                if (i < length) {
                    if (currentChar != '0') {
                        openBraces = 1;
                        result.append('(').append(currentChar);
                        inGroup = true;
                    } else {
                        result.append(currentChar);
                    }
                }
            }

            if (inGroup) {
                result.append(')');
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}