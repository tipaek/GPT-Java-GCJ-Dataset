import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, String> map = new HashMap<String, String>();
		
		map.put("2_2"," 1 2## 2 1");
		map.put("2_4"," 2 1## 1 2");
		map.put("3_3"," 1 3 2## 2 1 3## 3 2 1");
		map.put("3_6"," 3 2 1## 2 1 3## 1 3 2");
		map.put("3_9"," 3 2 1## 1 3 2## 2 1 3");
		map.put("4_4"," 1 4 3 2## 4 1 2 3## 3 2 1 4## 2 3 4 1");
		map.put("4_6"," 2 4 3 1## 4 1 2 3## 3 2 1 4## 1 3 4 2");
		map.put("4_7"," 3 4 2 1## 2 1 3 4## 4 2 1 3## 1 3 4 2");
		map.put("4_8"," 4 3 2 1## 2 1 4 3## 3 2 1 4## 1 4 3 2");
		map.put("4_9"," 4 3 2 1## 2 1 3 4## 3 4 1 2## 1 2 4 3");
		map.put("4_10"," 4 3 2 1## 3 1 4 2## 2 4 1 3## 1 2 3 4");
		map.put("4_11"," 4 3 2 1## 3 1 4 2## 1 2 3 4## 2 4 1 3");
		map.put("4_12"," 4 3 2 1## 3 2 1 4## 2 1 4 3## 1 4 3 2");
		map.put("4_13"," 4 3 2 1## 2 4 1 3## 1 2 3 4## 3 1 4 2");
		map.put("4_14"," 4 3 2 1## 3 4 1 2## 2 1 3 4## 1 2 4 3");
		map.put("4_16"," 4 3 2 1## 3 4 1 2## 2 1 4 3## 1 2 3 4");
		map.put("5_5"," 1 5 4 3 2## 5 1 3 2 4## 4 2 1 5 3## 3 4 2 1 5## 2 3 5 4 1");
		map.put("5_7"," 2 5 4 3 1## 5 1 3 2 4## 4 2 1 5 3## 3 4 2 1 5## 1 3 5 4 2");
		map.put("5_8"," 3 5 4 2 1## 5 1 2 4 3## 4 2 1 3 5## 2 3 5 1 4## 1 4 3 5 2");
		map.put("5_9"," 4 5 3 2 1## 5 1 2 4 3## 3 2 1 5 4## 2 3 4 1 5## 1 4 5 3 2");
		map.put("5_10"," 5 4 3 2 1## 4 1 2 5 3## 3 2 1 4 5## 2 3 5 1 4## 1 5 4 3 2");
		map.put("5_11"," 5 4 3 2 1## 4 1 5 3 2## 3 2 1 5 4## 2 3 4 1 5## 1 5 2 4 3");
		map.put("5_12"," 5 4 3 2 1## 4 2 1 5 3## 3 1 2 4 5## 2 3 5 1 4## 1 5 4 3 2");
		map.put("5_13"," 5 4 3 2 1## 4 2 5 1 3## 2 3 1 4 5## 1 5 2 3 4## 3 1 4 5 2");
		map.put("5_14"," 5 4 3 2 1## 4 3 2 1 5## 2 5 1 4 3## 1 2 5 3 4## 3 1 4 5 2");
		map.put("5_15"," 5 4 3 2 1## 4 3 5 1 2## 3 2 1 5 4## 2 1 4 3 5## 1 5 2 4 3");
		map.put("5_16"," 5 4 3 2 1## 4 5 2 1 3## 3 2 1 5 4## 2 1 4 3 5## 1 3 5 4 2");
		map.put("5_17"," 5 4 3 2 1## 4 3 5 1 2## 1 5 2 4 3## 2 1 4 3 5## 3 2 1 5 4");
		map.put("5_18"," 5 4 3 2 1## 4 3 5 1 2## 3 2 1 5 4## 1 5 2 4 3## 2 1 4 3 5");
		map.put("5_19"," 5 4 3 2 1## 4 3 5 1 2## 3 1 2 5 4## 2 5 1 4 3## 1 2 4 3 5");
		map.put("5_20"," 5 4 3 2 1## 4 5 2 1 3## 3 2 1 5 4## 1 3 5 4 2## 2 1 4 3 5");
		map.put("5_21"," 5 4 3 2 1## 4 5 2 1 3## 2 1 5 3 4## 3 2 1 4 5## 1 3 4 5 2");
		map.put("5_22"," 5 4 3 2 1## 4 5 2 1 3## 3 1 5 4 2## 1 2 4 3 5## 2 3 1 5 4");
		map.put("5_23"," 5 4 3 2 1## 3 5 2 1 4## 2 1 4 5 3## 1 3 5 4 2## 4 2 1 3 5");
		map.put("5_25"," 5 4 3 2 1## 4 5 2 1 3## 3 1 5 4 2## 2 3 1 5 4## 1 2 4 3 5");

		int cases = sc.nextInt();

		for (int cs = 1; cs <= cases; cs++) {

			int n = sc.nextInt();

			int k = sc.nextInt();
			
			String key = n + "_" + k;
			
			String val = null;
			
			if(map.containsKey(key)) {
				val = map.get(key);
			}

			System.out.println("Case #" + cs + ": " + ((val == null)?"IMPOSSIBLE" : "POSSIBLE"));
			
			if(val != null) {
				String []lines = val.split("##");
				
				for(String line : lines) {
					System.out.println(line.trim());
				}
			}
		}
		
		sc.close();
	}
}