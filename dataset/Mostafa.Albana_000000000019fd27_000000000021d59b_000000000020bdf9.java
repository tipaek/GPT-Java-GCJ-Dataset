import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();


        for (int t = 1; t <= T ; t++) {
            int N = in.nextInt();
            System.out.println(String.format("Case #%d: %s", t, solve(in, N)));
        }


    }


    public static String solve(Scanner in, int N) {
        List<ParentTask> tasks = new ArrayList<>();
        boolean lastAssignedToCameron = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            tasks.add(new ParentTask(start, end));
        }

        tasks.sort(new Comparator<ParentTask>() {
            @Override
            public int compare(ParentTask o1, ParentTask o2) {
                return o1.start-o2.start;
            }
        });

        // System.out.println();
        List<ParentTask> inProgress = new LinkedList<>();
        for (int i = 0; i < tasks.size(); i++) {

            Iterator<ParentTask> itr = inProgress.iterator();
            while (itr.hasNext()) {
                if (! (itr.next().end > tasks.get(i).start)) {
                    itr.remove();
                }
            }

            if(inProgress.size() > 1) return "IMPOSSIBLE";
            if(inProgress.size() == 0) {
                tasks.get(i).assignedC = true;
            }
            else {
                tasks.get(i).assignedC = !inProgress.get(0).assignedC;
            }
            inProgress.add(tasks.get(i));

            result.append(tasks.get(i).assignedC ? "C" : "J");
            // System.out.println(result.toString());
        }

        return result.toString();
    }


    public static class ParentTask {
        public int start;
        public int end;
        public boolean assignedC;

        public ParentTask() { }

        public ParentTask(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedC = assignedC;
        }
    }

}
