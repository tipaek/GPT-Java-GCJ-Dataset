import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int testCasesNum = scanner.nextInt();
		for (int i = 1; i <= testCasesNum; i++) {
			int N = scanner.nextInt();
			int[][] schedule = new int[N][3];
			for (int j = 0; j < N; j++) {
				int S = scanner.nextInt();
				int E = scanner.nextInt();
				schedule[j][0] = S;
				schedule[j][1] = j;
				schedule[j][2] = E;
			}
			Arrays.sort(schedule, new Comparator<int[]>(){

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
				
			});
			
			char[] result = new char[N];
			int cFinishTime = 0, jFinishTime = 0;
			for (int j = 0; j < schedule.length; j++) {
				if (cFinishTime <= schedule[j][0])
				{
					cFinishTime = schedule[j][2];
					result[schedule[j][1]] = 'C';
					continue;
				}
				if (jFinishTime <= schedule[j][0])
				{
					jFinishTime = schedule[j][2];
					result[schedule[j][1]] = 'J';
					continue;
				}
				result = "IMPOSSIBLE".toCharArray();
				break;
			}
			System.out.println("Case #" + i + ": " + new String(result));
		}
		try{
			scanner.close();
		}
		catch (Exception e){}
		System.out.flush();
	}
}