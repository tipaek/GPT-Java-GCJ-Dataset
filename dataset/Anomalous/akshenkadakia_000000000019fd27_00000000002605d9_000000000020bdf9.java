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
                    possible = handleOverlap(J, C, start, end, newTask);
                }
            }

            printResult(caseN, N, possible, J, C);
        }
    }

    private static boolean canFitTask(TreeMap<Integer, Task> map, int start, int end) {
        Map.Entry<Integer, Task> lower = map.floorEntry(start);
        Map.Entry<Integer, Task> higher = map.higherEntry(start);
        return (lower == null || lower.getValue().end <= start) && (higher == null || higher.getKey() >= end);
    }

    private static boolean handleOverlap(TreeMap<Integer, Task> J, TreeMap<Integer, Task> C, int start, int end, Task newTask) {
        Map.Entry<Integer, Task> lowerJ = J.floorEntry(start);
        Map.Entry<Integer, Task> higherJ = J.higherEntry(start);
        Map.Entry<Integer, Task> lowerC = C.floorEntry(start);
        Map.Entry<Integer, Task> higherC = C.higherEntry(start);

        boolean canFitLowerJ = lowerJ != null && lowerJ.getValue().end <= start;
        boolean canFitHigherJ = higherJ != null && higherJ.getKey() >= end;
        boolean canFitLowerC = lowerC != null && lowerC.getValue().end <= start;
        boolean canFitHigherC = higherC != null && higherC.getKey() >= end;

        if ((canFitLowerJ && canFitHigherC) || (canFitHigherJ && canFitLowerC)) {
            if (canFitLowerJ && lowerC != null && higherJ != null && lowerC.getValue().end > higherJ.getKey()) {
                return false;
            }
            if (canFitHigherJ && lowerJ != null && higherC != null && lowerJ.getValue().end > higherC.getKey()) {
                return false;
            }

            TreeMap<Integer, Task> newJ = new TreeMap<>();
            TreeMap<Integer, Task> newC = new TreeMap<>();

            newJ.putAll(J.headMap(start));
            newJ.putAll(C.tailMap(start));
            newC.putAll(C.headMap(start));
            newC.putAll(J.tailMap(start));

            if (canFitLowerJ) {
                newJ.put(start, newTask);
            } else {
                newC.put(start, newTask);
            }

            J.clear();
            J.putAll(newJ);
            C.clear();
            C.putAll(newC);
            return true;
        }
        return false;
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
            System.out.printf("Case #%d: IMPOSSIBLE\n", caseN);
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

    @Override
    public String toString() {
        return "Task{" +
                "start=" + start +
                ", end=" + end +
                ", number=" + number +
                '}';
    }
}