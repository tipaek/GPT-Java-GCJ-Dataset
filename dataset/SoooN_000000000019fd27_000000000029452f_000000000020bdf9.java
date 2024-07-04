import java.util.*;
public class RoughWork {

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
			for(int i = 0 ; i < n ; i++) {
				if(start[i] == 1440) {
					start[i] = 0;
				}
			}
			String ans = "J";
			for(int i = 1 ; i < n ; i++) {
				int st = start[i];
				int en = end[i];
				int flag_j = 0;
				int flag_c = 0;
				for(int j = 0 ; j < i ; j++) {
					int ts = start[j];
					int te = end[j];
					if(te <= st || ts >= en) {
						continue;
					}else{
						String a = ans.charAt(j) + "";
						if(a.equals("J")) {
							flag_j = 1;
						}else {
							flag_c = 1;
						}
					}
				}
				if(flag_c == 1 && flag_j == 1) {
					ans = "IMPOSSIBLE";
					break;
				}if(flag_c == 0 && flag_j == 0) {
					ans += ans.charAt(i - 1);
				}
				else {
					if(flag_c == 1) {
						ans += "J";
					}else {
						ans += "C";
					}
				}
			}
			System.out.println("Case #" + (l + 1) + ": " + ans);
		}
	}
}