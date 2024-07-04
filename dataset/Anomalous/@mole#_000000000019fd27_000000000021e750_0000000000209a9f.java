import java.util.Scanner;

class Stack {
    private static final int MAX = 50;
    private int[] data = new int[MAX];
    private int top;

    public Stack() {
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAX - 1;
    }

    public void push(int x) {
        if (!isFull()) {
            data[++top] = x;
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return data[top--];
        }
        return -1; // Indicating stack underflow
    }

    public int peek() {
        if (!isEmpty()) {
            return data[top];
        }
        return -1; // Indicating stack underflow
    }
}

public class InfixToPostfix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter an infix expression: ");
        String infix = scanner.next();
        String postfix = infixToPostfix(infix);
        System.out.println("\nPostfix expression: " + postfix);
    }

    private static String infixToPostfix(String infix) {
        Stack s = new Stack();
        StringBuilder postfix = new StringBuilder();
        char x;

        for (int i = 0; i < infix.length(); i++) {
            char token = infix.charAt(i);

            if (Character.isLetterOrDigit(token)) {
                postfix.append(token);
            } else if (token == '(') {
                s.push(token);
            } else if (token == ')') {
                while ((x = (char) s.pop()) != '(') {
                    postfix.append(x);
                }
            } else {
                while (!s.isEmpty() && precedence(token) <= precedence((char) s.peek())) {
                    x = (char) s.pop();
                    postfix.append(x);
                }
                s.push(token);
            }
        }

        while (!s.isEmpty()) {
            x = (char) s.pop();
            postfix.append(x);
        }

        return postfix.toString();
    }

    private static int precedence(char x) {
        switch (x) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return 3;
        }
    }
}