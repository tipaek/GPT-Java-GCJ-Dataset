import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tC; t++) {
			System.out.print("Case #" + t + ": ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			long[] array = new long[n];
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();

			for (int i = 0; i < n; i++) {
				array[i] = Long.parseLong(st.nextToken());

				if (map.containsKey(array[i])) {
					map.put(array[i], map.get(array[i]) + 1);
				} else {
					map.put(array[i], 1);
				}
			}

			int maxFreq = 0;
			long maxFreqElement = -1;
			long maxElement = array[n-1];
            boolean z = false;
			for (int i = 0; i < n; i++) {
				int newFreq = map.get(array[i]);
				
				if(newFreq > maxFreq) {
					maxFreqElement = array[i];
					maxFreq = newFreq;
				}
				
				if(maxFreq>= d){
				    System.out.println(0);
				    z = true;
				    break;
				}
			}
			if(z){
			    continue;
			}
			
			
			
			
			//System.out.println(maxFreq);
			// System.out.print(maxFreq);
			Arrays.sort(array);

			int min = d - 1;
			// System.out.println("min: " + min);
			if (min == 1) {

			    System.out.println(1);
				

				continue;
			} else if (min == 2) {
			    
                for (int i = 0; i < n; i++) {
					int index = Arrays.binarySearch(array, 2 * array[i]);
					if (index >= 0) {
						min--;
						break;
					}
				}
				
                if(map.size() > 1){
                    if(maxFreq == 2){
                        if(maxElement > maxFreq){
                            System.out.println(1);
                        }
                    }
                    else if(min == 1){
                        System.out.println(1);
                    }
                    else {
                    	System.out.println(2);
                    }
                }
                else {

                           System.out.println(2);
                }

				// if (maxFreq > 2) {
				// 	System.out.println(0);
				// } else if (maxFreq == 2) {
				// 	if (n == 2) {
				// 		System.out.println(2);
				// 	} else if(maxFreqElement == maxElement){
				// 		System.out.println(min);
				// 	}else {
				// 		System.out.println(1);
				// 	}
				// } else {
				// 	System.out.println(min);
				// }

				continue;
			} else {

			}
		}
	}
}
