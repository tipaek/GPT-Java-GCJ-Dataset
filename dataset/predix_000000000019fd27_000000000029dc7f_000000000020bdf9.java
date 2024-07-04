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
			return Integer.compare(this.start, o.start);
		}


		@Override
		public String toString() {
			return index + " " + start + " " + stop + " " + assignedPerson;
		}

	}

	public static void main(String[] args) {
		int T;
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();

		for (int i = 1; i < T + 1; i++) {
			boolean retFalse = false;
			int N = scanner.nextInt();
			PriorityQueue<Interval> pQueueAll = new PriorityQueue<>();

			int timeJ = 0;
			int timeC = 0;
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
				
				if(timeJ < timeC)
				{
					if(timeJ <= currentInterval.start ) {
						timeJ = currentInterval.stop;
						currentInterval.assignedPerson = Person.J;
					}else if(timeC <= currentInterval.start ) {
						timeC = currentInterval.stop;
						currentInterval.assignedPerson = Person.C;
					}else {
						retFalse = true;
						break;
					}
				}else {
					if(timeC <= currentInterval.start ) {
						timeC = currentInterval.stop;
						currentInterval.assignedPerson = Person.C;
					}else if(timeJ <= currentInterval.start ) {
						timeJ = currentInterval.stop;
						currentInterval.assignedPerson = Person.J;
					}else {
						retFalse = true;
						break;
					}
					
				}

				res.add(currentInterval);

			}

			String pre = String.format("Case #%d: ", i);

			if (retFalse)
				System.out.println(pre + "IMPOSSIBLE");
			else {
				StringBuilder resultString = new StringBuilder();
				for (Interval iv : res) {
					resultString.append(iv.assignedPerson);
				}
				System.out.println(pre + resultString);

			}
			System.out.flush();

		}

		scanner.close();

	}

}
