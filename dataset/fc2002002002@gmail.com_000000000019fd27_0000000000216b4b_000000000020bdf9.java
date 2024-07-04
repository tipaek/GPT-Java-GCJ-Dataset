import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = scanner.nextInt();
            List<int[]> list = new LinkedList<>();
            for (int j = 0; j < n; j++) list.add(new int[]{scanner.nextInt(), scanner.nextInt(), j});
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
        Collections.sort(input, (a,b)->a[0]-b[0]);
        char[] re = new char[input.size()];
        for (int i = 0; i < input.size(); i++) re[i] = 'J';
        List<Integer> cc = new LinkedList<>();
        int  end = -1;
        for (int[] e : input) {
            if (end == -1) {
                cc.add(e[2]);
            } if (e[0] < end) continue;
            else {
                end = e[1];
                cc.add(e[2]);
            }
        }
        for (int i : cc) re[i] = 'C';



        return new String(re);
    }

}
