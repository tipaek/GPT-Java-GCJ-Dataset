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
    int all[][] = new int[nSize][nSize];
    for (int i=0; i<nSize; i++)
    {
        String sRow = in.nextLine();
        //System.out.println("sRow" + sRow);
        if (sRow.length() == 0)
        {
            continue;
        }
        String[] rElements = sRow.split(" ");
        for (int j=0; j<nSize; j++ )
        {
            int nElement = Integer.parseInt(rElements[j]);
            all[i][j] = nElement;
        }
    }
    
    int nTrace = 0;
    for (int i=0; i<nSize; i++)
    {
        nTrace += all[i][i];
    }
    
    int nRowHasRepeated = 0;
    for (int i=0; i<nSize; i++)
    {
        int[] rowNumberCount = new int[nSize+1];
        Arrays.fill(rowNumberCount, 0);
        for (int j=0; j<nSize; j++)
        {
            int nElement = all[i][j];
            rowNumberCount[nElement] = rowNumberCount[nElement] + 1;
            if (rowNumberCount[nElement] == 2)
            {
                nRowHasRepeated++;
                break;
            }
        }
    }
    
    int nColHasRepeated = 0;
    for (int i=0; i<nSize; i++)
    {
        int[] colNumberCount = new int[nSize+1];
        Arrays.fill(colNumberCount, 0);
        for (int j=0; j<nSize; j++)
        {
            int nElement = all[j][i];
            colNumberCount[nElement] = colNumberCount[nElement] + 1;
            if (colNumberCount[nElement] == 2)
            {
                nColHasRepeated++;
                break;
            }
        }
    }
            
    
    System.out.println("Case #" + ind + ": " + nTrace + " " + nRowHasRepeated + " " + nColHasRepeated );
}
}