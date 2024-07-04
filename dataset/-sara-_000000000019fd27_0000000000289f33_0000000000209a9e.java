import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private static int nbQueries = 0;
	private static int b;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		b = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			nbQueries = 0;
			Integer[] storedData = new Integer[b];
			for (int j = 1; j <= 5; j++) {
				query(j, storedData, in);
				query(b+1-j, storedData, in);
			}
			boolean finished = false;
			while(!finished) {
				int fluctuation = determineFluctuation(storedData, in);
				storedData = applyFluctuation(storedData, fluctuation);
				int k = 0;
				while (nbQueries % 10 != 0  && !finished) {
					while (k < b && storedData[k] != null) {
						k++;
					}
					if (k == b) {
						finished = true;
						System.out.println(Arrays.toString(storedData).
								replace("[", "").replace(", ", "").replace("]", ""));
						String verdict = in.next();
						if(verdict.equals("N")) {
							return;
						} 
					} else {
						query(k+1, storedData, in);
						if (nbQueries % 10 != 0 && storedData[b-1-k] == null) {
							query(b-k, storedData,in);
						}
					}
				}
			}
		}
		in.close();
	}
	
	private static void query(int j, Integer storedData[], Scanner in) {
		System.out.println(j);
		storedData[j-1] = in.nextInt();
		nbQueries++;
	}
	
	/*
	 * 1 = complemented
	 * 2 = reversed
	 * 3 = reversed and complemented
	 * 4 = unchanged
	 */
	private static int determineFluctuation(Integer[] storedData, Scanner in) {
		System.out.println(1);
		int newValueOne = in.nextInt();
		nbQueries++;
		int indexTwo = -1;
		int newValueTwo = -1;
		if (storedData[0] == storedData[b-1]) {
			for (int j = 1; j < b/2; j++) {
				if(storedData[j] == null || storedData[j] == storedData[b-1-j]) {} 
				//will not give us any additional information
				else {
					System.out.println(j+1);
					newValueTwo = in.nextInt();
					nbQueries++;
					indexTwo = j;
					break;
				}
			}
			if (newValueOne == storedData[0]) {	// either unchanged or reversed
				if (indexTwo == -1 || newValueTwo == storedData[indexTwo]) {
					return 4;
				} else {
					return 2;
				}
			} else { //complemented or complemented and reversed
				if(indexTwo != -1 && newValueTwo == storedData[indexTwo]) {
					return 3;
				} else {
					return 1;
				}
			}
		} else {
			for (int j = 1; j < b/2; j++) {
				if(storedData[j] == null || storedData[j] != storedData[b-1-j]) {} 
				//will not give us any additional information
				else {
					System.out.println(j+1);
					newValueTwo = in.nextInt();
					nbQueries++;
					indexTwo = j;
					break;
				}
			}
			if (newValueOne == storedData[0]) {	// either unchanged or reversed and complemented
				if (indexTwo != -1 && newValueTwo == storedData[indexTwo]) {
					return 4;
				} else {
					return 3;
				}
			} else { //complemented or reversed
				if(indexTwo == -1 || newValueTwo == storedData[indexTwo]) {
					return 2;
				} else {
					return 1;
				}
			}
		}
	}
	
	/*
	 * 1 = complemented
	 * 2 = reversed
	 * 3 = reversed and complemented
	 * 4 = unchanged
	 */
	private static Integer[] applyFluctuation(Integer[] storedData, int fluctuation) {
		switch (fluctuation) {
			case 1:
				for (int j = 0; j < b; j++) {
					if(storedData[j] == 0) {
						storedData[j] = 1;
					} else if(storedData[j] == 1) {
						storedData[j] = 0;
					}
				}
				break;
			case 2:
				for (int j = 0; j < b/2; j++) {
					Integer temp = storedData[b-1-j];
					storedData[b-1-j] = storedData[j];
					storedData[j] = temp;
				}
				
				break;
			case 3:
				for (int j = 0; j < b/2; j++) {
					Integer temp = storedData[b-1-j];
					storedData[b-1-j] = storedData[j];
					storedData[j] = temp;
				}
				for (int j = 0; j < b; j++) {
					if(storedData[j] == 0) {
						storedData[j] = 1;
					} else if(storedData[j] == 1) {
						storedData[j] = 0;
					}
				}
				break;
			case 4:
				break;		
		}
		return storedData;
	}
}
