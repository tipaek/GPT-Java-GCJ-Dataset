import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int t = scn.nextInt();
		for (int _case_ = 1; _case_ <= t; _case_++) {
			ans.append("Case #").append(_case_).append(": ");
			
			//code
			int n=scn.nextInt();
			String main="";
			String[] array=new String[n];
			for (int i = 0; i < n; i++) {
				String str=scn.next();
				array[i]=str;
				if (str.length()>main.length()){
					main=str;
				}
			}
			int len=main.length();
			boolean flag=false;
			for (int i = 0; i < n; i++) {
				if (!check(main,array[i])){
					ans.append("*");
					flag=true;
					break;
				}
			}
			if (!flag){
				ans.append(main.substring(1));
			}
			
			ans.append("\n");
		}
		System.out.println(ans);
	}
	
	private static boolean check(String main, String s) {
		
		for (int i = main.length()-1,j=s.length()-1; s.charAt(j)!='*' ; i--,j--) {
			if (main.charAt(i)!=s.charAt(j)){
				return false;
			}
		}
		return true;
	}
	
}
