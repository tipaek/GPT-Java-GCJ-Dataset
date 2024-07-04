import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String[] intervalStr = sc.nextLine().split(" ");
                int[] interval = new int[2];
                interval[0] = Integer.parseInt(intervalStr[0]);
                interval[1] = Integer.parseInt(intervalStr[1]);
                if (listContains(interval, cameron)) {
                    if (listContains(interval, jamie)) {
                        sb.setLength(0);
                        sb.append("IMPOSSIBLE");
                        break;
                    } else {
                        jamie.add(interval);
                        sb.append("J");
                    }
                } else {
                    cameron.add(interval);
                    sb.append("C");
                }
//                cameron.add(interval);
//                if (cameron.size() == cSize) {
//                    jamie.add(interval);
//                    if (jSize == jamie.size()) {
//                        sb.setLength(0);
//                        sb.append("IMPOSSIBLE");
//                        break;
//                    } else {
//                        sb.append("J");
//                    }
//                } else {
//                    sb.append("C");
//                }
            }

            System.out.println("Case #" + k + ": " + sb);
        }
    }

    public static boolean overlaps(int s1, int e1, int s2, int e2) {
        return (e1 > s2) && (s1 < e2);
    }

    public static boolean listContains(int[] interval, List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            if (overlaps(interval[0], interval[1], list.get(i)[0], list.get(i)[1])) {
                return true;
            }
        }

        return false;
    }

//    static class Interval {
//        int start;
//        int end;
//
//        public Interval(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Interval interval = (Interval) o;
//            return overlaps(this, interval);
//        }
//
//        @Override
//        public int hashCode() {
//            return 1;
//        }
//    }
}
