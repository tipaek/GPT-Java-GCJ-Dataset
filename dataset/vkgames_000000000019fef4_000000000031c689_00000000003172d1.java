import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int c =0;
		while(t>0) {
			t--;
			c++;
			int n= sc.nextInt();
			int d = sc.nextInt();
			long [] a=  new long[n];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextLong();
			}
			Arrays.sort(a);
			HashMap<Long, Integer> freq = new HashMap<Long, Integer>();
			for(int i=0;i<n;i++) {
				freq.put(a[i],freq.getOrDefault(a[i],0)+1);
			}
			if(d==3) {
				int numCuts = 2;
				Iterator it = freq.entrySet().iterator();
				while(it.hasNext()) {
					Map.Entry pair = (Map.Entry)it.next();
					long key = (long)pair.getKey();
					int val=  (int)pair.getValue();
					if(key%2==0) {
						if(freq.containsKey(key/2)) {
							numCuts = 1;
						}
					}
					if(val==2 && key!=a[n-1]) {
						numCuts =1;
					}
				}
				for(int i=0;i<n;i++) {
					if(freq.get(a[i])>=3) {
						numCuts =0;
					}
				}
				System.out.println("Case #"+c+": "+numCuts);

			}
			else {
				int numCuts = 1;
				for(int i=0;i<n;i++) {
					if(freq.get(a[i])>=2) {
						numCuts =0;
					}
				}
				System.out.println("Case #"+c+": "+numCuts);
			}
			//at most 2 cuts....
		}
	}
}
