import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	
	public static final int E = 1;
	public static final int N = 1;
	public static final int W = -1;
	public static final int S = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			Pepper pepper = new Pepper(sc.nextInt(), sc.nextInt(), sc.next());
			int answer = -1;
			Iterator itr = pepper.pathMap.keySet().iterator();
			while(itr.hasNext()) {
				int min = (Integer) itr.next();
				if(Location.isPossible(pepper.pathMap.get(min), min)) {
					answer = min;
					break;
				}
			}
			
			if(answer != -1)
				System.out.println("Case #" + i + ": " + answer);
			else
				System.out.println("Case #" + i + ": IMPOSSIBLE");
		}
		sc.close();
	}
}


class Pepper {
	Location start;
	String path;
	HashMap<Integer, Location> pathMap = new HashMap<Integer, Location>();

	public Pepper(int x, int y, String path) {
		start = new Location(x, y);
		this.path = path;
		generatePathMap();
	}

	private void generatePathMap() {
		pathMap.put(0, start);
		Location location = start;
		for(int i = 0, minutes = 1 ; i < path.length() ; i++, minutes++) {
			location = Location.getNewLocation(location, path.charAt(i));
			pathMap.put(minutes, location);
		}
	}
	
	public Location getStartLocation() {
		return pathMap.get(0);
	}
	
	public Location getEndLocation() {
		return pathMap.get(path.length());
	}
}

class Location {
	public static final int PLUS = 1;
	public static final int MINUS = -1;
	
	int x;
	int y;

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}

	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Location getNewLocation(Location location, char c) {
		switch(c) {
		case 'S':
			return new Location(location.x, location.y + MINUS);
		case 'N':
			return new Location(location.x, location.y + PLUS);
		case 'E':
			return new Location(location.x + PLUS, location.y);
		case 'W':
			return new Location(location.x + MINUS, location.y);
		}
		return null;
	}
	
	public static boolean isPossible(Location location, int minutes) {
		int distance = Math.abs(location.x) + Math.abs(location.y);
		if(distance <= minutes)
			return true;
		return false;
	}
}