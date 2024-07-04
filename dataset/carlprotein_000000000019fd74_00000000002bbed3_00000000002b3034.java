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
    String sRight = "";
    
    for (int i=0; i<nSize; i++)
    {
        String sRow = in.nextLine();
        sRow = sRow.replace('*', ' ');
        //System.out.println("Row " + i + " is(" + sRow + ")");
        if (sRow.length() == 0)
        {
            continue;
        }
        
        String cLeft = "";
        String cRight = "";
        if (sRow.startsWith(" "))
        {
            cLeft = "";
            cRight = sRow.trim();
        }
        else if (sRow.endsWith(" "))
        {
            cLeft = sRow.trim();
            cRight = "";
        }
        else
        {
            String[] rElements = sRow.split(" ");
                    //System.out.println("Row " + i + " splitted(" + rElements[0] + "|" + rElements[1]+")");
            cLeft = rElements[0];
            cRight = rElements[1];
        }
        
        if (sLeft == "")
            sLeft = cLeft;
        else if (cLeft == "")
        {
            // 
        }
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
        
        if (sRight == "")
            sRight = cRight;
        else if (cRight == "")
        {
            // 
        }
        else if (sRight.indexOf(cRight) != -1)
        {
            //
        }
        else if (cRight.indexOf(sRight) != -1)
        {
            sRight = cRight;
        }
        else
        {
            notFound = true;
            break;
        }
        
        if (sLeft.length() + sRight.length() > 10000)
            break;
    }
    
    String result = sLeft + sRight;
    
    if (notFound || result.length() > 10000)
        System.out.println("Case #" + ind + ": *" );
    else
        System.out.println("Case #" + ind + ": " + result);
}
}

