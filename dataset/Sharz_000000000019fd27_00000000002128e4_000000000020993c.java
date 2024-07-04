import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int trace = 0;
			int arr[][] = new int[n][n]; 
			for (int j = 0; j< n; j++) {
			    for (int k = 0; k< n; k++) {
			        arr[j][k] = in.nextInt();
			        if (j == k) {
			            trace += arr[j][k];
			        }
			    }    
			}
			Map<Integer, Integer> r = new HashMap<>();
			Map<Integer, Integer> c = new HashMap<>();
			int rs = 0;
			int cs = 0;
			
			for (int j = 0; j< n; j++) {
			    r = new HashMap<>();
			    for (int k = 0; k< n; k++) {
			        if (r.containsKey(arr[j][k])) {
			            rs +=1;
			            break;
			        } else {
			            r.put(arr[j][k], 1);
			        }
			    }    
			}
			for (int j = 0; j< n; j++) {
			    c = new HashMap<>();
			    for (int k = 0; k< n; k++) {
			        if (c.containsKey(arr[k][j])) {
			            cs +=1;
			            break;
			        } else {
			            c.put(arr[k][j], 1);
			        }
			    }    
			}
			System.out.println("Case #" + i + ": " + trace + " " + rs + " " + cs);
		}
	}
}
