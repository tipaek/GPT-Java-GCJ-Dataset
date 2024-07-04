import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		//int totalTestCases=in.nextInt();
		String totalTestCases=in.nextLine();
		int count=0;
		while(in.hasNext()) {
		    count++;
			String input=in.nextLine();
			char[] arr=input.toCharArray();
			String output=helper(arr, 0);
			System.out.println("Case #"+count+": "+output);
		}
		
//		String input="4";
//		char[] arr=input.toCharArray();
//		String output=helper(arr, 0);
//		System.out.println("Case #"+1+" "+output);
	}
	
	public static String helper(char[] arr, int pos) {
		if(pos>=arr.length) return "";
		String str=helper(arr, pos+1);
		
		//System.out.println(str);
		int digit=arr[pos]-'0';
		if(digit==0) return "0"+str;
		int i=0;
		while(i<str.length()&&i<digit&&str.charAt(i)=='(') i++;
		digit=digit-i;
		//System.out.println(digit);
		StringBuilder sb=new StringBuilder(""+arr[pos]);
		while(digit>0) {
			sb.insert(0, '(');
			sb.append(')');
			digit--;
		}
		
		return str.substring(0, i)+sb.toString()+str.substring(i);
	}
}