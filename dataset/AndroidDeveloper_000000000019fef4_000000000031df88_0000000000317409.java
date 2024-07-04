import java.io.File;
import java.util.*;

public class Solution {
	
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
    	int tests = scanner.nextInt();
    	
        for (int test = 0; test < tests; ++test) {
        	int start_x = scanner.nextInt();
        	int start_y = scanner.nextInt();
        	String path = scanner.next();

        	int max_step = path.length();
        	
        	boolean impossible = true;
        	int shot_time = 0;
        	
        	int x = start_x;
        	int y = start_y;
        	
        	for (int step = 0; step < max_step; step++) {
        		char direction = path.charAt(step);
        		
        		switch (direction) {
        			case 'N': y++; break; 
        			case 'E': x++; break;
        			case 'S': y--; break;
        			case 'W': x--; break;
        		}
        		
        		int dist = manhattan(x,y);
        		
        		if (dist <= (step + 1)) {
        			shot_time = Math.min(step, dist) + 1;
        			impossible = false;
        			break;
        		}
        	}
        	
        	
        	if (impossible) {
        		System.out.println(String.format("Case #%d: IMPOSSIBLE", test + 1));
        	} else {
        		
        		System.out.println(String.format("Case #%d: %d", test + 1, shot_time));
        	}
        	
        }
	}
	
	
	public static int manhattan(int x, int y) {
		return Math.abs(x) + Math.abs(y);
	}
	
}