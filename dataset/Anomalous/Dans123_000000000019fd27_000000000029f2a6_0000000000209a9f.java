import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int testCase = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; ++i) {
            String sequence = scanner.nextLine();
            NestingDepths nestingDepths = new NestingDepths(sequence);
            nestingDepths.solve();
        }
    }
}

class NestingDepths {
    private static int testCase;
    private final String sequence;
    private final Queue<Integer> queue = new LinkedList<>();
    private final StringBuilder output = new StringBuilder();

    public NestingDepths(String sequence) {
        this.sequence = sequence;
    }

    public void solve() {
        for (char c : sequence.toCharArray()) {
            if (c == '0') {
                emptyQueueAndBuildString();
                output.append("0");
            } else {
                queue.add(Character.getNumericValue(c));
            }
        }
        emptyQueueAndBuildString();
        System.out.println("Case #" + testCase++ + ": " + output.toString());
    }

    private void emptyQueueAndBuildString() {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            appendParentheses(num, '(');
            output.append(num);
            while (!queue.isEmpty() && queue.peek() == num) {
                output.append(queue.poll());
            }
            while (!queue.isEmpty() && queue.peek() < num) {
                appendParentheses(num - queue.peek(), ')');
                num = queue.peek();
                output.append(queue.poll());
            }
            appendParentheses(num, ')');
        }
    }

    private void appendParentheses(int count, char parenthesis) {
        for (int i = 0; i < count; ++i) {
            output.append(parenthesis);
        }
    }
}