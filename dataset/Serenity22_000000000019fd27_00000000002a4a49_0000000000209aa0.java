import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Math;
import java.text.DecimalFormat; 

public class Solution {
	
	public static void main(String[] args) throws FileNotFoundException {
		try( Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int caseNumber = scanner.nextInt();
			if(caseNumber >= 1 && caseNumber <= 100) {
				for(int i=0; i<caseNumber; i++) {
					int N = scanner.nextInt();
					int K = scanner.nextInt();
					
					if(N== 2) {
						if(K!=2 && K!=4) {
							System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
						}
						else {
							System.out.println("Case #" + (i+1) + ": POSSIBLE");
							if(K == 2) {
								System.out.println("1 2");
								System.out.println("2 1");
							}
							else if(K == 4) {
								System.out.println("2 1");
								System.out.println("1 2");
							}
						}
					}
					else if(N == 3) calcThree(K, i);
					else if(N == 4) calcFour(K, i);
					else if(N == 5) calcFive(K, i);
					else System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
					
//					System.out.println("Case #" + (i+1) + ": ");
				}
			}
		}
	}
	
	public static void calcThree (int K, int i) {
		if(K!=3 && K!=6 && K != 9) {
			System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
		}
		else {
			System.out.println("Case #" + (i+1) + ": POSSIBLE");
			if(K == 3) {
				System.out.println("1 2 3");
				System.out.println("3 1 2");
				System.out.println("2 3 1");
			}
			else if(K == 6) {
				System.out.println("2 1 3");
				System.out.println("3 2 1");
				System.out.println("1 3 2");
			}
			else if(K == 9) {
				System.out.println("3 1 2");
				System.out.println("2 3 1");
				System.out.println("1 2 3");
			}
		}
	}

	public static void calcFour (int K, int i) {
		if(K<=3 || K == 5 || K == 15 || K>=17 ) {
			System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
		}
		else {
			System.out.println("Case #" + (i+1) + ": POSSIBLE");
			if(K == 4) {
				System.out.println("1 2 3 4");
				System.out.println("2 1 4 3");
				System.out.println("4 3 1 2");
				System.out.println("3 4 2 1");
			}
			else if(K == 6) {
				System.out.println("1 2 3 4");
				System.out.println("2 1 4 3");
				System.out.println("3 4 2 1");
				System.out.println("4 3 1 2");
			}
			else if(K == 7) {
				System.out.println("1 4 3 2");
				System.out.println("2 3 1 4");
				System.out.println("4 1 2 3");
				System.out.println("3 2 4 1");
			}
			else if(K == 8) {
				System.out.println("2 1 3 4");
				System.out.println("4 2 1 3");
				System.out.println("3 4 2 1");
				System.out.println("1 3 4 2");
			}
			else if(K == 9) {
				System.out.println("1 2 3 4");
				System.out.println("4 3 1 2");
				System.out.println("3 4 2 1");
				System.out.println("2 1 4 3");
			}
			else if(K == 10) {
				System.out.println("3 2 4 1");
				System.out.println("2 3 1 4");
				System.out.println("1 4 2 3");
				System.out.println("4 1 3 2");
			}
			else if(K == 11) {
				System.out.println("4 2 1 3");
				System.out.println("2 3 4 1");
				System.out.println("3 1 2 4");
				System.out.println("1 4 3 2");
			}
			else if(K == 12) {
				System.out.println("3 4 2 1");
				System.out.println("4 3 1 2");
				System.out.println("2 1 3 4");
				System.out.println("1 2 4 3");
			}
			else if(K == 13) {
				System.out.println("4 3 2 1");
				System.out.println("2 4 1 3");
				System.out.println("1 2 3 4");
				System.out.println("3 1 4 2");
			}
			else if(K == 14) {
				System.out.println("4 3 2 1");
				System.out.println("3 4 1 2");
				System.out.println("2 1 3 4");
				System.out.println("1 2 4 3");
			}
			else if(K == 16) {
				System.out.println("4 3 2 1");
				System.out.println("3 4 1 2");
				System.out.println("1 2 4 3");
				System.out.println("2 1 3 4");
			}
		}
	}


