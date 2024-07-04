import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {

            int size = scanner.nextInt();
            String output = "";
            List<int[]> list = new ArrayList<>();
            Map<int[], Character> map = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> p[1] - q[1]);
            PriorityQueue<int[]> pq1 = new PriorityQueue<>((p, q) -> p[1] - q[1]);
            boolean flag = false;

            for (int j = 0; j < size; j++) {
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                int[] temp = new int[2];
                temp[0] = left;
                temp[1] = right;
                list.add(temp);
            }

            for (int[] item : list) {
                int[] temp = new int[2];
                temp[0] = item[0];
                temp[1] = item[1];
                pq.add(temp);
                pq1.add(item);
            }

            int[] prev = pq.remove();
            int overLap = 1;
            while (!pq.isEmpty() && !flag) {
                int[] now = pq.remove();
                if (prev[1] <= now[0]) {
                    overLap = 1;
                    prev = now;
                } else {
                    overLap++;
                    prev[0] = Math.max(prev[0], now[0]);
                    prev[1] = Math.min(prev[1], now[1]);
                }

                flag = overLap > 2;
            }

            if (flag) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {

                int[] pre = pq1.remove();
                map.put(pre, 'C');
                while (!pq1.isEmpty()) {

                    int[] now = pq1.remove();
                    if (pre[1] <= now[0]) {
                        map.put(now, map.get(pre));
                    } else {
                        map.put(now, (map.get(pre) == 'C')? 'J' : 'C');
                    }
                    pre = now;
                }

                for (int[] item : list) {
                    output += map.get(item);
                }

                System.out.println("Case #" + i + ": "  + output);
            }
        }

    }



}
