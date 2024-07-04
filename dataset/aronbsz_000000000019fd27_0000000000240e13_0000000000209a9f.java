import java.util.*;
import java.util.Map.Entry;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < testCases; i++) {
			String num = sc.nextLine();
			int[] helper = new int[num.length()+2];
			int currOpen = 0;
			int prev = -1;
			for(int j = 0; j < num.length(); j++) {
				int curr = Integer.valueOf(String.valueOf(num.charAt(j)));
				if(j == 0) {
					helper[0] = curr;
					currOpen+=curr;
				}else {
					//keep current
					if(curr == prev) {
						helper[j] = 0;
					}else { //more parentheses needed if positive, less parentheses needed if negative
						helper[j] = curr-prev;
						currOpen += curr-prev;
					}
				}
				prev = curr;
			}
			String newNum = "";
			for(int j = 0; j < num.length(); j++) {
				for(int k = 0; k < Math.abs(helper[j]); k++) {
					if(helper[j] > 0) {
						newNum += "(";
					}else {
						newNum += ")";
					}
				}
				newNum += num.charAt(j);
			}
			for(int j = 0; j < currOpen; j++) {
				newNum += ")";
			}
			System.out.println("Case #" + (i+1) + ": " + newNum);
		}
	}
}