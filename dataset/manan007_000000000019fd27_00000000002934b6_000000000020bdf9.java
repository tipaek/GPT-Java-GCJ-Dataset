import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int numberOfTestCases = scanner.nextInt();
	ArrayList<String> answers = new ArrayList<String>();
	for (int i = 1; i <= numberOfTestCases; i++) {
	    int numberOfActivities = scanner.nextInt();
	    ArrayList<Scheduler> schedulers = new ArrayList<>(numberOfActivities);
	    for (int activityNum = 0; activityNum < numberOfActivities; activityNum++) {
		int startTime = scanner.nextInt();
		int endTime = scanner.nextInt();
		if (startTime > endTime || startTime == endTime || startTime < 0 || endTime > (24 * 60)) {
		    schedulers = null;
		}
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
		    if (!isCBusy) {
			newSchedule.assignTask("C");
		    } else if (!isJBusy) {
			newSchedule.assignTask("J");
		    }
		    if (schedulers != null)
			schedulers.add(newSchedule);
		}
	    }
	    String ans = "Case #" + i + ": ";
	    // System.out.print("Case #" + i + ": ");
	    if (schedulers == null) {
		ans += "IMPOSSIBLE";
	    } else {
		for (Scheduler scheduler : schedulers) {
		    ans += scheduler.assignedTo;
		}
	    }
	    answers.add(ans);
	}
	for (int i = 0; i < answers.size(); i++) {
	    if (i == answers.size() - 1) {
		System.out.print(answers.get(i));
	    } else {
		System.out.println(answers.get(i));
	    }
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

	if ((Math.max(0,
		Math.min(this.endTime, scheduler.endTime) - Math.max(this.startTime, scheduler.startTime))) > 0) {
	    return true;
	}
	return false;
    }
}