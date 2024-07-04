import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count = 1;

		while (t-- > 0) {
			int numActivities = sc.nextInt();
			boolean impossible = false;
			String schedule = "";
			boolean[] cameron = new boolean[1500];
			boolean[] jamie = new boolean[1500];
			
			for (int i = 0; i < numActivities; i++) {
				int begin = sc.nextInt();
				int end = sc.nextInt();
				
				if(checkAvailable(cameron, begin, end)) {
					for (int j = begin; j <= end; j++) {
						cameron[j] = true;
					}
					schedule += "C";
				} else if(checkAvailable(jamie, begin, end)) {
					for (int j = begin; j <= end; j++) {
						jamie[j] = true;
					}
					schedule += "J";
				} else {
					impossible = true;
					break;
				}

			}
			
			if(impossible) {
				System.out.println("Case #" + count + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + count + ": " + schedule);
			}
			
			count++;
		}
	}
	
	public static boolean checkAvailable(boolean[] person, int begin, int end) {
		for(int i = begin+1; i < end; i++) {
			if(person[i]) {
				return false;
			}
		}
		return true;
	}
}
