import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		// TODO
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i=1;i<=t;i++) {
			System.out.println("Case #"+i);
			int n = sc.nextInt();
			if (n<500) {
				simpleWalk(n);
			} else {
				complexWalk(n);
			}
		}
	}
	
	static void simpleWalk (int n) {
		for (int i=1;i<=n;i++) {
			System.out.println(i+" "+1);
		}
	}
	
	static void complexWalk(int n) {
		
		int m=n-30;
		boolean[] digits = new boolean[30];
		for (int i=0;i<=29;i++) {
			digits[i] = (m>>i)%2 == 1;
		}
		
		boolean left = true;
		int tmp = 0;
		for (int i=1;i<=30;i++) {
			if (digits[i-1]) {
				if (left) {
					for (int j=1;j<=i;j++) {
						System.out.println(i+" "+j);
					}
				} else {
					for (int j=i;j>=1;j--) {
						System.out.println(i+" "+j);
					}
				}
				left = !left;
			}
			else {
				if (left) {
					System.out.println(i+" 1");
				} else {
					System.out.println(i+" "+i);
				}
				tmp++;
			}
		}
		for (int i=31;i<61-tmp;i++) {
			if (left) {
				System.out.println(i+" 1");
			} else {
				System.out.println(i+" "+i);
			}
		}
	}

}

