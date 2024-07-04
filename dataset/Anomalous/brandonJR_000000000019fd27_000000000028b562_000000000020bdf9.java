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
            String result = isPossible ? getAssignmentString(appointments) : "IMPOSSIBLE";

            System.out.printf("Case #%d: %s%n", t, result);
        }
    }

    private static String getAssignmentString(List<Appointment> appointments) {
        StringBuilder result = new StringBuilder();
        for (Appointment appointment : appointments) {
            result.append(appointment.assignee);
        }
        return result.toString();
    }

    private static boolean assignAppointments(List<Appointment> appointments, int index, TreeSet<Appointment> cBookings, TreeSet<Appointment> jBookings) {
        if (index >= appointments.size()) {
            return true;
        }
        Appointment appointment = appointments.get(index);

        if (isAvailable(appointment, cBookings)) {
            cBookings.add(appointment);
            appointment.assignee = 'C';
            if (assignAppointments(appointments, index + 1, cBookings, jBookings)) {
                return true;
            } else {
                cBookings.remove(appointment);
                appointment.assignee = 0;
            }
        }

        if (isAvailable(appointment, jBookings)) {
            jBookings.add(appointment);
            appointment.assignee = 'J';
            if (assignAppointments(appointments, index + 1, cBookings, jBookings)) {
                return true;
            } else {
                jBookings.remove(appointment);
                appointment.assignee = 0;
            }
        }

        return false;
    }

    private static boolean isAvailable(Appointment appointment, TreeSet<Appointment> bookings) {
        Appointment last = bookings.floor(appointment);
        if (last == null) {
            return bookings.isEmpty() || bookings.first().start >= appointment.end;
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
            this.assignee = 0;
        }

        @Override
        public int compareTo(Appointment other) {
            return Integer.compare(this.start, other.start);
        }
    }
}