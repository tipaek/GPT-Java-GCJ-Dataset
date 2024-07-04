import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            String sequence = scanner.nextLine();
            NestingDepths nestingDepths = new NestingDepths(sequence);
            nestingDepths.solve(i + 1);
        }
    }
}

class NestingDepths {
    private final String sequence;
    private final Queue<Integer> queue = new LinkedList<>();
    private final StringBuilder output = new StringBuilder();

    public NestingDepths(String sequence) {
        this.sequence = sequence;
    }

    public void solve(int testCaseNumber) {
        for (char ch : sequence.toCharArray()) {
            if (ch == '0') {
                processQueue();
                output.append("0");
            } else {
                queue.add(Character.getNumericValue(ch));
            }
        }
        processQueue();
        System.out.println("Case #" + testCaseNumber + ": " + output);
    }

    private void processQueue() {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            appendBrackets(num, true);
            output.append(num);

            while (!queue.isEmpty() && queue.peek() == num) {
                output.append(queue.poll());
            }

            while (!queue.isEmpty() && queue.peek() < num) {
                int nextNum = queue.poll();
                appendBrackets(num - nextNum, false);
                num = nextNum;
                output.append(nextNum);
            }

            appendBrackets(num, false);
        }
    }

    private void appendBrackets(int count, boolean open) {
        char bracket = open ? '(' : ')';
        for (int i = 0; i < count; i++) {
            output.append(bracket);
        }
    }
}