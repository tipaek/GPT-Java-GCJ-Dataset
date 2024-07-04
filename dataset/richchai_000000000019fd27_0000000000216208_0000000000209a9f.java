import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		
		
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++) {
			String s = in.next();
			System.out.println(parenthesize(s, 0));
		}
		
		
		
	}
	
	public static String parenthesize(String s, int i) {
		String ret = "";
		ArrayList<String> arr = new ArrayList<>();
		int currindex = 0;
		String currval = Integer.toString(i);
		while(s.indexOf(currval, currindex) > -1) {
			arr.add(s.substring(currindex, s.indexOf(currval, currindex)));
			arr.add(currval);
			currindex = s.indexOf(currval, currindex) + 1;
		}
		arr.add(s.substring(currindex));
		
		
		for(int j = 0; j < arr.size(); j++) {
			if(arr.get(j).equals("")) {
				continue;
			} else if(arr.get(j).contains(currval)) {
				ret += currval;
			} else {
				ret += "(" + parenthesize(arr.get(j), i + 1) + ")";
			}
			
			
		}
		
		return ret;
	}
	
	
}
