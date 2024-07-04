import java.io.*;
// import java.math.BigInteger;
import java.util.*;

public class Solution{
    
    public static void main( String[] args ){
        
        try{
            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        
                int lim = Integer.valueOf( reader.readLine() );
            
                for( int i = 0; i < lim; i++ ){
                    String s = reader.readLine();
                    StringBuilder sb = new StringBuilder("");
                    
                    int depth = 0;
                    for( int j = 0; j < s.length(); j++ ){
                        char charVal = s.charAt(j);
                        int intVal = charVal - '0';

                        if( intVal > depth ){
                            while( depth != intVal ){
                                depth++;
                                sb.append("(");
                            }
                        }
                        else if( intVal < depth ){
                            while( depth != intVal ){
                                depth--;
                                sb.append(")");
                            }
                        }
                        sb.append( charVal );
                    }
                    while( depth != 0 ){
                        depth--;
                        sb.append(")");
                    }
                    System.out.println("Case #"+(i+1)+": "+String.valueOf(sb));
                }
            
        }
        catch( Exception e ){}  
    }

    
} 