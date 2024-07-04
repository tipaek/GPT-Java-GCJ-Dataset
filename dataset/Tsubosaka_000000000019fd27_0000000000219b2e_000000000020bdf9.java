import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class Activity{
		int start;
		int end;
		public Activity(int s , int e) {
			start = s;
			end = e;
		}
		boolean isOverlap(Activity anotherActivity){
			if(anotherActivity.end <= start){
				return false;
			}
			if(end <= anotherActivity.start){
				return false;
			}
			return true;
		}
	}
	static boolean isAssigned(char c){
		return c == 'C' || c == 'J';
	}
	static String solve(Activity[] activities){
		int N = activities.length;
		boolean overlaps[][] = new boolean[N][N];
		for(int i = 0 ; i < N ; ++i){
			for(int j = 0 ; j < N ; ++j){
				if(i == j){
					continue;
				}
				overlaps[i][j] = activities[i].isOverlap(activities[j]);				
			}
		}
		char taskAssign[] = new char[N];
		for(int i = 0 ; i < N ; ++i){
			if(isAssigned(taskAssign[i])){
				continue;
			}
			taskAssign[i] = 'C';
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			while(!q.isEmpty()){
				int cur = q.poll();
				char currentTaskAssign = taskAssign[cur];
				for(int a = 0 ; a < N ; ++a){
					if(!overlaps[cur][a]){
						continue;
					}
					char adjacentTaskAssign = taskAssign[a]; 
					if(adjacentTaskAssign == currentTaskAssign){
						return "IMPOSSIBLE";
					}
					if(isAssigned(adjacentTaskAssign)){
						continue;
					}
					q.add(a);
					taskAssign[a] = (currentTaskAssign == 'C') ? 'J' : 'C';
				}
			}
		}
		
		return new String(taskAssign);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1 ;  t <= T ; ++t){
			int N = sc.nextInt();
			Activity[] activities = new Activity[N];
			for(int i = 0 ; i < N ; ++i){
				int s = sc.nextInt();
				int e  =sc.nextInt();
				activities[i] = new Activity(s , e);				
			}
			System.out.printf("Case #%d: %s\n" , t , solve(activities));
		}
	}
}
