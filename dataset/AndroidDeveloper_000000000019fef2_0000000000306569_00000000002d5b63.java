import java.util.Scanner;

public class Solution {
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
    	int tests = scanner.nextInt();
    	int minR = scanner.nextInt();
    	int maxR = scanner.nextInt();
    	
    	int min = -1_000_000_000;
    	int max =  1_000_000_000;
    	
    	int prev_x = 0;
    	int prev_y = 0;
    	
    	
    	for (int test = 0; test < tests; ++test) {
        	String response = scanner.next();
        	
        	int x = min + (int)(Math.random() * ((max - min) + 1));
        	int y = min + (int)(Math.random() * ((max - min) + 1));
        	        	        	
        	System.out.println(String.format("%d %d", x, y));
        	
        	if (response.equals("CENTER")) {
        		continue;
        	}
        	
        	if (response.equals("HIT")) {
        		prev_x = x;
        		prev_y = y; 
        	}
        	
        	if (response.equals("MISS")) {
        		
        	}
    	}
	}
}