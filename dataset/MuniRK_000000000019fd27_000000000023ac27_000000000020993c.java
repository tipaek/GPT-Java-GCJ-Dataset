import java.util.*;
import java.io.* ;

public class Solution {
    
    void findVestigium( int c1, int n1 , int[][] arr ) {
        int c = c1 ;
        int n = n1 ;
        int[][] forRow = new int[100][100] ;   // value * Row
        int[][] forCol = new int[100][100] ;  // value * Col
        int maxRow = 0 ;
        int maxCol = 0 ;
        int value = 0 ;
        int diagonal = 0 ;
    // Given Memory Limit 1 GB. Time 20 Secods. To Achieve O(n) 
    
    for ( int i = 0 ; i < n ; i++ )
      for ( int j = 0 ; j < n ; j++ ) {
          
           value = arr[i][j] ;
           forRow[value][i]++;
           forCol[value][j]++;
          
            if( forRow[value][i] > maxRow )
                    maxRow = forRow[value][i] ;
                    
            if( forCol[value][j] > maxCol )
                    maxCol = forCol[value][j] ;
         
            if ( i == j  )
               diagonal += arr[i][j] ;
          
      }
      
      if (maxRow == 1)
         maxRow = 0 ;
      if (maxCol == 1)
        maxCol = 0 ;
      System.out.println("Case #"+ c +": "+diagonal+" "+maxRow+" "+maxCol) ;
    }
    
    
    
    public static void main(String args[]) {
        
          int t,n,inc=1;
          int[][] matrix = new int[100][100] ;
         Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
          Solution v= new Solution() ;

           t = in.nextInt() ;
    
            while ( inc <= t) {
              n = in.nextInt() ;
              for ( int i = 0 ; i < n ; i++ )
                for ( int j = 0 ; j < n ; j++ )
                    matrix[i][j] = in.nextInt() ;
                    
                    
               v.findVestigium(inc,n,matrix) ;
            inc++ ;
        
        }
        
    }
    
}