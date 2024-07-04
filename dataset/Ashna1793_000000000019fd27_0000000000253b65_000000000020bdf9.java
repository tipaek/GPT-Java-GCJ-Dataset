import java.util.*;
import java.io.*;

public class Solution {

	private static boolean isOverlapping(int[] oldSet, int [] newSet) {
		int maxStarts = Math.max(oldSet[0], newSet[0]);
		int minEnds = Math.min(oldSet[1], newSet[1]);
		return maxStarts < minEnds;
	}
	
	private static String getOrder(int[][] times){
		char ans[] = new char[times.length]; 
		Arrays.sort(times, new Comparator<int[]>(){
			@Override
			public int compare(int a[], int b[]){
				return a[0] - b[0];
			}
		});
		ArrayList<int []> c_list = new ArrayList<int[]>();
		ArrayList<int []> j_list = new ArrayList<int[]>();
		for(int i = 0; i < times.length; i++){
			int[] current = times[i];
			if(c_list.isEmpty() || !isOverlapping(c_list.get(c_list.size() -1), current)) {
				c_list.add(Arrays.copyOf(current, 3));
				ans[current[2]] = 'C';
			}else if (j_list.isEmpty() || !isOverlapping(j_list.get(j_list.size() -1), current)) {
				j_list.add(Arrays.copyOf(current, 3));
				ans[current[2]] = 'J';
			} else {
				return "IMPOSSIBLE";
			}
		}
		return  new String(ans);
	}
	
	public static void main( String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++){
			int N = in.nextInt();
			int[][] times = new int[N][3];
			for(int j = 0; j < N; j++) {
				times[j][0] = in.nextInt();
				times[j][1] = in.nextInt();
				times[j][2] = j;
			}
			String s = getOrder(times);
			System.out.println("Case #" + i + ": "+ s);
		}
		in.close();
	}
}
