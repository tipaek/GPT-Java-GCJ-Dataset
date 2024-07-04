import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static String consolidate(String s) {
		int index1 = s.indexOf("*");
		int index2 = s.indexOf("*", index1 + 1);
		if(index1 + 1 == index2) {
			s = s.substring(0, index1) + s.substring(index2);
			return consolidate(s);
		}
		else if(index2 != -1){
			return s.substring(index2);
		}
		else {
			return s;
		}
	}
	
	public static String flip(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i += 1) {
			result += s.substring(s.length() - 1 - i, s.length() - 1 - i + 1);
		}
		return result;
	}
	
	public static String merger(String s1, String s2) {
		String temp1 = consolidate(s1);
		String temp2 = consolidate(s2);
		
		int s1Index = temp1.indexOf("*");
		int s2Index = temp2.indexOf("*");
		int s1Counter = 0;
		int s2Counter = 0;
		String answer = "";
		
		while(s1Counter < s1Index && s2Counter < s2Index) {
			String s1Char = temp1.substring(s1Counter, s1Counter + 1);
			String s2Char = temp2.substring(s2Counter, s2Counter + 1);
			if(!s1Char.equals(s2Char)) {
				return "*";
			}
			else {
				answer += s1Char;
			}
			s1Counter += 1;
			s2Counter += 1;
		}
		
		while(s1Counter < s1Index) {
			String s1Char = temp1.substring(s1Counter, s1Counter + 1);
			answer += s1Char;
			s1Counter += 1;
		}
		
		while(s2Counter < s2Index) {
			String s2Char = temp2.substring(s2Counter, s2Counter + 1);
			answer += s2Char;
			s2Counter += 1;
		}
		
		answer += "*";
		temp1 = flip(temp1);
		temp2 = flip(temp2);
		s1Index = temp1.indexOf("*");
		s2Index = temp2.indexOf("*");
		s1Counter = 0;
		s2Counter = 0;
		while(s1Counter < s1Index && s2Counter < s2Index) {
			String s1Char = temp1.substring(s1Counter, s1Counter + 1);
			String s2Char = temp2.substring(s2Counter, s2Counter + 1);
			if(!s1Char.equals(s2Char)) {
				return "*";
			}
			else {
				answer = answer.substring(0, answer.length() - s1Counter) + s1Char + answer.substring(answer.length() - s1Counter);
			}
			s1Counter += 1;
			s2Counter += 1;
		}
		
		while(s1Counter < s1Index) {
			String s1Char = temp1.substring(s1Counter, s1Counter + 1);
			answer = answer.substring(0, answer.length() - s1Counter) + s1Char + answer.substring(answer.length() - s1Counter);
			s1Counter += 1;
		}
		
		while(s2Counter < s2Index) {
			String s2Char = temp2.substring(s2Counter, s2Counter + 1);
			answer = answer.substring(0, answer.length() - s2Counter) + s2Char + answer.substring(answer.length() - s2Counter);
			s2Counter += 1;
		}
		
		return answer;
	}
	
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		int t = kboard.nextInt();
		for(int i = 1; i <= t; i += 1) {
			int n = kboard.nextInt();
			ArrayList<String> list = new ArrayList<String>();
			for(int j = 0; j < n; j += 1) {
				list.add(kboard.next());
			}
			
			String answer = "";
			while(list.size() > 1) {
				String merged = merger(list.get(0), list.get(1));
				if(merged.equals("*")) {
					answer = "*";
					break;
				}
				else if (list.size() > 2) {
					answer = merged;
					list.set(0, merged);
					list.remove(1);
				}
				else {
					answer = merged.replaceAll("\\*", "");
					list.remove(1);
				}
			}
			
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}
