import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int f = 0;
        while (f++ < t) {
            long x = scan.nextLong();
            long y = scan.nextLong();
            Queue<Pair> pos = new LinkedList<>();
            String result = "IMPOSSIBLE";
            pos.add(new Pair(new long[]{0, 0}, ""));
            while (!pos.isEmpty()) {
                Pair poll = pos.poll();
                long[] v = poll.p;
                if (v[0] == x && v[1] == y) {
                    result = poll.v;
                    break;
                }
                if(v[0] > x || v[1] > y){
                    continue;
                }
                String pp = poll.v;
                long size = Math.round(Math.pow(2, pp.length()));
                pos.add(new Pair(new long[]{v[0] + size, v[1]}, pp + "E"));
                pos.add(new Pair(new long[]{v[0] - size, v[1]}, pp + "W"));
                pos.add(new Pair(new long[]{v[0], v[1] + size}, pp + "N"));
                pos.add(new Pair(new long[]{v[0], v[1] - size}, pp + "S"));
            }
            System.out.println("Case #" + f + ": " + result);
        }
    }

    static class Pair {
        long[] p;
        String v;

        public Pair(long[] p, String v) {
            this.p = p;
            this.v = v;
        }
    }
}