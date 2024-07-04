
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Rd1BQ1 {
	static HashMap<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		List<Integer> coordinates = new LinkedList<Integer>();
		for (int curCase = 1; curCase <= numCases; curCase++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			coordinates.add(x);
			coordinates.add(y);
		}
		findPath("", 0, 0, 1);
		int count = 1;
		while (!coordinates.isEmpty()) {
			System.out.print("CASE #" + count + ": ");
			count++;
			int x = coordinates.remove(0);
			int y = coordinates.remove(0);
			if (!map.containsKey(x + "," + y)) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(map.get(x + "," + y));
			}
		}
		scanner.close();
	}

	public static void findPath(String path, int x, int y, int dist) {
		System.out.println(path+","+dist);
		if (dist > 128) {
			return;
		}
		String key = (x + "," + y);
		if (!map.containsKey(x + "," + y)) {
			map.put(key, path);
		} else {
			String cur = map.get(key);
			if (path.length() < cur.length()) {
				map.put(key, path);
			}
		}
		findPath(path + "N", x, y + dist, dist * 2);
		findPath(path + "S", x, y - dist, dist * 2);
		findPath(path + "E", x + dist, y, dist * 2);
		findPath(path + "W", x - dist, y, dist * 2);
	}
}
