import java.util.*;
import java.io.*;

public class Solution {

    public static void addBrackets(Deque<Character> parenthesis, char num, int diff) {
        int n = Character.getNumericValue(num);
        for (int i = 0; i < diff; i++) {
            parenthesis.addLast('(');
        }
        parenthesis.addLast(num);
        for (int i = 0; i < n; i++) {
            parenthesis.addLast(')');
        }
    }

    public static void insertDigit(Deque<Character> parenthesis, char num) {
        int n = Character.getNumericValue(num);
        for (int i = 0; i < n; i++) {
            parenthesis.removeLast();
        }
        parenthesis.addLast(num);
        for (int i = 0; i < n; i++) {
            parenthesis.addLast(')');
        }
    }

    public static int checkLastDepth(Deque<Character> parenthesis) {
        Deque<Character> p = new ArrayDeque<>(parenthesis);
        if (p.isEmpty()) {
            return 0;
        }

        char top = p.peekLast();
        while (top == ')') {
            p.removeLast();
            top = p.peekLast();
        }

        return Character.getNumericValue(top);
    }

    public static void printStack(Deque<Character> parenthesis) {
        if (parenthesis.isEmpty()) {
            return;
        }

        char top = parenthesis.peekLast();
        parenthesis.removeLast();

        printStack(parenthesis);
        System.out.print(top);
        parenthesis.addLast(top);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String nums = in.next();
            Deque<Character> parenthesis = new ArrayDeque<>();
            for (int j = 0; j < nums.length(); j++) {
                char n = nums.charAt(j);
                int depth = checkLastDepth(parenthesis);
                int num = Character.getNumericValue(n);
                if (depth < num) {
                    int diff = num - depth;
                    if (parenthesis.isEmpty()) {
                        addBrackets(parenthesis, n, diff);
                    } else {
                        char top = parenthesis.peekLast();
                        while (top == ')') {
                            parenthesis.removeLast();
                            top = parenthesis.peekLast();
                        }
                        addBrackets(parenthesis, n, diff);
                    }
                } else {
                    insertDigit(parenthesis, n);
                }
            }
            System.out.print("Case #" + i + ": ");
            printStack(parenthesis);
            System.out.println();
        }
    }
}