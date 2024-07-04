import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t, k = 0;
		t = sc.nextInt();
		while(t-- > 0) {
			++k;
			int n;
			int d;
			n = sc.nextInt();
			d = sc.nextInt();
			long arr[] = new long[n];
			HashMap<Long, Long> mp=new HashMap<>();
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
				mp.put(arr[i], mp.getOrDefault(arr[i], 0l) + 1l);

			}
			long maxa = 0;
			Iterator itr = mp.entrySet().iterator();
			while(itr.hasNext()) {
				Map.Entry pair = (Map.Entry)itr.next();
				if((Long)pair.getValue() > maxa)
					maxa = (Long)pair.getValue();

			}
			Arrays.sort(arr);
			long f = 0;
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					if(arr[j] == 2 * arr[i])
						f = 1;
				}
			}
			long ans;
			if(d == 2 || d == 1) {
				ans = d - maxa;
			} else {
				long o = 1;
				if(f == 1)
					ans = Math.min(d - maxa, o);
				else
					ans = d - maxa;
			}
			System.out.println("Case #" + k + ": " + ans);
		}
	}
}
