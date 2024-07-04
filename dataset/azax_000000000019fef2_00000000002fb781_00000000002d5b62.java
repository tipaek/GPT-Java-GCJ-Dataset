import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	private static final long MAX_STEP = 257L;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		HashMap<Pair, String> targets = new LinkedHashMap<>();
		for (int index = 0; index < numCases; index++) {
			String[] line = sc.nextLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			targets.put(new Pair(x, y), "IMPOSSIBLE");
		}
		findPaths(targets);
		int num = 1;
		for (Map.Entry<Pair, String> entry : targets.entrySet()) {
			System.out.println(
					"Case #" + num + ": " + entry.getValue()
			);
			num++;
		}
		sc.close();
		
	}
	
	private static void findPaths(Map<Pair, String> cases) {
		Set<Pair> targets = new HashSet<Pair>(cases.keySet());
		
		Map<String, Pair> map = new HashMap<>();
		map.put("", new Pair(0, 0));
		long step = 1;
		while (targets.size() != 0 && step < MAX_STEP) {
			Map<String, Pair> newMap = new HashMap<>();
			for (Map.Entry<String, Pair> entry : map.entrySet()) {
				Pair p = entry.getValue();
				
				for (int choice = 0; choice < 4; choice++) {
					long horiz, vert;
					char c;
					switch(choice) {
						case 0:
							horiz = step; vert = 0;
							c = 'E';
							break;
						case 1:
							vert = step; horiz = 0;
							c = 'N';
							break;
						case 2:
							horiz = - step; vert = 0;
							c = 'W';
							break;
						default:
							vert = - step; horiz = 0;
							c = 'S';
							break;
					}
					Pair newPair = new Pair(p.x + horiz, p.y + vert);
					if (targets.contains(newPair)) {
						cases.put(newPair, entry.getKey() + c);
						targets.remove(newPair);
					}
					newMap.put(entry.getKey() + c, newPair);
				}
			}
			map = newMap;
			step *= 2;
		}
	}
	
	static class Pair {
		long x;
		long y;
		
		Pair(long x, long y) {
			this.x = x;
			this.y  = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null) return false;
			if (o instanceof Pair) {
				return ((Pair) o).x == x && ((Pair) o).y == y;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			int result = (int) (x ^ (x >>> 32));
	        result = 31 * result + (int) (y ^ (y >>> 32));
	        return result;
		}
	}
}
