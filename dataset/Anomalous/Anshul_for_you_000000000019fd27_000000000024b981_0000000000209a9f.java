import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String s = in.next();
            StackProcessor stackProcessor = new StackProcessor();
            int[] c = new int[s.length()];

            for (int j = 0; j < s.length(); j++) {
                c[j] = Character.getNumericValue(s.charAt(j));
            }

            int openCount = 0;
            int closeCount = 0;

            for (int j = 0; j < s.length(); j++) {
                if (c[j] == 0) {
                    stackProcessor.push("0");
                } else {
                    while (openCount - closeCount != c[j]) {
                        stackProcessor.push("(");
                        openCount++;
                    }
                    stackProcessor.push(String.valueOf(c[j]));
                    while (openCount - closeCount != 1) {
                        stackProcessor.push(")");
                        closeCount++;
                    }
                }
            }
            stackProcessor.push(")");

            System.out.print("Case #" + (i + 1) + ": ");
            stackProcessor.print();
        }
        in.close();
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

    void push(String x) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack Overflow");
        } else {
            stackArray[++top] = x;
        }
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i]);
        }
        System.out.println();
    }
}