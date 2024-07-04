import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		String S[] = new String[101];
		for (int i=0; i<T; i++) {
			S[i] = scanner.next();
		}
		scanner.close();
		
		String ans = "";
		
		for (int i=0; i<T; i++) {
			String[] out = S[i].split("(?<=(.))(?!\\1)");
			System.out.print("Case #" + (i+1) + ": ");
			for (String element : out) {
				switch (element.charAt(0)) {
				case '1':
					element = "(" + element + ")"; break;
				case '2':
					element = "((" + element + "))"; break;
				case '3':
					element = "(((" + element + ")))"; break;
				case '4':
					element = "((((" + element + "))))"; break;
				case '5':
					element = "(((((" + element + ")))))"; break;
				case '6':
					element = "((((((" + element + "))))))"; break;
				case '7':
					element = "(((((((" + element + ")))))))"; break;
				case '8':
					element = "((((((((" + element + "))))))))"; break;
				case '9':
					element = "(((((((((" + element + ")))))))))"; break;
					
				}
				System.out.print(element);
			}
			System.out.println();
		}
			
	}
}

