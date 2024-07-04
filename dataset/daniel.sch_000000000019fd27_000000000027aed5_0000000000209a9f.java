import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberInstances;
		try {
			numberInstances = Integer.parseInt(br.readLine());
		    for (int i = 1; i <= numberInstances; ++i) {
		    	StringBuilder sb = new StringBuilder();
		    	String[] arguments = br.readLine().split(" ");
		    	char[] input = arguments[0].toCharArray();
		    	int currentDepth = 0;
		    	for (char c:input) {
		    		int requiredDepth = c-48;
		    		while (requiredDepth > currentDepth) {
		    			sb.append("(");
		    			currentDepth++;
		    		}
		    		while (requiredDepth < currentDepth) {
		    			sb.append(")");
		    			currentDepth--;
		    		}
		    		sb.append(c);
		    	}
	    		while (0 < currentDepth) {
	    			sb.append(")");
	    			currentDepth--;
	    		}
		    	System.out.println("Case #" + i + ": " + sb.toString());

		    }
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}	
}
