import java.util.*;

class Interval {
    private int start;
    private int end;

    public Interval() {
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
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            List<Interval> intervals = new ArrayList<>();
            Map<String, String> actualOrder = new LinkedHashMap<>();
            int N = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < N; j++) {
                String[] input = scanner.nextLine().split(" ");
                Interval interval = new Interval();
                interval.setStart(Integer.parseInt(input[0]));
                interval.setEnd(Integer.parseInt(input[1]));
                intervals.add(interval);
                actualOrder.put(input[0] + input[1], input[1]);
            }

            int cs = -1, ce = -1, js = -1, je = -1;
            String result = "";

            intervals.sort(Comparator.comparingInt(Interval::getStart));

            for (Interval interval : intervals) {
                if (cs == -1 || interval.getStart() >= ce) {
                    cs = interval.getStart();
                    ce = interval.getEnd();
                    actualOrder.put(cs + "" + ce, "C");
                } else if (js == -1 || interval.getStart() >= je) {
                    js = interval.getStart();
                    je = interval.getEnd();
                    actualOrder.put(js + "" + je, "J");
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                StringBuilder sb = new StringBuilder();
                for (String key : actualOrder.keySet()) {
                    sb.append(actualOrder.get(key));
                }
                result = sb.toString();
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }
}