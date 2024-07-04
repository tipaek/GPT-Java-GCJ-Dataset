import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	
	int testCase;
	String[] input;
	final static String CASE_ = "Case #";
	final static String LEFT = "(";
	final static String RIGHT = ")";
	public void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCase = Integer.parseInt(br.readLine());
			input = new String[testCase+1];
			for (int i=1; i<=testCase; i++) {
				input[i] = br.readLine();
			}
			br.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void solve(int index) {
		StringBuilder builder = new StringBuilder();
		char[] array = input[index].toCharArray();
		int before = 0;
		Stack<String> stack = new Stack<>();
		for (int i=0; i<array.length;i++) {
			int temp = array[i] - '0';
			if (temp > before) {
				for (int j=0;j<temp-before;j++) {
					builder.append(LEFT);
					stack.add(LEFT);
				}
			} else if(temp < before) {
				for (int j=0; j<before-temp; j++) {
					builder.append(RIGHT);
					stack.pop();
				}
			}
			builder.append(temp);
			before = temp;
		}
		while(!stack.isEmpty()) {
			stack.pop();
			builder.append(RIGHT);
		}
		
		System.out.println(CASE_+index+": "+builder.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.input();
		for (int i=1; i<=s.testCase; i++) {
			s.solve(i);
		}
	}

}
