import java.io.*;
import java.util.*;

public class Solution {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTest = Integer.parseInt(br.readLine());
	  
		for (int n = 1; n <= numTest; n++) {
			
			int numActivity = Integer.parseInt(br.readLine());
			int curActC = -1;
			int curActJ = -1;
			List<Activity> list = new ArrayList<>();
			
			for (int i = 0; i < numActivity; i++) {
				String[] line = br.readLine().split("\\s+");
				Activity temp = new Activity(i, Integer.parseInt(line[0]), true);
				list.add(temp);
				Activity temp2 = new Activity(i, Integer.parseInt(line[1]), false);
				//System.out.println(line[0]+" "+line[1]);
				list.add(temp2);
			}
			
			Collections.sort(list, (a, b) -> a.time - b.time);
			Collections.sort(list, new Comparator<Activity>() {
				public int compare(Activity a, Activity b) {
					if (a.time == b.time) {
						if (a.idx != b.idx) return a.isStart ? 1 : -1;
						else return a.isStart ? -1 : 1;
					}
					else {
						return a.time - b.time;
					}
				}
			});
			
			boolean impossible = false;
			char[] record = new char[numActivity];
			
			for (int i = 0; i < list.size(); i++) {
				Activity cur = list.get(i);
				// System.out.println(cur.time+" "+cur.isStart);
				if (cur.isStart) {
					if (curActC == -1) {
						curActC = cur.idx;
						record[cur.idx] = 'C';
					}
					else if (curActJ == -1) {
						curActJ = cur.idx;
						record[cur.idx] = 'J';
					}
					else {
						impossible = true;
						break;
					}
				}
				else {
					if (curActC == cur.idx) {
						curActC = -1;
					}
					else if (curActJ == cur.idx) {
						curActJ = -1;
					}
				}
			}
			
			String result = impossible ? "IMPOSSIBLE" : String.copyValueOf(record);
			System.out.println("Case #" + n + ": " + result);
		}
	}
	
	
	private static class Activity {
		int idx;
		int time;
		boolean isStart;

		
		public Activity(int idx, int time, boolean isStart) {
			this.idx = idx;
			this.time = time;
			this.isStart = isStart;
		}
	}
}