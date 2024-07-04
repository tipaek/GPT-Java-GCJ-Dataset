import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Point {
	int x;
	int y;
	int steps;
	String path;
	
	Point(int xValue, int yValue, int step, String direction) {
		this.x = xValue;
		this.y = yValue;
		this.steps = step;
		this.path = direction;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int cases = scanner.nextInt();

        for (int testCase = 1; testCase <= cases; testCase++) {
            
        	int x = scanner.nextInt();
        	int y = scanner.nextInt();
            
            System.out.println("Case #" + testCase + ": " + findPath(x, y));
        }
        
        scanner.close();
	}
	
	private static String findPath(int x, int y) {
		Set<Point> visited = new HashSet<>();

		Queue<Point> queue = new LinkedList<>();
		
		Point origin = new Point(0, 0, 1, "");
		Point target = new Point(x, y, 0, "");
		
		queue.offer(origin);
				
		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			//System.out.println("Size: " + queue.size() + " " + currentPoint.x + " " + currentPoint.y + " " + currentPoint.steps + " " + currentPoint.path);
			
			//if (visited.contains(currentPoint)) {
			//	continue;
			//}
			
			if (currentPoint.x == target.x && currentPoint.y == target.y)
				return currentPoint.path;
			
			if ((currentPoint.x - target.x) % 2 != 0 && (currentPoint.y - target.y) % 2 != 0)
				continue;
			
			visited.add(currentPoint);
			
			Point point1 = new Point(currentPoint.x + (int) Math.pow(2, currentPoint.steps - 1), currentPoint.y, currentPoint.steps + 1, currentPoint.path + "E");
			
			if (!visited.contains(point1))
				queue.offer(point1);
			
			Point point2 = new Point(currentPoint.x, currentPoint.y + (int) Math.pow(2, currentPoint.steps - 1), currentPoint.steps + 1, currentPoint.path + "N");
			
			if (!visited.contains(point2))
				queue.offer(point2);
			
			Point point3 = new Point(currentPoint.x - (int) Math.pow(2, currentPoint.steps - 1), currentPoint.y, currentPoint.steps + 1, currentPoint.path + "W");
			
			if (!visited.contains(point3))
				queue.offer(point3);
			
			Point point4 = new Point(currentPoint.x, currentPoint.y - (int) Math.pow(2, currentPoint.steps - 1), currentPoint.steps + 1, currentPoint.path + "S");
			
			if (!visited.contains(point4))
				queue.offer(point4);
		}
		
		return "IMPOSSIBLE";
	}
}
