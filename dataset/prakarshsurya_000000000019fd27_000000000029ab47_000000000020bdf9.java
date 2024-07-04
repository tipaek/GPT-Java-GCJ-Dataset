import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			Map<Integer, Integer> map = new TreeMap<>();
			for(int j = 0; j < n; j++) {
				map.put(scan.nextInt(), scan.nextInt());
			}
			String output = "";
			String cam  ="C";
			String jam = "J";
			int jCurrEnd = 0;
			int cCurrEnd = 0;
			
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			    int start = entry.getKey();
			    int end = entry.getValue();
				if(jCurrEnd <= start) {
			    	output = output + jam;
			    	jCurrEnd = end;
			    } else if(cCurrEnd <= start ) {
			    	output = output + cam;
			    	cCurrEnd = end;
			    } else {
			    	output = "IMPOSSIBLE";
			    	break;
			    }
			    
			}

			System.out.println("Case #" + ( i + 1 )+ ": " +output);
		}
	}

}
