import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(scan.readLine());

		outer: for (int cases = 1; cases <= t; cases++) {
			int len = Integer.parseInt(scan.readLine());
			
			HashMap<Character, Integer> map = new HashMap<>();
			HashSet<Character> set = new HashSet<>();
			
			for(int line = 0; line < 10000;line++){
				String[] inp = scan.readLine().split(" ");
				for(char c: inp[1].toCharArray()){
					set.add(c);
				}
				
				if(inp[1].length() == len){
					if(!map.containsKey(inp[1].charAt(0))){
						map.put(inp[1].charAt(0),0);
					}
					map.put(inp[1].charAt(0), map.get(inp[1].charAt(0)) +1);
				}
			}
			String reString = "";
			for(int i = 0; i <9;i++){
				int max = 0;
				char maxc = '-';
				for(char key : map.keySet()){
					if(map.get(key) > max){
						maxc = key;
						max = map.get(key);
					}
				}
				reString = reString + maxc;
				map.remove(maxc);
				set.remove(maxc);
			}
			
			for(char c : set){
				reString = c + reString;
			}
			
			System.out.println("Case #"+ cases + ":" + " " + reString);
			
			
			
		}

	}

}
