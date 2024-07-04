

import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1 ; t <= T ; t++) {
			boolean possible = false;
			String[] strArr = sc.nextLine().split(" ");
			int n = Integer.parseInt(strArr[0]), k = Integer.parseInt(strArr[1]);
			possible = k % n == 0;		
			String ans = possible ? "POSSIBLE" : "IMPOSSIBLE";
			System.out.println(String.format("Case #%d: %s",t, ans));
		}
	}

}
