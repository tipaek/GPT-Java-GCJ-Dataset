import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Steve Mwangi
 * 10:56:41 PM
 * 2020
 */
public class Solution2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for(int iii = 0; iii < t; iii++){
        	int x = iii+1;
        	String oneRow = in.nextLine();
        	String result = "";
        	//System.out.println(" One Row1: " + oneRow);
            String[] temp = oneRow.split("");
            for(int i =0; i < temp.length; i++) {
            	int val = Integer.parseInt(temp[i]);
            	result = result.concat(temp[i]);
            	//System.out.println("Temp: " + temp[i]);
            	int val2 = -1;
            	if(i+1 < temp.length) {
            		val2 = Integer.parseInt(temp[i+1]);
            	}
            	if(val == 0) {
            		result = insertOpeningEnd(result, val2);
            		continue;
            	}
            	
            	if(val2 != -1) {
            		int diff = val - val2;
            		if(val2 != 0) {
            			result = insertOpening(result, val);
                		if(diff > 0) {
                			result = insertClosing(result, diff);
                			result = result.concat(temp[i+1]);
                			i++;
                			result = insertClosing(result,val2);
                		} else if(diff == 0) {
                			result = result.concat(temp[i+1]);
                			i++;
                		} else {
                			result = insertClosing(result, val);
                		}
            		} else {
            			result = insertClosing(result, val);
            			continue;
            		}
            	} else {
            		result = insertOpening(result, val);
            		result = insertClosing(result, val);
            	}
    	}
            System.out.println("Case #" + x + ": " + result);
        }
    }
    
    public static String insertClosing(String result, int x) {
    	for(int i =0; i < x; i++) {
    		result = result.concat(")");
    	}
    	return result;
    }
    
    public static String insertOpening(String result, int x) {
    	if(x<= 0) {
    		return result;
    	}
    	for(int i =0; i < x; i++) {
    		result = "(".concat(result);
    	}
    	return result;
    }
    
    public static String insertOpeningEnd(String result, int x) {
    	if(x<= 0) {
    		return result;
    	}
    	for(int i =0; i < x; i++) {
    		result = result.concat("(");
    	}
    	return result;
    }
}