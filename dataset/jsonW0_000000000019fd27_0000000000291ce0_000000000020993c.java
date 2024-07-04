//jasonwang292@gmail.com
import java.util.*;
import java.io.*;

class Vestigium
{
   public static void main(String[] args) throws Exception
   {
      //Scanner input = new Scanner(System.in);
      Scanner input = new Scanner(new File("test.txt"));
      int T = input.nextInt();
      for(int t=0; t<T; t++) {
         int N = input.nextInt();
         int[][] mat = new int[N][N];
         for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
               mat[i][j] = input.nextInt();
            }
         }
         int k=0;
         for(int i=0; i<N; i++) {
            k+=mat[i][i];
         }
         int r = 0;
         for(int row=0; row<N; row++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int i=0; i<N; i++) {
               int temp = mat[row][i];
               if(set.contains(temp)) {
                  r++;
                  break;
               }
               else {
                  set.add(temp);
               }
            } 
         }
         int c = 0;
         for(int col=0; col<N; col++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int i=0; i<N; i++) {
               int temp = mat[i][col];
               if(set.contains(temp)) {
                  c++;
                  break;
               }
               else {
                  set.add(temp);
               }
            } 
         }
         System.out.println("Case #"+(t+1)+": "+k+" "+r+" "+c);
      }
   }
}