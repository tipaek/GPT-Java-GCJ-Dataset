
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = sc.nextInt();
		
		for (int i=1; i<=tests; i++) {
			int n = sc.nextInt();
			sc.nextLine(); // sometimes necesary after nextInt to go to next line
			String[] input = new String[n];
			
			for (int j=0;j<n;j++) {
				input[j] = sc.nextLine();
			}
			
			System.out.println(solve(input, i));
		}
	}
	
	public static String solve (String[] input, int index) {
		Timeline timeline = new Timeline();
		for (int i=0;i<input.length;i++) {
			
			String[] se = input[i].split(" ");
			boolean success = timeline.addTask(new Interval (se[0], se[1], i));
			
			if (!success) {
				return "Case #" + index + ": IMPOSSIBLE";
			}
		}
		
		return timeline.result(index);
	}
}

class Timeline {
	List<Interval> kidA = new ArrayList<>();
	List<Interval> kidB = new ArrayList<>();
	
	public boolean addTask (Interval task) {
		boolean interferA = kidA.stream().anyMatch(e-> interference(task, e));
		
		if (interferA) {
			boolean interferB = kidB.stream().anyMatch(e-> interference(task, e));
			task.asignee = "J";
			kidB.add(task);
			return !interferB;
		} else {
			task.asignee = "C";
			kidA.add(task);
			return true;
		}
	}
	
	public boolean interference (Interval task, Interval e) {
		return Math.max(task.start, e.start) < Math.min(task.end, e.end);
	}
	
	public String result (int i) {
		kidA.addAll(kidB);
		kidA.sort((a,b)-> a.c < b.c ? -1 : a.c == b.c ? 0 : 1);
		
		String result = String.join("", kidA.stream().map(e->e.asignee).collect(Collectors.toList()));
		
		return "Case #" + i + ": " + result;
	}
}

class Interval {
	Integer start;
	Integer end;
	String asignee;
	int c;
	
	public Interval (String start, String end, int c) {
		this.start = Integer.parseInt(start);
		this.end = Integer.parseInt(end);
		this.c = c;
	}
}
