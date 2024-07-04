import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            StringBuilder nestedString = new StringBuilder();
            String input = scanner.next();
            char[] digits = input.toCharArray();
            
            Node head = new Node(null, null, Character.getNumericValue(digits[0]));
            Node previous = head;
            for (int k = 1; k < digits.length; k++) {
                Node current = new Node(previous, null, Character.getNumericValue(digits[k]));
                previous.next = current;
                previous = current;
            }

            Node current = head;
            int openParentheses = current.openParentheses;

            while (current != null) {
                if (current.previous != null && current.value != 0) {
                    if (openParentheses > current.closeParentheses) {
                        current.previous.closeParentheses = openParentheses - current.closeParentheses;
                        openParentheses -= current.previous.closeParentheses;
                        current.openParentheses = 0;
                    } else if (openParentheses < current.closeParentheses) {
                        current.openParentheses = current.closeParentheses - openParentheses;
                        openParentheses += current.openParentheses;
                        current.previous.closeParentheses = 0;
                    } else {
                        current.previous.closeParentheses = 0;
                    }
                }

                while (current.next != null && current.next.value == current.value) {
                    current = current.next;
                }
                current = current.next;
            }

            current = head;
            while (current != null) {
                for (int j = 0; j < current.openParentheses; j++) {
                    nestedString.append('(');
                }

                nestedString.append(current.value);
                while (current.next != null && current.next.value == current.value) {
                    current = current.next;
                    nestedString.append(current.value);
                }

                for (int j = 0; j < current.closeParentheses; j++) {
                    nestedString.append(')');
                }
                current = current.next;
            }

            System.out.println("Case #" + i + ": " + nestedString.toString());
        }
    }

    static class Node {
        Node previous;
        Node next;
        int value;
        int openParentheses;
        int closeParentheses;

        Node(Node previous, Node next, int value) {
            this.previous = previous;
            this.next = next;
            this.value = value;
            this.openParentheses = value;
            this.closeParentheses = value;
        }
    }
}