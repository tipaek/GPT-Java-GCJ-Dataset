import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	private static class Person {
		String name;
		ArrayList<Integer> freeTimes = new ArrayList<>();

		Person(String name) {
			this.name = name;
			freeTimes.add(0);
			freeTimes.add(1440);
		}

		@Override
		public String toString() {
			return name;
		}
	}

	private static boolean addFreeTime(int start, int end, Person p) {
		ArrayList<Integer> freeTimes = p.freeTimes;
		
		for (int i = 0; i < freeTimes.size(); i += 2) {
			int fStart = freeTimes.get(i);
			int fEnd = freeTimes.get(i + 1);
			
			if (fStart == fEnd) {
				return false;
			}
			
			if (fStart <= start && fEnd >= end) {
					freeTimes.add(i + 1, start);
					freeTimes.add(i + 2, end);
				
				return true;
			}
			
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();

		for (int i1 = 1; i1 <= t; ++i1) {
			Person c = new Person("C");
			Person j = new Person("J");
			int n = scanner.nextInt();
			StringBuilder stringBuilder = new StringBuilder();

			for (int i = 0; i < n; ++i) {
				int start = scanner.nextInt();
				int end = scanner.nextInt();

				boolean found = addFreeTime(start, end, c);

				if (found) {
					stringBuilder.append(c);
				} else {
					found = addFreeTime(start, end, j);
					if (found) {
						stringBuilder.append(j);
					} else {
						stringBuilder.delete(0, stringBuilder.length());
						stringBuilder.append("IMPOSSIBLE");
						break;
					}
				}

			}

			System.out.println("Case #" + i1 + ": " + stringBuilder.toString());
		}
	}
}

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static class FreeTime {
		Integer start;
		Integer end;
		
		FreeTime(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "FreeTime{" +
					       "start=" + start +
					       ", end=" + end +
					       '}';
		}
	}
	
	private static class Person {
		String name;
		ArrayList<FreeTime> freeTimes = new ArrayList<>();
		
		Person(String name) {
			this.name = name;
			freeTimes.add(new FreeTime(0, 1440));
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	private static boolean addFreeTime(int start, int end, Person p) {
		for (FreeTime freeTime : p.freeTimes) {
			if (freeTime.start <= start && freeTime.end >= end) {
				if (freeTime.start != start) {
					p.freeTimes.add(new FreeTime(freeTime.start, start));
				} if (freeTime.end != end) {
					p.freeTimes.add(new FreeTime(end, freeTime.end));
					
				}
				p.freeTimes.remove(freeTime);
				return true;
			}
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		for (int i1 = 1; i1 <= t; ++i1) {
			Person c = new Person("C");
			Person j = new Person("J");
			int n = scanner.nextInt();
			StringBuilder stringBuilder = new StringBuilder();
			
			for (int i = 0; i < n; ++i) {
				int start = scanner.nextInt();
				int end = scanner.nextInt();
				
				boolean found = addFreeTime(start, end, c);
				
				if (found) {
					stringBuilder.append(c);
				} else {
					found = addFreeTime(start, end, j);
					if (found) {
						stringBuilder.append(j);
					} else {
						stringBuilder.delete(0, stringBuilder.length());
						stringBuilder.append("IMPOSSIBLE");
						break;
					}
				}
				
			}
			
			System.out.println("Case #" + i1 + ": " + stringBuilder.toString());
		}
	}
}
 */

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static class Activity implements Comparable<Activity> {
		Integer start;
		Integer end;
		
		Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Activity activity) {
			return this.start.compareTo(activity.start);
		}
		
		@Override
		public String toString() {
			return "Activity{" +
					       "start=" + start +
					       ", end=" + end +
					       '}';
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		for (int i1 = 1; i1 <= t; ++i1) {
			int n = scanner.nextInt();
			ArrayList<Activity> list = new ArrayList<>();
			
			for (int i = 0; i < n; ++i) {
				list.add(new Activity(scanner.nextInt(), scanner.nextInt()));
			}
			
			Collections.sort(list);
			
			StringBuilder stringBuilder = new StringBuilder();
			int c = 0;
			int j = 0;
			
			for (Activity activity : list) {
				if (c <= activity.start) {
					stringBuilder.append("C");
					c = activity.end;
				} else if (j <= activity.start) {
					stringBuilder.append("J");
					j = activity.end;
				} else {
					stringBuilder.delete(0, stringBuilder.length());
					stringBuilder.append("IMPOSSIBLE");
					break;
				}
			}
			
			System.out.println("Case #" + i1 + ": " + stringBuilder.toString());
		}
	}
}

*/
