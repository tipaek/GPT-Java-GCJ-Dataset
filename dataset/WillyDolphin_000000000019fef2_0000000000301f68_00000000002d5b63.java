import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int r = a;
			int hit = 0;
			for(int x=-5; x<=5; x++) {
				for(int y=-5; y<=5; y++) {
					System.out.println(x+" "+y);
					String result = sc.next();
					if(result.equals("HIT")) {
						hit =1;
						break;
					}
				}
				if(hit > 0) {
					break;
				}
			}
		}
	}
}
