import java.util.Arrays;
import java.util.Scanner;

class Task {
    public int start;
    public int end;
    public int pos;
    public String assignee;

    public Task(int s, int e, int pos){
        this.start = s;
        this.end = e;
        this.pos = pos;
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
                tasks[j] = new Task(sc.nextInt(), sc.nextInt(), j);
            result[i] = distribute(tasks);
        }
        for (int i = 0; i < T; i++)
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
    }

    public String distribute(Task[] tasks) {
        StringBuilder sb = new StringBuilder();
        int n = tasks.length;
        Arrays.sort(tasks, (a, b) -> a.start - b.start);
        int freeTimeC = 0;
        int freeTimeJ = 0;
        for (int i = 0; i < n; i++) {
            if (freeTimeC <= tasks[i].start) {
                freeTimeC = tasks[i].end;
                tasks[i].assignee = "C";
            }
            else if (freeTimeJ <= tasks[i].start) {
                freeTimeJ = tasks[i].end;
                tasks[i].assignee = "J";
            }
            else return "IMPOSSIBLE";
        }
        Arrays.sort(tasks, (a, b) -> a.pos - b.pos);
        for (int i = 0; i < n; i++)
            sb.append(tasks[i].assignee);
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}