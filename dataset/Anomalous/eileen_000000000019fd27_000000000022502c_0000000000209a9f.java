import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.print("Case #" + (t + 1) + ": ");
            String input = scanner.next();
            boolean isOneOpen = false;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                char previousChar = i > 0 ? input.charAt(i - 1) : ' ';
                char nextChar = i < input.length() - 1 ? input.charAt(i + 1) : ' ';

                if (currentChar == '0') {
                    if (isOneOpen) {
                        System.out.print(")0");
                        isOneOpen = false;
                    } else {
                        System.out.print("0");
                    }
                } else if (currentChar == '1') {
                    if (i == 0 || previousChar == '0') {
                        System.out.print("(1");
                        isOneOpen = true;
                    } else if (i == input.length() - 1 || nextChar == '0') {
                        System.out.print("1)");
                        isOneOpen = false;
                    } else {
                        System.out.print("1");
                    }
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}