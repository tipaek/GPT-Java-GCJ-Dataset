import java.util.*;

public class Solution {
	
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
    	int tests = scanner.nextInt();
    	
        for (int test = 0; test < tests; ++test) {
        	String line = scanner.next();
        	
        	StringBuilder sb = new StringBuilder();
        	
        	int v = Character.getNumericValue(line.charAt(0));
        	for (int i = 0; i < v; i++) {
        		sb.append("(");
        	}
        	sb.append(Integer.toString(v));
        		
        	int next_v;
        	for (int c = 1; c < line.length(); c++) {
        		next_v = Character.getNumericValue(line.charAt(c));
        		if (next_v > v) {
        			for (int i = 0; i < next_v - v; i++) {
                		sb.append("(");
                	}
        		} else if (next_v < v) {
        			for (int i = 0; i < v - next_v; i++) {
                		sb.append(")");
                	}
        		}
        		sb.append(Integer.toString(next_v));
        			
        		v =	next_v;
        	}
        	for (int i = 0; i < v; i++) {
        		sb.append(")");
        	}
        	
        	System.out.println(String.format("Case #%d: %s", test + 1, sb.toString()));
        }
	}
	
}