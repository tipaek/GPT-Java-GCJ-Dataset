import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = scanner.nextInt();
            List<int[]> list = new LinkedList<>();
            for (int j = 0; j < n; j++) list.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            String re = get(list);
            System.out.println("Case #"+(i+1) +": " + re);
        }
    }
    private static String get(List<int[]> input) {
        PriorityQueue<Integer> in = new PriorityQueue<>();
        PriorityQueue<Integer> out = new PriorityQueue<>();
        for (int[] x : input) {
            in.offer(x[0]);
            out.offer(x[1]);
        }
        int now = 0;
        while (!in.isEmpty()) {
            if (in.peek() < out.peek()) {
                now++;
                in.poll();
            } else {
                now--;
                out.poll();
            }
            if (now > 2) return "IMPOSSIBLE";
        }

        StringBuilder sb = new StringBuilder();
        int start = -1, end = -1;
        char c = 'C';
        for (int[] e : input) {
            if (start == -1) {
                start = e[0];
                end = e[1];
                sb.append(c);
            } else if (e[0] < end) {
                end = e[1];
                c = c=='C'? 'J':'C';
                sb.append(c);
            } else {
                end = e[1];
                sb.append(c);
            }
        }



        return sb.toString();
    }

}
