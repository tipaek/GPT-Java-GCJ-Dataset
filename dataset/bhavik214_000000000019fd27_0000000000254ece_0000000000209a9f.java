import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	
	public static void prepareSolution(StringBuilder builder, int angleCount, char angle) {
		for(int i = 0; i < angleCount; i++)
			builder.append(angle);
	}
	
	public static void prepareSolution(int prev, int next, StringBuilder builder) {
		
		if(prev == Integer.MIN_VALUE) {
			
			prepareSolution(builder, next, '(');
			
		} else if (next == Integer.MAX_VALUE) {
			
			prepareSolution(builder, prev, ')');

			return;
			
		} else if(prev > next) {

			prepareSolution(builder, prev - next, ')');
			
		} else if (prev < next) {

			prepareSolution(builder, next - prev, '(');
			
		} 
		
		builder.append(next);
		
	}

	public static void solve(Scanner scanner, int caseNumber) {

		StringBuilder builder = new StringBuilder(102400);
		builder.append("Case #" + caseNumber + ": ");
		
		String str = scanner.next();
		
		char [] cArr = str.toCharArray();
		
		prepareSolution(Integer.MIN_VALUE, Character.getNumericValue(cArr[0]), builder);
		
		int length = cArr.length - 1; 
		for(int i = 1; i < length; i++) {
			prepareSolution(Character.getNumericValue(cArr[i - 1]), Character.getNumericValue(cArr[i]), builder);	
		}
		
		if(length > 0) {
			prepareSolution(Character.getNumericValue(cArr[length-1]), Character.getNumericValue(cArr[length]), builder);
		}
		prepareSolution(Character.getNumericValue(cArr[length]), Integer.MAX_VALUE, builder);
		
		System.out.println(builder.toString());
		System.out.flush();
	}
	
	public static void main(String args[]) throws IOException {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		
		int t = scanner.nextInt();
		
		for(int i = 1; i <= t; i++) {
			solve(scanner, i);
		}
	}

}