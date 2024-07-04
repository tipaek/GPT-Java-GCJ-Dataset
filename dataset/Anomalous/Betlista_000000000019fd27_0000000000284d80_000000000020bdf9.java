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
            Result result = solve(t + 1, N, tasks);
            sb.append(result);
        }
        System.out.print(sb);
    }

    private static Result solve(int x, int N, Task[] tasks) {
        Result res = new Result();
        res.x = x;
        res.y = schedule(N, tasks);
        return res;
    }

    private static String schedule(int N, Task[] tasks) {
        int[] sc = new int[MAX_TIME];
        int[] ec = new int[MAX_TIME];
        List<Integer>[] als = new List[MAX_TIME];
        List<Integer>[] ale = new List[MAX_TIME];
        Arrays.fill(sc, 0);
        Arrays.fill(ec, 0);

        for (int i = 0; i < N; i++) {
            int start = tasks[i].S;
            int end = tasks[i].E;
            
            sc[start]++;
            if (als[start] == null) {
                als[start] = new LinkedList<>();
            }
            als[start].add(i);

            ec[end]++;
            if (ale[end] == null) {
                ale[end] = new LinkedList<>();
            }
            ale[end].add(i);
        }

        boolean[] parentAvailable = {true, true};
        int activeTasks = 0;

        for (int i = 0; i < MAX_TIME; i++) {
            if (ec[i] > 0) {
                activeTasks -= ec[i];
                for (int e : ale[i]) {
                    parentAvailable[tasks[e].p.ordinal()] = true;
                }
            }
            if (sc[i] > 0) {
                activeTasks += sc[i];
                for (int oi : als[i]) {
                    for (Parent p : Parent.values()) {
                        if (parentAvailable[p.ordinal()]) {
                            tasks[oi].p = p;
                            parentAvailable[p.ordinal()] = false;
                            break;
                        }
                    }
                    if (tasks[oi].p == null) {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        char[] resultArray = new char[N];
        for (int i = 0; i < N; i++) {
            resultArray[i] = (tasks[i].p == Parent.C) ? 'C' : 'J';
        }
        return new String(resultArray);
    }

    enum Parent { C, J }

    static class Task {
        int S, E;
        Parent p;

        public Task(int s, int e) {
            S = s;
            E = e;
        }
    }

    static class Result {
        int x;
        String y;

        @Override
        public String toString() {
            return String.format("Case #%d: %s%n", x, y);
        }
    }
}