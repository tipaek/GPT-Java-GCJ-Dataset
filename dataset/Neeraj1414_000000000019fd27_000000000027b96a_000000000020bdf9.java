import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void intervalScheduling(List<Interval> intervals, List<List<Interval>> result,
			int selectedIntervals){
		
		if(selectedIntervals == intervals.size()) {
			return;
		}
		
		ArrayList<Interval> resultList = new ArrayList<>();

		int count = selectedIntervals;
		
		for(Interval currentInterval : intervals) {
			
			if(currentInterval.isSelected) {
				continue;
			}
			
			if(resultList.isEmpty()) {
				resultList.add(currentInterval);
				currentInterval.setSelected(true);
				count++;
			}
			else {
				if(currentInterval.getStartTime() >= resultList.get(resultList.size()-1).getEndTime()){
					resultList.add(currentInterval);
					currentInterval.setSelected(true);
					count++;
				}
			}
		}
		
		result.add(resultList);
		
		intervalScheduling(intervals, result, count);
	}

	public static void main(String args[] ) throws Exception {
		
		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		for(int k=1;k<=T;k++) {
			
			int n = Integer.parseInt(scanner.nextLine());
			
			List<Interval> intervals = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				String[] array = scanner.nextLine().split(" ");
				intervals.add(new Interval(Integer.parseInt(array[0]), Integer.parseInt(array[1]), i));
			}
			
			Collections.sort(intervals, Comparator.comparing(p -> p.getEndTime()));
			
			List<List<Interval>> result = new ArrayList<>();
			
			intervalScheduling(intervals, result, 0);
			
			if(result.size() == 2) {
				
				assignGroup(result.get(0), 'C');
				assignGroup(result.get(1), 'J');
				
				List<Interval> mergedResult = new ArrayList<>();
				mergedResult.addAll(result.get(0));
				mergedResult.addAll(result.get(1));
				
				Collections.sort(mergedResult, Comparator.comparing(i -> i.getOrder()));
				
				StringBuilder builder = new StringBuilder();
				
				for(Interval interval : mergedResult) {
					builder.append(interval.getGroup());
				}
				
				System.out.println(String.format("Case #%s: %s", k, builder.toString()));
				
			}
			else if(result.size() == 1) {
				
				StringBuilder builder = new StringBuilder();
				
				for(int i=0;i<n;i++) {
					builder.append('C');
				}
				
				System.out.println(String.format("Case #%s: %s", k, builder.toString()));
				
			}
			else {
				System.out.println(String.format("Case #%s: %s", k, "IMPOSSIBLE"));
			}
			
			
		}

		scanner.close();
		
	}
	
	private static void assignGroup(List<Interval> list, char group) {
		
		for(Interval interval : list) {
			interval.setGroup(group);
		}
		
	}

	private static class Interval {

		private int startTime;
		private int endTime;
		private boolean isSelected;
		private int order;
		private char group;

		public Interval(int startTime, int endTime, int order) {
			this.startTime = startTime;
			this.endTime = endTime;
			isSelected = false;
			this.order = order;
		}

		public int getStartTime() {
			return startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public boolean isSelected() {
			return isSelected;
		}

		public void setSelected(boolean isSelected) {
			this.isSelected = isSelected;
		}

		public int getOrder() {
			return order;
		}

		public char getGroup() {
			return group;
		}

		public void setGroup(char group) {
			this.group = group;
		}

	}

}
