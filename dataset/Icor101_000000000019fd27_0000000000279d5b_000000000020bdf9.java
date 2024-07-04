package CodeJam;

import java.util.*;

public class MinPlatform {
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

        public Task(int start_time, int end_time) {
            this.start_time = start_time;
            this.end_time = end_time;
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
            Map<Integer,Task> map = new HashMap<>();
            int n = sc.nextInt();
            List<Train> list = new ArrayList<>();
            List<Task> tasks = new ArrayList<>();
            //long arrival = 0, depart = 0;
            int a = -1, d = -1,count=0;
            for (int i = 0; i < 2 * n; i++) {
                if (i % 2 == 0) {
                    a = sc.nextInt();
                    list.add(new Train(a, 'a'));
                } else {
                    d = sc.nextInt();
                    list.add(new Train(d, 'd'));
                    Task dummy_task = new Task(a, d);
                    tasks.add(dummy_task);
                    map.put(count,dummy_task);
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
            StringBuilder ans_sch = new StringBuilder(ans_temp);
            char curr = 'C';
            for (int i = 1; i < tasks.size(); i++) {
                if (map.get(i).start_time < map.get(i - 1).end_time) {
                    if (curr == 'C') {
                        ans_sch.append('J');
                        curr = 'J';
                    } else {
                        ans_sch.append('C');
                        curr = 'C';
                    }
                } else
                    ans_sch.append(curr);
            }
            System.out.println("Case #" + (k + 1) + ": " + ans_sch);
        }
    }
}