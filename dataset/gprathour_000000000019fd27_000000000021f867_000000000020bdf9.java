import java.util.Scanner;

public class Solution {

	private static String calc(int arr[][]) {
		String res = "";
		int cList[][] = new int[arr.length][2];
		int jList[][] = new int[arr.length][2];
		
		for (int i = 0; i < arr.length; i++) {
			boolean exists = false;
			for (int[] cArr : cList) {
				if (arr[i][0] == cArr[0] || arr[i][1] == cArr[1]) {
					exists = true;
					break;
				} else if ((arr[i][0] > cArr[0] && arr[i][0] < cArr[1]) || (cArr[0] > arr[i][0] && cArr[0] < arr[i][1])
						|| (arr[i][1] > cArr[0] && arr[i][0] < cArr[1])
						|| (cArr[1] > arr[i][0] && cArr[0] < arr[i][1])) {
					exists = true;
					break;
				}
			}
			if (exists) {
				exists = false;
				for (int[] cArr : jList) {
					if (arr[i][0] == cArr[0] || arr[i][1] == cArr[1]) {
						exists = true;
						break;
					} else if ((arr[i][0] > cArr[0] && arr[i][0] < cArr[1])
							|| (cArr[0] > arr[i][0] && cArr[0] < arr[i][1])
							|| (arr[i][1] > cArr[0] && arr[i][0] < cArr[1])
							|| (cArr[1] > arr[i][0] && cArr[0] < arr[i][1])) {
						exists = true;
						break;
					}
				}
				if (exists) {
					return "IMPOSSIBLE";
				} else {
					jList[i] = arr[i];
					res += "J";
				}
			} else {
				cList[i] = arr[i];
				res += "C";
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][2];
			for (int j = 0; j < N; j++) {
				arr[j][0] = sc.nextInt();
				arr[j][1] = sc.nextInt();
			}
			System.out.println("Case #" + i + ": " + calc(arr));
		}
	}
}