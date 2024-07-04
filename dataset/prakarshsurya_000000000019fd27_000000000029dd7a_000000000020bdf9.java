import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			int a[] = new int[n];
			Map<Integer, Integer> map = new TreeMap<>();
			for(int j = 0; j < n; j++) {
				int s = scan.nextInt();
				map.put(s, scan.nextInt());
				a[j] = s; 
			}
			String output = "";
			char cam  = 'C';
			char jam = 'J';
			int jCurrEnd = 0;
			int cCurrEnd = 0;
			char[] ch = new char[n];
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			    int start = entry.getKey();
			    int end = entry.getValue();
				if(jCurrEnd <= start) {
					int k = 0;
					while(k < n) {
						if(a[k] == start)
							break;
						k++;
					}
					
			    	ch[k]= jam;
			    	jCurrEnd = end;
			    } else if(cCurrEnd <= start ) {
			    	int k = 0;
					while(k < n) {
						if(a[k] == start)
							break;
						k++;
					}
			    	ch[k]= cam;
			    	cCurrEnd = end;
			    } else {
			    	output = "IMPOSSIBLE";
			    	break;
			    }
			}
			if(!output.equals("IMPOSSIBLE")) {
				
				output = String.valueOf(ch);	
				
			}
			System.out.println("Case #" + i + ": " +output);
		}
		scan.close();
		return;
	}

}
