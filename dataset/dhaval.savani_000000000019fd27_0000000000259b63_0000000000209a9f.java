import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	private static String op;

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			for(int i = 1; i <= t; i++) {
				String n = scanner.next();
				//Splitting each numbers
				int[] nums = Arrays.stream(n.split("|"))
								   .mapToInt(v -> Integer.parseInt(v))
								   .toArray();
				
				//Making output string blank for each test case
				op = "";
				for (int j = 0; j < nums.length; j++) {
					int num = nums[j];
					
					//If number is zero
					//and if it is first character then just append it
					//else close braces and then append it
					if(num == 0) {
						op += "0";
						continue;
					}
					
					//If not zero, then
					//if its first character then append open braces that number times then number then close braces of next numbers difference if its lower
					//else if the previous number is lower then appending open braces and number and close braces of next numbers difference if its lower
					//else just append number and close braces of next numbers difference if its lower
					if(j == 0) {
						appendOpenBraces(num);
						op += num;
					} else {
						appendOpenBraces(num - nums[j -1]);
						op += num;
					}
					//Checking if last number is reached
					//if yes then closing all braces
					//else closing the difference if next number is lower
					if(j == nums.length - 1) {
						appendCloseBraces(num);
					} else {
						appendCloseBraces(num - nums[j + 1]);
					}
				}
				System.out.println("Case #" + i + ": " + op);
			}
		}
	}
	
	public static void appendOpenBraces(int times) {
		if(times > 0) {
			String str = "";
			for(int i = 0; i < times; i++) {
				str += "(";
			}
			op += str;
		}
	}
	
	public static void appendCloseBraces(int times) {
		if(times > 0) {
			String str = "";
			for(int i = 0; i < times; i++) {
				str += ")";
			}
			op += str;
		}
	}
}