import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static class Activity {
        private int start;
        private int stop;
        private int length;
        private int index;
        private String result;

        public Activity(int start, int stop, int index) {
            this.start = start;
            this.stop = stop;
            this.length = stop - start;
            this.index = index;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public int getLength() {
            return length;
        }

        public int getIndex() {
            return index;
        }

        public int getStop() {
            return stop;
        }

        public int getStart() {
            return start;
        }

        public String getResult() {
            return result;
        }
    }

    static class ActivitySorter implements Comparator<Activity> {

        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.start - o2.start;
        }
    }

    static class ActivitySorterByIndex implements Comparator<Activity> {

        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.index - o2.index;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            List<Activity> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(new Activity(in.nextInt(), in.nextInt(), j));
            }

            String output = parenting(list);

            System.out.println("Case #" + i + ": " + output);

        }
    }

    static String parenting(List<Activity> list) {

        list.sort(new ActivitySorter());

        int cFinish = 0;
        int jFinish = 0;

        for (Activity a : list) {
            if (cFinish <= a.getStart()) {
                a.setResult("C");
                cFinish = a.getStop();
            } else if (jFinish <= a.getStart()) {
                a.setResult("J");
                jFinish = a.getStop();
            } else {
                return "IMPOSSIBLE";
            }
        }

        list.sort(new ActivitySorterByIndex());

        return list.stream().map(Activity::getResult).collect(Collectors.joining(""));


    }

}
