import java.util.*;
import java.io.*;
public class Solution {
    
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      
      int[][] M = new int[n][n];
      
      for(int j=0; j<n; j++){
          for(int k=0; k<n; k++){
              M[j][k] = in.nextInt();
          }
      }
      
      findTrace(M, i);
    }
  }
  
  
  private static void findTrace(int[][] M, int cs){
      
        int k = 0; 
        int r = 0;
        int c = 0;
        for(int i=0, j=0; i<M.length; i++, j++){
            
            k += M[i][j];
            
            
            //check row
            Set<Integer> setInts = new HashSet<>();
            for(int it=0; it<M.length; it++){
                setInts.add(M[i][it]);
                if(setInts.size() < it+1){
                    r++;
                    break;
                }
            }
            
            //check column
            setInts.clear();
            for(int it=0; it<M.length; it++){
                setInts.add(M[it][j]);
                if(setInts.size() < it+1){
                    c++;
                    break;
                }
            }
            
        }
      
      
        System.out.println("Case #" + cs + ": " + k + " " + r + " " + c);
  }
}