
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i=1;i<=t;++i) {
			int n = in.nextInt();
			int d = in.nextInt();
			double[] slices = new double[d];
			HashMap<Double,Integer> map = new HashMap<>();
			int max = 1;
			for(int j = 0; j<d;++j) {
				double slice = in.nextLong();
				slices[j]= slice;
				if(map.containsKey(slice)) {
					max = Math.max(map.get(slice)+1, max);
					map.put(slice, map.get(slice)+1);
				}else {
					map.put(slice, 1);
				}
			}
			if(max == 3) {
				System.out.println("Case #"+i+": "+0);
				return;
			}
			int sol = 2;
			if(max == 1) {
				System.out.println("Case #"+i+": "+sol);
			}else {
				/*for(Map.Entry<Double, Integer> e: map.entrySet() ) {
					double value = e.getKey();
					if(e.getValue()==2) {
						for(int k =0; k<slices.length;++k) {
							
						}
					}
				}*/
				System.out.println("Case #"+i+": "+1);
			}
			
			
			
		}
	}
	
}
