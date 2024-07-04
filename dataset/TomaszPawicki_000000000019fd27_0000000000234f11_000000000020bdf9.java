import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = s.nextInt();
            List<R> list = new ArrayList<>(2 * n);
            for (int i = 0; i < n; i++) {
                list.add(new R(i, s.nextInt(), 'B'));
                list.add(new R(i, s.nextInt(), 'E'));
            }
            Collections.sort(list);
            int C = -1;
            int J = -1;
            char[] tab = new char[n];
            boolean impossible = false;
            for (R r : list) {
                if (r.type == 'E') {
                    if (C == r.id) {
                        C = -1;
                    } else if (J == r.id) {
                        J = -1;
                    } else {
                        throw new RuntimeException();
                    }
                } else if (r.type == 'B') {
                    if (C >= 0 && J >= 0) {
                        impossible = true;
                        break;
                    } else if (C < 0) {
                        C = r.id;
                        tab[r.id] = 'C';
                    } else if (J < 0) {
                        J = r.id;
                        tab[r.id] = 'J';
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            StringBuilder sb = new StringBuilder();
            if(impossible) {
                sb = new StringBuilder("IMPOSSIBLE");
            } else {
                for (int i = 0; i < tab.length; i++) {
                    sb.append(tab[i]);
                }
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }

    public static class R implements Comparable<R> {
        public int id;
        public int time;
        public char type; //'B', 'E'

        public R(int id, int time, char type) {
            this.id = id;
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(R r) {
            int ret = Integer.valueOf(time).compareTo(r.time);
            if (ret != 0) {
                return ret;
            }
            return -Character.valueOf(type).compareTo(r.type);
        }
    }
}
