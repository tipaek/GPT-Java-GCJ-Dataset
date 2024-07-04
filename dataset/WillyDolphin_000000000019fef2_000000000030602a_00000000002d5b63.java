import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int i=1; i<=t; i++) {
			if(a == 1000000000-5) {
				int r = a;
				int hit = 0;
				for(int x=-5; x<=5; x++) {
					for(int y=-5; y<=5; y++) {
						System.out.println(x+" "+y);
						String result = sc.next();
						if(result.equals("CENTER")) {
							hit =1;
							break;
						}
					}
					if(hit > 0) {
						break;
					}
				}
			}
			if(a == 1000000000-50) {
				int rx  = 999999999;
				int yi = -50;
				int hit = 0;
				for(int xx = -50-rx; xx <= 50-rx; xx++) {
					System.out.println(0+" "+xx);
					String result = sc.next();
					if(result.equals("MISS")) {
						yi++;
						continue;
					}else if(result.equals("CENTER")) {
						hit = 1;
						break;
					}else if(result.equals("HIT")) {
						for(int x=-50; x<=50; x++) {
							System.out.println(x+" "+yi);
							result = sc.next();
							if(result.equals("CENTER")) {
								hit = 1;
								break;
							}		
						}
						if(hit>0) {
							break;
						} else {
							yi++;
						}
					}
				}
			}
		}
	}
}
