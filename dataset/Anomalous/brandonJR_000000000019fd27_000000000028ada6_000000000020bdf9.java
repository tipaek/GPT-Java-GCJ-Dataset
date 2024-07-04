import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int numAppointments = scanner.nextInt();
            List<Appointment> appointments = new ArrayList<>();

            for (int n = 0; n < numAppointments; n++) {
                appointments.add(solution.new Appointment(scanner.nextInt(), scanner.nextInt()));
            }

            TreeSet<Appointment> cBookings = new TreeSet<>();
            TreeSet<Appointment> jBookings = new TreeSet<>();

            boolean isPossible = assignAppointments(appointments, 0, cBookings, jBookings);
            String result = isPossible ? getAssignments(appointments) : "IMPOSSIBLE";

            System.out.printf("Case #%d: %s%n", t, result);
        }
    }

    private static String getAssignments(List<Appointment> appointments) {
        StringBuilder assignments = new StringBuilder();
        for (Appointment appointment : appointments) {
            assignments.append(appointment.assignee);
        }
        return assignments.toString();
    }

    private static boolean assignAppointments(List<Appointment> appointments, int index, TreeSet<Appointment> cBookings, TreeSet<Appointment> jBookings) {
        if (index >= appointments.size()) {
            return true;
        }

        Appointment current = appointments.get(index);

        if (isAvailable(current, cBookings)) {
            cBookings.add(current);
            current.assignee = 'C';
            if (assignAppointments(appointments, index + 1, cBookings, jBookings)) {
                return true;
            }
            cBookings.remove(current);
        }

        if (isAvailable(current, jBookings)) {
            jBookings.add(current);
            current.assignee = 'J';
            if (assignAppointments(appointments, index + 1, cBookings, jBookings)) {
                return true;
            }
            jBookings.remove(current);
        }

        return false;
    }

    private static boolean isAvailable(Appointment appointment, TreeSet<Appointment> bookings) {
        Appointment last = bookings.floor(appointment);
        if (last == null && !bookings.isEmpty()) {
            last = bookings.first();
            return last.start >= appointment.end;
        } else if (last == null) {
            return true;
        }
        return last.end <= appointment.start;
    }

    class Appointment implements Comparable<Appointment> {
        int start;
        int end;
        char assignee;

        public Appointment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Appointment other) {
            return Integer.compare(this.start, other.start);
        }
    }
}