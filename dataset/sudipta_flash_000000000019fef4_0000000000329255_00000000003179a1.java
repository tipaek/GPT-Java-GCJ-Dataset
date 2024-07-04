import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < t; ++i) {
			
			int u = Integer.parseInt(sc.nextLine());
			

			func(i, u, sc);
		}
		sc.close();

	}

	private static void func(int i, int u, Scanner sc) {
		String res = "";
		Map<Character, Map<Character, Integer>> map = new HashMap<>();
		
		for (int j = 0; j < (Math.pow(10, u) - 1); j++) {

			String arr[] = sc.nextLine().split(" ");
			String data = arr[0];
			if(arr[0].length() != arr[1].length()) {
				continue;
			}
			
			for(int k = 0; k < data.length(); k++) {
				
				char ch = data.charAt(k);
				
				if(map.containsKey(ch)) {
					
					Map<Character, Integer>mp = map.get(ch);
					if(mp.containsKey(arr[1].charAt(k))) {
						mp.put(arr[1].charAt(k), mp.get(arr[1].charAt(k))+1);
					}else {
						
						mp.put(arr[1].charAt(k),1);
					}
				}
				else {
					Map<Character, Integer> newMap = new HashMap<>();
					newMap.put(arr[1].charAt(k), 1);
					
					map.put(ch, newMap);
				}
				
			}
			
			
			
			

		}
		char charr[] = {'0', '1','2','3','4','5','6','7','8','9'};
		
		
		for(int a = 0; a < charr.length; a++) {
			
			char c = charr[a];
			Map<Character, Integer> maps = map.get(c);
			int max = Integer.MIN_VALUE;
			char mch = 'x';
			for(char cx: maps.keySet()) {
				int val = maps.get(cx);
				if(max <= val) {
					max = val;
					mch = cx;
				}
			}
			res += mch;
			
		}
		
			System.out.println("Case #" + ++i + ": " + res);
		
		
	}

}