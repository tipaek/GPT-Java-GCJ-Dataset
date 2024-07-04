import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StackProcessor stackProcessor = new StackProcessor();
            int[] digits = new int[input.length()];

            for (int j = 0; j < input.length(); j++) {
                digits[j] = Character.getNumericValue(input.charAt(j));
            }

            int openCount = 0;
            int closeCount = 0;

            for (int j = 0; j < input.length(); j++) {
                if (digits[j] == 0) {
                    stackProcessor.push("0");
                } else {
                    while (openCount - closeCount != digits[j]) {
                        stackProcessor.push("(");
                        openCount++;
                    }
                    stackProcessor.push(String.valueOf(digits[j]));
                    while (openCount - closeCount != 1) {
                        stackProcessor.push(")");
                        closeCount++;
                    }
                }
            }

            if (openCount - closeCount != 0) {
                stackProcessor.push(")");
            }

            System.out.print("Case #" + (i + 1) + ": ");
            stackProcessor.print();
        }
    }
}

class StackProcessor {
    private int top;
    private static final int MAX_SIZE = 1000;
    private String[] stackArray;

    StackProcessor() {
        top = -1;
        stackArray = new String[MAX_SIZE];
    }

    void push(String value) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("StackOverflow");
        } else {
            stackArray[++top] = value;
        }
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i]);
        }
        System.out.println();
    }
}