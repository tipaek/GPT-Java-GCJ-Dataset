import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            Shift[] shifts = new Shift[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                shifts[i] = new Shift(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(shifts);

            StringBuilder schedule = new StringBuilder();
            Jam jam = new Jam(shifts[0].start, shifts[0].end);
            Cam cam = new Cam(-1, -1);
            boolean isImpossible = false;

            schedule.append("J");

            for (int i = 1; i < n; i++) {
                if (!cam.canTakeShift(shifts[i].start, shifts[i].end) && !jam.canTakeShift(shifts[i].start, shifts[i].end)) {
                    isImpossible = true;
                    break;
                } else if (cam.canTakeShift(shifts[i].start, shifts[i].end) && jam.canTakeShift(shifts[i].start, shifts[i].end)) {
                    int camDiff = shifts[i].start - cam.currentEnd;
                    int jamDiff = shifts[i].start - jam.currentEnd;
                    if (camDiff <= jamDiff) {
                        cam.updateShift(shifts[i].start, shifts[i].end);
                        schedule.append("C");
                    } else {
                        jam.updateShift(shifts[i].start, shifts[i].end);
                        schedule.append("J");
                    }
                } else if (cam.canTakeShift(shifts[i].start, shifts[i].end)) {
                    cam.updateShift(shifts[i].start, shifts[i].end);
                    schedule.append("C");
                } else if (jam.canTakeShift(shifts[i].start, shifts[i].end)) {
                    jam.updateShift(shifts[i].start, shifts[i].end);
                    schedule.append("J");
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + schedule);
            }
        }
    }
}

class Cam {
    public int currentStart;
    public int currentEnd;

    public Cam(int start, int end) {
        this.currentStart = start;
        this.currentEnd = end;
    }

    public boolean canTakeShift(int start, int end) {
        return start >= currentEnd;
    }

    public void updateShift(int start, int end) {
        this.currentStart = start;
        this.currentEnd = end;
    }
}

class Jam {
    public int currentStart;
    public int currentEnd;

    public Jam(int start, int end) {
        this.currentStart = start;
        this.currentEnd = end;
    }

    public boolean canTakeShift(int start, int end) {
        return start >= currentEnd;
    }

    public void updateShift(int start, int end) {
        this.currentStart = start;
        this.currentEnd = end;
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

    @Override
    public String toString() {
        return start + " " + end;
    }
}