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
				int l = -50;
				int r = 50;
				int hit = 0;
				while(r-l>2) {
					int mid = (l+r)/2;
					System.out.println(0+" "+(mid-rx));
					String results = sc.next();
					if(results.equals("HIT")) {
						r = mid+1;
					} else {
						l = mid;
					}
				}
				for(int x=-50; x<=50; x++) {
					for(int y=l; y<=r; y++) {
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
		}
	}
}
