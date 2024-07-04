import java.util.*;
import java.io.*;

class Pair {
	public int i,j;
    public	StringBuilder sb;
	public Pair(int i, int j) {
		this.i = i;
		this.j=j;
		sb = new StringBuilder();
	}

}

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		for (int z = 1; z <= t; ++z) {
			int n = in.nextInt();
			int d = in.nextInt();
			long[] arr = new long[n];	
	
			for (int i=0;i<n;i++){
				arr[i]= in.nextLong();
			}
			
		
			System.out.print("Case #" + z + ": ");
			boolean found =false;
			int minCut=d-1	;
			Arrays.sort(arr);
			for (int i=0;i<n;i++){
				long sm = arr[i];
				int req=d-1;
				int cuts=0;
				List<Long> multiples = new ArrayList<>();
				for (int j=i+1;j<n;j++){
					if (arr[j]%sm==0 && arr[j]/sm <= req){
						multiples.add(arr[j]);	
						req-=arr[j]/sm;
						cuts+=(arr[j]/sm)-1;
						if (req==0)break;
					}
				}
				if (req==0 && cuts<minCut)minCut=cuts;
			}			
			System.out.println(minCut);

		}
	}
}
