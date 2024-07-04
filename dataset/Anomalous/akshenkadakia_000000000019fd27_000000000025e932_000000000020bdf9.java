import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int caseN = 1; caseN <= T; caseN++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Task> J = new TreeMap<>();
            TreeMap<Integer, Task> C = new TreeMap<>();
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (possible) {
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    Task newTask = new Task(i, start, end);

                    boolean canFitJ = canFitTask(J, start, end);
                    boolean canFitC = canFitTask(C, start, end);

                    if (canFitJ) {
                        J.put(start, newTask);
                    } else if (canFitC) {
                        C.put(start, newTask);
                    } else {
                        if (canSwapTasks(J, C, start, end)) {
                            swapTasks(J, C, start, newTask);
                        } else {
                            possible = false;
                        }
                    }
                }
            }

            printResult(caseN, N, possible, J, C);
        }
    }

    private static boolean canFitTask(TreeMap<Integer, Task> map, int start, int end) {
        Map.Entry<Integer, Task> lower = map.floorEntry(start);
        Map.Entry<Integer, Task> higher = map.higherEntry(start);
        return (lower == null || start >= lower.getValue().end) && (higher == null || end <= higher.getKey());
    }

    private static boolean canSwapTasks(TreeMap<Integer, Task> J, TreeMap<Integer, Task> C, int start, int end) {
        boolean canFitLowerJ = canFitTask(J, start, end);
        boolean canFitHigherC = canFitTask(C, start, end);
        boolean canFitLowerC = canFitTask(C, start, end);
        boolean canFitHigherJ = canFitTask(J, start, end);
        return (canFitLowerJ && canFitHigherC) || (canFitHigherJ && canFitLowerC);
    }

    private static void swapTasks(TreeMap<Integer, Task> J, TreeMap<Integer, Task> C, int start, Task newTask) {
        Map<Integer, Task> headJ = J.headMap(start);
        Map<Integer, Task> tailJ = J.tailMap(start);
        Map<Integer, Task> headC = C.headMap(start);
        Map<Integer, Task> tailC = C.tailMap(start);

        J.clear();
        C.clear();

        J.putAll(headJ);
        J.putAll(tailC);
        C.putAll(headC);
        C.putAll(tailJ);

        if (canFitTask(J, start, newTask.end)) {
            J.put(start, newTask);
        } else {
            C.put(start, newTask);
        }
    }

    private static void printResult(int caseN, int N, boolean possible, TreeMap<Integer, Task> J, TreeMap<Integer, Task> C) {
        if (possible) {
            String[] arr = new String[N];
            for (Task x : J.values()) {
                arr[x.number] = "J";
            }
            for (Task x : C.values()) {
                arr[x.number] = "C";
            }
            System.out.printf("Case #%d: %s\n", caseN, String.join("", arr));
        } else {
            System.out.printf("Case #%d: %s\n", caseN, "IMPOSSIBLE");
        }
    }
}

class Task {
    int start, end, number;

    Task(int number, int start, int end) {
        this.number = number;
        this.start = start;
        this.end = end;
    }
}