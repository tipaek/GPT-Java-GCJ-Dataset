import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {

            int size = scanner.nextInt();
            boolean flag = false;
            int[] time = new int[60 * 24 + 1];
            List<int[]> list = new ArrayList<>();
            Map<int[], Character> map = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> p[1] - q[1]);
            for (int j = 0; j < size; j++) {
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                int[] temp = new int[2];
                temp[0] = left;
                temp[1] = right;
                list.add(temp);
                pq.add(temp);
                for (int p = left + 1; p <= right; p++) {
                    time[p]++;
                }
            }

            for (int n : time) {
                if (n > 2) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                String output = "";
                int[] prev = pq.remove();

                map.put(prev, 'C');
                while (!pq.isEmpty()) {
                    int[] now = pq.remove();
                    if (prev[1] <= now[0]) {
                        map.put(now, map.get(prev));
                    } else {
                        map.put(now, (map.get(prev) == 'C') ? 'J' : 'C');
                    }
                    prev = now;
                }
                for (int[] item : list) {
                    output += map.get(item);
                }

                System.out.println("Case #" + i + ": "  + output);
            }
        }
    }
}

