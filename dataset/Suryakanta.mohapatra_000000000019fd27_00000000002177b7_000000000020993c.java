import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {
     
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	int numTests = input.nextInt();
    	for(int i=0;i<numTests;i++) {
    		int N = input.nextInt();
    		int[][] arr = new int[N][N];
    		int rowCount = 0; int colCount = 0; int trace = 0;
    		for(int row=0;row<N; row++) {
    			Set<Integer> set = new HashSet<>();
    			for(int col=0;col<N;col++) {
    				int val = input.nextInt();
    				if(row==col) trace+=val;
    				arr[row][col]=val;
    				set.add(val);
    			}
    			rowCount+=(set.size()==N)?0:1;
    		}
    		for(int col=0;col<N; col++) {
    			Set<Integer> set = new HashSet<>();
    			for(int row=0;row<N;row++) {
    				int val = arr[row][col];
    				set.add(val);
    			}
    			colCount+=(set.size()==N)?0:1;
    		}
    		System.out.printf("Case #%d: ",i+1);
    		System.out.println(trace+" "+rowCount+" "+colCount);	
    	}
    	input.close();
    }
}