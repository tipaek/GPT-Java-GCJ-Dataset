import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int t = scnr.nextInt();
    //System.out.println("Total cases: " + t);
    
    for (int cas = 0; cas < t; cas++) { // Each file
      //System.out.println("Case number: " + cas);

      int r = scnr.nextInt();
      int c = scnr.nextInt();
      //System.out.println(r + ", " + c);
      
      int[][] mat = new int[r][c];
      int interest = 0;
      
      for (int i = 0 ; i < r; ++ i) {
        for (int j = 0; j < c; ++j) {
          mat[i][j] = scnr.nextInt();
          //System.out.println(mat[i][j]);
          //interest+= mat[i][j];
        }
      }
      
      
      boolean done = false;
      boolean iterated = false;
      
      ArrayList<Integer> toRemove = new ArrayList<Integer>();
      
      while (!done) {
        if (toRemove.isEmpty() && iterated == true) {
          //System.out.println("Simualtion done");
          done = true;
          break;
        }
        while(!toRemove.isEmpty()) {
          mat[toRemove.get(toRemove.size()-2)][toRemove.get(toRemove.size()-1)] = -1;
          //System.out.println("Setting " + toRemove.get(toRemove.size()-2) + ", " + toRemove.get(toRemove.size()-1));
          toRemove.remove(toRemove.size()-1);
          toRemove.remove(toRemove.size()-1);
        }
        
        iterated = true;
        //System.out.println("Checking neighbours");
        for (int  i = 0; i < r; ++i) {
          for (int j = 0; j < c; ++j) {
            
            int neigCount = 0;
            double neigSkill = 0;
            if (mat[i][j] != -1) {
              interest+= mat[i][j];
            }
            for (int m = j + 1; m < mat[i].length; ++m) {
              if(mat[i][m] != -1) {
                neigSkill += mat[i][m];
                neigCount +=1;
                break;
              }
            }
            for (int m = j -1 ; m >= 0; --m) {
              if(mat[i][m] != -1) {
                neigSkill += mat[i][m];
                neigCount +=1;
                break;
              }
            }
            for (int m = i + 1; m < mat.length; ++m) {
              if(mat[i][m] != -1) {
                neigSkill += mat[m][j];
                neigCount +=1;
                break;
              }
            }
            for (int m = i - 1; m >= 0; --m) {
              if(mat[i][m] != -1) {
                neigSkill += mat[m][j];
                neigCount += 1;

                break;
              }
            }
            
            if (mat[i][j] < neigSkill/neigCount && mat[i][j] != -1) {
              //System.out.println("Skill " + mat[i][j] + "ns: " + neigSkill + ", " + neigCount);
              toRemove.add(i);
              toRemove.add(j);
            }
            
            //System.out.println(neigSkill);
          }
        }
      }//System.out.println("Size of case" + n);

      System.out.println("Case #" + (cas + 1) + ": " + interest);
      
//      System.out.println("Case #" + (cas + 1) + ": " + " ");
//      for (int i = 0; i < n; ++i) {
//        System.out.println((i+1) + " " + 1);
      
      
    }
    
  }
}
