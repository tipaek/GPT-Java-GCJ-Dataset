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
			HashMap<String,String> map = assignJobs(list);
			if(map == null) {
				result = "IMPOSSIBLE";
			} else {
				for(Interval curInt : orig) {
					result += map.get(curInt.start + "," + curInt.end);
				}
			}
			System.out.println("CASE #" + curCase + ":" + result);
			
		}
	}

	public static HashMap<String,String> assignJobs(List<Interval> list) {
		HashMap<String,String> map = new HashMap<String,String>();
		
		int lastFreeC = -1;
		int lastFreeJ = -1;
		
		for(Interval cur : list) {
			if(cur.start >= lastFreeC) {
				map.put(cur.start+","+cur.end,"C");
				lastFreeC = cur.end;
			} else if(cur.start >= lastFreeJ) {
				map.put(cur.start+","+cur.end,"J");
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