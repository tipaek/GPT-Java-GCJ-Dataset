import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCase; i++) {
            int taskNumber = Integer.parseInt(sc.nextLine());
            String[][] taskTiming = new String[taskNumber][2];
            Task[] taskList = new Task[taskNumber];
            Task[] taskListFirst = new Task[taskNumber];
            boolean canShare = true;
            for (int j = 0; j < taskNumber; j++) {
                taskTiming[j] = sc.nextLine().split(" ");
                taskList[j] = new Task(Integer.parseInt(taskTiming[j][0]), Integer.parseInt(taskTiming[j][1]));
                taskListFirst[j] = taskList[j];
            }
            Arrays.sort(taskList);
            for (int j = 0; j < taskNumber && canShare; j++) {
                boolean cCan = true;
                boolean lCan = true;
                for (int k = 0; k < j && canShare; k++) {
                    if (taskList[k].doBy == 'C' && taskList[j].isOverlapped(taskList[k]))
                        cCan = false;
                }
                if (cCan) {
                    taskList[j].doBy = 'C';
                } else {
                    for (int k = 0; k < j && canShare; k++) {
                        if (taskList[k].doBy == 'J' && taskList[j].isOverlapped(taskList[k])) {
                            lCan = false;
                        }
                    }
                    if (lCan) {
                        taskList[j].doBy = 'J';
                    } else {
                        canShare = false;
                    }
                }
            }

            if (!canShare)
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            else{
                System.out.print("Case #" + (i + 1) + ": ");
                for (Task t : taskListFirst)
                    System.out.print(t.doBy);
                System.out.println();
            }

        }
    }


    static class Task implements Comparable<Task> {
        public int start;
        public int end;
        public char doBy;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlapped(Task t) {
            return (t.start >= start && t.start < end) ||
                    (t.end > start && t.end <= end) ||
                    (t.start <= start && t.end >= end);
        }

        @Override
        public String toString() {
            return "[" + start +
                    "," + end +
                    "], doBy=" + doBy;

        }


        @Override
        public int compareTo(Task task) {
            if (start < task.start)
                return -1;
            else if (start > task.start)
                return 1;
            else return 0;
        }
    }
}