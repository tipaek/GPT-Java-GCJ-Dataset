
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int N = sc.nextInt();
			int trace = sc.nextInt();
			double div = (double)trace/(double)N ;
			int sum = (N*(N+1))/2;
			if((div-(int)div)==0 ){
			    System.out.println("decimal value is not there");
			    StringBuilder sb = new StringBuilder();
			    int diagnolEqualNum = (int)div;
			    int[][] latinMatrix = new int[N][N];
			    if((div-(int)div)==0 ) {
			    	for(int row=0;row<N;row++) {
				    	for(int column=0;column<N;column++) {
				    		if(row>column) {//increasing order
				    			int num = latinMatrix[row-1][column] +1;
				    			num = num > N? 1:num;
				    			latinMatrix[row][column] = num;
				    			sb.append(num+" ");
				    		}
				    		else if(row == column) {
				    			latinMatrix[row][column] = diagnolEqualNum;
				    			sb.append( diagnolEqualNum+" ");
				    		}
				    		else {//decreasing order
				    			int num = latinMatrix[row][column-1] -1;
				    			num = num == 0? N:num;
				    			latinMatrix[row][column] = num;
				    			sb.append( num);
				    			if(column == N-1) {
				    				sb.append("\n");
				    			}
				    			else {
				    				sb.append(" ");
				    			}
				    		}
				    	}
				    }
			    }
			    else {
			    	for(int row=0;row<N;row++) {
				    	for(int column=0;column<N;column++) {
				    		if(row>column) {
				    			int num = latinMatrix[row-1][column] -1;
				    			num = num == 0? N:num;
				    			latinMatrix[row][column] = num;
				    			sb.append(num+" ");
				    		}
				    		else if(row == column) {
				    			latinMatrix[row][column] = N -row;
				    			sb.append( (N -row)+" ");
				    		}
				    		else {
				    			int num = latinMatrix[row][column-1] -1;
				    			num = num == 0? N:num;
				    			latinMatrix[row][column] = num;
				    			sb.append( num);
				    			if(column == N-1) {
				    				sb.append("\n");
				    			}
				    			else {
				    				sb.append(" ");
				    			}
				    		}
				    	}
				    }
			    }
			    
				System.out.println("Case #" + (i + 1) + ": POSSIBLE\n" + sb);
			}
			else {
				System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE" );
			}
		}
		sc.close();
	}

}
