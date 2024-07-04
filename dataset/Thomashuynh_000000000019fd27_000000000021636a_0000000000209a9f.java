import java.util.*;

public class Solution {
	static Scanner CONSOLE = new Scanner(System.in);
	static String getOpen(int n) {
		String result="";
		for (int i=0;i<n;i++) {
			result+='(';
		}
		return result;
	}
	static String getClose(int n) {
		String result="";
		for (int i=0;i<n;i++) {
			result+=')';
		}
		return result;
	}
	static String getResult(String s) {
		String dummie = "";
		for (int i=0;i<s.length();i++) {
			int data = Integer.parseInt(""+s.charAt(i));
			dummie = dummie + getOpen(data)+data+getClose(data);
		}
		while (dummie.contains(")(")){
			int index = dummie.indexOf(")(");
			dummie = dummie.substring(0, index) + dummie.substring(index+2);
		}
		return dummie;
	}
	static String getTest() {
		String s = CONSOLE.next();
		return getResult(s);
	}
	static void printResult(String[] result) {
		int index=1;
		for (String s:result) {
			System.out.printf("Case #%d: %s\n", index, s);
			index++;
		}
	}
	public static void main(String[]args) {
		int test = CONSOLE.nextInt();
		String[] result = new String[test];
		for (int i=0;i<test;i++) {
			result[i] = getTest();
		}
		printResult(result);
	}
}
