
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
				long x = s.nextLong();
				String st = s.next();
				arr[i] = new Test(x, st);
				if(arr[i].no == -1) {
					break;
//					continue;
				}
				for(int j = 0; j < arr[i].str.length(); j++) {
					map.put(arr[i].str.charAt(j), null);
				}
			}
			HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
			for(Character key : map.keySet()) {
				map.put(key, 9);
				freq.put(key, 0);
			}
			HashSet<Character> firstPlace = new HashSet<Character>();

			for(int i = 0; i < arr.length; i++) {
				if(arr[i].no == -1) {
					break;
//					continue;
				}
				String num = "" + arr[i].no;
				firstPlace.add(arr[i].str.charAt(0));
				if((int)Math.floor(Math.log10(arr[i].no)) + 1 == arr[i].str.length()) {
					map.put(arr[i].str.charAt(0), Math.min(map.get(arr[i].str.charAt(0)), num.charAt(0) - '0'));
					freq.put(arr[i].str.charAt(0), map.get(arr[i].str.charAt(0)) + 1);
				}
			}
			char[] ans = new char[10];
			for(Character ch : map.keySet()) {
				if(!firstPlace.contains(ch)) {
					map.put(ch, 0);
					ans[0] = ch;
				}
			}
			if(arr[1].no == -1) {
				int[][] temp = new int[9][2];
				int k = 0;
				for(Character ch : freq.keySet()) {
					if(ch == ans[0]) {
						continue;
					}
					temp[k][0] = ch;
					temp[k++][1] = freq.get(ch);
				}
				Arrays.sort(temp, (A, B) -> B[1] - A[1]);
				for(int i = 0; i < temp.length; i++) {
					ans[i + 1] = (char)temp[i][0];
				}
			} else {for(Character ch : map.keySet()) {
				ans[map.get(ch)] = ch;
			}}
//			System.out.println();
			
			System.out.println("Case #" + testCase++ + ": " + new String(ans));
		}

	}

}

class Test  {
	long no;
	String str;
	Test(long n, String s) {
		no = n;
		str = s;
	}
}