import static java.lang.System.out;
import java.util.*;
import java.io.*;

public class Solution  {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int count = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i=1; i<=count; i++)
        {
            String strNum = in.next();
            test(i, strNum);
        }
    }

public static void test(int ind, String strNum)
{
    StringBuffer strConverted = new StringBuffer();
    String strLeft = "(";
    String strRight = ")";
    
    int nLeftLeft = 0;
    int len = strNum.length();
    for (int i=0; i < len; i++)
    {
        char c = strNum.charAt(i);
        int nCurrent = Character.getNumericValue(c);
        
        int nLeftNeeded = (nCurrent > nLeftLeft) ? nCurrent-nLeftLeft : 0;
        int nRightNeeded = (nCurrent <= nLeftLeft) ? nLeftLeft-nCurrent : 0;
        nLeftLeft = nCurrent;
        
        for(int k = 0; k < nRightNeeded; k++) {
            strConverted.append(strRight);
        }
        for(int k = 0; k < nLeftNeeded; k++) {
            strConverted.append(strLeft);
        }
        strConverted.append(c);
        
        if (i==len-1)
        {
            for(int k = 0; k < nLeftLeft; k++) {
                strConverted.append(strRight);
            }
        }
    }
    
    System.out.println("Case #" + ind + ": " + strConverted);
}
}