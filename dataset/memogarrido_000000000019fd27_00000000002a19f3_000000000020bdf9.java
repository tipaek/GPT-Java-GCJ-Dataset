
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static class Appointment {
        public int start;
        public int end;

        public Appointment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Appointment> comparator = new Comparator<Appointment>() {
            @Override
            public int compare(Appointment appointment, Appointment appointment2) {
                return appointment.start - appointment2.end;
            }
        };
        int testCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int activities = scanner.nextInt();
            PriorityQueue<Appointment> jamie = new PriorityQueue<>(comparator);
            PriorityQueue<Appointment> cameron = new PriorityQueue<>(comparator);
            StringBuilder schedule = new StringBuilder();
            for (int activityIndex = 0; activityIndex < activities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean jamieIsAvailable = true;
                boolean cameronIsAvailable = true;
                for (Appointment appointment : jamie) {
                    if ((start >= appointment.start && start < appointment.end)||(end >= appointment.start && end < appointment.end))
                        jamieIsAvailable = false;
                }
                for (Appointment appointment : cameron) {
                    if ((start >= appointment.start && start < appointment.end)||(end >= appointment.start && end < appointment.end))
                        cameronIsAvailable = false;
                }
                if (cameronIsAvailable) {
                    cameron.add(new Appointment(start, end));
                    schedule.append("C");
                } else if (jamieIsAvailable) {
                    jamie.add(new Appointment(start, end));
                    schedule.append("J");
                } else schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println(String.format("Case #%s: %s", caseIndex, schedule.toString()));
        }
    }

}