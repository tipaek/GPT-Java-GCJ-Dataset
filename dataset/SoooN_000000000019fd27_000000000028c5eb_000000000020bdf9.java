import java.util.*;
public class Solution {

	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int l = 0 ; l < t ; l++) {
			int n = s.nextInt();
			int start[] = new int[n];
			int end[] = new int[n];
			for(int i = 0 ; i < n ; i++) {
				start[i] = s.nextInt();
				end[i] = s.nextInt();
			}
			String ans = "J";
			int fl = 0;
			for(int i = 1 ; i < n ; i++) {
				int st = start[i];
				int en = end[i];
				int o = 0;
				String p = "";
				int flag_j = 0;
				int flag_c = 0;
				int flag = 0;
				int flag2 = 0;
				for(int j = 0 ; j < i ; j++) {
					int ts = start[j];
					int te = end[j];
					if(te <= st || ts >= en) {
						continue;
					}else{
						flag2 = 1;
						String a = ans.charAt(j) + "";
						if(a.equals("J")) {
							flag_j = 1;
						}else {
							flag_c = 1;
						}
					}
				}
				if(flag_c == 1 && flag_j == 1) {
					fl = 1;
					break;
				}else {
					if(flag_c == 1) {
						ans += "J";
					}else {
						ans += "C";
					}
				}
			}
			if(fl == 1) {
				System.out.println("Case #" + (l + 1) + ": IMPOSSIBLE");
			}else {
				System.out.println("Case #" + (l + 1) + ": " + ans);
			}
		}
	}
}