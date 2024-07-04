
import java.util.*;

public class Solution {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            ArrayList<Tm> list = new ArrayList<Tm>();
            int n = in.nextInt();
            int[] v = new int[n];
            for (int i = 0; i < v.length; i++) {
                list.add(new Tm(in.nextInt(), in.nextInt(), i));
            }

            Collections.sort(list);

            int last = 0;
            for (int i = 0; i < list.size(); i++) {
                Tm p = list.get(i);
                if (p.x >= last) {
                 
                    p.type = 1;
                    last = p.y;
                }
            }
            last = 0;
            for (int i = 0; i < list.size(); i++) {
                Tm p = list.get(i);
                if (p.type != 1) {
                    if (p.x >= last) {
                        p.type = 2;
                        last = p.y;
                    }
                }
            }
            for (Tm p : list) {
                v[p.idx] = p.type;
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

    public static class Tm implements Comparable<Tm> {

        public int x, y, idx;
        int type = 0;

        public Tm(int a, int b, int x) {
            this.x = a;
            this.y = b;
            this.idx = x;
        }

        @Override
        public int compareTo(Tm t) {
            return this.x - t.x;
        }
    }
}
