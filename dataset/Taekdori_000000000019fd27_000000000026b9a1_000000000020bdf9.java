

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	int testCase;
	List<Time>[] time;
	final static String J= "J";
	final static String C="C";
	final static String CASE_ = "Case #";
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCase = Integer.parseInt(br.readLine());
			time = new ArrayList[testCase+1];
			for (int i=1; i<=testCase;i++) {
				int N = Integer.parseInt(br.readLine());
				time[i] = new ArrayList<>();
				for (int j=1;j<=N;j++) {
					String[] split = br.readLine().split("\\s");
					Time item = new Time(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
					time[i].add(item);
				}
			}
			br.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void solve(int index) {
		boolean CisWorking = false;
		boolean JisWorking = false;
		List<Time> schedule = time[index];
		//Collections.sort(schedule);
		PriorityQueue<Temp> queue = new PriorityQueue<>();
		for (int i=0; i<schedule.size(); i++) {
			Time item = schedule.get(i);
			queue.add(new Temp(item.startTime, "S", i));
			queue.add(new Temp(item.endTime, "E", i));
		}
		
		String solution = null;
		while(!queue.isEmpty()) {
			Temp remove = queue.remove();
			int indexOfSchedule = remove.index; String startOrEnd = remove.startOrEnd;
			
			if (startOrEnd.equals("S")) {
				if (!CisWorking) {
					CisWorking = true;
					schedule.get(indexOfSchedule).name = C;
				} else if (!JisWorking) {
					JisWorking = true;
					schedule.get(indexOfSchedule).name = J;
				} else {
					solution = "IMPOSSIBLE";
					break;
				}
			} else {
				if (schedule.get(indexOfSchedule).name.equals(C)) {
					//C
					CisWorking = false;
				} else {
					//J
					JisWorking = false;
				}
			}
		}
		if (solution == null) {
			StringBuilder builder = new StringBuilder();
			for (Time item : schedule) {
				builder.append(item.toString());
			}
			solution = builder.toString();
		}
		System.out.println(CASE_+index+": "+solution);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.input();
		for (int i=1; i<=s.testCase; i++) {
			s.solve(i);
		}
	}

}

class Temp implements Comparable<Temp> {
	int time;
	String startOrEnd;
	int index;
	
	public Temp(int time, String startOrEnd, int index) {
		this.time = time;
		this.startOrEnd = startOrEnd;
		this.index = index;
	}


	@Override
	public int compareTo(Temp o) {
		// TODO Auto-generated method stub
		if (this.time < o.time) {
			return -1;
		}
		else if (this.time == o.time) {
			return this.startOrEnd.compareTo(o.startOrEnd);
		}
		else {
			return 1;
		}
	}
}

class Time {
	int startTime;
	int endTime;
	String name;
	public Time(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String toString() {
		return name;
	}
	
	
}
