import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    	int testNumber = in.nextInt();
    	List<String> tests = new ArrayList<>(testNumber);
    	for (int i = 1; i <= testNumber; i++) {
    		final String next = in.next();
    		tests.add(next);
    	}
    
    	for (int i = 0; i < tests.size(); i++) {
    		String sTag = getNestedString(tests.get(i));
    		System.out.println("Case #" + (i+1) + ": " + sTag);
    	}
	}
	
	static String getNestedString(String s){
		int countLeft = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<s.length(); i++){
			int next = s.charAt(i) -'0';
			while(next > countLeft){
				sb.append('(');
				countLeft++;
			}
			while(next<countLeft){
				sb.append(')');
				countLeft--;
			}
			sb.append(next);
		}
		while(countLeft>0){
			sb.append(')');
			countLeft--;
		}
		return sb.toString();
	}
}