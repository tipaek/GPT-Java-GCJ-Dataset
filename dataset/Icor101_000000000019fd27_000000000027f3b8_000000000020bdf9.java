

import java.util.*;

public class Solution {
    static class Train implements Comparable<Train> {
        int time;
        char type;

        public Train(int time, char type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Train o) {
            return Integer.compare(this.time, o.time);
        }

        @Override
        public String toString() {
            return "Train{" +
                    "time=" + time +
                    ", type=" + type +
                    '}';
        }
    }

    static class Task implements Comparable<Task> {
        int start_time;
        int end_time;
        char doer;
        int idx;

        public Task(int start_time, int end_time, int idx) {
            this.start_time = start_time;
            this.end_time = end_time;
            this.idx = idx;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(this.start_time, o.start_time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        label:
        for (int k = 0; k < t; k++) {
            Map<Integer, Task> map = new HashMap<>();
            int n = sc.nextInt();
            List<Train> list = new ArrayList<>();
            List<Task> tasks = new ArrayList<>();
            int a = -1, d = -1, count = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (i % 2 == 0) {
                    a = sc.nextInt();
                    list.add(new Train(a, 'a'));
                } else {
                    d = sc.nextInt();
                    list.add(new Train(d, 'd'));
                    Task dummy_task = new Task(a, d, count);
                    tasks.add(dummy_task);
                    map.put(count, dummy_task);
                    count++;
                }
            }
            Collections.sort(list);
            int temp = 0, ans = Integer.MIN_VALUE;
            for (Train train : list) {
                if (train.type == 'a')
                    temp++;
                else
                    temp--;
                ans = Math.max(ans, temp);
                if (ans > 2) {
                    System.out.println("Case #" + (k + 1) + ": IMPOSSIBLE");
                    continue label;
                }
            }
            Collections.sort(tasks);
            String ans_temp = "C";
            //StringBuilder ans_sch = new StringBuilder(ans_temp);
            char curr = 'C';
            tasks.get(0).doer = curr;
            for (int i = 1; i < tasks.size(); i++) {
                if (tasks.get(i).start_time < tasks.get(i - 1).end_time) {
                    if (curr == 'C') {
                        //ans_sch.append('J');
                        curr = 'J';
                    } else {
                        //ans_sch.append('C');
                        curr = 'C';
                    }
                }
                tasks.get(i).doer = curr;
            }
            char[] ans_sch = new char[tasks.size()];
            ans_sch[0] = 'C';
            for (Task task : tasks) {
                ans_sch[task.idx] = task.doer;
            }
            String final_ans= new String(ans_sch);
            System.out.println("Case #" + (k + 1) + ": " + final_ans);
        }
    }
}