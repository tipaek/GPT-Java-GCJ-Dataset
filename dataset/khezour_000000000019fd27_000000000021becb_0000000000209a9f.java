import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {

            String s = in.next();

            StringBuilder ss = new StringBuilder(s);
            int degit;
            int prev_degit = 0 ;

            for (int i = 0 ; i < ss.length() ; i++ ){
                degit = Character.getNumericValue(ss.charAt(i)) ;
                if (prev_degit < degit){
                    for (int j = 0 ; j < (degit - prev_degit) ; j++ ) ss.insert(i , '(') ;
                     i  += ( degit - prev_degit ) ;
                }
                else {
                    for (int j = 0 ; j < (prev_degit - degit) ; j++ ) ss.insert(i , ')') ;
                    i  += (prev_degit - degit) ;
                }
                prev_degit = degit ;
            }
            for (int j = 0 ; j < prev_degit ; j++ ) ss.append( ')') ;
            // solution
            System.out.println("Case #"+ x  + ": " + ss  );
        }
    }
}
