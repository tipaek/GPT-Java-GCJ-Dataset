import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 1 ; i <= t ; i++) {
			int N = scan.nextInt();
			System.out.println("Case #" + i + ": " );
			if(N==1) {
				System.out.println("1 1");
			} else if(N==2) {
				System.out.println("1 1");
				System.out.println("2 1");	
			} else if(N==3) {
				System.out.println("1 1");
				System.out.println("2 1");	
				System.out.println("3 1");
			} else if (N==4) {
				System.out.println("1 1");
				System.out.println("2 1");	
				System.out.println("3 1");
				System.out.println("4 1");
			} else {
				System.out.println("1 1");
				System.out.println("2 1");	
				System.out.println("3 2");
				System.out.println("3 1");
				for(int j = 5 ; j < N ; j++) {
					System.out.println((j-1) + " 1");
				}
			}
		}

	}

}
