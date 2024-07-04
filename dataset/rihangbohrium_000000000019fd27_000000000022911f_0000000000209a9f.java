import java.io.*;

public class Solution { 
    static String solve(String S) {
        String r = "";

        // initialize for first index
        int lastVal = Character.getNumericValue(S.charAt(0));
        for (int i = 0; i < lastVal; i++) 
            r += "(";
        r += S.charAt(0);

        for (int i = 1; i < S.length(); i++) {
            int t = Character.getNumericValue(S.charAt(i));
            int diff = t-lastVal;
            if (diff > 0) 
                for (int j = 0; j < diff; j++) 
                    r += "(";
            else if (diff < 0)
                for (int j = 0; j < -1*diff; j++) 
                    r += ")";

            r += S.charAt(i);
            lastVal = t;
        }

        for (int i = 0; i < lastVal; i++)
            r += ")";
        
        return r;
    }
    public static void main(String [] args) throws Exception{
        BufferedReader input = new BufferedReader( new InputStreamReader(System.in) );
        int T = Integer.parseInt( input.readLine() );

        for (int i = 1; i <= T; i++) {
            String s = input.readLine();
            System.out.println("Case #" + i + ": " + solve(s));
        }        
    }
}