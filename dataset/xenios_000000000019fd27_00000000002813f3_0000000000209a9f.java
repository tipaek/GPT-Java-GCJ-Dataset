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
        	String[] temp = oneRow.split("");
        	String result = "";
        	//System.out.println(" One Row1: " + oneRow);
            result = recur(temp, 0, result);
            System.out.println("Case #" + x + ": " + result);
    	}
    }

    public static String recur(String[] sArr, int index, String result) {
    	int cur = Integer.parseInt(sArr[index]);
    	int next = -1;
    	result = result.concat(sArr[index]);
    	
    	if(index==0) {
    		if(sArr.length<2) {
    			result = insertOpening(result, cur);
    			result = insertClosing(result, cur);
    			return result;
    		} else {
    			result = insertOpening(result, cur);
    		}
    	}
    	if(index == sArr.length-1) {
    		result = insertClosing(result, cur);
    		return result;
    	}
    	if(index + 1 < sArr.length) {
    		next = Integer.parseInt(sArr[index+1]);
    		if(next == 0) {
    			result = insertClosing(result, cur);
    		} else if(cur > next) {
    			result = insertClosing(result, cur - next);
    			//result = insertOpeningEnd(result, next);
    		} else if(cur < next) {
    			//result = insertClosing(result, cur);
    			result = insertOpeningEnd(result, next-cur);
    		}
    		result = recur(sArr, index+1, result);
    	} else {
    		result = insertClosing(result, cur);
    	}
    	return result;
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