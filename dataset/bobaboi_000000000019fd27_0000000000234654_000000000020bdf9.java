import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int caseCount = 1;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        for (int i = 0; i < count; i++) {
            solve(scan);
        }
    }
    public static void solve(Scanner scan) {
        int activities = scan.nextInt();
        List<Event> eventList = new ArrayList<>();
        List<Character> result = new LinkedList<>();

        int cameronLast = Integer.MIN_VALUE;
        int jaimeLast = Integer.MIN_VALUE;

        for (int i = 0; i < activities; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            eventList.add(new Event(start, end));
        }

        for (int i = 0; i < eventList.size(); i++) {
            if (cameronLast <= eventList.get(i).start) {
                cameronLast = eventList.get(i).end;
                result.add('C');
            } else if (jaimeLast <= eventList.get(i).start) {
                jaimeLast = eventList.get(i).end;
                result.add('J');
            } else {
                // kill the list bois
                result.clear();
                break;
            }
        }
        if (result.isEmpty()) {
            System.out.println("Case #" + caseCount + ": IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : result) {
                sb.append(c);
            }
            System.out.println("Case #" + caseCount + ": " + sb.toString());
        }
        caseCount++;
    }

    static class Event{
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
