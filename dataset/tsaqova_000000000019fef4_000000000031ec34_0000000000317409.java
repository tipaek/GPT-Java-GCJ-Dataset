import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int t = scanner.nextInt();
	    for (int a=0; a<t; a++) {
	    	int x, y;
	    	y = scanner.nextInt();
	    	x = scanner.nextInt();
	    	int sx = x;
	    	int sy = 0;
	    	int ex = 0;
	    	int ey = y;
	    	String s = scanner.next();
	    	int ans = -1;
	    	for (int i=0; i<=s.length(); i++) {
	    		int diff = (Math.abs(ex-sx) + Math.abs(ey-sy)) - (s.length() - (s.length() - i));
	    		if (diff <= 0) {
					ans = i;
					break;
				}
	    		if (i < s.length()) {
					Character c = s.charAt(i);
					if (c == 'S') {
						ex++;
					} else if (c=='N') {
						ex--;
					} else if (c=='W') {
						ey--;
					} else {
						ey++;
					}
				}
			}
	    	if (ans == -1) {
	    		System.out.println("Case #" + (a + 1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (a + 1) + ": " + (ans));
			}
		}
    }
}