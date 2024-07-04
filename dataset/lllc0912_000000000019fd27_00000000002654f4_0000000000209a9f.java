import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static String solve (String input) {
		List<String> current = Arrays.asList(input.split(""));
		if (current.isEmpty()) {
			return input;
		}
		
		Integer max = Integer.valueOf(current.stream().filter(c -> !"".equals(c)).max(Comparator.naturalOrder()).get());
		Integer min = Integer.valueOf(current.stream().filter(c -> !"".equals(c)).min(Comparator.naturalOrder()).get());
    	if (max == 0) {
    		return input;
    	}
    	
    	if (min == 1 && max == 1) {
    		return "(" + input + ")";
    	}
    	
    	if (max == 1) {
    		StringBuilder sb2 = new StringBuilder();
        	StringBuilder sb = new StringBuilder();
    		for (int c = 0; c < current.size(); c++) {
    			if (current.get(c).equals("0")) {
    				if (sb2.length() > 0) {
    					sb.append("(").append(sb2.toString()).append(")");
    					sb2.setLength(0);
    				}
    				sb.append(current.get(c));
    			} else {
    				sb2.append(current.get(c));
    			}
    		}
    		
    		if (sb2.length() > 0) {
    			sb.append("(").append(sb2.toString()).append(")");
    			sb2.setLength(0);
    		}
    		return sb.toString();
    	}
    	
    	if (current.size() == 1) {
    		Integer cInt = Integer.valueOf(current.get(0));
    		String temp = current.get(0);
    		for (int i = 0; i < cInt; i++) {
    			temp = addParentheses(temp);
    		}
    		return temp;
    	}
    	
    	List<Integer> zeroIndex = new ArrayList<>();
    	for (int i = 0; i< current.size(); i++) {
    		if ("0".equals(current.get(i))) {
    			zeroIndex.add(i);
    		}
    	}
    	
    	StringBuilder result = new StringBuilder();
    	int currentVal = 0;
    	
    	String tempResult = "";
    	String tempStr = "";
    	
    	for (int i = 0; i< current.size() - 1; i++) {
    		Integer v = Integer.valueOf(current.get(i));
    		Integer v2 = Integer.valueOf(current.get(i+1));
    		
    		if (v == 0) {
    			if (tempResult.length() > 0) {
    				result.append(addParentheses(tempResult));
    				tempResult = "";
    				tempStr = "";
    				currentVal = 0;
    			}
    			result.append(v);
    			if (i == (current.size() - 2)) {
    				if (v2 == 0) {
    					result.append(v2);
    				} else {
    					tempResult += solve2(v2, v2.toString());
            			tempResult = addParentheses(tempResult);
    				}
        			
        		}
    			continue;
    		}
    		
    		if (currentVal == 0) {
				tempStr += v;
				currentVal = v;
			}
    		
    		if (v != v2){
//    			System.out.println("before:" + i+ ", tempResult:" + tempResult +", tempStr: " + tempStr +", " +currentVal);
    			tempStr = solve2(currentVal, tempStr);
    			tempResult += tempStr;
    			tempStr = "" + v2;
    			currentVal = v2;
    		} else {
    			if (v2 != 0) {
        			tempStr += v2;
        			currentVal = v;
        		}
    		}
    		
    		if (i == (current.size() - 2)) {
    			if (v2 == 0) {
    				tempResult = addParentheses(tempResult) + v2;
    			} else {
    				tempResult += solve2(v2, tempStr.toString());
        			tempResult = addParentheses(tempResult);
    			}
    		}
    		
//    		System.out.println(i+ ", tempResult:" + tempResult +", tempStr: " + tempStr +", " +currentVal);
    	}
    	
    	result.append(tempResult);
    	
    	return result.toString();
	}
	
	public static String solve2(int level, String c) {
		String temp = c;
		for (int i = 0; i < level - 1; i++) {
			temp = addParentheses(temp);
		}
 		return temp;
	}
	
	public static String addParentheses(String c) {
		return "(" + c + ")";
	}

	public static void main (String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
        	String line = in.next();
        	System.out.println("Case #" + i + ": " + solve(line));
        }
	}
}
