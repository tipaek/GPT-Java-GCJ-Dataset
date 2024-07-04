import java.util.Arrays;
import java.util.Scanner;

class Task {
    public int start;
    public int end;

    public Task(int s, int e){
        this.start = s;
        this.end = e;
    }
}

public class Solution {
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] result = new String[T];
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            Task[] tasks = new Task[n];
            for (int j = 0; j < n; j++)
                tasks[j] = new Task(sc.nextInt(), sc.nextInt());
            result[i] = distribute(tasks);
        }
        for (int i = 0; i < T; i++)
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
    }

    public String distribute(Task[] tasks) {
        StringBuilder sb = new StringBuilder();
        int n = tasks.length;
        char[] schedule = new char[n];
        Task[] sortedTasks = tasks.clone();
        Arrays.sort(sortedTasks, (a, b) -> a.start - b.start);
        int freeTimeC = 0;
        int freeTimeJ = 0;
        for (int i = 0; i < n; i++) {
            if (freeTimeC <= sortedTasks[i].start) {
                freeTimeC = sortedTasks[i].end;
                schedule[i] = 'C';
            }
            else if (freeTimeJ <= sortedTasks[i].start) {
                freeTimeJ = sortedTasks[i].end;
                schedule[i] = 'J';
            }
            else return "IMPOSSIBLE";
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sortedTasks[j].start == tasks[i].start &&
                        sortedTasks[j].end == tasks[i].end) {
                    sb.append(schedule[j]);
                    sortedTasks[j].start = -1;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}