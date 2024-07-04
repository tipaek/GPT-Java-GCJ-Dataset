import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<Tracker> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Tracker(start, end, i));
            }

            tasks.sort((t1, t2) -> {
                if (t1.start != t2.start) {
                    return Integer.compare(t1.start, t2.start);
                } else {
                    return Integer.compare(t1.end, t2.end);
                }
            });

            String[] results = new String[n];
            boolean possible = true;
            int cEnd = 0, jEnd = 0;

            for (Tracker task : tasks) {
                if (task.start >= cEnd) {
                    cEnd = task.end;
                    results[task.index] = "C";
                } else if (task.start >= jEnd) {
                    jEnd = task.end;
                    results[task.index] = "J";
                } else {
                    possible = false;
                    break;
                }
            }

            String output = possible ? String.join("", results) : "IMPOSSIBLE";
            System.out.println("Case #" + testCase + ": " + output);
        }
    }
}

class Tracker {
    int start;
    int end;
    int index;

    Tracker(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}