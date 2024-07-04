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
			else if(that.startTime == that.endTime) {
				if(this.startTime == that.startTime) {
					if(that.person.equals("C")) {
						this.person = "C";
					}
					else if(that.person.equals("J")) {
						this.person = "J";
					}
				}
				else {
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
			else if(that.startTime == this.startTime) {
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
			else if(that.endTime == this.endTime) {
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


public class Solution {
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		int t = kboard.nextInt();
		for(int i = 1; i <= t; i += 1) {
			int n = kboard.nextInt();
			ArrayList<Schedule> activities = new ArrayList<Schedule>();
			String answer = "";
			boolean impossible = false;
			for(int j = 0; j < n; j += 1) {
				Schedule next = new Schedule(kboard.nextInt(), kboard.nextInt());
				String result = "";
				if(!impossible) {
					result = next.checkConflict(activities);
				}
				if(result.equals("IMPOSSIBLE")) {
					impossible = true;
				}
				answer += result;
				activities.add(next);
 			}
			if(impossible) {
				answer = "IMPOSSIBLE";
			}
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}