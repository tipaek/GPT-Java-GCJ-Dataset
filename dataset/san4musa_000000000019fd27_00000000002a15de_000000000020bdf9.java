import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int caseNo = -1;
	int eachCase = 1;
	String num = null;
	StringBuffer output = new StringBuffer();
	Integer N = null;
	while (sc.hasNext()) {
	    if (caseNo == -1) {
		caseNo = Integer.parseInt(sc.nextLine().trim());
		continue;
	    } else if (N == null) {
		num = sc.nextLine();
		N = Integer.parseInt(num.trim());
	    }
	    List<Time> cTimeList = new ArrayList<>();
	    List<Time> jTimeList = new ArrayList<>();

	    int inputS, inputE;
	    String result = "";
	    boolean dontTakeInput = false;
	    Time time = null;

	    for (int i = 0; i < N; i++) {
		sc.hasNext();
		num = sc.nextLine().trim();
		if (dontTakeInput)
		    continue;
		inputS = Integer.parseInt(num.split(" ")[0]);
		inputE = Integer.parseInt(num.split(" ")[1]);
		time = new Time(inputS, inputE);

		Collections.sort(cTimeList);
		Collections.sort(jTimeList);

		if (isValidAllocation(time, cTimeList)) {
		    result += "C";
		    cTimeList.add(time);
		} else if (isValidAllocation(time, jTimeList)) {
		    result += "J";
		    jTimeList.add(time);
		} else {
		    result = "IMPOSSIBLE";
		    dontTakeInput = true;
		}

	    }
	    output.append("Case #" + eachCase + ": " + result);
	    eachCase++;
	    if (eachCase > caseNo)
		break;
	    output.append("\n");
	    N = null;
	}
	System.out.println(output.toString());
	sc.close();
    }

    private static boolean isValidAllocation(Time time, List<Time> timeList) {
	if (timeList.isEmpty()) {
	    return true;
	}
	if (time.end <= timeList.get(0).start)
	    return true;
	else if (time.start >= timeList.get(timeList.size() - 1).end)
	    return true;
	else {
	    for (Time t : timeList) {
		if (time.start == t.start) {
		    return false;
		} else if (time.start > t.start && time.start < t.end) {
		    return false;
		} else if (time.start < t.start && time.end > t.start) {
		    return false;
		} else if (time.end > t.start && time.end < t.end) {
		    return false;
		} else if (time.end > t.end && time.start < t.start) {
		    return false;
		}
	    }
	    timeList.add(time);
	    Collections.sort(timeList);
	    int index = timeList.indexOf(time);
	    Time prev = null;
	    if (index > 0) {
		prev = timeList.get(index - 1);
	    }
	    Time next = null;
	    if (index < (timeList.size() - 1)) {
		next = timeList.get(index + 1);
	    }
	    timeList.remove(index);
	    if (next != null && prev != null && time.end <= next.start && time.start >= prev.end) {
		return true;
	    }
	}
	return false;
    }

    static class Time implements Comparable<Time> {
	Integer start;
	Integer end;

	Time(int s, int e) {
	    start = s;
	    end = e;
	}

	@Override
	public int compareTo(Time o) {
	    if (this.start > o.start)
		return 1;
	    else if (this.start < o.start)
		return -1;
	    else if (this.end > o.end)
		return 1;
	    else if (this.end < o.end)
		return -1;
	    return 0;
	}

	@Override
	public String toString() {
	    return "Start=" + start + " End=" + end;
	}
    }
}
