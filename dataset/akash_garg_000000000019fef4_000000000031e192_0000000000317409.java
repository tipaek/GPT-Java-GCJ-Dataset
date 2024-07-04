import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test_cases = in.nextInt();
		for (int q = 1; q <= test_cases; q++) {
			System.out.print("Case #" + q + ": ");
			int i = in.nextInt(), j = in.nextInt();
			String str = in.nextLine();
			int ans = 0;
			boolean flag = true;
			for(int x = 0; x < str.length(); x++, ans++) {
				if(ans >= Math.abs(i) + Math.abs(j)) {
					flag = false;
					System.out.println(ans);
					break;
				}
				char ch = str.charAt(x);
				if(ch == 'N') {
					j++;
				}
				else if(ch == 'S') {
					j--;
				}
				else if(ch == 'E') {
					i++;
				}
				else if(ch == 'W') {
					j--;
				}
			}
			if(flag) {
				if(ans >= Math.abs(i) + Math.abs(j)) {
					System.out.println(ans);
				}else {
					System.out.println("IMPOSSIBLE");
				}
			}
		}
	}

}