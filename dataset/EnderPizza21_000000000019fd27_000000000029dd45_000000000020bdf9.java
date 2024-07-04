import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) {
			int l = Integer.parseInt(br.readLine());
			ArrayList<int[]> curr = new ArrayList<>();
			for(int j = 0; j < l; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				curr.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), j});
			}
			System.out.println("Case #" + i + ": " + schedule(curr));
		}
	}
	
	public static String schedule(ArrayList<int[]> intervals) {
		Collections.sort(intervals, new IntervalComp());
		String[] answerArr = new String[intervals.size()];
		int[] c = new int[] {0, 0, -1};
		int[] j = new int[] {0, 0, -1};
		String answer = "";
		for(int i = 0; i < intervals.size(); i++) {
			int[] curr = intervals.get(i);
			if(c[1] <= curr[0]) {
				c = curr;
				answerArr[curr[2]] = "C";
			}
			else if(j[1] <= curr[0]) {
				j = curr;
				answerArr[curr[2]] = "J";
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		for(int i = 0; i < intervals.size(); i++) {
			answer += answerArr[i];
		}
		return answer;
	}
	
	public static class IntervalComp implements Comparator<int[]>{
		@Override
	    public int compare(int[] o1, int[] o2) {
	        return Integer.compare(o1[0], o2[0]);
	    }
	}

}
