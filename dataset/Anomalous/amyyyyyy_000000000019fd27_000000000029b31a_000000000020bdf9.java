import java.io.*;
import java.util.*;

public class CodeJamQual_3 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

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
            Person jam = new Person(tasks[0].start, tasks[0].end);
            Person cam = new Person(-1, -1);
            boolean impossible = false;

            for (int i = 1; i < n; i++) {
                if (!cam.assignShift(tasks[i].start, tasks[i].end) && !jam.assignShift(tasks[i].start, tasks[i].end)) {
                    impossible = true;
                    break;
                } else if (cam.assignShift(tasks[i].start, tasks[i].end) && jam.assignShift(tasks[i].start, tasks[i].end)) {
                    int camDiff = tasks[i].start - cam.curEnd;
                    int jamDiff = tasks[i].start - jam.curEnd;
                    if (camDiff <= jamDiff) {
                        cam.updateShift(tasks[i].start, tasks[i].end);
                        finalOrder[tasks[i].order] = 'C';
                    } else {
                        jam.updateShift(tasks[i].start, tasks[i].end);
                        finalOrder[tasks[i].order] = 'J';
                    }
                } else if (cam.assignShift(tasks[i].start, tasks[i].end)) {
                    cam.updateShift(tasks[i].start, tasks[i].end);
                    finalOrder[tasks[i].order] = 'C';
                } else if (jam.assignShift(tasks[i].start, tasks[i].end)) {
                    jam.updateShift(tasks[i].start, tasks[i].end);
                    finalOrder[tasks[i].order] = 'J';
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + new String(finalOrder));
            }
        }
    }

    static class Person {
        int curStart;
        int curEnd;

        Person(int start, int end) {
            this.curStart = start;
            this.curEnd = end;
        }

        boolean assignShift(int start, int end) {
            return start >= curEnd;
        }

        void updateShift(int start, int end) {
            this.curStart = start;
            this.curEnd = end;
        }
    }

    static class Shift implements Comparable<Shift> {
        int start;
        int end;
        int order;

        Shift(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }

        @Override
        public int compareTo(Shift other) {
            return Integer.compare(this.start, other.start);
        }
    }
}