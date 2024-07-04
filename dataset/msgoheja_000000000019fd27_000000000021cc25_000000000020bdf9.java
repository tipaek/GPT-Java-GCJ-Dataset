import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
	public static class Time implements Comparable<Time>{
		int start, end;
		String assign;
		Time(int start, int end){
			this.start = start;
			this.end = end;
			assign = "C";
		}
		@Override
		public int compareTo(Time o) {
			if(this.start < o.start) return -1;
			else if(this.start > o.start) return 1;
			return 0;
		}
	}
	
	public static boolean isOverLap(Time t1, Time t2) {
		if(t2.start >= t1.start && t2.start < t1.end) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String output = "";
		List<Time> list, list1, list2;
		Time t,prevT;
		int N;
		Time[] schd;
		int T = in.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			output = "";
			
			N = in.nextInt();
			schd = new Time[N];
			list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				t = new Time(in.nextInt(), in.nextInt());
				schd[i] = t;
				list.add(schd[i]);
			}
			
			Collections.sort(list);
			
			// Categorize C & J list
			List<Time> overLappingList = new ArrayList<>();
			
			boolean flag = false;
			for(int i = 1; i < list.size(); i++) {
				t = list.get(i);
				
				for(int j = 0; j < i; j++) {
					prevT = list.get(j);
					if(prevT.assign.equals("C") && isOverLap(prevT, t)) {
						list.get(i).assign = "J";
						overLappingList.add(list.get(i));
						break;
					}
				}
			}
			
			for(int i = 1; i < overLappingList.size(); i++) {
				t = overLappingList.get(i);
				for(int j = 0; j < i; j++) {
					prevT = overLappingList.get(j);
					if(isOverLap(prevT, t)) {
						flag = true;
						break;
					}
				}
			}
			
			if(flag) {
				output = "IMPOSSIBLE";
			} else {
				for(Time time: schd) {
					output += time.assign;
				}
			}
			
			System.out.println("Case #" + tc + ": " + output);
		}
		in.close();
	}
}
