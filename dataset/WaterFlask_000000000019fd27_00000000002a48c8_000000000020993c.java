
import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {


        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        
        for(int i = 1; i <= cases; ++i) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for(int j = 0; j < n; ++j) {
            	for(int k = 0; k < n; ++k) {
            		int num = in.nextInt();
            		arr[j][k] = num;
            	}
            }
//            int[][] intervals = new int[tasks][3];
//            for(int t = 0; t < tasks; ++t) {
//    			int start = in.nextInt();
//    			int end = in.nextInt();
//    			intervals[t][0] = start;
//    			intervals[t][1] = end;
//    			intervals[t][2] = t;
//    		}
//            
            System.out.print("Case #" + i + ": ");
            System.out.println(calculate(arr));
        }
        in.close();
	}
	
	public static String calculate(int[][] arr) {
		StringBuilder res = new StringBuilder();
		int sum = 0;
		for(int i = 0; i < arr.length; ++i) {
			sum += arr[i][i];
		}
		res.append(sum + " ");
		
		int rCount = 0;
		int cCount = 0;
		for(int i = 0; i < arr.length; ++i) {
			int rRep = 0;
			int cRep = 0;
			for(int j = 0; j < arr.length; ++j) {
				rRep ^= ((j+1) ^ arr[i][j]);
				cRep ^= ((j+1) ^ arr[j][i]);
			}
			if(rRep != 0) {
				rCount++;
			}
			if(cRep != 0) {
				cCount++;
			}
		}
		
		res.append(rCount + " " + cCount);
		return res.toString();
	}
}