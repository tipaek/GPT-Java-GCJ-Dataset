import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		Solution sol = new Solution ();
		int T = Integer.parseInt(in.nextLine());
		
		for (int t=1; t<=T; t++){
			int N = in.nextInt();
			List<Appointment> appts= new LinkedList<Appointment>();
			for (int n = 0; n<N; n++) {
				appts.add(sol.new Appointment(in.nextInt(), in.nextInt()));
			}
			TreeSet<Appointment> cBookings = new TreeSet<Appointment>();
			TreeSet<Appointment> jBookings = new TreeSet<Appointment>();

			boolean b = assignNextAppointment(appts, 0, cBookings, jBookings);
			String s = null ;
			if (b) {
				s = getAssignments(appts);
			} else {
				s = "IMPOSSIBLE";
			}
			
			
			System.out.printf("Case #%d: %s%n", t, s);
		}
	}
	

	private static String getAssignments(List<Appointment> appts) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i<appts.size(); i++) {
			result.append(appts.get(i).assignee);
		}
		return result.toString();
	}


	private static boolean assignNextAppointment(List<Appointment> appts, int i, TreeSet<Appointment> cBookings, TreeSet<Appointment> jBookings) {
		if (i >= appts.size()) {
			return true;
		}
		Appointment appt = appts.get(i);
		//try C
		if (checkAvail(appt, cBookings)) {
			cBookings.add(appt);
			appt.assignee = 'C';
			if (assignNextAppointment(appts, i+1, cBookings, jBookings)){
				return true;
			} else {
				cBookings.remove(appt);
				appt.assignee = 0;
			}
		} 
			
		if (checkAvail(appt, jBookings)) {
			jBookings.add(appt);
			appt.assignee = 'J';
			if (assignNextAppointment(appts, i+1, cBookings, jBookings)){
				return true;
			} else {
				jBookings.remove(appt);
				appt.assignee = 0;
			}
		} 
		
		return false;
		
	}


	private static boolean checkAvail(Appointment appt, TreeSet<Appointment> cBookings) {
		for (Appointment booking : cBookings) {
			if (appt.start >= booking.start && appt.start < booking.end || 
					booking.start >= appt.start && booking.start < appt.end) {
				return false;
			}
			if (booking.start >= appt.end) {
				return true;
			}
		}
		return true;
	}


	class Appointment implements Comparable {
		public Appointment(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		int start;
		int end;
		char assignee;
		@Override
		public int compareTo(Object arg0) {
			Appointment apptArg = (Appointment) arg0;
			if (start < apptArg.start) {
				return -1;
			} else if (start > apptArg.start) {
				return 1;
			} else {
				return 0;
			}
		}
		
	}

}