	public static void calcFive(int K, int i) {
		if(K<=4 || K==6 || K == 24 || K>=26) {
			System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
		}
		else {
			System.out.println("Case #" + (i+1) + ": POSSIBLE");
			if(K == 5) {
				System.out.println("1 2 3 4 5");
				System.out.println("5 1 2 3 4");
				System.out.println("4 5 1 2 3");
				System.out.println("3 4 5 1 2");
				System.out.println("2 3 4 5 1");
			}
			else if(K == 7) {
				System.out.println("2 1 3 4 5");
				System.out.println("1 2 5 3 4");
				System.out.println("5 4 1 2 3");
				System.out.println("3 5 4 1 2");
				System.out.println("4 3 2 5 1");
			}
			else if(K == 8) {
				System.out.println("2 3 1 4 5");
				System.out.println("1 2 4 5 3");
				System.out.println("5 1 2 3 4");
				System.out.println("3 4 5 1 2");
				System.out.println("4 5 3 2 1");
			}
			else if(K == 9) {
				System.out.println("2 5 1 3 4");
				System.out.println("1 2 4 5 3");
				System.out.println("5 1 3 4 2");
				System.out.println("3 4 2 1 5");
				System.out.println("4 3 5 2 1");
			}
			else if(K == 10) {
				System.out.println("2 1 3 4 5");
				System.out.println("5 2 1 3 4");
				System.out.println("4 5 2 1 3");
				System.out.println("3 4 5 2 1");
				System.out.println("1 3 4 5 2");
			}
			else if(K == 11) {
				System.out.println("5 2 4 3 1");
				System.out.println("3 1 2 5 4");
				System.out.println("2 3 1 4 5");
				System.out.println("1 4 5 2 3");
				System.out.println("4 5 3 1 2");
			}
			else if(K == 12) {
				System.out.println("5 2 3 4 1");
				System.out.println("2 1 5 3 4");
				System.out.println("3 4 2 1 5");
				System.out.println("4 5 1 2 3");
				System.out.println("1 3 4 5 2");
			}
			else if(K == 13) {
				System.out.println("5 2 4 3 1");
				System.out.println("3 1 2 4 5");
				System.out.println("2 5 3 1 4");
				System.out.println("1 4 5 2 3");
				System.out.println("4 3 1 5 2");
			}
			else if(K == 14) {
				System.out.println("5 3 2 1 4");
				System.out.println("4 2 1 3 5");
				System.out.println("2 4 3 5 1");
				System.out.println("1 5 4 2 3");
				System.out.println("3 1 5 4 2");
			}
			else if(K == 15) {
				System.out.println("3 5 4 2 1");
				System.out.println("1 3 5 4 2");
				System.out.println("2 1 3 5 4");
				System.out.println("4 2 1 3 5");
				System.out.println("5 4 2 1 3");
			}
			else if(K == 16) {
				System.out.println("5 2 3 4 1");
				System.out.println("2 5 4 1 3");
				System.out.println("4 1 2 3 5");
				System.out.println("1 3 5 2 4");
				System.out.println("3 4 1 5 2");
			}
			else if(K == 17) {
				System.out.println("5 4 2 1 3");
				System.out.println("2 5 1 3 4");
				System.out.println("1 2 3 4 5");
				System.out.println("4 3 5 2 1");
				System.out.println("3 1 4 5 2");
			}
			else if(K == 18) {
				System.out.println("5 4 1 2 3");
				System.out.println("3 5 2 1 4");
				System.out.println("2 1 3 4 5");
				System.out.println("4 2 5 3 1");
				System.out.println("1 3 4 5 2");
			}
			else if(K == 19) {
				System.out.println("5 3 4 2 1");
				System.out.println("3 5 1 4 2");
				System.out.println("1 2 3 5 4");
				System.out.println("4 1 2 3 5");
				System.out.println("2 4 5 1 3");
			}
			else if(K == 20) {
				System.out.println("4 5 3 2 1");
				System.out.println("2 4 5 1 3");
				System.out.println("1 3 4 5 2");
				System.out.println("3 2 1 4 5");
				System.out.println("5 1 2 3 4");
			}
			else if(K == 21) {
				System.out.println("5 4 1 3 2");
				System.out.println("3 5 2 1 4");
				System.out.println("2 3 4 5 1");
				System.out.println("1 2 3 4 5");
				System.out.println("4 1 5 2 3");
			}
			else if(K == 22) {
				System.out.println("5 4 3 2 1");
				System.out.println("4 5 2 1 3");
				System.out.println("1 2 4 3 5");
				System.out.println("3 1 5 4 2");
				System.out.println("2 3 1 5 4");
			}
			else if(K == 23) {
				System.out.println("5 4 1 2 3");
				System.out.println("2 5 4 3 1");
				System.out.println("4 3 5 1 2");
				System.out.println("1 2 3 4 5");
				System.out.println("3 1 2 5 4");
			}
			else if(K == 25) {
				System.out.println("5 4 3 2 1");
				System.out.println("3 5 4 1 2");
				System.out.println("1 2 5 4 3");
				System.out.println("2 3 1 5 4");
				System.out.println("4 1 2 3 5");
			}
		}
	}

}









