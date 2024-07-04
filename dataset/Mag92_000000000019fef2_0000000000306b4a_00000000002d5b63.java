import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int T = scanner.nextInt();
		long A = scanner.nextInt();
		long B = scanner.nextInt();
		long Xmin = (long) Math.pow(-10, 9);
		long Xmax = (long) Math.pow(10, 9);
		long Ymin = (long) Math.pow(-10, 9);
		long Ymax = (long) Math.pow(10, 9);
		
		Random rand = new Random();
		long Xi = Xmin;
		long Yi = Ymin;
		Boolean pos = false;
		// for each testcase
		for(int i = 0; i < T; i++) {
			
			// output Xi and Yi and wait for judge
			System.out.println(Xi + " " + Yi);
			
			// get judge o/p
			String output = scanner.next();
			
			if (output.equals("CENTER")) break;
			
			else if (output.equals("HIT")) {
				// update range:
				Xmin = -Math.abs(Xi);
				Xmax = Math.abs(Xi);
				Ymin = -Math.abs(Yi);
				Ymax = Math.abs(Yi);
				
				long randomX = ThreadLocalRandom.current().nextLong((Xmax-Xmin) + 1) + Xmin;
				long randomY = ThreadLocalRandom.current().nextLong((Ymax-Ymin) + 1) + Ymin;
				Xi = randomX;
				Yi = randomY;
				
			}
			
			
			else if (output.equals("MISS")) {
				long randomX = ThreadLocalRandom.current().nextLong((Xmax-Xmin) + 1) + Xmin;
				long randomY = ThreadLocalRandom.current().nextLong((Xmax-Xmin) + 1) + Ymin;
				if (A == B) {
					Xi = Xi + B;
					Yi = Yi + B;
				}
				else {
					if (pos) {
						Xi = Xi + (B-A);
						Yi = Yi + (B-A);
					}
					else {
						Xi = Xi - (B-A);
						Yi = Yi - (B-A);
					}
				}
			}
			
			
		}
		scanner.close();
	}

}