
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		int cas = 1;
		while (t-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			Long[] arr = new Long[n];
			for(int i = 0 ; i < arr.length ; i++) {
				arr[i] = s.nextLong();
			}
			Arrays.sort(arr);
			boolean ch = false;
			for(int i = 0  ; i < n ;i++) {
				for(int j = i+1; j<n ;j++) {
					if(arr[j] == 2L*arr[i])
						ch =true;
				}
			}
			
			boolean two = false;
			boolean three = false;
			HashMap<Long, Long> map = new HashMap<Long, Long>();
			for(int i = 0  ; i < n ;i++) {
				if(map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i])+1);
				}else {
					map.put(arr[i], (long) 1);
				}
				if(map.get(arr[i])==3) {
					three = true;
					two = true;
				}
				if(map.get(arr[i])==2) {
				//	three = true;
					two = true;
				}
				
			}
			if(m==2) {
				if(two)
				System.out.println("Case #" + cas + ": "+"0");
				else
					System.out.println("Case #" + cas + ": "+"1");
				cas++;

			continue;
			}
			
			
				if(three )
				System.out.println("Case #" + cas + ": "+"0");
				else if (ch)
					System.out.println("Case #" + cas + ": "+"1");
				else
					System.out.println("Case #" + cas + ": "+"2");


			
			cas++;
		}
	}
}
