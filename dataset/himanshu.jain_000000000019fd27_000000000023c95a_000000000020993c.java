import java.util.*;
import java.io.*;
public class Solution {

      
 public static void main(String[] args) {
    int[][] matrix = new int[100][100];
    Map<Integer, HashSet<Integer>> cset = new HashMap<>();
    HashSet<Integer> rset = new HashSet();
    HashSet<Integer> cnums = new HashSet();
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int m = 1; m <= t; ++m) {
       int N = in.nextInt();
       int k = 0;
       int r = 0;
       int c = 0;
       
       for(int i = 0; i < N ; i++)
       {
           boolean foundInRow = false;
           
           for(int j = 0; j < N; j++)
           {
               matrix[i][j] = in.nextInt();
               if(i == j) k += matrix[i][j];
               if(rset.contains(matrix[i][j]) && !foundInRow)
               {
                   foundInRow = true;
                   r++;
               }
               
               cset.putIfAbsent(j, new HashSet());
               if(cset.get(j).contains(matrix[i][j]) && !cnums.contains(j))
               {
                   c++;
                   cnums.add(j);
               }
               cset.get(j).add(matrix[i][j]);
               rset.add(matrix[i][j]);
           }
           rset.clear();
       }
       
       rset.clear();
       cnums.clear();
       cset.clear();
       System.out.println("Case #"+m+": "+k+" "+r+" "+c);
    }
  }
  
}