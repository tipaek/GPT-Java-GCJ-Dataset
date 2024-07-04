import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int N = in.nextInt();
            String[] ans = new String[N];
            boolean isImpossible = false;
            Task[] tasks = new Task[N];
            boolean isCameronBusy = false;
            boolean isJamieBusy = false;
            int cameronEndTime = 0;
            int jamieEndTime = 0;

            for (int x = 0; x < N; x++) {
                tasks[x] = new Task(in.nextInt(), in.nextInt(), x);
            }

            Arrays.sort(tasks);

            for (int x = 0; x < N; x++) {
                int startTime = tasks[x].start;
                
                if (cameronEndTime <= startTime) {
                    isCameronBusy = false;
                }
                if (jamieEndTime <= startTime) {
                    isJamieBusy = false;
                }

                if (!isCameronBusy) {
                    isCameronBusy = true;
                    ans[tasks[x].originalIndex] = "C";
                    cameronEndTime = tasks[x].end;
                } else if (!isJamieBusy) {
                    isJamieBusy = true;
                    ans[tasks[x].originalIndex] = "J";
                    jamieEndTime = tasks[x].end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String answer = isImpossible ? "IMPOSSIBLE" : String.join("", ans);
            System.out.println("Case #" + tt + ": " + answer);
        }
    }
}

class Task implements Comparable<Task> {
    public int start;
    public int end;
    public int originalIndex;

    public Task(int start, int end, int originalIndex) {
        this.start = start;
        this.end = end;
        this.originalIndex = originalIndex;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public String toString() {
        return "[" + start + " " + end + "]";
    }
}