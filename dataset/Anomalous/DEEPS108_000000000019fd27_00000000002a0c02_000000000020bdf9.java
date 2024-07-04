import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            HashMap<Integer, Minutes> timeMap = new HashMap<>();

            for (int j = 0; j <= 1440; j++) {
                timeMap.put(j, new Minutes());
            }

            for (int j = 0; j < N; j++) {
                startTimes.add(sc.nextInt());
                endTimes.add(sc.nextInt());
            }

            for (int j = 0; j < N; j++) {
                timeMap.get(startTimes.get(j)).getStart().add(j);
                timeMap.get(endTimes.get(j)).getEnd().add(j);
            }

            List<Character> assignments = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                assignments.add('N');
            }

            boolean cAvailable = true, jAvailable = true, conflict = false;

            for (int minute = 0; minute <= 1440; minute++) {
                for (int end : timeMap.get(minute).getEnd()) {
                    if (assignments.get(end) == 'C') {
                        cAvailable = true;
                    } else {
                        jAvailable = true;
                    }
                }
                for (int start : timeMap.get(minute).getStart()) {
                    if (cAvailable) {
                        assignments.set(start, 'C');
                        cAvailable = false;
                    } else if (jAvailable) {
                        assignments.set(start, 'J');
                        jAvailable = false;
                    } else {
                        conflict = true;
                        break;
                    }
                }
                if (conflict) {
                    break;
                }
            }

            if (conflict) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                for (char ch : assignments) {
                    result.append(ch);
                }
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            }
        }
    }
}

class Minutes {

    private List<Integer> start;
    private List<Integer> end;

    public Minutes() {
        this.start = new ArrayList<>();
        this.end = new ArrayList<>();
    }

    public List<Integer> getStart() {
        return start;
    }

    public List<Integer> getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Minutes [start=" + start + ", end=" + end + "]";
    }
}