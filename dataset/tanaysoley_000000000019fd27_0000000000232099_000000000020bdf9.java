import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCases; tc++) {
			int tasks = Integer.parseInt(br.readLine());
			List<Time> times = new LinkedList<>();
			List<Task> taskList = new LinkedList<>();
			for (int task = 0; task < tasks; task++) {
				List<Integer> se = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
				Task t = new Task(se.get(0), se.get(1));
				times.add(t.start);
				times.add(t.end);
				taskList.add(t);
			}

			times.sort((a, b) -> {
				if (a.time != b.time) {
					return a.time - b.time;
				} else {
					return a.tick - b.tick;
				}
			});

//			times.forEach(System.out::println);
			Deque<String> workers = new ArrayDeque<>();
			workers.push("C");
			workers.push("J");
			boolean impossible = false;
			for (Time time : times) {
				if (time.tick == 1 && workers.isEmpty()) {
					impossible = true;
					break;
				} else if (time.tick == 1 && !workers.isEmpty()) {
					time.task.worker = workers.pop();
				} else if (time.tick == -1) {
					workers.push(time.task.worker);
				}
			}

			String answer = "";
			if(impossible) {
				answer = "IMPOSSIBLE";
			}else{
				taskList.sort(Comparator.comparingInt(t -> t.index));
				answer = taskList.stream().sorted(Comparator.comparingInt(t -> t.index)).map(Task::toString).reduce((a,b) -> a+b).get();
			}
			System.out.println("Case #" + tc + ": " + answer);
		}
	}
}

class Task {
	private static int count = 0;

	public Task(int start, int end) {
		this.start = new Time(start, this, 1);
		this.end = new Time(end, this, -1);
		this.index = count;
		count++;
	}

	Time start;
	Time end;
	String worker;
	int index;

	@Override
	public String toString() {
		return worker;
	}
}

class Time {
	public Time(int time, Task task, int tick) {
		this.tick = tick;
		this.time = time;
		this.task = task;
	}

	@Override
	public String toString() {
		String type;
		if (tick == 1) {
			type = "start";
		} else {
			type = "end";
		}

		return type + "[" + time + "]";
	}

	int tick;
	int time;
	Task task;
}