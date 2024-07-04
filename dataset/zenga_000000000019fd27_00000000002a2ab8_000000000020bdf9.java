import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Task {
        int s, e;

        public Task(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            boolean[] cameron = new boolean[24 * 60 + 1];
            boolean[] jamie = new boolean[24 * 60 + 1];

            List<Task> tasks = new ArrayList<>();
            Map<Task, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                Task task = new Task(s, e);
                tasks.add(task);
                map.put(task, i);
            }


            Collections.sort(tasks, new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    return o1.s - o2.s;
                }
            });


            char result[] = new char[n];
            for (Task currTask : tasks) {
                int s = currTask.s;
                int e =currTask.e;

                if (isFree(cameron, s, e)) {
                    result[map.get(currTask)] = 'C';
                    fillTask(cameron, s, e);
                } else if (isFree(jamie, s, e)) {
                    result[map.get(currTask)] = 'J';
                    fillTask(jamie, s, e);
                } else {
                    result[0] = 'x';
                    break;
                }
            }

            if (result[0] == 'x') {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.printf("Case #%d: %s\n", t, new String(result));
            }

        }
    }

    static boolean isFree(boolean[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            if (arr[i]) {
                return false;
            }
        }
        return true;
    }

    static void fillTask(boolean[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            arr[i] = true;
        }
    }
}
