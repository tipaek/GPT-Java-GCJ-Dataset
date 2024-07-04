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
    	String tempResult = "";
    	String tempStr = "";
    	
    	for (int i = 0; i< current.size(); i++) {
//    		System.out.println("before:" + i+ ", tempResult:" + tempResult +", tempStr: " + tempStr +", ");
    		Integer v = Integer.valueOf(current.get(i));
    		if (v == 0) {
    			result.append(process(tempStr));
    			result.append(v);
    			tempStr = "";
    		} else {
    			tempStr += v;
    		}
    		
    		if (i == current.size() - 1 && tempStr.length() > 0) {
    			
    			result.append(process(tempStr));
    		}
//    		System.out.println(i+ ", tempResult:" + tempResult +", tempStr: " + tempStr +", " );
    	}
    	
    	result.append(tempResult);
    	
    	return result.toString();
	}
	
	public static String process(String s) {
		if (s.equals("")) {
			return s;
		}
		List<Integer> list = new ArrayList<>();
		int max = 0;
		int min = 10;
		for (String c : Arrays.asList(s.split(""))) {
			int v = Integer.valueOf(c);
			list.add(v);
			if (v > max) {
				max = v;
			}
			if (v < min) {
				min = v;
			}
		}

		String t = "";
		int left = 0;
		int right = 0;
		for (int i = 0; i < min; i++) {
			t += "(";
			left++;
		}

		for (int i = 0; i < list.size(); i++) {
			int v = list.get(i);
			
			if (i >= 1) {
				int v2 = list.get(i-1);
//				System.out.println("v2: " +v2 + ", v " + v);
				if (v2 > v) {
					for (int k = 0; k < (v2 - v); k++) {
						t += ")";
						right++;	
					}
				} else {
					if (v2 == min) {
//						System.out.println("left: " +left + ", right " + right);
						int t2 = left - right;
						for (int k = 0; k < t2; k++) {
							t += ")";
							right++;
						}
					}
				}
			}
			
			if (left == right) {
				left = 0;
				right = 0;
			}
			
//			System.out.println(t);
//			System.out.println("left: " +left + ", " +right + ", " +v + ", " + (v - left));
			int temp = v -left;
			for (int j = 0; j < temp; j++) {
				t += "(";
				left++;
			}
			t += v;
			
		}
		for (int i = 0; i < (left - right); i++) {
			t += ")";
		}
		
		return t;
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
