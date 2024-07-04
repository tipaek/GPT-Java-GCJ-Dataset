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

                    int[][] time = new int[loop][3];
                    StringBuilder sb = new StringBuilder("");
                    
                    for( int i = 0; i < loop; i++ ){
                        String[] x = reader.readLine().split(" ");
                        time[i][0] = Integer.valueOf(x[0]);
                        time[i][1] = Integer.valueOf(x[1]);
                        time[i][2] = i;
                        sb.append("C");
                    }
                    

                    Arrays.sort( time, ( x, y ) -> {
                        if( x[0] != y[0] ) return x[0] - y[0];
                        else if( x[1] != y[1] ) return x[1] - y[1];
                        else return 0;
                    });

                    ArrayList<int[]> C = new ArrayList<int[]>();
                    ArrayList<int[]> J = new ArrayList<int[]>();

                    boolean ok = true;

                    for( int i = 0; i < time.length; i++ ){
                        if( C.size() == 0 || time[i][0] >= C.get( C.size() - 1 )[1] ) {
                            C.add( time[i] );
                        }
                        else if( J.size() == 0 || time[i][0] >= J.get( J.size() - 1 )[1] ) {
                            J.add( time[i] );
                            sb.setCharAt(time[i][2], 'J');
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