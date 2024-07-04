import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		for (int test=1; test<=tests;test++) {
			String[] input_string = in.next().split("");
			int[] input_arr = new int[input_string.length];
			for(int i=0; i<input_arr.length; i++) {
				input_arr[i]=Integer.parseInt(input_string[i]);
			}
			print(test, input_arr);
		}
	}
	
	private static void print(int test, int[] input) {
		String result = "Case #"+test+": ";
		int open=0;
		for (int i=0; i<input.length;) {
			if (open==input[i]) {
				result+=input[i];
				i++;
			} else if (open < input[i]) {
				result+="(";
				open++;
			} else if (open > input[i]) {
				result+=")";
				open--;
			}
		}
		while(open>0) {
			result+=')';
			open--;
		}
		System.out.println(result);
	}

}
