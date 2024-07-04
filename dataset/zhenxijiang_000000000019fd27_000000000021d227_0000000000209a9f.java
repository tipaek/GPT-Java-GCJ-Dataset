
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < t; i++) {
    		System.out.println("Case #" + (i+1) + ": " + solve(br.readLine()));
    	}
    }
    
    public static String solve(String str) {
    	char[] carr = str.toCharArray();
    	int l = carr.length;
    	
    	int[] toInt = new int[l + 2];
    	
    	toInt[0] = 0;
    	toInt[l + 1] = 0;
    	
    	int[] diff = new int[l + 1];
    	
    	for (int i = 0; i < l; i++) {
    		toInt[i + 1] = (int) carr[i] - 48;
    	}
    	
    	StringBuilder ret = new StringBuilder();
    	
    	for (int i = 0; i < l + 1; i++) {
    		diff[i] = toInt[i + 1] - toInt[i];
    	}
    	
    	for (int i = 0; i < l; i++) {
    		if (diff[i] > 0)
	    		for (int j = 0; j < diff[i]; j++) {
	    			ret.append("(");
	    		}
    		else if (diff[i] < 0)
    			for (int j = 0; j < -diff[i]; j++) {
	    			ret.append(")");
	    		}
    		ret.append(carr[i]);
    	}
		for (int j = 0; j < -diff[l]; j++) {
			ret.append(")");
		}
		
		return ret.toString();
    }
}