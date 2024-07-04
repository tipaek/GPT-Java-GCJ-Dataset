import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			int n = sc.nextInt();
			System.out.println("Case #"+t+":");
			if(n <=500) {
				for(int i = 0; i < n; i++) {
					System.out.println((i+1) + " 1");
				}
				continue;
			}
			int currX = 2;
			int currY = 1;
			System.out.println("1 1");
			n-=1;
			while(true) {
				if(n>=currY) {
					n-=currY;
					System.out.println(currX + " " + currY);
					currX++;
					currY++;
				}else {
					break;
				}
			}
			while(n>0) {
				System.out.println(currY + " " + currY);
				n--;
				currY++;
			}
		}
		sc.close();
	}
	
}
