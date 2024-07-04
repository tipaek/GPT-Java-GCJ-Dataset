import java.util.*;
import java.io.*;

public class Solution {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNo = 1; caseNo <= testCases; ++caseNo) {
            int n = scanner.nextInt();
            solveParentingPartners(caseNo, n);
        }
    }

    private static class Task {
        int endTime;
        int person;

        public Task(int endTime, int person) {
            this.endTime = endTime;
            this.person = person;
        }
    }

    public static void solveParentingPartners(int caseNo, int n) {
        int[][] intervals = new int[n][];
        char[] result = new char[n];
        char[] people = {'C', 'J'};

        for (int i = 0; i < n; i++) {
            intervals[i] = new int[] {scanner.nextInt(), scanner.nextInt(), i}; // start - end - index
        }

        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<Task> heap = new PriorityQueue<>(2, Comparator.comparingInt((Task t) -> t.endTime).thenComparingInt(t -> t.person));
        heap.add(new Task(-1, 0));
        heap.add(new Task(-1, 1));

        for (int[] interval : intervals) {
            Task task = heap.poll();
            if (task.endTime > interval[0]) {
                System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
                return;
            }
            result[interval[2]] = people[task.person];
            task.endTime = interval[1];
            heap.add(task);
        }

        System.out.println("Case #" + caseNo + ": " + new String(result));
    }

    public static void solveNestingDepth(int caseNo, String line) {
        StringBuilder sb = new StringBuilder(line.length());
        int openCount = 0;

        for (char ch : line.toCharArray()) {
            int num = ch - '0';
            while (openCount < num) {
                sb.append('(');
                openCount++;
            }
            while (openCount > num) {
                sb.append(')');
                openCount--;
            }
            sb.append(ch);
        }
        while (openCount > 0) {
            sb.append(')');
            openCount--;
        }
        System.out.println("Case #" + caseNo + ": " + sb.toString());
    }

    public static void solveVestigium(int caseNo, int n) {
        Set<Integer>[] rows = new HashSet[n];
        Set<Integer>[] cols = new HashSet[n];
        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        Set<Integer> repeatedRows = new HashSet<>();
        Set<Integer> repeatedCols = new HashSet<>();
        int trace = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                if (!rows[i].add(num)) repeatedRows.add(i);
                if (!cols[j].add(num)) repeatedCols.add(j);
                if (i == j) trace += num;
            }
        }

        System.out.println("Case #" + caseNo + ": " + trace + " " + repeatedRows.size() + " " + repeatedCols.size());
    }
}