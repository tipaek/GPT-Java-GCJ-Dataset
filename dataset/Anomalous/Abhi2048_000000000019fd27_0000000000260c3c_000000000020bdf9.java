import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int totalMinutes = 24 * 60 + 2;

        for (int testCase = 1; testCase <= t; testCase++) {
            int[] timeSlots = new int[totalMinutes];
            int n = sc.nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                timeSlots[start] = 1;
                timeSlots[end - 1] = -1;
                tasks[i] = new Task(start, end - 1, i);
            }

            Arrays.sort(tasks);

            boolean isPossible = true;
            for (int i = 1; i < totalMinutes; i++) {
                timeSlots[i] += timeSlots[i - 1];
                if (timeSlots[i] > 2) {
                    isPossible = false;
                    break;
                }
            }

            sb.append("Case #").append(testCase).append(": ");

            if (isPossible) {
                char[] result = new char[n];
                char[] assignedChars = {'C', 'J'};
                int currentCharIndex = 0;

                for (int i = 0; i < n; i++) {
                    Task currentTask = tasks[i];
                    currentTask.assignedChar = assignedChars[currentCharIndex];
                    result[currentTask.index] = currentTask.assignedChar;

                    for (int j = i + 1; j < n; j++) {
                        if (tasks[j].start <= currentTask.end) {
                            currentCharIndex = 1 - currentCharIndex;
                            tasks[j].assignedChar = assignedChars[currentCharIndex];
                            result[tasks[j].index] = tasks[j].assignedChar;
                        } else {
                            break;
                        }
                    }
                }

                sb.append(new String(result));
            } else {
                sb.append("IMPOSSIBLE");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
        sc.close();
    }
}

class Task implements Comparable<Task> {
    int start;
    int end;
    int index;
    char assignedChar;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}