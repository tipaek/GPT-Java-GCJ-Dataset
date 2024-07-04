import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.next();
            StackProcessor stackProcessor = new StackProcessor();
            int[] digits = new int[inputString.length()];
            
            for (int j = 0; j < inputString.length(); j++) {
                digits[j] = Character.getNumericValue(inputString.charAt(j));
            }
            
            if (digits[0] == 0) {
                stackProcessor.push("0");
            } else if (digits[0] == 1 && inputString.length() == 1) {
                stackProcessor.push("(");
                stackProcessor.push("1");
                stackProcessor.push(")");
            } else {
                stackProcessor.push("(");
                stackProcessor.push("1");
            }
            
            for (int j = 1; j < inputString.length(); j++) {
                if (digits[j] == 1 && digits[j - 1] != 1) {
                    stackProcessor.push("(");
                    stackProcessor.push("1");
                }
                if (digits[j] == 0 && digits[j - 1] == 0) {
                    stackProcessor.push("0");
                }
                if (digits[j] == 1 && digits[j - 1] == 1) {
                    stackProcessor.push("1");
                }
                if (digits[j] == 1 && j + 1 == inputString.length()) {
                    stackProcessor.push(")");
                }
                if (digits[j] == 0 && digits[j - 1] == 1) {
                    stackProcessor.push(")");
                    stackProcessor.push("0");
                }
            }
            
            System.out.print("Case #" + (i + 1) + ": ");
            stackProcessor.print();
        }
        
        scanner.close();
    }
}

class StackProcessor {
    private static final int MAX_SIZE = 1000;
    private int top;
    private String[] stackArray;

    StackProcessor() {
        top = -1;
        stackArray = new String[MAX_SIZE];
    }

    void push(String element) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack Overflow");
        } else {
            stackArray[++top] = element;
        }
    }

    void pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stackArray[top--]);
        }
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i]);
        }
        System.out.println();
    }

    void peek() {
        if (top >= 0) {
            System.out.println(stackArray[top]);
        } else {
            System.out.println("Stack is empty");
        }
    }
}