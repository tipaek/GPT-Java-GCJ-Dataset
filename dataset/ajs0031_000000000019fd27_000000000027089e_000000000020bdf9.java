import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = scanner.nextInt();
		for (int curCase = 1; curCase <= numCases; curCase++) {
			int numJobs = scanner.nextInt();
			List<Interval> list = new LinkedList<Interval>();
			for (int job = 1; job <= numJobs; job++) {
				list.add(new Interval(scanner.nextInt(), scanner.nextInt()));
			}
			List<Interval> orig =  new LinkedList<Interval>(list); 
			Collections.sort(list);
			String result = "";
			HashMap<String,List<String>> map = assignJobs(list);
			if(map == null || map.size() == 0) {
				result = "IMPOSSIBLE";
			} else {
				for(Interval curInt : orig) {
					result += map.get(curInt.start + "," + curInt.end).get(0);
					map.get(curInt.start + "," + curInt.end).remove(0);
				}
			}
			System.out.println("Case #" + curCase + ": " + result);
			
		}
		scanner.close();
	}

	public static HashMap<String,List<String>> assignJobs(List<Interval> list) {
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		
		int lastFreeC = -1;
		int lastFreeJ = -1;
		
		for(Interval cur : list) {
			if(!map.containsKey(cur.start+","+cur.end)) {
				map.put(cur.start+","+cur.end,new LinkedList<String>());
			}
			if(cur.start >= lastFreeC) {
				
				map.get(cur.start+","+cur.end).add("C");
				lastFreeC = cur.end;
			} else if(cur.start >= lastFreeJ) {
				map.get(cur.start+","+cur.end).add("J");
				lastFreeJ = cur.end;
			} else {
				return null;
			}
		}
		return map;
	}
}

class Interval implements Comparable<Interval> {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public String toString() {
		return "[" + start + "," + end + "]";
	}

	@Override
	public int compareTo(Interval i) {
		if (start != i.start) {
			return start - i.start;
		} else {
			return end - i.start;
		}
	}
}