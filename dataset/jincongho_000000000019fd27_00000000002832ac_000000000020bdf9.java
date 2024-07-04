import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	public static class Schedule{
		public int start;
		public int end;
		public Parent parent;

		public Schedule(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	
	public static class Parent extends LinkedList<Schedule>{
		public String _name;
		
		public Parent(String name)
		{
			_name = name;
		}
		
		public boolean canDo(Schedule plan)
		{
			return size()==0 || getLast().end <= plan.start;
		}
	}

	public static boolean search(Schedule[] schedules, Parent[] parents, int taskIndex)
	{
		for(int i=0; i<schedules.length; i++) {
			if(parents[0].canDo(schedules[i])) {
				parents[0].add(schedules[i]);
				schedules[i].parent = parents[0];
			}else if(parents[1].canDo(schedules[i])) {
				parents[1].add(schedules[i]);
				schedules[i].parent = parents[1];
			}else {
				return false;
			}
		}
		return true;
//		for(int i=0;i<parents.length;i++) {
//			if(parents[i].canDo(schedules[taskIndex])){
//				parents[i].add(schedules[taskIndex]);
//				schedules[taskIndex].parent = parents[i];
//				
//				if(taskIndex+1==schedules.length) {
//					return true;
//				}else {
//					if(search(schedules, parents, taskIndex+1)) {
//						return true;
//					}else {
//						schedules[taskIndex].parent = null;
//						parents[i].removeLast();
//					}
//				}
//			}
//		}
		
//		return false;
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		for(int t=0;t<T;t++) {
			int N = input.nextInt();
			Schedule[] schedules = new Schedule[N];
			Schedule[] schedules_sorted = new Schedule[N];
			for(int n=0;n<N;n++) {
				int start = input.nextInt();
				int end = input.nextInt();
				schedules[n] = new Schedule(start, end);
				schedules_sorted[n] = schedules[n];
			}
			Arrays.sort(schedules_sorted, new Comparator<Schedule>() {
				
				@Override
				public int compare(Schedule a, Schedule b) {
					return Integer.compare(a.start, b.start);
				}
			});
			
			StringBuilder result = new StringBuilder();
			if(search(schedules_sorted, new Parent[] {new Parent("C"), new Parent("J")}, 0)) {
				for(int i=0;i<N;i++) {
					result.append(schedules[i].parent._name);
				}
			}else {
				result.append("IMPOSSIBLE");
			}
			System.out.println(String.format("Case #%d: %s", (t+1), result));
		}
		
	}

}
