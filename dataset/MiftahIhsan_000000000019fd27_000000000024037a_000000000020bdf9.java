import java.io.*;
// import java.math.BigInteger;
import java.util.*;

public class Solution{
    
    public static void main( String[] args ){
        
        try{
            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        
                int lim = Integer.valueOf( reader.readLine() );
            
                for( int l = 0; l < lim; l++ ){

                    int loop = Integer.valueOf(reader.readLine());

                    int[][] time = new int[loop][2];
                    
                    for( int i = 0; i < loop; i++ ){
                        StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
                        while( token.hasMoreTokens() ){
                            time[i][0] = Integer.valueOf(token.nextToken());
                            time[i][1] = Integer.valueOf(token.nextToken());
                        }
                    }
                    

                    Arrays.sort( time, ( x, y ) -> {
                        if( x[0] != y[0] ) return x[0] - y[0];
                        else if( x[1] != y[1] ) return x[1] - y[1];
                        else return 0;
                    });

                    ArrayList<int[]> C = new ArrayList<int[]>();
                    ArrayList<int[]> J = new ArrayList<int[]>();

                    StringBuilder sb = new StringBuilder("");

                    boolean ok = true;

                    for( int i = 0; i < time.length; i++ ){
                        if( C.size() == 0 || time[i][0] >= C.get( C.size() - 1 )[1] ) {
                            C.add( time[i] );
                            sb.append("C");
                        }
                        else if( J.size() == 0 || time[i][0] >= J.get( J.size() - 1 )[1] ) {
                            J.add( time[i] );
                            sb.append("J");
                        }
                        else { ok = false; break; }
                    }

                    if( ok )System.out.println("Case #"+(l+1)+": "+String.valueOf(sb));
                    else System.out.println("Case #"+(l+1)+": IMPOSSIBLE");
                }
            
        }
        catch( Exception e ){}  
    }

    
} 