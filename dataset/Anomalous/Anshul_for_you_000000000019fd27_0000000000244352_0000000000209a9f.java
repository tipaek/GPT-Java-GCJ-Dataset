import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();
            StringBuilder result = new StringBuilder();
            StackProcessor stackProcessor = new StackProcessor();

            int[] digits = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                digits[j] = Character.getNumericValue(s.charAt(j));
            }

            if (digits[0] == 0) {
                stackProcessor.push("0");
            } else if (digits[0] == 1 && s.length() == 1) {
                stackProcessor.push("(");
                stackProcessor.push("1");
                stackProcessor.push(")");
            } else {
                stackProcessor.push("(");
                stackProcessor.push("1");
            }

            for (int j = 1; j < s.length(); j++) {
                if (digits[j] == 1 && digits[j - 1] != 1) {
                    stackProcessor.push("(");
                    stackProcessor.push("1");
                } else if (digits[j] == 0 && digits[j - 1] == 0) {
                    stackProcessor.push("0");
                } else if (digits[j] == 1 && digits[j - 1] == 1) {
                    stackProcessor.push("1");
                } else if (digits[j] == 1 && j + 1 == s.length()) {
                    stackProcessor.push(")");
                } else if (digits[j] == 0 && digits[j - 1] == 1) {
                    stackProcessor.push(")");
                    stackProcessor.push("0");
                }
            }

            stackProcessor.print();
        }
        scanner.close();
    }
}

class StackProcessor {
    private int top;
    private static final int MAX = 1000;
    private String[] stack;

    StackProcessor() {
        top = -1;
        stack = new String[MAX];
    }

    void push(String x) {
        if (top >= MAX - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = x;
        }
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i]);
        }
        System.out.println();
    }
}