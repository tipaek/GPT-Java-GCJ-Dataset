import java.util.*;

class Pair {
    int start;
    int end;
    char assignedTo;
    int index;

    Pair(int start, int end, char assignedTo, int index) {
        this.start = start;
        this.end = end;
        this.assignedTo = assignedTo;
        this.index = index;
    }
}

class SortByTime implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        if (p1.start == p2.start) {
            return p1.end - p2.end;
        } else {
            return p1.start - p2.start;
        }
    }
}

class SortById implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return p1.index - p2.index;
    }
}

class Solution {

    public static int assignTasks(ArrayList<Pair> tasks, int n) {
        if (n == 0) {
            return -1;
        }

        tasks.get(0).assignedTo = 'C';
        int cLastEnd = tasks.get(0).end;
        int jLastEnd = 0;
        int i = 1;

        while (i < n) {
            Pair task = tasks.get(i);

            if (task.start >= cLastEnd) {
                task.assignedTo = 'C';
                cLastEnd = task.end;
            } else if (task.start >= jLastEnd) {
                task.assignedTo = 'J';
                jLastEnd = task.end;
            } else {
                return -1;
            }
            i++;
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            ArrayList<Pair> tasks = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Pair(start, end, 'a', i));
            }

            Collections.sort(tasks, new SortByTime());

            int result = assignTasks(tasks, n);
            StringBuilder resultString = new StringBuilder();

            if (result == -1) {
                resultString.append("IMPOSSIBLE");
            } else {
                Collections.sort(tasks, new SortById());
                for (Pair task : tasks) {
                    resultString.append(task.assignedTo);
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + resultString);
        }
    }
}