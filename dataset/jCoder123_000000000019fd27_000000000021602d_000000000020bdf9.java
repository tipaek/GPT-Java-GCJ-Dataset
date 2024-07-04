import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);	
	        
	        int T = input.nextInt();
	        
	        ArrayList<String> results = new ArrayList<String>();
	        
	        for (int ks = 1; ks <= T; ks++) {
	            results.add(String.format("Case #%d: %s", ks, solve(input)));
	        }
	        
	        for (int i = 0; i < results.size();i++) {
	        	System.out.println(results.get(i));
	        }
	}
	
	public static String solve(Scanner input) {
		int N = input.nextInt();
		int jVal = 0;
		int cVal = 0;
		String result = "";
		char[] resultArray = new char[N];
		Map<Double, Integer> hash = new HashMap<>();
		Map<Double, Integer> indices = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			int key = input.nextInt();
			int value = input.nextInt();
			
			if (hash.containsKey((double)key)) {
				double newKey = key;
				while(!(hash.containsKey(newKey))) {
					newKey += 0.001;
				}
				hash.put(newKey, value);
				indices.put(newKey, i);
				
			}
			else {
				hash.put((double) key, value);
				indices.put((double) key, i);

			}
			
		}
		
		List<Double> keys = new ArrayList<>(hash.keySet());
		
		Collections.sort(keys);
		
		for (double keyValue: keys) {
			int value = hash.get(keyValue);
			int key = (int) (keyValue);
			
			if (cVal <= key) {
				resultArray[indices.get(keyValue)] = 'C';
				cVal = value;
			}
			else if (jVal <= key) {
				resultArray[indices.get(keyValue)] = 'J';
				jVal = value;
			}
			else {
				result = "IMPOSSIBLE";
				break;
			}
		}
		
		if (result.equals("IMPOSSIBLE") == false) {
			for (int k = 0; k < resultArray.length; k++) {
				result += Character.toString(resultArray[k]);
			}	
		}
			
		return result;

	}

}
