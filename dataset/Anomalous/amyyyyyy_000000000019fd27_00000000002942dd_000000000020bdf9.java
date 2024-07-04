import java.io.*;
import java.util.*;

public class CodeJamQual_3 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(tasks);

            Schedule jam = new Schedule(tasks[0].start, tasks[0].end);
            Schedule cam = new Schedule(-1, -1);
            boolean impossible = false;

            sb.setLength(0);
            sb.append("J");

            for (int i = 1; i < n; i++) {
                if (!cam.takeShift(tasks[i].start, tasks[i].end) && !jam.takeShift(tasks[i].start, tasks[i].end)) {
                    impossible = true;
                    break;
                } else if (cam.takeShift(tasks[i].start, tasks[i].end)) {
                    cam.update(tasks[i].start, tasks[i].end);
                    sb.append("C");
                } else if (jam.takeShift(tasks[i].start, tasks[i].end)) {
                    jam.update(tasks[i].start, tasks[i].end);
                    sb.append("J");
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + sb);
            }
        }
    }
}

class Schedule {
    private int curStart;
    private int curEnd;

    public Schedule(int start, int end) {
        this.curStart = start;
        this.curEnd = end;
    }

    public boolean takeShift(int start, int end) {
        return start >= curEnd;
    }

    public void update(int start, int end) {
        this.curStart = start;
        this.curEnd = end;
    }
}

class Task implements Comparable<Task> {
    public int start;
    public int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}