import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public String solve(long y, long x) {
		Map<Long, String> map = new HashMap<>();
		Queue<Long> Q = new LinkedList<>();
		Q.add(0L);
		map.put(0L, "");
		
		long power = 1;
		while(!Q.isEmpty()) {
			//System.out.println(Q.size());
			int size = Q.size();
			for(int i = 0; i < size; i++) {
				long cur = Q.poll();
				long curX = cur / 1000000000L;
				long curY = cur % 1000000000L;
				//if(curX != x && power > Math.abs(curX - x) * 2) continue;
				//if(curY != y && power > Math.abs(curY - y) * 2) continue;
				String curStr = map.get(cur);
				//System.out.println(curX + "," + curY + ":" + curStr);
				if(curX == x && curY == y) return curStr;
				long newcur = (curX+power) * 1000000000L + curY;
				if(!map.containsKey(newcur)) {
					Q.add(newcur);
					map.put(newcur, curStr+"N");
				}
				newcur = (curX-power) * 1000000000L + curY;
				if(!map.containsKey(newcur)) {
					Q.add(newcur);
					map.put(newcur, curStr+"S");
				}
				newcur = (curX) * 1000000000L + curY + power;
				if(!map.containsKey(newcur)) {
					Q.add(newcur);
					map.put(newcur, curStr+"E");
				}
				newcur = (curX) * 1000000000L + curY - power;
				if(!map.containsKey(newcur)) {
					Q.add(newcur);
					map.put(newcur, curStr+"W");
				}
			}
			power *= 2;
			if(power >= 1000) break;
		}
		
		return "IMPOSSIBLE";
	}
	
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve(2, 3));
		System.out.println(Q.solve(-2, -3));
		System.out.println(Q.solve(3, 0));
		System.out.println(Q.solve(-1, 1));
		System.out.println(Q.solve(1000000000, 1000000000));
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			long X = in.nextLong();
			long Y = in.nextLong();
			in.nextLine();
			String output = Q.solve(X, Y);
			System.out.println("Case #" + i + ": " + output);
			System.out.flush();
		}
	}

}
