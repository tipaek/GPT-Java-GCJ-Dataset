

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TimeIndex implements Comparable<TimeIndex>{
	int time;
	int index;
	public TimeIndex(int time, int index) {
		super();
		this.time = time;
		this.index = index;
	}
	@Override
	public String toString() {
		return " [time=" + time + ", index=" + index + "]";
	}
	@Override
	public int compareTo(TimeIndex t) {
		return Integer.compare(this.time, t.time);
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1 ; t <= T ; t++) {
			String ans = "";
			int n = Integer.parseInt(sc.nextLine());
			ArrayList<TimeIndex> starts = new ArrayList<TimeIndex>();
			ArrayList<TimeIndex> ends = new ArrayList<TimeIndex>();
			char[] assingment = new char[n];
			for(int i = 0 ; i < n ; i++) {
				String[] strArr = sc.nextLine().split(" ");
				starts.add(new TimeIndex(Integer.parseInt(strArr[0]), i));
				ends.add(new TimeIndex(Integer.parseInt(strArr[1]), i));				
			}
			Collections.sort(starts);
			Collections.sort(ends);
			int i = 0, j = 0, menReq = 0;
			boolean cFree = true;
			while(i < n && j < n && menReq <= 2) {
				if(starts.get(i).time < ends.get(j).time) {
					menReq++;
					if(cFree) {
						assingment[starts.get(i).index] = 'C';
						cFree = false;
					}
					else
						assingment[starts.get(i).index] = 'J';	
					i++;
				}else {
					menReq--;
					if(assingment[ends.get(j).index] == 'C')
						cFree = true;
					j++;
				}
			}
			if(menReq > 2)
				ans = "IMPOSSIBLE";
			else
				ans = new String(assingment);
			System.out.println(String.format("Case #%d: %s",t, ans));
		}
	}

}
