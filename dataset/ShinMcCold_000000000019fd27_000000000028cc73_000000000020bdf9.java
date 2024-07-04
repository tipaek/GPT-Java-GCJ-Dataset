
import java.util.*;

public class Solution {

	static class Time {

		int start_point;
		int end_point;
		int index;

		public Time(int start_point, int end_point, int index) {
			super();
			this.start_point = start_point;
			this.end_point = end_point;
			this.index = index;
		}

	};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int i = 0; i < test; i++) {
			String answer = "";
			int intervals = sc.nextInt();
			boolean check_condition = true;
			ArrayList<Time> array_time_J = new ArrayList<>();
			ArrayList<Time> array_time_C = new ArrayList<>();
			Time[] time = new Time[intervals];
			for (int j = 0; j < intervals; j++) {
				time[j] = new Time(sc.nextInt(), sc.nextInt(), j);

			} // done

			Arrays.sort(time, new Comparator<Time>() {
				@Override
				public int compare(Time o1, Time o2) {
					return Integer.compare(o1.start_point, o2.start_point);
				}
			});

			for (int j = 0; j < time.length; j++) {
				//System.out.println("" + time[j].start_point + " " + time[j].end_point);
			}

			int c_end = 0;
			int j_end = 0;

			String result = null;

			HashMap<Integer, Character> hash = new HashMap<>();
			for (int j = 0; j < time.length; j++) {
				if (time[j].start_point < c_end && time[j].start_point < j_end) {
					result = "IMPOSSIBLE";

					break;
				}

				if (time[j].start_point >= c_end) {
					hash.put(time[j].index, 'C');

					c_end = time[j].end_point;
				} else {
					hash.put(time[j].index, 'J');
					j_end = time[j].end_point;
				}

			}
			
			if(result==null)
			{   result="";
				for (int j = 0; j < intervals; j++) {
					result+=hash.get(j);
				}
			}
            
			
			System.out.println("Case #"+(i+1)+": "+result);
		}

	}
}
