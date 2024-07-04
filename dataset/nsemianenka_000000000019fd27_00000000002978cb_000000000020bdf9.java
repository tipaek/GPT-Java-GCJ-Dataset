import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = in.nextInt();
        for (int t = 1; t <= tc; ++t) {
            int n = in.nextInt();

            List<TPoint> arrp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();

                TPoint startPoint = new TPoint();
                startPoint.setTime(start);
                startPoint.setState(1);
                startPoint.setIndex(i);
                TPoint endPoint = new TPoint();
                endPoint.setTime(end);
                endPoint.setState(-1);
                endPoint.setIndex(i);

                arrp.add(startPoint);
                arrp.add(endPoint);
            }

            Collections.sort(arrp);

            int maxOverlap = 0;
            int currentOverlap = 0;

            int cCurr = -1;
            int jCurr = -1;

            boolean possible = true;

            Map<Integer, String> map = new HashMap<>();

            for (int i = 0; i < arrp.size(); i++) {
                TPoint point = arrp.get(i);
                currentOverlap += point.getState();
                if (maxOverlap < currentOverlap) maxOverlap = currentOverlap;
                if (point.getState() > 0) {
                    if (cCurr < 0) {
                        cCurr = point.getIndex();
                        map.put(point.getIndex(), "C");
                    } else if (jCurr < 0) {
                        jCurr = point.getIndex();
                        map.put(point.getIndex(), "J");
                    } else {
                        possible = false;
                    }
                } else {
                    if (cCurr == point.getIndex()) {
                        cCurr = -1;
                    }
                    if (jCurr == point.getIndex()) {
                        jCurr = -1;
                    }
                }
            }

            if (possible) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i ++) {
                    sb.append(map.get(i));
                }
                System.out.println(String.format("Case #%s: %s ", t, sb.toString()));
            } else {
                System.out.println(String.format("Case #%s: %s ", t, "IMPOSSIBLE"));
            }

        }
    }

    public static class TPoint implements Comparable<TPoint> {
        private Integer time;
        private Integer state;
        private Integer index;

        @Override
        public int compareTo(TPoint o) {
            int comp = time.compareTo(o.getTime());
            if (comp == 0) {
                return state.compareTo(o.getState());
            }
            return comp;
        }

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "TPoint{" +
                    "time=" + time +
                    ", state=" + state +
                    ", index=" + index +
                    '}';
        }
    }

}
