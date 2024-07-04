import static java.lang.System.out;
import java.util.*;
import java.io.*;

public class Solution  {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nRound = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
                        //System.out.println("nRound" + nRound);
        for (int i=1; i<=nRound; i++)
        {
            int nSize  = in.nextInt();
            in.nextLine();
                        //System.out.println("nSize" + nSize);
            test(i, nSize, in);
        }
    }

public static void test(int ind, int nSize, Scanner in)
{
    boolean notFound = false;
    String sLeft = "";
    
    for (int i=0; i<nSize; i++)
    {
        String sRow = in.nextLine();
        String cLeft = sRow.substring(1);
        //System.out.println("Row " + i + " is(" + sRow + ")");
        if (sRow.length() == 0)
        {
            continue;
        }
        
       
        
        if (sLeft == "")
            sLeft = cLeft;
        else if (sLeft.indexOf(cLeft) != -1)
        {
            //
        }
        else if (cLeft.indexOf(sLeft) != -1)
        {
            sLeft = cLeft;
        }
        else
        {
            notFound = true;
            break;
        }
        
        
        if (sLeft.length() > 10000)
            break;
    }

    
    if (notFound || sLeft.length() > 10000)
        System.out.println("Case #" + ind + ": *" );
    else
        System.out.println("Case #" + ind + ": " + sLeft);
}
}

