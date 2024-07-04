import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            Shift[] tasks = new Shift[n];
            char[] finalOrder = new char[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                tasks[i] = new Shift(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
            }

            Arrays.sort(tasks);
            finalOrder[tasks[0].order] = 'J';
            Schedule jam = new Schedule(tasks[0].start, tasks[0].end);
            Schedule cam = new Schedule(-1, -1);
            boolean impossible = false;

            for (int i = 1; i < n; i++) {
                Shift task = tasks[i];
                if (!cam.canTakeShift(task.start, task.end) && !jam.canTakeShift(task.start, task.end)) {
                    impossible = true;
                    break;
                } else if (cam.canTakeShift(task.start, task.end) && jam.canTakeShift(task.start, task.end)) {
                    int camDiff = task.start - cam.end;
                    int jamDiff = task.start - jam.end;
                    if (camDiff <= jamDiff) {
                        cam.updateSchedule(task.start, task.end);
                        finalOrder[task.order] = 'C';
                    } else {
                        jam.updateSchedule(task.start, task.end);
                        finalOrder[task.order] = 'J';
                    }
                } else if (cam.canTakeShift(task.start, task.end)) {
                    cam.updateSchedule(task.start, task.end);
                    finalOrder[task.order] = 'C';
                } else if (jam.canTakeShift(task.start, task.end)) {
                    jam.updateSchedule(task.start, task.end);
                    finalOrder[task.order] = 'J';
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + new String(finalOrder));
            }
        }
    }
}

class Schedule {
    int start;
    int end;

    public Schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean canTakeShift(int start, int end) {
        return start >= this.end;
    }

    public void updateSchedule(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Shift implements Comparable<Shift> {
    int start;
    int end;
    int order;

    public Shift(int start, int end, int order) {
        this.start = start;
        this.end = end;
        this.order = order;
    }

    @Override
    public int compareTo(Shift other) {
        return Integer.compare(this.start, other.start);
    }
}