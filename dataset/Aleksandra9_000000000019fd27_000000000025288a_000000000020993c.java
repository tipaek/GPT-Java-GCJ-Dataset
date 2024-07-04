import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int t=1; t<=tests; t++) {
        	 int N = in.nextInt();
             int[][] mat = new int[N][N];
        	 int summa = 0;
        	 for(int i=0; i<N; i++)
        		 for(int j=0; j<N; j++) {
        			 mat[i][j] = in.nextInt();
        			 if(i == j)
        				 summa += mat[i][j];
        		 }
        	 
        	 int row = 0;
        	 for(int i=0; i<N; i++) {
        		 int[] elements = new int[N];
        		 for(int j=0; j<N; j++) {
        			 if(elements[mat[i][j]-1] == 0)
        				 elements[mat[i][j]-1]++;
        			 else {
        				 row++;
        				 break;
        			 }
        		 }
        	 }
        	 
        	 int columns = 0;
        	 for(int j=0; j<N; j++) {
        		 int[] elements = new int[N];
        		 for(int i=0; i<N; i++) {
        			 if(elements[mat[i][j]-1] == 0)
        				 elements[mat[i][j]-1]++;
        			 else {
        				 columns++;
        				 break;
        			 }
        		 }
        	 }
             
             System.out.println("Case #"+t+": " + summa + " " + row + " " + columns);
        }
	}
}