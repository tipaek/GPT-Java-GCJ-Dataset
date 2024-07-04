import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private int MB = 1<<20;
    private int SIZE = 20 * MB;

    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    static int readInt() throws IOException {
        String line = br.readLine();
        return Integer.parseInt(line.trim());
    }

    static int[] readIntArray(int size) throws IOException {
        int[] arr = new int[size];
        String line = br.readLine();
        Scanner scanner = new Scanner(line);
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
            sb.append(res.toString());
        }
        System.out.print(sb);
    }

    public static Result solve(int x, int N, Task[] tasks) {
        Result res = new Result();
        res.x = x;
        res.y = schedule(N, tasks);
        return res;
    }

    private static int MAX_TIME = 24*60 + 1;

    private static String schedule(int N, Task[] tasks) {
        int[] sc = new int[MAX_TIME];
        int[] ec = new int[MAX_TIME];
        List<Integer>[] als = new List[MAX_TIME]; // activity list start
        List<Integer>[] ale = new List[MAX_TIME]; // activity list end
        Arrays.fill(sc, 0);
        Arrays.fill(ec, 0);
        for (int i = 0; i < N; i++) {
            ++sc[tasks[i].S];
            if (als[tasks[i].S] == null) {
                als[tasks[i].S] = new LinkedList<>();
            }
            als[tasks[i].S].add(i);

            ++ec[tasks[i].E];
            if (ale[tasks[i].E] == null) {
                ale[tasks[i].E] = new LinkedList<>();
            }
            ale[tasks[i].E].add(i);
        }

        boolean[] pa = new boolean[] {true, true}; // Parent Available

        int ac = 0;
        for (int i = 0; i < sc.length; i++) {
            if (ec[i] > 0) {
                ac -= ec[i];
                for (int e: ale[i]) {
                    pa[tasks[e].p.ordinal()] = true;
                }
            }
            if (sc[i] > 0) {
                ac += ec[i];
                // for every opening tasks
                for (int oi: als[i]) {
                    // iterate over parents
                    for (Parent p: Parent.values()) {
                        if (pa[p.ordinal()]) {
                            tasks[oi].p = p;
                            pa[p.ordinal()] = false;
                            break;
                        }
                    }

                    if (tasks[oi].p == null) {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        char[] ca = new char[N]; // Char Array
        int i = 0;
        for (Task task :
                tasks) {
            ca[i++] = (task.p == Parent.C ? 'C' : 'J');
        }
        return new String(ca);
    }

    enum Parent { C, J };

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
