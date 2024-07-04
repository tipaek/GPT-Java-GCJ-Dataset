import java.util.*;
public class Solution {
	

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();
		for(int tCurr = 1; tCurr<=tNum ; tCurr++) {
			
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			Map<Long, Integer> sizeToCnt = new HashMap<Long, Integer>();
			for(int i = 0; i < N; i++) {
				long val = sc.nextLong();
				sizeToCnt.put(val, sizeToCnt.getOrDefault(val, 0) + 1);
			}
			
			int result = -1;
			
//			for(int i : new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,  47} ) { // primes
//				if (i >= D) {
//					break;
//				}
//				for(Long val : sizeToCnt.keySet()) {
//					
//				}
//				
//			}
			
			for(Map.Entry<Long, Integer> entry : sizeToCnt.entrySet()) {
				if (entry.getValue() >= D) {
					result = 0;
					break;
				}
				if (sizeToCnt.containsKey(entry.getKey() / 2) && entry.getKey() % 2 == 0) {
					result = 1;
				}
			}
		
			System.out.println(String.format("Case #%d: %d" , tCurr, result == -1 ? D-1 : result));
			
		}

		System.out.flush();
	}
	

}
