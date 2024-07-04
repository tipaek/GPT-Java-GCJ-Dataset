import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String[] input = scanner.nextLine().split("");
            StringBuilder result = new StringBuilder();
            boolean isOneActive = false;

            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("1")) {
                    if (!isOneActive) {
                        result.append("(1");
                        isOneActive = true;
                    } else {
                        result.append("1");
                    }
                } else if (input[j].equals("0")) {
                    if (isOneActive) {
                        result.append(")0");
                        isOneActive = false;
                    } else {
                        result.append("0");
                    }
                }

                if (j == input.length - 1 && isOneActive) {
                    result.append(")");
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}