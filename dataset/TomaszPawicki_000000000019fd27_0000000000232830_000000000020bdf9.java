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
            int c = -1;
            int j = -1;
            StringBuilder sb = new StringBuilder();
            for (R r : list) {
                if(r.type == 'E') {
                    if(c == r.id) {
                        c = -1;
                    } else if(j == r.id) {
                        j = -1;
                    } else {
                        throw new RuntimeException();
                    }
                } else if(r.type == 'B') {
                    if(c >= 0 && j >= 0) {
                        sb = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else if(c < 0) {
                        c = r.id;
                        sb.append("C");
                    } else if(j < 0) {
                        j = r.id;
                        sb.append("J");
                    }
                } else {
                    throw new RuntimeException();
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
