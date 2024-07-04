import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author arabtech
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            long trace = 0;
            int rows=0;
            int cols=0;
            int[][] matrix = new int[n][n];
            for(int i=0; i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=sc.nextInt();
                    if(i==j){
                        trace+=matrix[i][j];
                    }
                }
            }
            for(int i=0; i<n ;i++){
                HashSet<Integer> rowSet= new HashSet<Integer>();
                rowSet.add(matrix[i][0]);
                boolean repeated = false;
                for(int j=1 ; j<n ;j++){
                    if(rowSet.contains(matrix[i][j])){
                        repeated = true;
                    }
                    rowSet.add(matrix[i][j]);
                }
                if(repeated){
                    rows++;
                }
            }
            for(int i=0 ; i<n ;i++){
                HashSet<Integer> colSet = new HashSet<Integer>();
                colSet.add(matrix[0][i]);
                boolean repeated= false;
                for(int j=1 ;j<n ;j++){
                    if(colSet.contains(matrix[j][i])){
                        repeated = true;
                    }
                    colSet.add(matrix[j][i]);
                }
                if(repeated){
                    cols++;
                }
            }
            System.out.println("Case #"+(z+1)+": "+trace+" "+rows+" "+cols);
        }

    }

}
