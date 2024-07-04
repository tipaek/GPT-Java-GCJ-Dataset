import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner input = new Scanner(System.in);
        int numberT = input.nextInt();

        for (int caseNum = 1; caseNum <= numberT; caseNum++) {
        	String nums = input.next();
            String answer = solver(nums);
            System.out.println("Case #"+caseNum+": " + answer);
        }
    }

    private static String solver(String nums) {
    	int beforeInt = 0;
    	String ansString = "";
    	for (int i = 0; i < nums.length(); i++) {
    		int num = Integer.valueOf(String.valueOf(nums.charAt(i))).intValue();
    		int diff = num - beforeInt;
    		if (diff > 0) {
    			String sep = "";
    			for (int j = 0; j < diff; j++) {
    				sep = sep + "(";
    			}
    			ansString = ansString + sep + String.valueOf(num);
    		} else if (diff < 0) {
    			String sep = "";
    			for (int j = 0; j < diff*(-1); j++) {
    				sep = sep + ")";
    			}
    			ansString = ansString + sep + String.valueOf(num);
    		} else {
    			ansString = ansString + String.valueOf(num);
    		}
    		if (i == nums.length() - 1) {
    			String sep = "";
    			for (int j = 0; j < num; j++) {
    				sep = sep + ")";
    			}
    			ansString = ansString + sep;
    		}
    		beforeInt = num;
    	}
    	return ansString;
    }
}
