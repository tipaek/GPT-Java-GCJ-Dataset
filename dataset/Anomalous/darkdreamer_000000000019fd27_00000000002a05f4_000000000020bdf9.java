import java.util.Arrays;
import java.util.Scanner;

class Node implements Comparable<Node> {
    int start;
    int end;

    Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node other) {
        if (this.start == other.start) {
            return this.end - other.end;
        } else {
            return this.start - other.start;
        }
    }
}

public class Solution {
    public static String assignTasks(Node[] tasks) {
        Arrays.sort(tasks);
        int cameronEnd = -1;
        int jamieEnd = -1;
        StringBuilder schedule = new StringBuilder();

        for (Node task : tasks) {
            if (cameronEnd == -1) {
                cameronEnd = task.end;
                schedule.append("C");
            } else if (jamieEnd == -1) {
                jamieEnd = task.end;
                schedule.append("J");
            } else if (task.start < cameronEnd && task.start < jamieEnd) {
                return "IMPOSSIBLE";
            } else if (task.start < cameronEnd) {
                schedule.append("J");
                jamieEnd = task.end;
            } else {
                schedule.append("C");
                cameronEnd = task.end;
            }
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numTasks = scanner.nextInt();
            Node[] tasks = new Node[numTasks];

            for (int i = 0; i < numTasks; i++) {
                tasks[i] = new Node(scanner.nextInt(), scanner.nextInt());
            }

            String result = "Case #" + testCase + ": " + assignTasks(tasks);
            System.out.println(result);
        }
    }
}