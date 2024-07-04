import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class ChoresTime {
	int startTime;
	int endTime;
	
	public ChoresTime(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

public class Solution {

	public static final char Jamie = 'J';
	public static final char Cameron = 'C';
	public static final String Impossible = "IMPOSSIBLE";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int count = 1; count <= T; count++) {
			int N = sc.nextInt();
			ChoresTime[] choreTimings = new ChoresTime[N];
			for (int i = 0; i < N; i++) {
				choreTimings[i] = new ChoresTime(sc.nextInt(), sc.nextInt());
			}
			String result = parentingPartneringReturns(N, choreTimings);
			System.out.println("Case #" + count + ": " + result);
		}
		sc.close();
	}

	private static String parentingPartneringReturns(int n, ChoresTime[] choreTimings) {
		String result = String.valueOf(Cameron);
		Arrays.sort(choreTimings, new Comparator<ChoresTime>() {
			@Override
			public int compare(ChoresTime o1, ChoresTime o2) {
				return o1.startTime - o2.startTime;
			}
		});
		int lastEndTimeC = choreTimings[0].endTime;
		int lastEndTimeJ = 0;
		for (int index = 1; index < n; index++) {
			int startTime = choreTimings[index].startTime;
			int endTime = choreTimings[index].endTime;
			if (startTime > endTime)
				return Impossible;
			char ch = result.charAt(result.length() - 1);
			if (startTime >= lastEndTimeC) {
				result += Cameron;
				lastEndTimeC = endTime;
			}
			else if (startTime >= lastEndTimeJ) {
				result += Jamie;
				lastEndTimeJ = endTime;
			}
			else {
				return Impossible;
			}
		}
		/*for (ChoresTime choresTime : choreTimings) {
			System.out.println(choresTime.startTime + " : " + choresTime.endTime);
		}
		*/
		return result;
	}
}
