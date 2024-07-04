import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tC = sc.nextInt();
		sc.nextLine();
		
		for(int t = 1; t <= tC; t++) {
		
			StringBuilder str = new StringBuilder(sc.nextLine());
			int prev = Integer.parseInt(str.substring(0,1));
			
			for(int i = 0; i < prev; i++) {
				System.out.print("(");
			}
			System.out.print("Case #" + t + ": " + prev);
			
			for(int i = 1; i < str.length(); i++) {
				int num = Integer.parseInt(str.substring(i,i+1));
				
				if(num < prev) {
					int diff = prev-num;
					
					for(int j = 0; j < diff; j++) {
						System.out.print(")");
					}
				}
				else if(num > prev) {
					int diff = num-prev;
					
					for(int j = 0; j < diff; j++) {
						System.out.print("(");
					}
				}
				System.out.print(num);
				prev = num;
			}
			for(int i = 0; i < prev; i++) {
				System.out.print(")");
			}
			System.out.println();
		}
	}
}
