
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
			Set<Integer> rset = new HashSet<>();
			Set<Integer> cset = new HashSet<>();
			for(int j = 0; j < arr.length; ++j) {
				rset.add(arr[i][j]);
				cset.add(arr[j][i]);
			}
			if(rset.size() != arr.length) {
				rCount++;
			}
			if(cset.size() != arr.length) {
				cCount++;
			}
		}
		
		res.append(rCount + " " + cCount);
		return res.toString();
	}
}