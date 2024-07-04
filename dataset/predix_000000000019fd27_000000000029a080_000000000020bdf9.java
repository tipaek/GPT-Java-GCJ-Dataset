import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	private enum Person {
		C, J;
	}

	private static class Interval implements Comparable<Interval> {

		int start;
		int stop;
		int index;
		Person assignedPerson;

		public Interval(int start, int stop, int index, Person assignedPerson) {
			this.start = start;
			this.stop = stop;
			this.index = index;
			this.assignedPerson = assignedPerson;

		}

		@Override
		public int compareTo(Interval o) {
			return Integer.compare(start, o.start);
		}

		public boolean overlap(Interval interval) {

			if (this.compareTo(interval) < 0)
				return this.stop > interval.start;
			else
				return interval.stop > this.start;

		}
		
		@Override
		public String toString() {
			return index+ " " +start +  " " + stop+" "+assignedPerson;
		}

	}

	public static void main(String[] args) {
		int T;
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();

		for (int i = 1; i < T+1; i++) {
			boolean retFalse = false;
			int N = scanner.nextInt();
			PriorityQueue<Interval> pQueueAll = new PriorityQueue<>();

			PriorityQueue<Interval> pQueueC = new PriorityQueue<>(new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {

					return Integer.compare(o2.start, o1.start);
				}
			});

			PriorityQueue<Interval> pQueueJ = new PriorityQueue<>(new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {

					return Integer.compare(o2.start, o1.start);
				}
			});

			PriorityQueue<Interval> res = new PriorityQueue<>(new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {

					return Integer.compare(o1.index, o2.index);
				}
			});

			for (int j = 0; j < N; j++) {
				int start = scanner.nextInt();
				int stop = scanner.nextInt();

				pQueueAll.add(new Interval(start, stop, j, null));

			}
		

			while (!pQueueAll.isEmpty()) {
				Interval currentInterval = pQueueAll.poll();
		
				if (pQueueC.isEmpty()) {
					currentInterval.assignedPerson = Person.C;
					pQueueC.add(currentInterval);
					res.add(currentInterval);
				} else if (pQueueJ.isEmpty()) {
					currentInterval.assignedPerson = Person.J;
					pQueueJ.add(currentInterval);
					res.add(currentInterval);

				} else if (!pQueueC.peek().overlap(currentInterval)) {
					currentInterval.assignedPerson = Person.C;
					pQueueC.add(currentInterval);
					res.add(currentInterval);
				} else if (!pQueueJ.peek().overlap(currentInterval)) {
					currentInterval.assignedPerson = Person.J;
					pQueueJ.add(currentInterval);
					res.add(currentInterval);
				} else {
					retFalse = true;
					break;

				}

			}

			String pre = String.format("Case #%d: ", i);
			if (retFalse)
				System.out.println(pre+"IMPOSSIBLE");
			else {
				StringBuilder resultString = new StringBuilder();
				for (Interval iv : res) {
					resultString.append(iv.assignedPerson);
				}
				System.out.println(pre+resultString);

			}

		}

		scanner.close();

	}

}
