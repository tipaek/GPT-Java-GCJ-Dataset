import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int numberOfTestCases = scanner.nextInt();
	for (int i = 1; i <= numberOfTestCases; i++) {
	    int numberOfActivities = scanner.nextInt();
	    ArrayList<Scheduler> schedulers = new ArrayList<>(numberOfActivities);
	    for (int activityNum = 0; activityNum < numberOfActivities; activityNum++) {
		int startTime = scanner.nextInt();
		int endTime = scanner.nextInt();
		Scheduler newSchedule = new Scheduler(startTime, endTime);
		boolean isJBusy = false;
		boolean isCBusy = false;
		if (schedulers != null) {
		    for (Scheduler scheduler : schedulers) {
			boolean overlap = scheduler.doesScheduleOverlap(newSchedule);
			if (overlap) {
			    if (scheduler.assignedTo == "J") {
				isJBusy = true;
			    } else if (scheduler.assignedTo == "C") {
				isCBusy = true;
			    }
			}
			if (isCBusy && isJBusy) {
			    schedulers = null;
			    break;
			}
		    }
		    if (!isJBusy) {
			newSchedule.assignTask("J");
		    } else if (!isCBusy) {
			newSchedule.assignTask("C");
		    }
		    if (schedulers != null)
			schedulers.add(newSchedule);
		}
	    }
	    System.out.print("Case #" + i + ": ");
	    if (schedulers == null) {
		System.out.print("IMPOSSIBLE");
	    } else {
		for (Scheduler scheduler : schedulers) {
		    System.out.print(scheduler.assignedTo);
		}
	    }
	    System.out.println();
	}
    }
}

class Scheduler {
    int startTime;
    int endTime;
    String assignedTo;

    public Scheduler(int startTime, int endTime) {
	this.startTime = startTime;
	this.endTime = endTime;
    }

    public void assignTask(String person) {
	this.assignedTo = person;
    }

    public boolean doesScheduleOverlap(Scheduler scheduler) {
	if (this.startTime < scheduler.endTime || scheduler.startTime < this.endTime) {
	    return true;
	}
	return false;
    }
}