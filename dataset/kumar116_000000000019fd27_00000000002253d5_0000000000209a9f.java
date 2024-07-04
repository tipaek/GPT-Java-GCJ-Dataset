import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            String[] s = scanner.next().split("");

            Stack<String> result = new Stack<String>();
            Stack<String> buffer = new Stack<String>();
            for (int j = (s.length - 1); j >= 0; j--) {
                Integer c = Integer.parseInt(s[j]);
                if (result.isEmpty()) {
                    for (int rightBrackets = 0; rightBrackets < c; rightBrackets++) {
                        result.push(")");
                    }
                    result.push(c.toString());
                    for (int leftBrackets = 0; leftBrackets < c; leftBrackets++) {
                        result.push("(");
                    }
                } else {
                    for (int brackets = 0; brackets < c; brackets++) {
                        if (result.peek() == "(") {
                            buffer.push(result.pop());
                        } else {
                            break;
                        }
                    }

                    int selfBrackets = c - buffer.size();
                    for (int rightBrackets = 0; rightBrackets < selfBrackets; rightBrackets++) {
                        result.push(")");
                    }
                    result.push(c.toString());
                    for (int leftBrackets = 0; leftBrackets < selfBrackets; leftBrackets++) {
                        result.push("(");
                    }
                    while (!buffer.isEmpty()) {
                        result.push(buffer.pop());
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            while (!result.isEmpty()) {
                sb.append(result.pop());
            }
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
    }
}
