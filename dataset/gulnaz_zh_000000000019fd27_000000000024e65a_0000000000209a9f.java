import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NestingDepth {
	
	private static Scanner scanner;
	
	public static List<Character> nesting(String input) {
		List<Character> res = new ArrayList<>();
		int[] n = new int[input.length()];
		n[0] = Character.getNumericValue((input.charAt(0)));
		for (int j=0; j<n[0]; j++) {
			res.add('(');
		}
		res.add(Character.forDigit(n[0], 10));
		for (int j=0; j<n[0]; j++) {
			res.add(')');
		}
		int i=1;
		int begin = n[i-1]+i, end = 0;
		boolean ch = false;
		for (; i<input.length(); i++) {
			n[i] = Character.getNumericValue((input.charAt(i)));			
			if (n[i] > n[i-1]) {
				ch = true;
				int count = n[i]-n[i-1];
				while (count != 0) {
					res.add(begin, '(');
					count--;
				}
				end = begin+n[i] - n[i-1];
				res.add(end, Character.forDigit(n[i], 10));
				while (count != n[i]-n[i-1]) {
					res.add(end+1, ')');
					count++;
				}
				begin = begin + n[i]-n[i-1];
			}
			else if (n[i] < n[i-1]) {
				begin = begin + n[i-1]-n[i];
				if (ch == true) begin ++;
				res.add(begin, Character.forDigit(n[i], 10));
				begin++;
			} else {
				res.add(begin, Character.forDigit(n[i], 10));
				begin += 2;
			}
		}
			
		return res;
	}

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		scanner.skip("[\r\n]+");
		String[] input = new String[cases];
		for (int i=0; i<cases; i++) {
			input[i] = scanner.nextLine();
		}
		
        for (int i=0; i<cases; i++) {
        	int k=i+1;
        	List<Character> res = nesting(input[i]);
            System.out.print("Case #" +k+": ");
            for (int j=0; j<res.size(); j++) {
            	System.out.print(res.get(j));
            }
            System.out.print("\n");
        }  
	}

}
