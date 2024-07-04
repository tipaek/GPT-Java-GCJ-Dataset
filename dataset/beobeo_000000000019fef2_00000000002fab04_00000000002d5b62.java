import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static String getResult(int x, int y) {
		Map<Integer, Map<Integer, Boolean>> visited = new HashMap<>();
		Queue<QueueElement> queue = new LinkedList<>();
		queue.offer(new QueueElement(0, 0, 0, ""));
		Map<Integer, Boolean> map = new HashMap<>();
		map.put(0, true);
		visited.put(0, map);
		while(!queue.isEmpty()) {
			QueueElement top = queue.poll();
			if ((int)top.x == x && (int) top.y == y) return top.direction;
			for (QueueElement next : getNext(top)) {
				if (visited.containsKey(next.x) && visited.get(next.x).containsKey(next.y)) continue;
				map = visited.getOrDefault(next.x, new HashMap<>());
				map.put((int) next.y, true);
				visited.put((int) next.x, map);
				queue.offer(next);
			}
		}
		return "IMPOSSIBLE";
	}
	
	public static List<QueueElement> getNext(QueueElement element) {
		List<QueueElement> list = new ArrayList<>();
		long step = (long) Math.pow(2, element.step);
		if (element.y + step <= 100) {
			// move north
			list.add(new QueueElement(element.x, element.y + step, element.step + 1, element.direction + "N"));
		}
		if (element.y - step >= -100) {
			list.add(new QueueElement(element.x, element.y - step, element.step + 1, element.direction + "S"));
		}
		if (element.x + step <= 100) {
			list.add(new QueueElement(element.x + step, element.y, element.step + 1, element.direction + "E"));
		}
		if (element.x - step >= -100) {
			list.add(new QueueElement(element.x - step, element.y, element.step + 1, element.direction + "W"));
		}
		return list;
	}
	
	public static class QueueElement {
		private long x;
		private long y;
		private int step;
		private String direction;
		public QueueElement(long x, long y, int currentStep, String current) {
			this.x = x;
			this.y = y;
			this.step = currentStep;
			this.direction = current;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			System.out.println("Case #" + (i + 1) + ": " + getResult(x, y));
		}
	}
}