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
		
		for (int index = 0; index < N; index++) {
			int start = input.nextInt();
			double finish = (double) input.nextInt();
			
			if (hash.containsKey(finish)) {
				double newFinish = finish;
				while(!(hash.containsKey(newFinish))) {
					newFinish += 0.001;
				}
				hash.put(newFinish, start);
				indices.put(newFinish, index);
			}
			else {
				hash.put(finish, start);
				indices.put(finish, index);
			}
			
		}
		
		List<Double> keys = new ArrayList<>(hash.keySet());
		
		Collections.sort(keys);
		
		for (double keyValue: keys) {
			int startTime = hash.get(keyValue);
			int finishTime = (int) (keyValue);
			
			if (startTime >= cVal && startTime >= jVal) {
				if (cVal > jVal) {
					resultArray[indices.get(keyValue)] = 'C';
					cVal = finishTime;
					continue;
				}
				else {
					resultArray[indices.get(keyValue)] = 'J';
					jVal = finishTime;
					continue;
				}
			}
			else if (startTime >= cVal) {
				resultArray[indices.get(keyValue)] = 'C';
				cVal = finishTime;
				continue;
			}
			else if (startTime >= jVal) {
		    	resultArray[indices.get(keyValue)] = 'J';
				jVal = finishTime;
				continue;
			}
			result = "IMPOSSIBLE";
			break;
		}
		
		if (result.equals("IMPOSSIBLE") == false) {
			for (int k = 0; k < resultArray.length; k++) {
				result += Character.toString(resultArray[k]);
			}	
		}
			
		return result;

	}

}
