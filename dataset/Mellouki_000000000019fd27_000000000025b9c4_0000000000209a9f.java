import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
        	String string = in.next();
        	Solution solution = new Solution(string);
        	System.out.println("Case #" + i + ": "+ solution.getSolution());
        }
    }
	
	private int[] numbers;
	private int length;
	public Solution(String string) {
		length = string.length();
		numbers = new int[length];
		for(int i = 0; i < length; i++)
			numbers[i] = string.charAt(i) - '0';
		solution = nest(0, 0);
	}
	
	private String nest(int index, int level) {
		if(index >= length) if(level == 0) return "";
						    else 		   return ")" + nest(index, level - 1);
		
		if(numbers[index] > level) return "(" + nest(index, level + 1);
		if(numbers[index] == level) return "" + numbers[index] + nest(index + 1, level);
		return ")" + nest(index, level - 1);
	}
	
	public String getSolution() {return solution;}
	private String solution;
}
