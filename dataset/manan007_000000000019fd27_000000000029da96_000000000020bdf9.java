import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		schedulers.add(new Scheduler(startTime, endTime));
	    }
	    Collections.sort(schedulers, new SchedulerCoparator());
	    boolean isNotPossible = false;
	    String answer = "Case #" + i + ": ";
	    for (Scheduler scheduler : schedulers) {
		boolean isJBusy = false;
		boolean isCBusy = false;
		for (Scheduler s : schedulers) {
		    boolean overlap = s.doesScheduleOverlap(scheduler);
		    if (overlap && s.assignedTo == "J") {
			isJBusy = true;
		    } else if (overlap && s.assignedTo == "C") {
			isCBusy = true;
		    }
		    if (isCBusy && isJBusy) {
			answer = "Case #" + i + ": IMPOSSIBLE";
			isNotPossible = true;
			break;
		    }
		}
		if (isNotPossible) {
		    break;
		}
		if (!isJBusy) {
		    scheduler.assignTask("J");
		    answer += "J";
		} else if (!isCBusy) {
		    scheduler.assignTask("C");
		    answer += "C";
		}
	    }
	    System.out.println(answer);
	}
//	for (int i = 0; i < answers.size(); i++) {
//	    if (i == answers.size() - 1) {
//		System.out.print(answers.get(i));
//	    } else {
//		System.out.println(answers.get(i));
//	    }
//	}
    }
}

class SchedulerCoparator implements Comparator<Scheduler> {
    @Override
    public int compare(Scheduler s1, Scheduler s2) {
	return s1.getStartTime() - s2.getStartTime();
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

    public int getStartTime() {
	return this.startTime;
    }

    public void assignTask(String person) {
	this.assignedTo = person;
    }

    public boolean doesScheduleOverlap(Scheduler scheduler) {
	if (this.startTime < scheduler.endTime && scheduler.startTime < this.endTime) {
	    return true;
	}
	return false;
    }
}