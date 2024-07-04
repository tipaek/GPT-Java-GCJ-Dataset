
//package googlecodejam;

import java.util.*;

/**
 *
 * @author Amith Kumar Matapady
 */
class Main {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int T = 0;
        T = sc.nextInt();
        
        for(int i = 0; i< T; i++)
        {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            int colCount = 0, rowCount = 0, trace = 0;
            for(int j = 0; j< N; j++)
            {
                Set<Integer> rowSet = new HashSet();
                for(int k = 0; k < N; k++)
                {
                    mat[j][k] = sc.nextInt();
                    if( j == k)
                    {
                        trace += mat[j][k];
                    }                        
                    rowSet.add(mat[j][k]);
                }
                if(rowSet.size() < N)
                    rowCount++;
            }
            
            for(int k = 0; k < N; k++)
            {
                Set<Integer> colSet = new HashSet();
                for(int j = 0; j< N; j++)
                {
                    colSet.add(mat[j][k]);
                }
                if(colSet.size() < N)
                    colCount++;
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + rowCount + " " + colCount);
        }
        
        
    }
    
}
