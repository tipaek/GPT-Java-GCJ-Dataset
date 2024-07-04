import java.util.Scanner;

public class Solution {
	public static boolean checkAvailability(int[] arr, int start, int end) {
		for(int i = start; i < end; i += 1) {
			if(i == start) {
				if(arr[i] != 0 && arr[i + 1] != 0) {
					return false;
				}
			}
			else if(arr[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] addActivity(int[] arr, int start, int end) {
		for(int i = start; i <= end; i += 1) {
			arr[i] = 1;
		}
		return arr;
	}
	
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		int t = kboard.nextInt();
		for(int i = 1; i <= t; i += 1) {
			int n = kboard.nextInt();
			int[] cameron = new int[1441];
			int[] jamie = new int[1441];
			for(int j = 0; j < 1440; j += 1) {
				cameron[j] = 0;
				jamie[j] = 0;
			}
			String answer = "";
			boolean impossible = false;
			for(int j = 0; j < n; j += 1) {
				int start = kboard.nextInt();
				int end = kboard.nextInt();
				if(!impossible) {
					boolean checkCameron = checkAvailability(cameron, start, end);
					boolean checkJamie = false;
					if(!checkCameron) {
						checkJamie = checkAvailability(jamie, start, end);
					}
					if(!checkCameron && !checkJamie) {
						impossible = true;
					}
					else if(checkCameron) {
						cameron = addActivity(cameron, start, end);
						answer += "C";
					}
					else {
						jamie = addActivity(jamie, start, end);
						answer += "J";
					}
				}
			}
			if(impossible) {
				answer = "IMPOSSIBLE";
			}
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}