import java.util.ArrayList;
import java.util.Scanner;

class Schedule {
	int startTime;
	int endTime;
	String person;
	
	Schedule(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String checkConflict(ArrayList<Schedule> arr) {
		for(int i = 0; i < arr.size(); i += 1) {
			Schedule that = arr.get(i);
			if(that.startTime < this.startTime && that.endTime > this.startTime) {
				if(that.person.equals("C") && this.person == null) {
					this.person = "J";
				}
				else if(that.person.equals("J") && this.person == null) {
					this.person = "C";
				}
				else if(this.person != null) {
					return "IMPOSSIBLE";
				}
			}
			else if(that.startTime > this.startTime && that.endTime < this.endTime) {
				if(that.person.equals("C") && this.person == null) {
					this.person = "J";
				}
				else if(that.person.equals("J") && this.person == null) {
					this.person = "C";
				}
				else if(this.person != null) {
					return "IMPOSSIBLE";
				}
			}
			else if(that.startTime < this.endTime && that.endTime > this.endTime) {
				if(that.person.equals("C") && this.person == null) {
					this.person = "J";
				}
				else if(that.person.equals("J") && this.person == null) {
					this.person = "C";
				}
				else if(this.person != null) {
					return "IMPOSSIBLE";
				}
			}
		}
		if(this.person == null) {
			this.person = "C";
		}
		return this.person;
	}
}


public class QualificationRoundQuestion3 {
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		int t = kboard.nextInt();
		for(int i = 1; i <= t; i += 1) {
			int n = kboard.nextInt();
			ArrayList<Schedule> activities = new ArrayList<Schedule>();
			String answer = "";
			for(int j = 0; j < n; j += 1) {
				Schedule next = new Schedule(kboard.nextInt(), kboard.nextInt());
				String result = next.checkConflict(activities);
				if(result.equals("IMPOSSIBLE")) {
					answer = "IMPOSSIBLE";
					for(int k = 0; k < n - j - 1; k += 1) {
						kboard.nextInt();
					}
					break;
				}
				answer += result;
				activities.add(next);
 			}
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}
