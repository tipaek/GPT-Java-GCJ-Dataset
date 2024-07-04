import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int periods = in.nextInt();

            List<Task> tasks = new ArrayList<>();

            for (int period = 0; period < periods; period++) {
                int start = in.nextInt();
                int end = in.nextInt();
                tasks.add(new Task(start, end, period));
            }
            Collections.sort(tasks, new SortbyStart());

            int cameronEnd = -1;
            int jEnd = -1;
            boolean impossible = false;
            char[] doer = new char[tasks.size()];

            for (int j = 0; j < tasks.size(); j++) {
                //System.out.println(tasks.get(j).start + " " + tasks.get(j).end + " " + tasks.get(j).pos);
                int start = tasks.get(j).start;
                int end = tasks.get(j).end;
                int pos = tasks.get(j).pos;

                if (start >= cameronEnd) {
                    cameronEnd = -1;
                }

                if (start >= jEnd) {
                    jEnd = -1;
                }

                if (cameronEnd == -1) {
                    doer[pos] = 'C';
                    cameronEnd = end;
                } else if (jEnd == -1) {
                    doer[pos] = 'J';
                    jEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder ans = new StringBuilder();
                for (int j = 0; j < doer.length; j++) {
                    ans.append(doer[j]);
                }
                System.out.println("Case #" + i + ": " + ans.toString());
            }
        }
    }
}

class Task {
    int start;
    int end;
    int pos;

    public Task(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class SortbyStart implements Comparator<Task> {
    public int compare(Task a, Task b) {
        return a.start - b.start;
    }
}