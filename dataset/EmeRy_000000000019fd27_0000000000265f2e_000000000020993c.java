import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= cases; ++t) {
      int n = in.nextInt();
      int k = 0, r = 0, c = 0;
      boolean continueCheckingRow = true;
      ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
      for( int i = 0; i < n; i++)
      {
        ArrayList<Integer> row = new ArrayList<Integer>();
        continueCheckingRow=true;
        for (int j = 0; j < n; j++)
        {
            int x = in.nextInt();
            if(i == j) k+=x;
            
            if( continueCheckingRow && row.contains(x) )
            {
                continueCheckingRow=false; 
                r++;
            }
            row.add(x);
            if(j == n-1) {matrix.add(row);}
        }
      }
       
        for( int i = 0; i < n; i++)
        {
            ArrayList<Integer> col = new ArrayList();
            for (int a = 0; a<n; a++) 
            { 
                if( col.contains(matrix.get(a).get(i)) )
                { 
                    c++; break;
                }
                else
                {
                    col.add(matrix.get(a).get(i)); 
                }
            }
        }
       
    System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
    }
  }
}