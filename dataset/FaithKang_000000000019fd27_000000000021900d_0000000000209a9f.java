import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			String s = sc.next();
			String answer = "";
			for(int i=0;i<s.length();i++) {
				if((i == 0 && s.charAt(i)=='1') || (i>0 && s.charAt(i-1)=='0' && s.charAt(i) == '1')) {
					answer = answer + "("+s.substring(i, i+1);
//					System.out.println("is it really 1? : " + ("1" == s.substring(i, i+1)));
				}
				
				else if((i>0 && s.charAt(i-1) == '1' && s.charAt(i)=='0')){
					answer = answer + ")" + s.substring(i, i+1);
				}
				else {
					answer = answer + s.substring(i, i+1);
				}
				if((i == s.length()-1 && s.charAt(i) =='1')) {
					answer = answer + s.substring(i, i+1)+")";
				}
			}
			System.out.println("Case #"+(test_case)+": "+answer);
		}
		sc.close();
		
	}
}