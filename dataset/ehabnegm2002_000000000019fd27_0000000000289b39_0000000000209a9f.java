import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
		
		int cases = scanner.nextInt();

        for (int testCase = 1; testCase <= cases; testCase++) {
            
        	String str = scanner.next();
        	
        	int[] nums = new int[str.length()];
        	
        	for (int c = 0; c < nums.length; c++)
        		nums[c] = Character.getNumericValue(str.charAt(c));
            
            System.out.println("Case #" + testCase + ": " + generateString(nums, 0, nums.length - 1, 0));
        }
        
        scanner.close();
    }

	public static String generateString(int[] array, int left, int right, int prevParen) {
		
		StringBuilder sb = new StringBuilder();
		
		int min = getMin(array, left, right);
		
		for (int i = 0; i < min - prevParen; i++) {
			sb.append("(");
		}
		
		if (left == right) {
			sb.append(array[left]);
		}
		else {
			int fPointer = left;
			int sPointer = right;
			
			while (fPointer <= right && sPointer <= right) {
				while (fPointer <= right && array[fPointer] == min) {
					sb.append(array[fPointer]);
					fPointer++;
				}
				
				if (fPointer > right)
					break;
				
				sPointer = fPointer;
				
				while (sPointer <= right && array[sPointer] != min) 
					sPointer++;
				sPointer--;
				
				sb.append(generateString(array, fPointer, sPointer, min));
				fPointer = sPointer + 1;
			}
		}
		
		for (int i = 0; i < min - prevParen; i++) {
			sb.append(")");
		}
		
		return sb.toString();
	}

	private static int getMin(int[] array, int start, int end) {
		
		int min = Integer.MAX_VALUE;
		
		for (int index = start; index <= end; index++) {
			if(array[index]<min) 
				min = array[index];
		}
		
		return min;
	}
}