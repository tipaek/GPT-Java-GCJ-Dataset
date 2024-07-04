import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
	
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
    	int tests = scanner.nextInt();
    	
        for (int test = 0; test < tests; ++test) {
        	int target_x = scanner.nextInt();
        	int target_y = scanner.nextInt();

        	int border = 1_000;
        	int N = 15;
        	
        	boolean impossible = true;
        	
        	char result[] = new char[N];
        	char currentRes[] = new char[N];
        	int currentSet[] = new int[N];
        	char letters[] = new char[] {'N', 'E', 'S', 'W'};
        	for (int i = 0; i < N; i++) {
        		currentSet[i] = 0;
        	}
        	int bestN = Integer.MAX_VALUE;
        	while (getNextSet(currentSet, letters.length-1, N)) {
        	    int sum_x = 0;
        		int sum_y = 0;
        		int step = 1;
        		for (int i = 0; i < N; i++) {
        			currentRes[i] = letters[currentSet[i]];
        			switch (currentSet[i]) {
        				case 0: sum_y += step; break; // N   
        				case 1: sum_x += step; break; // E
				        case 2: sum_y -= step; break; // S   
						case 3: sum_x -= step; break; // W
        			}
        			
        			if (Math.abs(sum_x) > border || Math.abs(sum_y) > border) {
        				break;
        			}
        			
        			if (sum_x == target_x && sum_y == target_y) {
        				if (i < bestN) {
        					bestN = i + 1;
        					for (int j = 0; j < bestN; j++) {
            					result[j] = currentRes[j];
            				}
            				impossible = false;
            			}
        			}
        			step <<= 1;
        			
        		}
        	}
        	
        	
        	if (impossible) {
        		System.out.println(String.format("Case #%d: IMPOSSIBLE", test + 1));
        	} else {
        		StringBuilder sb = new StringBuilder();
        		char[] word = Arrays.copyOfRange(result, 0, bestN);
        		sb.append(word);
        		System.out.println(String.format("Case #%d: %s", test + 1, sb.toString()));
        	}
        	
        }
	}
	
	public static boolean getNextSet(int [] a, int quantity, int size) {
		int j = size - 1;
		while (j >= 0 && a[j] == quantity) j--;
		if (j < 0) return false;
		if (a[j] >= quantity) j--;
		a[j]++;
		if (j == size - 1) return true;
		for (int k = j + 1; k < size; k++)
			a[k] = 0;
		return true;
	}

}