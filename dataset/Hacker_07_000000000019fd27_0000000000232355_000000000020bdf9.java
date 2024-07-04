import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\revan\\Desktop\\All Files\\Coding\\Random Code\\CodeChallenges\\src\\CodeJam\\input.txt"));
		int t = Integer.parseInt(reader.readLine());
		for(int idx = 1; idx <= t; idx++) {
			output(idx, solve(reader));
		}

		reader.close();
	}

	private static String solve(BufferedReader reader) throws IOException {
		int n = input(reader).get(0);
		List<Slot> slots = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			List<Integer> slot = input(reader);
			slots.add(new Slot(slot.get(0), slot.get(1), i));
		}

		Slot j = new Slot(0, 0, 0), c = new Slot(0, 0, 0);
		StringBuilder schedule = new StringBuilder();
		slots.sort(Comparator.comparingInt(s -> s.startTime));
		for(Slot slot : slots) {
			if(j.endTime <= slot.startTime) {
				j = slot;
				j.owner = "J";
			} else if(c.endTime <= slot.startTime) {
				c = slot;
				c.owner = "C";
			} else {
				return "IMPOSSIBLE";
			}
		}

		slots.sort(Comparator.comparingInt(s -> s.position));
		for(Slot slot : slots) {
			schedule.append(slot.owner);
		}

		return schedule.toString();
	}

	public static class Slot {
		private int startTime, endTime;
		private int position;
		private String owner;

		public Slot(int startTime, int endTime, int position) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.position = position;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public String getOwner() {
			return owner;
		}

		public void setOwner(String owner) {
			this.owner = owner;
		}
	}

	private static List<Integer> input(BufferedReader reader) throws IOException {
		return input(reader, Integer::valueOf);
	}

	private static <T> List<T> input(BufferedReader reader, Function<String, T> function) throws IOException {
		return Arrays.stream(reader.readLine().split(" "))
					 .map(function)
					 .collect(Collectors.toList());
	}

	private static <T> void output(int idx, T answer) {
		System.out.println(
				String.format(
						"Case #%d: %s",
						idx,
						answer.toString()
				)
		);
	}
}