import java.util.*;
import java.io.*;
public class Solution
{

   public static void main(String[] args) 
   {
      Scanner scan = new Scanner(System.in) ;
      int t = scan.nextInt();
      for(int i = 0; i < t; i++){
          int n = scan.nextInt();
          
          HashSet<Integer> setR = new HashSet<Integer>();  
          HashSet<Integer> setC = new HashSet<Integer>();  
          
          int[][] arr = new int[n][n];
          
          int trace = 0;
          for(int j = 0; j < n; j++){
              for(int k = 0; k < n; k++){
                  arr[j][k] = scan.nextInt();
                  if(j == k)
                    trace += arr[j][k];
              }
          }
          int countR = 0;
          boolean currR = true;
          int countC = 0;
          boolean currC = true;
          
          for(int j = 0; j < n; j++){
              for(int k = 0; k < n; k++){
                  if(setR.add(arr[j][k]) == false && currR){
                    countR++;
                    currR = false;
                  }
                  if(setC.add(arr[k][j]) == false && currC){
                    countC++;
                    currC = false;
                  }
              }
              currR = true;
              currC = true;
              setR.clear();
              setC.clear();
          }
          System.out.println("Case #" + i + ": " + trace + " " + countR + " " + countC);
      }
   }
}/*3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3*/