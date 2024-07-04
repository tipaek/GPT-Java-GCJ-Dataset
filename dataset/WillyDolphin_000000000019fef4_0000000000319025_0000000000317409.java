import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String s = sc.next();
			int time =1;
			Boolean flag = false;
			for(char c : s.toCharArray()) {
				if(c == 'S') {
					y--;
				}
				if(c == 'N') {
					y++;
				}
				if(c == 'E') {
					x++;
				}
				if(c == 'W') {
					x--;
				}
				if(Math.abs(x) + Math.abs(y) <= time) {
					System.out.println("Case #"+i+": " + time);
					flag = true;
					break;
				}
				time++;
			}
			if(!flag) {
				System.out.println("Case #"+i+": IMPOSSIBLE");
			}
			
		}
	}
}
