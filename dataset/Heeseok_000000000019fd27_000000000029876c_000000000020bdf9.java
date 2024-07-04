import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Task implements Comparable<Task> {
        int mStart;
        int mEnd;
        char mWho;
        Task(int start, int end) {
            mStart = start;
            mEnd = end;
        }

        @Override
        public int compareTo(Task other) {
            if(mStart > other.mStart) return 1;
            if(mStart < other.mStart) return -1;
            if(mEnd > other.mEnd) return 1;
            if(mEnd < other.mEnd) return -1;
            return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("./input.txt"));
        Scanner scanner = new Scanner(System.in);

        int T_testCount = scanner.nextInt();

        outer:
        for (int i = 0; i < T_testCount; i++) {
            List<Task> tasks = new ArrayList<>();
            int N_activities_count = scanner.nextInt();
            for (int j = 0; j < N_activities_count; j++) {
                int S_start = scanner.nextInt();
                int E_end = scanner.nextInt();

                tasks.add(new Task(S_start, E_end));
            }

            List<Task> ordered = new ArrayList<>(tasks);

            Collections.sort(ordered);

            int CameronTaskId = -1;
            int JamieTaskId = -1;

            CameronTaskId = 0;
            ordered.get(0).mWho = 'C';
            for (int j = 1; j < N_activities_count; j++) {

                Task task = ordered.get(j);

                if(CameronTaskId != -1 && ordered.get(CameronTaskId).mEnd <= task.mStart) {
                    CameronTaskId = -1;
                }

                if(JamieTaskId != -1 && ordered.get(JamieTaskId).mEnd <= task.mStart) {
                    JamieTaskId = -1;
                }

                if(CameronTaskId == -1) {
                    CameronTaskId = j;
                    task.mWho = 'C';
                    continue;
                }

                if(JamieTaskId == -1) {
                    JamieTaskId = j;
                    task.mWho = 'J';
                    continue;
                }

                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                continue outer;
            }

            System.out.print("Case #" + (i+1) + ": ");
            for (int j = 0; j < N_activities_count; j++) {
                System.out.print(tasks.get(j).mWho);
            }
            System.out.println();
        }
    }
}
