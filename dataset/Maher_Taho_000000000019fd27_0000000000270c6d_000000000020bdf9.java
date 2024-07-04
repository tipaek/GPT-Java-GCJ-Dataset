
import java.util.*;

public class Solution {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            ArrayList<Pair> list = new ArrayList<Pair>();
            int n = in.nextInt();

            int[] v = new int[n];
            while (n-- > 0) {
                list.add(new Pair(in.nextInt(), in.nextInt()));
            }
            Collections.sort(list);
            int last = 0;
            for (int i = 0; i < list.size(); i++) {
                Pair p = list.get(i);
                if (p.x >= last) {
                    v[i] = 1;
                    last = p.y;
                }
            }
            last = 0;
            for (int i = 0; i < list.size(); i++) {
                Pair p = list.get(i);
                if (v[i] != 1) {
                    if (p.x >= last) {
                        v[i] = 2;
                        last = p.y;
                    }
                }
            }
            StringBuilder build = new StringBuilder();
            boolean flg = true;
            for (int i = 0; i < v.length; i++) {
                if (v[i] == 0) {
                    flg = false;
                    break;
                } else {
                    if (v[i] == 1) {
                        build.append("C");
                    } else {
                        build.append("J");
                    }
                }
            }
            if (flg) {
                System.out.println("Case #" + t + ": " + build.toString());

            } else {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }
        }
    }

    public static class Pair implements Comparable<Pair> {

        public int x, y;

        public Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }

        @Override
        public int compareTo(Pair t) {
            return this.x - t.x;
        }
    }
}
