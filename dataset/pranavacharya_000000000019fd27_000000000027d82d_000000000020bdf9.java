import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    class Task {

        int index;
        int start;
        int end;

        Task(int i, int s, int e) {
            this.index = i;
            this.start = s;
            this.end = e;
        }
    }

    public void ParentingPartnerReturns(int caseno, int[][] tasks) {
        PriorityQueue<Task> minHeap = new PriorityQueue<>((a, b) -> (a.start - b.start));
        for (int i = 0; i < tasks.length; i++) {
            Task t = new Task(i, tasks[i][0], tasks[i][1]);
            minHeap.add(t);
        }
        int cmax = Integer.MIN_VALUE;
        int jmax = Integer.MIN_VALUE;
        HashMap<Integer, Character> map = new HashMap<>();
        while (!minHeap.isEmpty()) {
            Task currentTask = minHeap.remove();
            if (currentTask.start >= cmax) {
                cmax = currentTask.end;
                map.put(currentTask.index, 'C');
            } else if (currentTask.start >= jmax) {
                jmax = currentTask.end;
                map.put(currentTask.index, 'J');
            } else {
                System.out.format("Case #%d: %s", caseno, "IMPOSSIBLE");
                System.out.println();
                return;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tasks.length; i++) {
            answer.append(map.get(i));
        }
        System.out.format("Case #%d: %s", caseno, answer.toString());
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution v = new Solution();
        int testcases = sc.nextInt();
        for (int t = 1; t <= testcases; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            v.ParentingPartnerReturns(t, arr);
        }
    }
}
