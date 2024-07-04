import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        for (int i = 0; i < numberOfTestCases; i++) {
            String sequence = scanner.nextLine();
            NestingDepths nestingDepths = new NestingDepths(sequence);
            nestingDepths.solve();
        }
    }
}

class NestingDepths {
    private static int testCase = 1;
    private final String sequence;
    private final Queue<Integer> queue = new LinkedList<>();
    private final StringBuilder output = new StringBuilder();

    public NestingDepths(String sequence) {
        this.sequence = sequence;
    }

    public void solve() {
        for (char ch : sequence.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (digit == 0) {
                processQueue();
                output.append('0');
            } else {
                queue.add(digit);
            }
        }
        processQueue();
        System.out.println("Case #" + testCase++ + ": " + output);
    }

    private void processQueue() {
        while (!queue.isEmpty()) {
            int currentNum = queue.poll();
            output.append("(".repeat(currentNum)).append(currentNum);

            while (!queue.isEmpty() && queue.peek() == currentNum) {
                output.append(queue.poll());
            }

            while (!queue.isEmpty() && queue.peek() < currentNum) {
                int nextNum = queue.poll();
                output.append(")".repeat(currentNum - nextNum)).append(nextNum);
                currentNum = nextNum;
            }

            output.append(")".repeat(currentNum));
        }
    }
}