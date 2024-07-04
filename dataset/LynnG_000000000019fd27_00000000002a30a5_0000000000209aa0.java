
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));    
    int t = in.nextInt(); //number of tests
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int k = in.nextInt();
        boolean possible = true;
        
        //if n = 2, only 2 and 4
        if(k == n+1 || k==(n*n-1)){
            possible = false;
            System.out.println("Case #" + i +": IMPOSSIBLE" );
        }
                
        //if n = 3, only 3, 6, 9
        else if(n == 3 && (k ==5 || k == 7)){
            possible = false;
            System.out.println("Case #" + i +": IMPOSSIBLE" );
        }
        //if n=4,  6, 7, 9, 10, 11, 13, 14
        /*else if(n == 4 && (k ==6 || k == 7)){
            possible = false;
            System.out.println("Case #" + i +": IMPOSSIBLE" );
        }
        else if(n == 4 && k == 6){
         //1	2	3	4
         //2	1	4	3
        // 3	4	2	1
        // 4	3	1	2   
        }*/
        //it is possible for any multiple of n if n is even
        else{
            System.out.println("Case #" + i +": POSSIBLE" );
          int[][] arr = new int[n][n];
          //set up basic with one on diagonal
          int val = 0;
          int diag = k/n;
          for(int r = 0; r < n; r++){
              //val = val + 1
              for(int c = 0; c < n; c++){
                  arr[r][c] = (c-r+diag)%n;
                  if(arr[r][c] <= 0){arr[r][c] += n;}
                  System.out.print(arr[r][c]);
              }
              System.out.println();
          } 
        }
    }
  } 
}
