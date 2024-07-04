import java.util.*;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            Queue<Job> queue = new PriorityQueue<>(Comparator.comparingInt(Job::getStart));
            List<Job> list = new ArrayList<>();

            int N = in.nextInt();
            for (int i = 0; i < N; i++) {
                queue.add(new Job(in.nextInt(), in.nextInt(), i));
            }
            int c = -1;
            int j = -1;
            boolean impossible = false;
            while (!queue.isEmpty()) {
                Job job = queue.remove();
                if (job.getStart() >= c) {
                    c = job.getEnd();
                    job.setC('C');
                } else if (job.getStart() >= j) {
                    j = job.getEnd();
                    job.setC('J');
                } else {
                    impossible = true;
                    break;
                }
                list.add(job);
            }
            String res = impossible ? "IMPOSSIBLE" : getRes(list);
            System.out.println(String.format("Case #%d: %s", t, res));
        }
    }

    public static String getRes(List<Job> list) {
        list.sort(Comparator.comparingInt(Job::getOrderNo));
        StringBuilder stringBuilder = new StringBuilder();
        list.stream().forEach((x) -> stringBuilder.append(x.getC()));
        return stringBuilder.toString();
    }

    static class Job {
        int orderNo;
        char c;
        private final int start;
        private final int end;

        public Job(int start, int end, int orderNo) {
            this.start = start;
            this.end = end;
            this.orderNo = orderNo;
        }

        public int getDiff() {
            return end - start;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getOrderNo() {
            return orderNo;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }
    }
}
