import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            Shift[] tasks = new Shift[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                tasks[i] = new Shift(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(tasks);

            Jam jam = new Jam(tasks[0].start, tasks[0].end);
            Cam cam = new Cam(-1, -1);
            boolean impossible = false;
            StringBuilder sb = new StringBuilder();
            sb.append("J");

            for (int i = 1; i < n; i++) {
                if (!cam.takeShift(tasks[i].start, tasks[i].end) && !jam.takeShift(tasks[i].start, tasks[i].end)) {
                    impossible = true;
                    break;
                } else if (cam.takeShift(tasks[i].start, tasks[i].end)) {
                    cam.updateShift(tasks[i].start, tasks[i].end);
                    sb.append("C");
                } else {
                    jam.updateShift(tasks[i].start, tasks[i].end);
                    sb.append("J");
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + sb.toString());
            }
        }
    }
}

class Cam {
    private int curStart;
    private int curEnd;

    public Cam(int start, int end) {
        this.curStart = start;
        this.curEnd = end;
    }

    public boolean takeShift(int start, int end) {
        return start >= curEnd;
    }

    public void updateShift(int start, int end) {
        this.curStart = start;
        this.curEnd = end;
    }
}

class Jam {
    private int curStart;
    private int curEnd;

    public Jam(int start, int end) {
        this.curStart = start;
        this.curEnd = end;
    }

    public boolean takeShift(int start, int end) {
        return start >= curEnd;
    }

    public void updateShift(int start, int end) {
        this.curStart = start;
        this.curEnd = end;
    }
}

class Shift implements Comparable<Shift> {
    public int start;
    public int end;

    public Shift(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Shift other) {
        return Integer.compare(this.start, other.start);
    }
}