import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberInstances;
		try {
			numberInstances = Integer.parseInt(br.readLine());
		    for (int i = 1; i <= numberInstances; ++i) {
		    	StringBuilder sb = new StringBuilder();
		    	String[] arguments = br.readLine().split(" ");
		    	int input = Integer.parseInt(arguments[0]);
		    	if (input <= 29) {
		    		int counter = 0;
		    		while (counter < input) {
		    			sb.append((counter+1) +" "+ 1 + "\n");
		    			counter ++;
		    		}
		    	}
		    	else { 	
		    		
		    		//System.out.println("number: " + (input -29));
			    	int maxDepth = 29;
			    	LinkedList<Integer> powers = getPowers(input-maxDepth);
			    	//System.out.println(powers.toString());
			    	int additionalOnes = powers.size();
			    	boolean leftSide=true;
			    	int currentRow = 1;
			    	while (currentRow <= maxDepth) {
			    		if (!powers.isEmpty() && currentRow == (int) powers.peekLast()+1) {
			    			powers.removeLast();
			    			if (leftSide) {
			    				for (int k=1;k<=currentRow; k++) {
			    					sb.append(currentRow +" "+ k + "\n");
			    				}
			    				leftSide = false;
			    			}
			    			else {
			    				for (int k=currentRow;k>=1; k--) {
			    					sb.append(currentRow +" "+ k + "\n");
			    				}
			    				leftSide = true;
			    			}
			    		}
			    		else {
			    			if (leftSide) {
			    				sb.append(currentRow +" "+ 1 + "\n");
			    			}
			    			else {
			    				sb.append(currentRow +" "+ currentRow + "\n");
			    			}
			    		}
			    		currentRow++;
			    	}
			    	
		    		int counter = 0;
		    		while (counter < additionalOnes) {
		    			if (leftSide) sb.append((maxDepth+counter+1) +" "+ 1 + "\n");
		    			else  sb.append((maxDepth+counter+1) +" "+ (maxDepth+counter+1) + "\n");
		    			counter ++;
		    		}
			    	
		    	}
		    	
		    	sb.delete(sb.length()-1, sb.length());
		    	
		    	
		    	
		    	
		    	System.out.println("Case #" + i + ": \n" + sb.toString());

		    }
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static LinkedList<Integer> getPowers(int i) {
		int myNumber = i;
		LinkedList<Integer> toReturn = new LinkedList<Integer>();
		for (int max = 29; max >=0; max--) {
			if (myNumber>=Math.pow(2, max)) {
				toReturn.add(max);
				myNumber = myNumber- (int) Math.pow(2, max);
			}			
		}
		return toReturn;
	}

	public static int ceilLog2(int x)
	{
	    return   (int) Math.ceil((Math.log(x) / Math.log(2)));
	}
}
