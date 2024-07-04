import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            char[] digits = input.toCharArray();
            Node head = new Node(null, null, Character.getNumericValue(digits[0]));
            Node prev = head;
            
            for (int j = 1; j < digits.length; j++) {
                Node current = new Node(prev, null, Character.getNumericValue(digits[j]));
                prev.next = current;
                prev = current;
            }
            
            Node current = head;
            int openParentheses = current.openParentheses;
            
            while (current != null) {
                if (current.value == 0) {
                    openParentheses = 0;
                }
                
                if (current.prev != null && current.value != 0) {
                    if (openParentheses > current.closeParentheses) {
                        current.prev.closeParentheses = openParentheses - current.closeParentheses;
                        openParentheses -= current.prev.closeParentheses;
                        current.openParentheses = 0;
                    } else if (openParentheses < current.closeParentheses) {
                        current.openParentheses = current.closeParentheses - openParentheses;
                        openParentheses += current.openParentheses;
                        current.prev.closeParentheses = 0;
                    } else {
                        current.prev.closeParentheses = 0;
                    }
                }
                
                while (current.next != null && current.next.value == current.value) {
                    current = current.next;
                }
                
                current = current.next;
            }
            
            current = head;
            StringBuilder nestedString = new StringBuilder();
            
            while (current != null) {
                nestedString.append("(".repeat(current.openParentheses)).append(current.value);
                
                while (current.next != null && current.next.value == current.value) {
                    current = current.next;
                    nestedString.append(current.value);
                }
                
                nestedString.append(")".repeat(current.closeParentheses));
                current = current.next;
            }
            
            System.out.println("Case #" + i + ": " + nestedString);
        }
    }

    static class Node {
        Node prev;
        Node next;
        int value;
        int openParentheses;
        int closeParentheses;

        Node(Node prev, Node next, int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
            this.openParentheses = value;
            this.closeParentheses = value;
        }
    }
}