import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    String s = in.nextLine();
    for (int t = 1; t <= T; ++t) {
        int N = in.nextInt();
        
        int k = 0;
        int r = 0;
        int c = 0;
        
        ArrayList<Integer>[] col = new ArrayList[N]; 
        
        boolean[] foundCol = new boolean[N];
        
        // initialize the arraylist
        for(int a = 0; a < N; a++) {
            
            col[a] = new ArrayList<Integer>();
            
        }
        
      for(int i = 0; i < N; i++) {
      
        ArrayList<Integer> row = new ArrayList<Integer>();
        boolean foundRow = false;
        for(int j = 0; j < N; j++) {
        
            int num = in.nextInt();
            
            if(!foundRow && (row.contains(num))) {
                r++;
                row.add(num);
                foundRow = true;
            }
            else {
                row.add(num);
            }
            
            if(i == j) {
            
                k += num;
            }
            for(int ind = 0; ind < col[j].size(); ind++) {
                
                //System.out.println(col[j].get(ind));
            }
            if(!foundCol[j] && col[j].contains(num)) {
                //System.out.println(i + " " + j + " " + num + " 111");
                c++;
                col[j].add(num);
                foundCol[j] = true;
                
            }
            else {
                
                col[j].add(num);
                
            }
        
        }
      
      }
      
      System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
    }
  }
}