
import java.util.*;
import java.io.*;

public class Solution{
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    public static void main(String []args) {
        int numOfCases = in.nextInt();
        for (int caseNum = 0; caseNum < numOfCases; caseNum++) {
        	int x = in.nextInt();
        	int y = in.nextInt();
        	System.out.println("Case #"+ (caseNum+1) + ": " + calcCase(x, y));
        }
    } 
    
    public static String calcCase (int x, int y) {
    	String result = "";
    	String shortestResult = "";
    	long start = System.currentTimeMillis();
    	boolean found = false;
    	while (System.currentTimeMillis() - start < 390) {
    		int counter = 0;
        	int len = (int)(Math.random()*10);
        	result = "";
        	for (int i = 0; i < len; i++) {
        		result = result.concat(getLetter(Math.random()));
        	}
        	if (checkX(result, x) && checkY(result, y)) {
        		if (result.length() <= shortestResult.length() || shortestResult.equals("")) {
	        		shortestResult = result;
	        		counter++;
	        		if (counter > 10) {
	        			break;
	        		}
        		}
	        	found = true;
        	}
    	}
    	if (!found) {
    		shortestResult = "IMPOSSIBLE";
    	}
    	return shortestResult;
    }
    
    public static String getLetter (double random) {
    	if (random < 0.25) {
    		return ("N");
    	}else if (random > 0.25 && random < 0.5) {
    		return ("W");
    	}else if (random > 0.5 && random < 0.75) {
    		return ("E");
    	}else {
    		return ("S");
    	}
    }
    
    public static boolean checkX (String str, int number) {
    	int sum = 0;
    	for (int p = 0; p < str.length(); p++) {
    		if (str.charAt(p) == 'E') {
    			sum += Math.pow(2.0, p);
    		}else if (str.charAt(p) == 'W') {
    			sum -= Math.pow(2.0, p);
    		}
    	}
    	if (sum == number) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public static boolean checkY (String str, int number) {
    	int sum = 0;
    	for (int p = 0; p < str.length(); p++) {
    		if (str.charAt(p) == 'N') {
    			sum += Math.pow(2.0, p);
    		}else if (str.charAt(p) == 'S') {
    			sum -= Math.pow(2.0, p);
    		}
    	}
    	if (sum == number) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public static String numberToBin (int number) {
    	String binString = Integer.toBinaryString(number);
    	return binString;
    }
    
    public static String getDirections (int number, boolean x) {
    	if (x) {
    		if (number > 0) {
    			return ("E"); 
    		}else {
    			return ("W");
    		}
    	}else {
    		if (number > 0) {
    			return ("N");
    		}else {
    			return ("S");
    		}
    	}
    	
    }
    
    public static void markUsed (boolean[] powers, String bin) {
		for (int c = bin.length()-1; c >= 0; c--) {
			if (bin.charAt(c) == '1') {
				powers[bin.length() - 1 - c] = true;
			}
		}
    }
    
    public static boolean buildNumber (boolean[] powers, int number) {
    	int sum = 0;
    	int[] indexes = new int[powers.length];
    	for (int i = 0; i < powers.length; i++) {
    		if (!powers[i]) {
    			indexes[i] = i;
    		}
    	}
    	
    	
    	return false;
//    	int sum = 0;
//    	double sumPlus = 0;
//    	double sumMinus = 0;
//    	for (int i = 0; i < powers.length; i++) {
//    		if (!powers[i]) {
//    			sumPlus = (double)sum + Math.pow(2.0, i);
//    			sumMinus = (double)sum - Math.pow(2.0, i);
//    			if (sumPlus == number || sumMinus == number) {
//    				return true;
//    			}
//    			sum += Math.pow(2.0, i);
//    		}
//    	}
//    	return false;
    }
    
    public static String calcPower(int number, boolean x) {
    	if (number == 1 || number == -1) {
    		return (getDirections(1 ,x));
    		//return (getDirections(-2 ,x) + getDirections(3 ,x));
    	}
    	if (number == 2 || number == -2) {
    		return (getDirections(2 ,x));
    		//return (getDirections(=1 ,x));
    	}
    	if (number == 3 || number == -3) {
    		return (getDirections(4 ,x));
    	}
    	return null;
    }

}
