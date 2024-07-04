import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            int onesCount = 0;
            for (int j = 0; j < input.length(); ) {
                if (input.charAt(j) == '1') {
                    onesCount = 1;
                    while (j + onesCount < input.length() && input.charAt(j + onesCount) == '1') {
                        onesCount++;
                    }
                    result.append("(").append(input, j, j + onesCount).append(")");
                    j += onesCount;
                } else {
                    result.append(input.charAt(j));
                    j++;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}