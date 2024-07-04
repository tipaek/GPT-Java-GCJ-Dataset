import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class Solution {


	static Solution sol = new Solution();


	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();


		for(int usease = 0; usease< T;usease++) {

			TreeMap<Long,Integer> slicesAngle = new TreeMap();
			int N = scann.nextInt(); //Number of slice
			int D = scann.nextInt(); //Number of dinners

			for(int i =0 ;i < N;i++) {
				long slice = scann.nextLong();
				if(slicesAngle.containsKey(slice)) {
					int nb = slicesAngle.get(slice)+1;
					slicesAngle.put(slice, nb);
				}
				else {
					slicesAngle.put(slice,1);	
				}
				
			}
			
			if(N==1) {
				System.out.println(String.format("Case #%s: %s",usease+1,D-1));
			}
			else if(slicesAngle.size()<N) {
				if(slicesAngle.containsValue(D)) {
					System.out.println(String.format("Case #%s: 0",usease+1));
				}
				else {
					
					
					
				}		
			}
			else {
				
				int numberOfCut = 1;
				long minAngle = slicesAngle.firstKey();
				boolean hasbeenCut = false;
				for(Map.Entry<Long, Integer> entry : slicesAngle.entrySet()) {
					if(minAngle!=entry.getKey() && entry.getKey()-minAngle >= minAngle) {
						System.out.println(String.format("Case #%s: %s",usease+1,1));
						hasbeenCut = true;
						break;
					}
				}
				if(!hasbeenCut) {
					System.out.println(String.format("Case #%s: %s",usease+1,D-1));

				}

			}
			
			
			
			
			
		


		}


	}






}
