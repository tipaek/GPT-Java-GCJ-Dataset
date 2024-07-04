
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int curCase = 1; curCase <= numCases; curCase++) {
			int numJobs = scanner.nextInt();
			List<Interval> list = new LinkedList<Interval>();
			for (int job = 1; job <= numJobs; job++) {
				list.add(new Interval(scanner.nextInt(), scanner.nextInt()));
			}
			Collections.sort(list);
			System.out.println("CASE #" + curCase + ":" + assignJobs(list));

		}
	}
	
	public static String assignJobs(List<Interval> list) {
		String result = "";
		
		int lastFreeC = -1;
		int lastFreeJ = -1;
		
		for(Interval cur : list) {
			if(cur.start >= lastFreeC) {
				result += "C";
				lastFreeC = cur.end;
			} else if(cur.start >= lastFreeJ) {
				result += "J";
				lastFreeJ = cur.end;
			} else {
				return "IMPOSSIBLE";
			}
		}
		return result;
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