import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static final boolean DEBUG = false;
	
	public static void main(String[] args) throws FileNotFoundException {
		long beginTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("expogo.txt") : System.in;
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
			int testCount = scanner.nextInt();
			// System.out.println("testCount :: " + testCount);
			for (int testNumber = 1; testNumber <= testCount; testNumber++) {
				int n = scanner.nextInt();
				int k = scanner.nextInt();
				solve(testNumber, n, k);
			}
		}
		System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
	}

	private static void solve(int testNumber, int x, int y) {
		boolean result = false;
		
		//System.out.println(x + " :: " + y);
		
		String resStr = "IMPOSSIBLE";
		
		List<Point> pList = new ArrayList<Point>();
		List<Point> pListNext = null;
		pList.add(new Point(0, 0,""));
		
		outer:
		for (int i = 0; i < 15 ; i++) {
			pListNext = new ArrayList<Point>();
			for (Point point : pList) {
				pListNext.add(new Point(point.x, (int)(point.y + Math.pow(2,i)), point.direction + "N"));
				pListNext.add(new Point(point.x, (int)(point.y - Math.pow(2,i)), point.direction + "S"));
				pListNext.add(new Point((int)(point.x + Math.pow(2,i)), point.y, point.direction + "W"));
				pListNext.add(new Point((int)(point.x - Math.pow(2,i)), point.y, point.direction + "E"));
			}
			pList = pListNext;
			for (Point point : pListNext) {
				if(point.equals(new Point(x,y,""))) {
					result = true;
					resStr = point.direction;
					break outer;
				}
			}
		}

		
		if(!result) {
			System.out.println("Case #" + testNumber + ": " + resStr);
		} else {
			System.out.println("Case #" + testNumber + ": " + resStr);
		}
		

	}

}

class Point{
	int x;
	int y;
	String direction;
	
	public Point(int x,int y,String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
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
		/*
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
			*/
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
