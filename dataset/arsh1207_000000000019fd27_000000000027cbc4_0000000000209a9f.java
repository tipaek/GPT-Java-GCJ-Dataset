import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			int test = Integer.parseInt(br.readLine());
			for (int t = 0; t < test; t++) {
				String arr[] = br.readLine().split("");
				List<String> with_paranthesis = new ArrayList<String>();
				Stack<String> paranthesis = new Stack<String>();
				int counter = 0;
				for (int i = 0; i < arr.length; i++) {
					int digit = Integer.parseInt(arr[i]);
					if (digit > counter) {
						for (int j = 0; j < digit-counter; j++) {
							counter++;
							with_paranthesis.add("(");
							paranthesis.add("(");
						}
						with_paranthesis.add(arr[i]);
					}
					else if(digit < counter) {
						for (int j = 0; j < counter - digit; j++) {
							counter--;
							with_paranthesis.add(")");
							paranthesis.pop();
						}
						with_paranthesis.add(arr[i]);
					}
					else {
						with_paranthesis.add(arr[i]);
					}
				}
				for (int j = 0; j < counter; j++) {
					with_paranthesis.add(")");
					paranthesis.pop();
				}
				String result = "";
				for (String s: with_paranthesis) {
					result = result + s;
				}
				System.out.println("Case #"+(t+1)+": "+result);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}