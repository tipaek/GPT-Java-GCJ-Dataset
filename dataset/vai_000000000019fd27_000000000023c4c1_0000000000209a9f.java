import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
	
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int total = in.nextInt();
		for (int counter = 1; counter <= total; counter++) {

			String row = in.next() + in.nextLine();
			char[] nums = row.toCharArray();
			int currentDepth = 0;
			StringBuffer output = new StringBuffer("");
			for (int i = 0; i < nums.length; i++) {

				int num = Character.getNumericValue(nums[i]);
				int diff = num - currentDepth;
				if (diff > 0) {
					for (int j = 1; j <= diff; j++) {
						output.append("(");
					}
				} else if (diff < 0) {
					for (int j = 1; j <= Math.abs(diff); j++) {
						output.append(")");
					}
				}
				output.append(num);
				currentDepth = num;
			}
			
			if (currentDepth > 0) {
				for (int j = 1; j <= currentDepth; j++) {
					output.append(")");
				}
			}
			
			System.out.println("Case #" + counter + ": " + output);
		}
		in.close();

	}

}
