import java.util.*;
import java.util.stream.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numTests  = scanner.nextInt();
		
		for(int i = 0; i < numTests; i++) {
			String s = scanner.next();
			String res = result(s);
			System.out.println("Case #" + (i + 1) + ": " + res);
		}
	}


	static String result(String s) {
		Set<Character> digits = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			digits.add(s.charAt(i));
		}

		List<Character> sortedDigits = digits.stream().sorted().collect(Collectors.toList());
		
		//System.out.println(sortedDigits);
		
		String res = new String(s);
		for(Character digit: sortedDigits) {
			
			int lastIndex = -1;
			int index = res.indexOf(digit, lastIndex + 1);
			while(index > lastIndex) {
				//System.out.println("res:" + res);
				int left = index, right = index;

				while(left >= 0 && res.charAt(left) != '(' && res.charAt(left) >= digit ) {
					left--;
				}
			
				int leftInsert = 0;
				if(left == -1) leftInsert = digit - '0';
				if(left > 0 && res.charAt(left) != '(') leftInsert = digit - res.charAt(left);

				//System.out.println(" leftInsert :" + leftInsert );
				//System.out.println("res after left:" + res);

				while(right < res.length() && res.charAt(right) != ')' && res.charAt(right) >= digit ) {
					right++;
				}
			
				int rightInsert = 0;
				if(right == res.length()) rightInsert = digit - '0';
				if(right < res.length() && res.charAt(right) != ')') rightInsert = digit - res.charAt(right);

				//System.out.println("rightinsert :" + rightInsert );
				int insert = Math.max(leftInsert, rightInsert);
				//System.out.println("insert :" + insert);
				res = res.substring(0, left + 1) + new String(new char[insert]).replace("\0", "(") 
					+ res.substring(left + 1);

				right += insert;
				res = res.substring(0, right) + new String(new char[insert]).replace("\0", ")") + res.substring(right);
				//System.out.println("res after right:" + res);


				lastIndex = index + insert;
				index = res.indexOf(digit, lastIndex + 1);
			}
		}

		//System.out.println("res before return:" + res);
		return res;
	}

}