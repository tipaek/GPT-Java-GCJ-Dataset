import java.util.*;
import java.io.BufferedReader;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 1; k <= t; k++) {
        	int n = in.nextInt();
        	int[][][] nums = new int[n][n][2]; //[i][i][0] represents counts of row i has number i+1
        	int[] rows = new int[n]; //rows[i] == 0, row i don't contain repeated number, rows[i] == 1, row i contains repeated number
        	int[] cols = new int[n]; //cols[i] == 0, col i don't contain repeated number, cols[i] == 1, col i contains repeated number
        	int[] res = new int[3]; 
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < n; j++) {
        			int num = in.nextInt();
        			nums[i][num-1][0]++;
        			if (nums[i][num-1][0] > 1) rows[i] = 1;
        			nums[j][num-1][1]++;
        			if (nums[j][num-1][1] > 1) cols[j] = 1;
        			if (i == j) res[0]+= num;
        		}
        	}
        	for (int cnt: rows) res[1] += cnt;
        	for (int cnt: cols) res[2] += cnt;
        	System.out.println("Case #" + k + ": " + res[0] + " " + res[1] + " " + res[2]);
        }
	}
}