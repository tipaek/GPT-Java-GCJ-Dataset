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
        scanner.nextLine();  // Consume the newline character

        for (int i = 0; i < t; ++i) {
            String sequence = scanner.nextLine();
            NestingDepth nestingDepth = new NestingDepth(sequence);
            nestingDepth.solve();
        }
    }
}

class NestingDepth {
    static int testCase = 1;
    String sequence;
    Queue<Integer> queue = new LinkedList<>();
    StringBuilder output = new StringBuilder();

    NestingDepth(String sequence) {
        this.sequence = sequence;
    }

    public void solve() {
        for (int i = 0; i < sequence.length(); ++i) {
            char currentChar = sequence.charAt(i);
            if (currentChar == '0') {
                processQueue();
                output.append("0");
            } else {
                queue.add(Character.getNumericValue(currentChar));
            }
        }
        processQueue();
        System.out.printf("Case #%d: %s%n", testCase++, output.toString());
    }

    private void processQueue() {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            appendParentheses(num, '(');
            output.append(num);

            while (!queue.isEmpty() && queue.peek() == num) {
                output.append(queue.poll());
            }

            while (!queue.isEmpty() && queue.peek() < num) {
                int nextNum = queue.peek();
                appendParentheses(num - nextNum, ')');
                num = nextNum;
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