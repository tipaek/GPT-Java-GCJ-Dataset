import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            boolean isOpen = false;
            System.out.print("Case #" + (i + 1) + ": ");
            String inputString = scanner.next();

            for (int j = 0; j < inputString.length(); j++) {
                char currentChar = inputString.charAt(j);

                if (currentChar == '0') {
                    if (isOpen) {
                        System.out.print(")0");
                        isOpen = false;
                    } else {
                        System.out.print("0");
                    }
                } else if (currentChar == '1') {
                    if (!isOpen) {
                        if (j == 0 || inputString.charAt(j - 1) == '0') {
                            System.out.print("(1");
                        } else {
                            System.out.print("1");
                        }
                        isOpen = true;
                    } else {
                        System.out.print("1");
                    }

                    if (j == inputString.length() - 1) {
                        System.out.print(")");
                        isOpen = false;
                    }
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}