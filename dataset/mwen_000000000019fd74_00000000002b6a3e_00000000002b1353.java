import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		int inputs = file.nextInt();
		for(int i = 1; i <= inputs; i++) {
			int n = file.nextInt();
			System.out.printf("Case #%d:%n", i);
			int index = 1;
			boolean first = false;
			while(n > 0) {
				if(index <= 2) {
					System.out.println(index + " " + 1);
					n -= 1;
					index++;
				}
				else {
					if(n >= index-1) {
						first = true;
						System.out.println(index + " " + 2);
						n -= index-1;
						index++;
					}
					else {
						if(first) {
							first = false;
							System.out.println(index-1 + " " + 1);
							n -= 1;
						}
						else {
							System.out.println(index + " " + 1);
							n -= 1;
							index++;
						}
						
					}
				}
			}
		}
		file.close();
	}

}
