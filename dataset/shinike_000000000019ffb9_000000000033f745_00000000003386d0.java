import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		// TODO
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			long[] x = new long[n];
			long[] y = new long[n];
			int max = 0;
			
			for (int j=0;j<n;j++) {
				x[j]=sc.nextLong();
				y[j]=sc.nextLong();
			}
			
			for (int j=0;j<n;j++) {
				for (int k=j+1;k<n;k++) {
					long a = y[j]-y[k];
					long b = x[k]-x[j];
					HashMap<Long, int[]> map = new HashMap<>();
					for (int l=0;l<n;l++) {
						long c = a*x[l]+b*y[l];
						if (map.get(c)==null) {
							map.put(c, new int[1]);
						}
						map.get(c)[0]++;
					}
					
					int count = 0;
					int oddCount = 0;
					
					for (Map.Entry<Long, int[]> e : map.entrySet()) {
						count += e.getValue()[0]/2;
						if (e.getValue()[0] >= 3) {
							oddCount += e.getValue()[0]%2;
						}
					}
					
					max = Math.min(count*2+oddCount/2*2+2, n);
				}
			}
			
			
			max = Math.max(max, 1);
			
			System.out.println("Case #"+i+": "+max);
			
		}
	}

}
