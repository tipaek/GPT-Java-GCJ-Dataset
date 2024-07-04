import java.io.*;
// import java.math.BigInteger;
import java.util.*;

public class Solution{
    
    public static void main( String[] args ){
        
        try{
            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        
            int lim = Integer.valueOf( reader.readLine() );
            
            for( int l = 0; l < lim; l++ ){               
 
               int n = Integer.valueOf( reader.readLine() );

               int[][] a = new int[n][n];
               
                for( int i = 0; i < n; i++ ){
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
                    int j = 0;
                    while( tokenizer.hasMoreTokens() ){
                        a[i][j] = Integer.valueOf( tokenizer.nextToken() );    
                        j++;
                    }
                }

                int row = 0;
                for( int i = 0; i < n; i++ ){
                    HashSet<Integer> set = new HashSet<Integer>();
                    for( int j = 0; j < n; j++ ){
                        if( !set.contains(a[i][j]) ) {set.add(a[i][j]);}
                        else {row++; break;}
                    }
                }               

                int col = 0;
                for( int i = 0; i < n; i++ ){
                    HashSet<Integer> set = new HashSet<Integer>();
                    for( int j = 0; j < n; j++ ){
                        if( !set.contains( a[j][i] ) ) {set.add(a[j][i]);}
                        else {col++; break;}
                    }
                }

                int sum = 0;
                int i = 0;
                int j = 0;
                while( i < a.length && j < a.length ){ sum += a[i][j]; i++; j++; }

                System.out.println("Case #"+(l+1)+": "+sum+" "+row+" "+col);
 
            }
            
        }
        catch( Exception e ){}
        
    }

    
} 