import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
 
public class Solution {
    public static void solve(Scanner input, int caseNum, int[][] nums, int n) {
    	int trace = 0;
    	HashSet<Integer> duplRows= new HashSet<>();
    	HashSet<Integer> duplCols= new HashSet<>();
    	HashSet<String> colValues = new HashSet<>();
    	HashSet<String> rowValues = new HashSet<>();
    	
    	
    	for (int i=0;i<n;i++) {
    	    for (int j=0;j<n;j++){
                if (i==j) trace += nums[i][j];
                String rowValue = i + "|" + nums[i][j];
                if (rowValues.contains(rowValue)){
                    duplRows.add(i);
                } else {
                    rowValues.add(rowValue);
                }
                
                String colValue = j + "|" + nums[i][j];
                if (colValues.contains(colValue)){
                    duplCols.add(j);
                } else {
                    colValues.add(colValue);
                }
    	    }
    	}
    	
        System.out.println("Case #" + caseNum + ": " + trace + " " + duplRows.size() + " " + duplCols.size());
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
         try {
 			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\CodeJam2020\\qalificationRound\\vestigium\\input.txt")));
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
        	int N = input.nextInt();
            int[][] nums = new int[N][N];
        	
        	
            for (int i=0;i<N;i++) {
            	//String s = input.next();
                //String[] str = s.split(" ");
                for (int j=0;j<N;j++){
                    //nums[i][j] = Integer.parseInt(str[j]);
                    nums[i][j] = input.nextInt();
                }
            }
            solve(input, ks, nums, N);
        }
        
        input.close();
        
    }
}
