import java.util.*;
import java.io.*;

public class Solution {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            solveParentingPartners(caseNumber, n);
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

    public static void solveParentingPartners(int caseNumber, int n) {
        int[][] intervals = new int[n][2];
        StringBuilder result = new StringBuilder(n);
        char[] people = {'C', 'J'};

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<Task> availableTasks = new PriorityQueue<>(2, Comparator.comparingInt(task -> task.endTime));
        availableTasks.add(new Task(-1, 0));
        availableTasks.add(new Task(-1, 1));

        for (int[] interval : intervals) {
            Task currentTask = availableTasks.poll();
            if (currentTask.endTime > interval[0]) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
            result.append(people[currentTask.person]);
            currentTask.endTime = interval[1];
            availableTasks.add(currentTask);
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    public static void solveNestingDepth(int caseNumber, String line) {
        StringBuilder result = new StringBuilder(line.length());
        int openParentheses = 0;

        for (char ch : line.toCharArray()) {
            int digit = ch - '0';
            while (openParentheses > digit) {
                result.append(')');
                openParentheses--;
            }
            while (openParentheses < digit) {
                result.append('(');
                openParentheses++;
            }
            result.append(ch);
        }
        while (openParentheses > 0) {
            result.append(')');
            openParentheses--;
        }
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    public static void solveVestigium(int caseNumber, int n) {
        Set<Integer>[] rows = new HashSet[n];
        Set<Integer>[] columns = new HashSet[n];
        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
        }

        Set<Integer> repeatedRows = new HashSet<>();
        Set<Integer> repeatedColumns = new HashSet<>();
        int trace = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                if (!rows[i].add(num)) repeatedRows.add(i);
                if (!columns[j].add(num)) repeatedColumns.add(j);
                if (i == j) trace += num;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows.size() + " " + repeatedColumns.size());
    }
}