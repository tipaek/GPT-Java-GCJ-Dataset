
import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String args[]) {
				
		int testCase, testCounter = 1;

		Scanner inputScanner = new Scanner(System.in);

		testCase = inputScanner.nextInt();

		while (testCounter <= testCase) {
			
			int N = inputScanner.nextInt();
			int K = inputScanner.nextInt(); 
			
			int divider = K/N;
			int remainder = K%N;
			if(remainder == 0) {
				System.out.println("Case #"+testCounter+": POSSIBLE");
				int counter = divider;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(counter++ +" ");
						
						if(counter > N)
							counter = 1;
					}
					counter--;
					if(counter == 0)
						counter = N;
					System.out.println();
				}
			}else {
				System.out.println("Case #"+testCounter+": IMPOSSIBLE");

			}
			
			testCounter++;
		}
	}
}
