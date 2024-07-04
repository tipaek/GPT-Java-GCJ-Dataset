import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            processTestCase(testCase, scanner);
        }
    }

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        int intervalsCount = scanner.nextInt();
        Node[] intervals = new Node[intervalsCount];

        for (int i = 0; i < intervalsCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals[i] = new Node(start, end);
        }

        // Arrays.sort(intervals); // Uncomment if sorting is needed

        Person personJ = new Person();
        Person personC = new Person();

        boolean isImpossible = false;
        StringBuilder resultBuilder = new StringBuilder();

        for (Node interval : intervals) {
            if (!personJ.hasOverlap(interval)) {
                personJ.addInterval(interval);
                resultBuilder.append("J");
            } else if (!personC.hasOverlap(interval)) {
                personC.addInterval(interval);
                resultBuilder.append("C");
            } else {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            printTestCaseResult(testCaseNumber, "IMPOSSIBLE");
        } else {
            printTestCaseResult(testCaseNumber, resultBuilder.toString());
        }
    }

    private static class Person {
        private final List<Node> intervals;

        public Person() {
            intervals = new ArrayList<>();
        }

        public void addInterval(Node interval) {
            intervals.add(interval);
        }

        public boolean hasOverlap(Node interval) {
            for (Node existingInterval : intervals) {
                if (existingInterval.overlapsWith(interval)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class Node implements Comparable<Node> {
        private final int start;
        private final int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(Node other) {
            return (this.start < other.end && this.end > other.start);
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.start, other.start);
        }
    }

    private static void printTestCaseResult(int testCaseNumber, String result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}