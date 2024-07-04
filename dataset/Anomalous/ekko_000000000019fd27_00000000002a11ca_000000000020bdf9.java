import java.util.*;
import java.io.*;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            solveParentingPartners(caseNumber, n);
        }
    }

    private static class Task {
        int endTime;
        int personIndex;

        public Task(int endTime, int personIndex) {
            this.endTime = endTime;
            this.personIndex = personIndex;
        }
    }

    private static void solveParentingPartners(int caseNumber, int n) {
        int[][] intervals = new int[n][2];
        StringBuilder result = new StringBuilder(n);
        char[] persons = {'C', 'J'};

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        PriorityQueue<Task> taskQueue = new PriorityQueue<>(2, Comparator.comparingInt((Task t) -> t.endTime).thenComparingInt(t -> t.personIndex));
        taskQueue.add(new Task(-1, 0));
        taskQueue.add(new Task(-1, 1));

        for (int[] interval : intervals) {
            Task currentTask = taskQueue.poll();
            if (currentTask.endTime > interval[0]) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
            result.append(persons[currentTask.personIndex]);
            currentTask.endTime = interval[1];
            taskQueue.add(currentTask);
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static void solveNestingDepth(int caseNumber, String input) {
        StringBuilder result = new StringBuilder(input.length());
        int openBrackets = 0;

        for (char ch : input.toCharArray()) {
            int num = ch - '0';
            while (openBrackets > num) {
                result.append(')');
                openBrackets--;
            }
            while (openBrackets < num) {
                result.append('(');
                openBrackets++;
            }
            result.append(ch);
        }
        while (openBrackets > 0) {
            result.append(')');
            openBrackets--;
        }
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static void solveVestigium(int caseNumber, int n) {
        Set<Integer>[] rows = new HashSet[n];
        Set<Integer>[] columns = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
        }

        Set<Integer> duplicateRows = new HashSet<>();
        Set<Integer> duplicateColumns = new HashSet<>();
        int trace = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                if (!rows[i].add(num)) duplicateRows.add(i);
                if (!columns[j].add(num)) duplicateColumns.add(j);
                if (i == j) trace += num;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows.size() + " " + duplicateColumns.size());
    }
}