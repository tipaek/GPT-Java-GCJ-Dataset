import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution{
    
    public static String L = "(";
    public static String R = ")";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            List<Task> tasks = makeTasks(n, sc);

            String ans = makeAns(tasks);

            System.out.println(String.format("Case #%s: %s", i, ans));
        }

    }

    private static String makeAns(List<Task> tasks) {
        int c = 0;
        int j = 0;
        List<Result> results = new ArrayList<Result>();
        
        for (Task t: tasks) {
            if (c <= t.start) {
                c = t.end;
                results.add(new Result(t.index, "C"));
                continue;
            }

            if (j <= t.start) {
                j = t.end;
                results.add(new Result(t.index, "J"));
                continue;
            }
            
            return "IMPOSSIBLE";
        }
        results.sort(Comparator.naturalOrder());
        return results.stream().map(r -> r.x).reduce((l, acc) -> l + acc).get();
    }
    

    private static List<Task> makeTasks(int n, Scanner sc) {
        List<Task> tasks = new ArrayList<Task>();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");

            tasks.add(
                new Task(i, 
                    Integer.parseInt(line[0]),
                    Integer.parseInt(line[1])
                    )
                );
        }

        tasks.sort(Comparator.naturalOrder());
        return tasks;
    }

    static class Task implements Comparable<Task>{
        int index;
        int start;
        int end;

        public Task(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task o) {
            return this.start - o.start;
        }
    }

    static class Result implements Comparable<Result>{
        int index;
        String x;

        public Result(int index, String x) {
            this.index = index;
            this.x = x;
        }

        @Override
        public int compareTo(Result o) {
            return this.index - o.index;
        }
    }
}
