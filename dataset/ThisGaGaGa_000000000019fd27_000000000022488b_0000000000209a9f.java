import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int i = 0; i<T; i++) {
			String str = sc.next();
			System.out.println("Case #" +(i+1)+": "+mod(str,0));
		}
	}
	public static String mod(String str, int num) {
		if(done(str, num)||str.length()==0) return str;
		if(check(str, num)) return "("+mod(str,num+1)+")";
		int index = 0;
		for(int i = 0; i<str.length(); i++) {
			if(Integer.valueOf(""+str.charAt(i))<=num) {
				index = i;
				break;
			}
		}
		if(index==0) return str.charAt(index)+mod(str.substring(index+1),num);
		return "("+mod(str.substring(0,index), num+1)+")"+str.charAt(index)+mod(str.substring(index+1),num);
		
	}
	public static boolean done(String str, int num) {
		for(int i = 0; i<str.length(); i++) {
			if(isInteger(str.charAt(i))) {
				if(Integer.valueOf(""+str.charAt(i))>num) return false;
			}
		}
		return true;
	}
	public static boolean check(String str, int num) {
		for(int i = 0; i<str.length(); i++) {
			if(isInteger(str.charAt(i))) {
				if(Integer.valueOf(""+str.charAt(i))<=num) return false;
			}
		}
		return true;
	}
	public static boolean isInteger(char c) {
		String str = "0123456789";
		return str.contains(""+c);
	}

}
