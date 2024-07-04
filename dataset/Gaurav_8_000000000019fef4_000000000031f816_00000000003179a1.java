
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void func(ArrayList<Character> list, int[] arr, Test[] query, int idx) {
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt(), testCase = 1;
		while(testCase <= t) {
			Test[] arr = new Test[10000];
			int u = s.nextInt();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for(int i = 0; i < arr.length; i++) {
				int x = s.nextInt();
				String st = s.next();
				arr[i] = new Test(x, st);
				if(arr[i].no == -1) {
					continue;
				}
				for(int j = 0; j < arr[i].str.length(); j++) {
					map.put(arr[i].str.charAt(j), null);
				}
			}
			for(Character key : map.keySet()) {
				map.put(key, 9);
			}
			HashSet<Character> firstPlace = new HashSet<Character>();
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].no == -1) {
					continue;
				}
				String num = "" + arr[i].no;
				firstPlace.add(arr[i].str.charAt(0));
				if((int)Math.floor(Math.log10(arr[i].no)) + 1 == arr[i].str.length()) {
					map.put(arr[i].str.charAt(0), Math.min(map.get(arr[i].str.charAt(0)), num.charAt(0) - '0'));
				}
			}
			for(Character ch : map.keySet()) {
				if(!firstPlace.contains(ch)) {
					map.put(ch, 0);
				}
			}
			char[] ans = new char[10];
			for(Character ch : map.keySet()) {
				ans[map.get(ch)] = ch;
			}
//			System.out.println();
			
			System.out.println("Case #" + testCase++ + ": " + new String(ans));
		}

	}

}

class Test  {
	int no;
	String str;
	Test(int n, String s) {
		no = n;
		str = s;
	}
}