import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int tc = 1; tc <= T; tc++) {
			
			char[] ans;
			
			ArrayList<Schedule> list = new ArrayList<Schedule>();
			ArrayList<Integer> C = new ArrayList<Integer>();
			ArrayList<Integer> J = new ArrayList<Integer>();
			
			int N = sc.nextInt();
			
			ans = new char[N];
			int[][] time = new int[N][2];
			for(int i = 0; i < N; i++) {
				time[i][0] = sc.nextInt();
				time[i][1] = sc.nextInt();
				
				list.add(new Schedule(i, time[i][0], time[i][1]));
			}
			
			list.sort(null);
			
			int cEnd = 0, jEnd = 0;
			C.add(0);
			J.add(0);
			
			for(Schedule s : list) {
				
				int cDiff = s.start - cEnd;
				int jDiff = s.start - jEnd;
				
				if(cDiff == 0 || (cDiff > 0 && jDiff < 0)) {
				
					cEnd = s.end;
					C.add(s.idx);
				} else if( jDiff == 0 || (jDiff > 0 && cDiff < 0)) {
					
					jEnd = s.end;
					J.add(s.idx);
				} else {
					if(cDiff < 0 && jDiff < 0) continue;
					if(cDiff < jDiff) {
						cEnd = s.end;
						C.add(s.idx);
					} else if(cDiff > jDiff) {
						jEnd = s.end;
						J.add(s.idx);
					}
					else{
						
						cEnd = s.end;
						C.add(s.idx);
					}
				}
			}
			
			C.remove(0); J.remove(0);
			for(int i : C)
				ans[i] = 'C';
			for(int i : J)
				ans[i] = 'J';
			
			boolean isExist = true;
			for(int i = 0; i < N; i++) 
				if(isExist && ans[i] == '\u0000') isExist = false;
			
			if(isExist)
				System.out.println("Case #" + tc + ": " + String.valueOf(ans));
			else 
				System.out.println("Case #" + tc + ": " + "IMPOSSIBLE");
		}

	}

}

class Schedule implements Comparable<Schedule>{
	public int idx;
	public int start, end;
	
	public Schedule() {
		idx = 0; start = 0; end = 0;
	}

	public Schedule(int idx, int start, int end) {
		this.idx = idx;
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Schedule o) {
		
		if(this.end == o.end) {
			return this.start - o.start;
		}
		
		return this.end - o.end;
	}
	
}






