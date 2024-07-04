import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        int c=1;
        while(c<=x) {
            int rowCount = 0;
            int colCount = 0;
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for(int i=0; i<n;i++) {
                boolean rowRepeatExists = false;
                HashSet<Integer> rowSet = new HashSet<Integer>();
                for(int j=0;j<n;j++) {
                    int number = sc.nextInt();
                    mat[i][j] = number;
                    if(rowSet.contains(number)) {
                        rowRepeatExists = true;
                    } else {
                        rowSet.add(number);
                    }
                }
                if(rowRepeatExists) {rowCount++;}
            }
            
            long trace = 0;
            for (int i=0;i<n;i++) {
                boolean colRepeatExists = false;
                HashSet colSet = new HashSet<Integer>();
                for(int j=0;j<n;j++) {
                    if(i==j) {trace += mat[i][j];}
                    if(colSet.contains(mat[j][i])) {
                        colRepeatExists = true;
                    } else {
                        colSet.add(mat[j][i]);
                    }
                }
                if(colRepeatExists) {colCount++;}
            }
            System.out.println("Case #"+c+":"+ trace +" "+ rowCount + " " +colCount);
            c++;
        }
        
	}
}
