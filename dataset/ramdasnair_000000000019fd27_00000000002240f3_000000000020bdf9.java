import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int x = 0; x < t; x++) {

			int n = sc.nextInt();
			
			int[] s = new int[n];
			int[] e = new int[n];
			
			for(int i=0; i < n; i++) {
				s[i] = sc.nextInt();
				e[i] = sc.nextInt();
			}
			
			Map<Integer, String> cMap = new HashMap<Integer, String>();
			Map<Integer, String> jMap = new HashMap<Integer, String>();
			
			boolean impossible = false;
			StringBuilder sDash = new StringBuilder();
			
			for(int i=0; i < n; i++) {
				
				if (cMap.get(Integer.valueOf(s[i])) == null
						&& cMap.get(Integer.valueOf(e[i])) == null
						&& jMap.get(Integer.valueOf(s[i])) == null
						&& jMap.get(Integer.valueOf(e[i])) == null) {
					
					for(int j=s[i]; j < e[i]; j++) {
						cMap.put(Integer.valueOf(j), "Y");
					}
					sDash.append("C");
				} else {
					if ((cMap.get(Integer.valueOf(s[i])) != null
							|| cMap.get(Integer.valueOf(e[i])) != null)) {
						
						if (jMap.get(Integer.valueOf(s[i])) == null
							&& jMap.get(Integer.valueOf(e[i])) == null) {
							for(int j=s[i]; j < e[i]; j++) {
								jMap.put(Integer.valueOf(j), "Y");
							}
							sDash.append("J");
						} else {
							impossible = true;
							break;
						}
					} else if ((jMap.get(Integer.valueOf(s[i])) != null
							|| jMap.get(Integer.valueOf(e[i])) != null)) {
						
						if (cMap.get(Integer.valueOf(s[i])) == null
								&& cMap.get(Integer.valueOf(e[i])) == null) {
								for(int j=s[i]; j < e[i]; j++) {
									cMap.put(Integer.valueOf(j), "Y");
								}
								sDash.append("C");
						} else {
							impossible = true;
							break;
						}
					}
				}
				
			}
			
			String sOut = sDash.toString();
			
			if (impossible) sOut = "IMPOSSIBLE";
			
			System.out.println("Case #" + (x+1) + ": " + sOut);
		}
	}
}
