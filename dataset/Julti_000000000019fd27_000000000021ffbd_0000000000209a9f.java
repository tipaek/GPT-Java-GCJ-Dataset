import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t =s.nextInt();
		s.nextLine();
		for (int i = 0; i < t; i++) {
			String a = s.nextLine();
			String x = "";
			for (int j = 1; j < 2; j++) {
				int from = -1;
				int prev =0;
				if(a.charAt(0)=='1') {
					a="("+a;
				}
				a=a.replaceAll("01", "0(1");
				a=a.replaceAll("10", "1)0");
				if(a.charAt(a.length()-1)=='1') {
					a=a+")";
				}
			}
			System.out.println("Case #"+(i+1)+": "+a);
		}
	}
}
