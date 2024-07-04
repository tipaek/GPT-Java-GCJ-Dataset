import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.valueOf(sc.nextLine());
		for(int t =1; t<=T;t++) {
			int nb = 0;
			int offset = 0;
			String line = sc.nextLine();
			String[] numbers = line.split("");
			StringBuilder res = new StringBuilder(line);
			for(int i=0; i<numbers.length; i++) {
				int n = Integer.valueOf(numbers[i]);
				while(nb<n) {
					res.insert(offset++, '(');
					nb++;
				}
				while(nb>n) {
					res.insert(offset++, ')');
					nb--;
				}
				offset++;
			}
			while(nb>0) {
				res.insert(offset++, ')');
				nb--;
			}
			String s = res.toString();
			System.out.println("Case #" + t + " " + s);
		}
		
		sc.close();
	}

}
