import java.io.*;
// import java.math.BigInteger;
import java.util.*;

public class Solution{
    
    public static void main( String[] args ){
        
        try{
            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        
                int lim = Integer.valueOf( reader.readLine() );
            
                for( int l = 0; l < lim; l++ ){

                    boolean ok = false;
                        
                    List<String> list = new ArrayList<String>(); 

                    String[] x = reader.readLine().split(" ");

                    int size = Integer.valueOf( x[0] );
                    int target = Integer.valueOf( x[1] );

                    dfs( size, target, new StringBuilder(""), list );     
                    
                    // System.out.println(list);
                    
                    int[][] arr = new int[0][0];

                    for( int i = 0; i < list.size(); i++ ){
                        arr = new int[size][size];
                        String s = list.get(i);
                        int m = 0;
                        int n = 0;
                        while( m < arr.length && n < arr.length ) {
                            arr[m][n] = s.charAt(m) - '0';
                            m++;
                            n++;
                        }
                        ok = backTrack( arr, 0, 0 );
                        if( ok ) break; 
                    }

                    if( !ok ) System.out.println("Case #"+(l+1)+": IMPOSSIBLE");
                    else{
                        System.out.println("Case #"+(l+1)+": POSSIBLE");
                        for( int v = 0; v < arr.length; v++ ){
                            for( int j = 0; j < arr.length; j++ ) System.out.print( arr[v][j] );
                            System.out.println();
                        }
                    }
                }
            
        }
        catch( Exception e ){}  
    }

    public static boolean backTrack( int[][] arr, int i, int j ){
        if( j >= arr.length ){
            j = 0;
            i++;
        }
        if( i >= arr.length ) return true;
        

        if( i == j || arr[i][j] != 0 ){
            return backTrack(arr, i, j + 1);
        }

        for( int k = 1; k <= arr.length; k++ ){
            arr[i][j] = k;
            if( !check(i, j, arr) ) arr[i][j] = 0;
            else{
                boolean ok = backTrack(arr, i, j + 1);
                if( ok ) return ok;
                arr[i][j] = 0; 
            }
        }

        return false;
    }

    public static boolean check( int x, int y, int[][] arr ){
        int val = arr[x][y];
        for( int i = x - 1; i >= 0; i-- ) if( arr[i][y] == val ) return false;
        for( int i = x + 1; i < arr.length; i++ ) if( arr[i][y] == val ) return false;
        for( int i = y - 1; i >= 0; i-- ) if( arr[x][i] == val ) return false;
        for( int i = y + 1; i < arr.length; i++ ) if( arr[x][i] == val ) return false;

        return true;
    }

    public static void dfs(int size, int target, StringBuilder sb, List<String> list){
        if( sb.length() > size ) return;
        if( target <= 0 ){
            if( target < 0 ) return; 
            if( sb.length() == size ) list.add( String.valueOf( sb ) );
            return;
        }

        for( int i = 1; i <= size; i++ ){
            sb.append( i );
            dfs( size, target - i, sb, list );
            sb.deleteCharAt( sb.length() - 1 );
        }
    }
    
} 