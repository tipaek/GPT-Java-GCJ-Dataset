import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final int MB = 1 << 20;
    private static final int SIZE = 20 * MB;
    private static final int MAX_TIME = 24 * 60 + 1;

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);

    private static int readInt() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    private static int[] readIntArray(int size) throws IOException {
        int[] arr = new int[size];
        Scanner scanner = new Scanner(br.readLine());
        for (int i = 0; i < size; ++i) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        for (int t = 0; t < T; ++t) {
            int N = readInt();
            Task[] tasks = new Task[N];
            for (int n = 0; n < N; n++) {
                int[] se = readIntArray(2);
                tasks[n] = new Task(se[0], se[1]);
            }
            Result res = solve(t + 1, N, tasks);
            sb.append(res);
        }
        System.out.print(sb);
    }

    private static Result solve(int caseNumber, int N, Task[] tasks) {
        Result res = new Result();
        res.caseNumber = caseNumber;
        res.schedule = createSchedule(N, tasks);
        return res;
    }

    private static String createSchedule(int N, Task[] tasks) {
        int[] startCount = new int[MAX_TIME];
        int[] endCount = new int[MAX_TIME];
        List<Integer>[] startActivities = new List[MAX_TIME];
        List<Integer>[] endActivities = new List[MAX_TIME];
        Arrays.fill(startCount, 0);
        Arrays.fill(endCount, 0);

        for (int i = 0; i < N; i++) {
            startCount[tasks[i].start]++;
            if (startActivities[tasks[i].start] == null) {
                startActivities[tasks[i].start] = new LinkedList<>();
            }
            startActivities[tasks[i].start].add(i);

            endCount[tasks[i].end]++;
            if (endActivities[tasks[i].end] == null) {
                endActivities[tasks[i].end] = new LinkedList<>();
            }
            endActivities[tasks[i].end].add(i);
        }

        boolean[] parentAvailable = {true, true};
        int activeCount = 0;

        for (int i = 0; i < startCount.length; i++) {
            if (endCount[i] > 0) {
                activeCount -= endCount[i];
                for (int endIndex : endActivities[i]) {
                    parentAvailable[tasks[endIndex].parent.ordinal()] = true;
                }
            }
            if (startCount[i] > 0) {
                activeCount += startCount[i];
                for (int startIndex : startActivities[i]) {
                    for (Parent parent : Parent.values()) {
                        if (parentAvailable[parent.ordinal()]) {
                            tasks[startIndex].parent = parent;
                            parentAvailable[parent.ordinal()] = false;
                            break;
                        }
                    }
                    if (tasks[startIndex].parent == null) {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        char[] result = new char[N];
        for (int i = 0; i < N; i++) {
            result[i] = (tasks[i].parent == Parent.C) ? 'C' : 'J';
        }
        return new String(result);
    }

    private enum Parent { C, J }

    private static class Task {
        int start, end;
        Parent parent;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class Result {
        int caseNumber;
        String schedule;

        @Override
        public String toString() {
            return String.format("Case #%d: %s%n", caseNumber, schedule);
        }
    }
}