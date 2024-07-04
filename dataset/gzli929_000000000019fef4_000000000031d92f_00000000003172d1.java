import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tC; t++) {
			System.out.print("Case #" + t + ": ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] array = new long[n];
            HashMap<Long,Integer> map = new HashMap<Long,Integer>();
            
            for(int i = 0; i < n; i++) {
                array[i] = Long.parseLong(st.nextToken());
                
                if(map.containsKey(array[i])) {
                	map.put(array[i], map.get(array[i])+1);
                }
                else {
                	map.put(array[i], 1);
                }
            }
            
            int maxFreq = 0;
            
            for(int i = 0; i < n; i++) {
            	maxFreq = Math.max(maxFreq, map.get(array[i]));
            }
            //System.out.print(maxFreq);
            Arrays.sort(array);
            
            int min = d-1;
            //System.out.println("min: " + min);
            if(min == 0) {
            	System.out.println(0);
            	continue;
            }
            else if(min == 1) {
            	//System.out.println("Hello");
                if(maxFreq > 1) {
                	System.out.println(0);
                }
                else {
                	System.out.println(1);
                }

                continue;
            }
            else if(min == 2) {
            	
            	for(int i = 0; i < n; i++) {
            		int index = Arrays.binarySearch(array, 2*array[i]);
            		if(index > 0) {
            			min--;
            			break;
            		}
            	}
            	
                if(maxFreq > 2) {
                	System.out.println(0);
                }
                else if(maxFreq == 2) {
                	System.out.println(1);
                }
                else {
                	System.out.println(min);
                }
            	
            	continue;
            }
            else {
            	
            }
		}
	}
}
