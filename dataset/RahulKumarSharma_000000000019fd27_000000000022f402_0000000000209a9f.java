import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = Integer.parseInt(sc.nextLine());

		for (int cs = 1; cs <= cases; cs++) {

			String input = sc.nextLine();

			char[] inputChars = input.toCharArray();

			int []nums = new int[inputChars.length];
			
			for(int i = 0; i < nums.length; i++) {
				nums[i] = inputChars[i] - '0';
				
			}
			
			StringBuffer output = new StringBuffer();

			int openingBracketCount = nums[0];
			
			for(int j = 0; j < openingBracketCount; j++ )
				output.append("(");
			
			output.append(nums[0]);
			
			for(int i = 1; i < nums.length; i++) {
				
				if(nums[i] > nums[i - 1]) {
					for(int j = 0; j < nums[i] - nums[i - 1]; j++ )
						output.append("(");
					
					
					
				} else if (nums[i] < nums[i - 1]) {
					for(int j = 0; j < nums[i - 1] - nums[i]; j++ )
						output.append(")");
				}
			
				openingBracketCount += (nums[i] - nums[i - 1]);
				output.append(nums[i]);
			}
			
			for(int j = 0; j < openingBracketCount; j++ )
				output.append(")");
			
			System.out.println("Case #" + cs + ": " + output);
		}

		sc.close();
	}
}
