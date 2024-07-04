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
            //in.nextLine();
                        //System.out.println("nSize" + nSize);
            Solution s = new Solution();
            s.test(i, nSize, in);
        }
    }

   // inner class
   class Pair implements Comparable< Pair > {
       private int start;
       private int end;
       private int index;
       
      public Pair(int start, int end, int index)
      {
         this.start = start;
         this.end = end;
         this.index = index;
      }
     
    public int getStart() {
        return start;
    }
    
    public int getEnd() {
        return end;
    }
    
    public int getIndex() {
        return index;
    }
    
    @Override
    public int compareTo(Pair o) {
        return this.getStart() - o.getStart();
    }
   }
   
public void test(int ind, int nSize, Scanner in)
{
    StringBuffer strConverted = new StringBuffer();
    strConverted.setLength(nSize);
    ArrayList<Pair> allPairs = new ArrayList<Pair>();
    for (int i=0; i<nSize; i++)
    {
        int start = in.nextInt();
        int end = in.nextInt();
       
        Pair p = new Pair(start, end, i);
        allPairs.add(p);
    }
    
    Collections.sort(allPairs);
    
    strConverted.setCharAt(allPairs.get(0).getIndex(), 'C');
    Pair cP = allPairs.get(0);
    strConverted.setCharAt(allPairs.get(1).getIndex(), 'J');
    Pair jP = allPairs.get(1);
    
    for (int i=2; i<nSize; i++)
    {
        Pair tmpP = allPairs.get(i);
        int start = tmpP.getStart();
        
        if (start >= cP.getEnd())
        {
            strConverted.setCharAt(tmpP.getIndex(), 'C');
            cP = tmpP;
        }
        else if (start >= jP.getEnd())
        {
            strConverted.setCharAt(tmpP.getIndex(), 'J');
            jP = tmpP;
        }
        else
        {
            strConverted.delete(0, strConverted.length());
            strConverted.append("IMPOSSIBLE");
            break;
        }
    }
    
    System.out.println("Case #" + ind + ": " + strConverted);
}
}