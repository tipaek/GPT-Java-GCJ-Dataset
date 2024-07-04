import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        for (int x = 1; x <= t; x++) {

            int n = scan.nextInt();
            scan.nextLine();
            PriorityQueue<Activities> pq = new PriorityQueue<Activities>(n, new Comparator<Activities>() {
                @Override
                public int compare(Activities o1, Activities o2) {
                    if (o1.getStart() == o2.getStart()) {
                        return o1.getEnd() - o2.getEnd();
                    }
                    return o1.getStart() - o2.getStart();
                }
            });
            HashMap<String, Integer> indexes1 = new HashMap<>();
            HashMap<Integer, String> indexes2 = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int temp1 = scan.nextInt();
                int temp2 = scan.nextInt();
                pq.add(new Activities(temp1, temp2));
                indexes1.put(temp1 + " " + temp2, i);
            }

//            while(!pq.isEmpty()){
//                System.out.println(pq.remove());
//            }
//            System.out.println("End--------------------------------");
            boolean cfree = false;
            boolean jfree = false;
            StringBuilder sb = new StringBuilder();
            Activities cActivities = pq.remove();
            int index1 = indexes1.get(cActivities.getStart() + " " + cActivities.getEnd());
            indexes2.put(index1, "C");
            Activities jActivities = pq.remove();
            index1 = indexes1.get(jActivities.getStart() + " " + jActivities.getEnd());
            indexes2.put(index1, "J");
            boolean possible = true;
            while (!pq.isEmpty()) {
                Activities act = pq.remove();
                index1 = indexes1.get(act.getStart() + " " + act.getEnd());
                if (act.getStart() >= cActivities.getEnd()) {
                    indexes2.put(index1, "C");
                    cActivities = act;
                } else if (act.getStart() >= jActivities.getEnd()) {
                    indexes2.put(index1, "J");
                    jActivities = act;
                } else {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                sb = new StringBuilder("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append(indexes2.get(i));
                }
            }
            System.out.println("Case #" + x + ": " + sb.toString());
        }
    }

    public static class Activities {
        private int start;
        private int end;

        public Activities(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "Activities{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
