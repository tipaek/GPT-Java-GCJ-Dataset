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
    String allLeft[] = new String[nSize];
    String allRight[] = new String[nSize];
    for (int i=0; i<nSize; i++)
    {
        String sRow = in.nextLine();
        sRow = sRow.replace('*', ' ');
        //System.out.println("Row " + i + " is(" + sRow + ")");
        if (sRow.length() == 0)
        {
            continue;
        }
        if (sRow.startsWith(" "))
        {
            allLeft[i] = "";
            allRight[i] = sRow.trim();
        }
        else if (sRow.endsWith(" "))
        {
            allLeft[i] = sRow.trim();
            allRight[i] = "";
        }
        else
        {
            String[] rElements = sRow.split(" ");
                    //System.out.println("Row " + i + " splitted(" + rElements[0] + "|" + rElements[1]+")");
            allLeft[i] = rElements[0];
            allRight[i] = rElements[1];
        }
    }
    
    boolean notFound = false;
    
    String sLeft = "";
    for (int i=0; i<nSize; i++)
    {
        String s = allLeft[i];
        if (sLeft == "")
            sLeft = s;
        else if (sLeft.indexOf(s) != -1)
        {
            continue;
        }
        else if (s.indexOf(sLeft) != -1)
        {
            sLeft = s;
            continue;
        }
        else
        {
            notFound = true;
            break;
        }
    }
    
    String sRight = "";
    if (!notFound)
    {
        for (int i=0; i<nSize; i++)
        {
            String s = allRight[i];
            if (sRight == "")
                sRight = s;
            else if (sRight.indexOf(s) != -1)
            {
                continue;
            }
            else if (s.indexOf(sRight) != -1)
            {
                sRight = s;
                continue;
            }
            else
            {
                notFound = true;
                break;
            }
        }
    }
    
    String result = sLeft + sRight;
    
    if (notFound || result.length() > 10000)
        System.out.println("Case #" + ind + ": *" );
    else
        System.out.println("Case #" + ind + ": " + result);
}
}

