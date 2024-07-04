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
        StringBuilder result = new StringBuilder();

        for (Node task : tasks) {
            if (cameronEnd == -1) {
                cameronEnd = task.end;
                result.append("C");
            } else if (jamieEnd == -1) {
                jamieEnd = task.end;
                result.append("J");
            } else if (task.start < cameronEnd && task.start < jamieEnd) {
                return "IMPOSSIBLE";
            } else if (task.start < cameronEnd) {
                jamieEnd = task.end;
                result.append("J");
            } else {
                cameronEnd = task.end;
                result.append("C");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Node[] tasks = new Node[n];
            for (int i = 0; i < n; i++) {
                tasks[i] = new Node(scanner.nextInt(), scanner.nextInt());
            }
            String result = "Case #" + t + ": " + assignTasks(tasks);
            System.out.println(result);
        }
        scanner.close();
    }
}