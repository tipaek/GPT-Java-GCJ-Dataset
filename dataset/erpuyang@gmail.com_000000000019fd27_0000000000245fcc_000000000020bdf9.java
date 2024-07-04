
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            inputs.add(line);
        }

        if (inputs.size() == 0) {
            return;
        }

        int caseCnt = Integer.parseInt(inputs.get(0).trim());

        for (int i = 1, index = 1; i <= caseCnt; i++) {
            int intervalCnt = Integer.parseInt(inputs.get(index).trim());

            List<Interval> intervals = new ArrayList<>(intervalCnt);

            for (int j = 0; j < intervalCnt; j++) {
                String str = inputs.get(index + j + 1);
                String[] strArr = str.split("\\s+");
                intervals.add(new Interval(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1])));
            }

            String result = assign(intervals);
            System.out.println(String.format("Case #%d: %s", i, result));
            index += intervalCnt + 1;
        }
    }

    private static String assign(List<Interval> intervals) {
        // C J
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval arg0, Interval arg1) {
                if (arg0.start > arg1.start) {
                    return 1;
                } else if (arg0.start < arg1.start) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        Map<Character, Interval> map = new HashMap<>();
        map.put('C', null);
        map.put('J', null);
        for (Interval interval : intervals) {
            if (map.get('C') != null && interval.start >= map.get('C').end) {
                sb.append('C');
                map.put('C', null);
            }
            if (map.get('J') != null && interval.start >= map.get('J').end) {
                sb.append('J');
                map.put('J', null);
            }
            if (map.get('C') != null && map.get('J') != null) {
                // impossible
                return "IMPOSSIBLE";
            }

            char assign = 'C';
            if (map.get('C') != null) {
                assign = 'J';
            }
            map.put(assign, interval);
        }

        sb.append(map.get('C') != null ? 'C' : "").append(map.get('J') != null ? "J" : "");

        return sb.toString();
    }

    private static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}


