import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            processTestCase(testCase, intervals);
        }
    }

    static class IntervalNode {
        int start;
        int end;
        IntervalNode next;

        IntervalNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class InsertionStatus {
        boolean inserted;
        IntervalNode root;

        InsertionStatus(boolean inserted, IntervalNode root) {
            this.inserted = inserted;
            this.root = root;
        }
    }

    private static InsertionStatus tryInsertNode(IntervalNode root, int start, int end) {
        if (root == null) {
            root = new IntervalNode(start, end);
            return new InsertionStatus(true, root);
        }

        if (end <= root.start) {
            IntervalNode newNode = new IntervalNode(start, end);
            newNode.next = root;
            return new InsertionStatus(true, newNode);
        }

        IntervalNode current = root;
        while (current.next != null) {
            if (current.end <= start && current.next.start >= end) {
                IntervalNode temp = current.next;
                current.next = new IntervalNode(start, end);
                current.next.next = temp;
                return new InsertionStatus(true, root);
            }
            current = current.next;
        }

        if (current.end <= start) {
            current.next = new IntervalNode(start, end);
            return new InsertionStatus(true, root);
        }

        return new InsertionStatus(false, root);
    }

    private static void processTestCase(int testCaseNumber, int[][] intervals) {
        StringBuilder result = new StringBuilder();
        IntervalNode cRoot = null, jRoot = null;

        for (int[] interval : intervals) {
            InsertionStatus status = tryInsertNode(cRoot, interval[0], interval[1]);

            if (status.inserted) {
                result.append("C");
                cRoot = status.root;
            } else {
                status = tryInsertNode(jRoot, interval[0], interval[1]);
                if (status.inserted) {
                    result.append("J");
                    jRoot = status.root;
                } else {
                    System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                    return;
                }
            }
        }
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}