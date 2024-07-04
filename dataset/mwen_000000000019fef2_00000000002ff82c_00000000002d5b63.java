import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		int inputs = file.nextInt();
		int A = file.nextInt();
		int B = file.nextInt();
		for(int i = 1; i <= inputs; i++) {
			A: for(int j = -5; j <= 5; j++) {
				for(int h = -5; h <= 5; h++) {
					System.out.println(j + " " + h);
					System.out.flush();
					String ans = file.next();
					if(ans.equals("CENTER")) {
						break A;
					}
				}
			}
		}
		file.close();
	}

}
