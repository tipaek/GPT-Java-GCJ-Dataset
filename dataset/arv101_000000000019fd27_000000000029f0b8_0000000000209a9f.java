import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int q = 1; q <= T; q++) {
			
			String line = in.readLine();
			
			int[] numbers = new int[line.length()];
			
			for(int s = 0; s < line.length(); s++) {
				numbers[s] = Integer.parseInt(line.substring(s,s+1));
			}
			
			String answer1 = "";
			for(int i = 0; i < line.length(); i++) {
				for(int x = 0; x < numbers[i]; x++) {
					answer1 = answer1 + '(';
				}
				answer1 = answer1 + numbers[i];
				for(int x = 0; x < numbers[i]; x++) {
					answer1 = answer1 + ')';
				}
			}
			boolean broYes = true;
			while(broYes) {
			for(int i = 0; i < answer1.length(); i++) {
				int x = i + 1;
				if(x == answer1.length())
					break;
				if(answer1.charAt(i) == ')' && answer1.charAt(x) == '(') {
					answer1 = charRemoveAt(answer1,i);
					answer1 = charRemoveAt(answer1,i);
				}
			}
			broYes = keepGoing(answer1);
			}		
			System.out.println("Case #" + q + ": " + answer1);
		}
	}
		
	public static String charRemoveAt(String str, int p) {  
		return str.substring(0, p) + str.substring(p + 1);  

	}
	public static boolean keepGoing(String str) {
		for(int i = 0; i < str.length(); i++) {
			
			if(i + 1 == str.length())
				break;
			if(str.charAt(i) == ')' && str.charAt(i + 1) == '(') {
				return true;
			}
		}
		return false;
		
		
	}
}