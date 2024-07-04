import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Stack {
    private int top;
    private char[] elements;

    public Stack(int capacity) {
        top = -1;
        elements = new char[capacity];
    }

    public void push(char c) {
        elements[++top] = c;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public char pop() {
        return elements[top--];
    }

    public char peek() {
        return elements[top];
    }

    public int size() {
        return top + 1;
    }

    public char[] getElements() {
        return Arrays.copyOf(elements, size());
    }
}

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            char[][] results = new char[n][];

            for (int i = 0; i < n; i++) {
                String input = reader.readLine();
                Stack stack = new Stack(90000);

                for (int j = 0; j < input.length(); j++) {
                    int digit = Character.getNumericValue(input.charAt(j));
                    int count = 0;

                    if (stack.isEmpty() || stack.peek() == '0') {
                        while (count < digit) {
                            stack.push('(');
                            count++;
                        }
                        stack.push(input.charAt(j));
                        count = 0;
                        while (count < digit) {
                            stack.push(')');
                            count++;
                        }
                    } else if (stack.peek() == ')') {
                        while (count < digit && stack.peek() == ')') {
                            stack.pop();
                            count++;
                        }
                        if (count < digit) {
                            int openCount = 0;
                            while (openCount < digit - count) {
                                stack.push('(');
                                openCount++;
                            }
                        }
                        stack.push(input.charAt(j));
                        count = 0;
                        while (count < digit) {
                            stack.push(')');
                            count++;
                        }
                    }
                }
                results[i] = stack.getElements();
            }

            for (int i = 0; i < n; i++) {
                System.out.print("Case #" + (i + 1) + ": ");
                System.out.println(results[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}