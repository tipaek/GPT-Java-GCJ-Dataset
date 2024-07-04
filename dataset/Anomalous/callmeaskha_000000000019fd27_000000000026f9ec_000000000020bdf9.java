import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        int testCases = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(reader.nextLine());
            List<Interval> intervals = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                String[] times = reader.nextLine().split(" ");
                int leftTime = Integer.parseInt(times[0]);
                int rightTime = Integer.parseInt(times[1]);
                intervals.add(new Interval(leftTime, rightTime));
            }

            intervals.sort(new IntervalComparator());

            boolean impossible = false;
            Stack<Interval> stack = new Stack<>(intervals);
            Map<String, Interval> assignments = new HashMap<>();
            List<Interval> originalOrder = new ArrayList<>(intervals);

            while (!stack.isEmpty()) {
                Interval current = stack.pop();

                if (!assignments.containsKey("C")) {
                    current.who = "C";
                    assignments.put("C", current);
                } else if (!assignments.containsKey("J")) {
                    current.who = "J";
                    assignments.put("J", current);
                } else {
                    Interval lastC = assignments.get("C");
                    Interval lastJ = assignments.get("J");

                    if (lastC.rightTime > current.leftTime && lastJ.rightTime > current.leftTime) {
                        impossible = true;
                        break;
                    } else if (lastC.rightTime <= current.leftTime) {
                        current.who = "C";
                        assignments.put("C", current);
                    } else {
                        current.who = "J";
                        assignments.put("J", current);
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (i + 1) + ": ");
                for (Interval interval : originalOrder) {
                    System.out.print(interval.who);
                }
                System.out.println();
            }
        }
    }
}

class Interval {
    public int leftTime;
    public int rightTime;
    public String who;

    public Interval(int leftTime, int rightTime) {
        this.leftTime = leftTime;
        this.rightTime = rightTime;
        this.who = "";
    }

    @Override
    public String toString() {
        return "Interval{" +
                "leftTime=" + leftTime +
                ", rightTime=" + rightTime +
                ", who='" + who + '\'' +
                '}';
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
        if (i1.leftTime != i2.leftTime) {
            return Integer.compare(i1.leftTime, i2.leftTime);
        }
        return Integer.compare(i1.rightTime, i2.rightTime);
    }
}