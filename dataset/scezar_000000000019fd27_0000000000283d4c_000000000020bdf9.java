import java.util.*;
import java.io.*;


public class Solution {


public class Task {
    int start;
    int end;
    int idx;

    Task(int start, int end, int idx) {
        this.idx = idx;
        this.start = start;
        this.end = end;
    }
}

public class TaskComparator implements Comparator<Task> {
    public int compare (Task t1, Task t2) {
        if (t1.start > t2.start) return 1;
        if (t1.start < t2.start) return -1;
        if (t1.end > t2.end) return 1;
        if (t1.end < t2.end) return -1;
        if (t1.idx > t2.idx) return 1;
        if (t1.idx < t2.idx) return -1;
        return 0;
    }
}

public static void main(String[] args) {
    Solution sol = new Solution();
    sol.sol();
}

    void sol(){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt();
        for (int idx=1; idx<=N; ++idx) {
            TreeSet<Task> set = getTasks(in);
            char[] sol = new char[set.size()];
            int[] last = {0, 0};
            boolean bad = false;
            for (Task task: set) {
                if (last[0] <= task.start) {
                    sol[task.idx] = 'C';
                    last[0] = task.end;
                    continue;
                }
                if (last[1] <= task.start) {
                    sol[task.idx] = 'J';
                    last[1] = task.end;
                    continue;
                }
                bad = true;
                break;
            }
            if (!bad) {
                System.out.printf("Case #%d: %s\n", idx, new String(sol));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", idx);
            }


        }
    }

    TreeSet<Task>  getTasks(Scanner in){
        int size = in.nextInt();
        TreeSet<Task> set = new TreeSet<Task>(new TaskComparator());
        for (int row=0; row<size; ++row) {
            int from = in.nextInt();
            int to = in.nextInt();

            Task task = new Task(from, to, row);
            set.add(task);
        }
        return set;
    }



}
